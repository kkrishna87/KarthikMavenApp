package krishna.imcs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import krishna.imcs.pojo.EmployeeBonus;

public class EmployeeBonusDAO extends AbstractDAO {

	public void setBonus(EmployeeBonus empBonus) throws SQLException {

		try (Connection con = getConnection();PreparedStatement psmt = con.prepareStatement("insert into employeebonus values(?,?,?,?)")) {

			
			
			psmt.setInt(1, empBonus.getEmpNum());
			psmt.setString(2, empBonus.getEmpStatus());
			psmt.setDouble(3, empBonus.getAmount());
			psmt.setDate(4, new Date(empBonus.getDateAllocated().getTime()));
			psmt.execute();

		}

	}

}
