package krishna.imcs.pojo;

import java.util.Date;

public class EmployeeBonus {

	private int EmpNum;
	private String EmpStatus;
	private double Amount;
	private Date DateAllocated;
	
	public int getEmpNum() {
		return EmpNum;
	}

	public void setEmpNum(int empNum) {
		EmpNum = empNum;
	}

	public String getEmpStatus() {
		return EmpStatus;
	}

	public void setEmpStatus(String empStatus) {
		EmpStatus = empStatus;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public Date getDateAllocated() {
		return DateAllocated;
	}

	public void setDateAllocated(Date dateAllocated) {
		DateAllocated = dateAllocated;
	}

	public EmployeeBonus(int empNum, String empStatus, double amount, Date dateAllocated) {
		super();
		EmpNum = empNum;
		EmpStatus = empStatus;
		Amount = amount;
		DateAllocated = dateAllocated;
	}

	@Override
	public String toString() {
		return "EmployeeBonus [EmpNum=" + EmpNum + ", EmpStatus=" + EmpStatus + ", Amount=" + Amount
				+ ", DateAllocated=" + DateAllocated + "]";
	}
	
	
}
