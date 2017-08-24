package krishna.imcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import krishna.imcs.pojo.DeptBonus;
import krishna.imcs.pojo.Employee;

public class EmployeeDAO extends AbstractDAO {

	public List<Employee> getEmployees(int deptNum, String string) throws SQLException {
		
		List<Employee> list=new ArrayList<>();
		
		try(Connection con=getConnection();PreparedStatement psmt=con.prepareStatement("select * from employee where DeptNum=? order by " +string)){
			
			psmt.setInt(1, deptNum);
			ResultSet rs=psmt.executeQuery();
			
			while(rs.next()){
				list.add(new Employee(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getDate(4),rs.getDouble(5),rs.getInt(6)));
			}
		}
		
		return list;

	}
}
