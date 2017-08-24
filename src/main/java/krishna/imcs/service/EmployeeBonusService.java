package krishna.imcs.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import krishna.imcs.dao.EmployeeBonusDAO;
import krishna.imcs.pojo.DeptBonus;
import krishna.imcs.pojo.Employee;
import krishna.imcs.pojo.EmployeeBonus;

public class EmployeeBonusService {

	DeptBonusService deptbonusservice = new DeptBonusService();
	EmployeeService empservice = new EmployeeService();
	EmployeeBonusDAO empbonusdao = new EmployeeBonusDAO();

	public void giveBonus(Employee emp) throws SQLException {

		double bonus = getBonus(emp.getSalary(), emp.getEmpSalGrade());

		double remainingAmount = deptbonusservice.getRemainingAmount(emp.getDeptNum());

		if (remainingAmount == 0.0f) {

			setBonus(new EmployeeBonus(emp.getEmpNum(), "INC", 0.0d, new Date()));
		} else if (remainingAmount >= bonus) {

			setBonus(new EmployeeBonus(emp.getEmpNum(), "CMP", bonus, new Date()));
			deptbonusservice.setremainingAmount(remainingAmount - bonus, emp.getDeptNum());

		} else {

			setBonus(new EmployeeBonus(emp.getEmpNum(), "PAR", remainingAmount, new Date()));
			deptbonusservice.setremainingAmount(0.0d, emp.getDeptNum());

		}

	}

	private void setBonus(EmployeeBonus employeeBonus) throws SQLException {

		empbonusdao.setBonus(employeeBonus);

	}

	public double getBonus(double EmpSalary, int EmpSalGrade) {
		double douBonus = 0;
		switch (EmpSalGrade) {

		case 1:
			douBonus = EmpSalary * 0.1;
		case 2:
			douBonus = EmpSalary * 0.15;
		case 3:
			douBonus = EmpSalary * 0.2;
		case 4:
			douBonus = EmpSalary * 0.25;

		}
		return douBonus;

	}

	public void allocateBonus() throws SQLException {
		List<DeptBonus> list = new ArrayList<>();
		ExecutorService executorservice=Executors.newFixedThreadPool(6);
		list = deptbonusservice.getAllBonus();

		for (final DeptBonus db : list) {
			
			final List<Employee> emp = empservice.getEmployees(db.getDeptNum());
			Thread thread=new Thread(){
				public void run(){
					//System.out.println(emp.size());
					System.out.println(db.getDeptNum());
					for (Employee e : emp) {
		
						try {
							giveBonus(e);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		
					}
				}
				
			};
			executorservice.execute(thread);
		}
		executorservice.shutdown();
			
	}



}
