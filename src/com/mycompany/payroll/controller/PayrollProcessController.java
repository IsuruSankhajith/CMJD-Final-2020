/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.controller;

import com.mycompany.payroll.dao.AttendanceDetailDAO;
import com.mycompany.payroll.dao.EmployeeDAO;
import com.mycompany.payroll.dao.LeaveDAO;
import com.mycompany.payroll.dao.PayrollProcessDAO;
import com.mycompany.payroll.dao.SettingsDAO;
import com.mycompany.payroll.model.Attendance;
import com.mycompany.payroll.model.Employee;
import com.mycompany.payroll.model.Leave;
import com.mycompany.payroll.model.PayrollProcess;
import com.mycompany.payroll.model.PayrollTransaction;
import com.mycompany.payroll.model.PayrollTransactionDetail;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isuru Sankajith
 */
public class PayrollProcessController {

    public List<PayrollProcess> findAllAttendance() throws ClassNotFoundException, SQLException {
        return new PayrollProcessDAO().findAllAttendance();

    }

    public int salaryProcess() throws ClassNotFoundException, SQLException, ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        double otAmount = 0;
        double noPayAmount = 0;
        double epfAmount = 0;
        double etfAmount = 0;
        int processCount = 0;

        EmployeeDAO employeeDAO = new EmployeeDAO();
        AttendanceDetailDAO attendanceDAO = new AttendanceDetailDAO();
        SettingsDAO settingsDAO = new SettingsDAO();
        LeaveDAO leaveDAO = new LeaveDAO();
        PayrollProcessDAO payrollProcessDAO = new PayrollProcessDAO();

        PayrollProcess payrollProcess = payrollProcessDAO.findFinanaceMonth();

        List<Attendance> notProcessAttendances = attendanceDAO.findNotProcessAttendance(payrollProcess.getMonth_start());

        if (notProcessAttendances.size() > 0) {

            if (payrollProcess.getMonth_start() != null) {
                double otRate = Double.parseDouble(settingsDAO.finSettingById("OT_RATE").getValue());
                double epfRate = Double.parseDouble(settingsDAO.finSettingById("EPF").getValue());
                double etfRate = Double.parseDouble(settingsDAO.finSettingById("ETF").getValue());

                List<Employee> employees = employeeDAO.findAllEmployeeWithCategoryAndType();

                for (Employee employee : employees) {
                    processCount++;
                    PayrollTransaction payrollTransaction = new PayrollTransaction();
                    List<PayrollTransactionDetail> transactionDetails = new ArrayList<>();

                    PayrollTransactionDetail basicSalary = new PayrollTransactionDetail("Basic Salary");
                    basicSalary.setAmount(employee.getBasicSalary());

                    PayrollTransactionDetail ot = new PayrollTransactionDetail("Over Time");
                    PayrollTransactionDetail noPay = new PayrollTransactionDetail("No Pay");
                    PayrollTransactionDetail epf = new PayrollTransactionDetail("EPF Deduction");
                    PayrollTransactionDetail etf = new PayrollTransactionDetail("ETF Deduction");

                    List<Attendance> attendances = attendanceDAO.findAllAttendanceByEmployeeId(employee.getEmployeeId(), payrollProcess.getMonth_start());

                    if (employee.getEmployeeCategoryObj().getIs_ot_allowed() == 1) {

                        for (Attendance attendance : attendances) {

                            long shiftTime = attendance.getShift().getEnd_time().getTime() - attendance.getShift().getStart_time().getTime();
                            long workingTime = attendance.getOut_time().getTime() - attendance.getIn_time().getTime();

                            if ((shiftTime - workingTime) >= 3600000) {
                                double timeGap = (attendance.getOut_time().getTime() - attendance.getIn_time().getTime()) / 3600000;
                                double oneHourAmount = employee.getBasicSalary() / 240;
                                otAmount = (timeGap * oneHourAmount) * otRate;
                                ot.setAmount(otAmount);
                                transactionDetails.add(ot);
                            }
                        }

                    }

                    List<Leave> leaves = leaveDAO.findAllLeaveByEmployeeId(employee.getEmployeeId(), payrollProcess.getMonth_start());
                    int totalLeaveHours = 0;

                    for (Leave leave : leaves) {

                        totalLeaveHours += leave.getLeaveType().getNo_of_hour();

                    }

                    if (employee.getRemainingLeave() - totalLeaveHours < 0) {
                        noPayAmount = (employee.getBasicSalary() / 240) * (totalLeaveHours - employee.getRemainingLeave());
                        noPay.setAmount(noPayAmount);
                        transactionDetails.add(noPay);
                    } else {
                        noPay.setAmount(0);
                        transactionDetails.add(noPay);
                    }

                    epfAmount = employee.getBasicSalary() * epfRate;
                    epf.setAmount(epfAmount);
                    transactionDetails.add(epf);

                    etfAmount = employee.getBasicSalary() * etfRate;
                    etf.setAmount(etfAmount);
                    transactionDetails.add(etf);

                    payrollTransaction.setEmployeeId(employee.getEmployeeId());
                    payrollTransaction.setGrossSalary(employee.getBasicSalary());
                    payrollTransaction.setNetSalary((employee.getBasicSalary() + otAmount) - (epfAmount + etfAmount + noPayAmount));
                    payrollTransaction.setSalaryFor(sdf.format(payrollProcess.getMonth_start().getTime()));

                    int result = payrollProcessDAO.addPayrollTransaction(payrollTransaction);

                    if (result > 0) {
                        for (PayrollTransactionDetail transactionDetail : transactionDetails) {
                            transactionDetail.setTransactionId(result);
                            payrollProcessDAO.addPayrollTransactionDetail(transactionDetail);
                        }
                    }
                }
                payrollProcessDAO.updateFinanceMonth();
                payrollProcessDAO.addFinanceMonth();
            }
        }
        return processCount;
    }

}
