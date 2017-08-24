package krishna.imcs.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import krishna.imcs.dao.EmployeeDAO;
import krishna.imcs.pojo.Employee;

public class EmployeeService {
	
	EmployeeDAO employeedao=new EmployeeDAO();

	public List<Employee> getEmployees(int deptNum) throws SQLException {
		List<Employee> emps=new ArrayList<>();
		if(deptNum%2==0){
			emps=employeedao.getEmployees(deptNum,"DOB");
			
		}else{
			emps=employeedao.getEmployees(deptNum,"DOJ");	
		}
		
		return emps;
	}

}
