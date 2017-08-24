package krishna.imcs.pojo;

public class DeptBonus {

	private int DeptNum;
	private double Amount;
	private double RemainingAmount;
	
	public DeptBonus(int deptNum, double amount, double remainingAmount) {
		super();
		DeptNum = deptNum;
		Amount = amount;
		RemainingAmount = remainingAmount;
	}
	
	@Override
	public String toString() {
		return "DeptBonus [DeptNum=" + DeptNum + ", Amount=" + Amount + ", RemainingAmount=" + RemainingAmount + "]";
	}

	public int getDeptNum() {
		return DeptNum;
	}
	public void setDeptNum(int deptNum) {
		DeptNum = deptNum;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public double getRemainingAmount() {
		return RemainingAmount;
	}
	public void setRemainingAmount(double remainingAmount) {
		RemainingAmount = remainingAmount;
	}
	
	
}
