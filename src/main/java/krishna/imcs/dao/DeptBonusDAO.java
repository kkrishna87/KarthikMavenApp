package krishna.imcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import krishna.imcs.pojo.DeptBonus;

public class DeptBonusDAO extends AbstractDAO {

	public void loadAllDeptBonus(List<DeptBonus> deptbonus) throws SQLException {

		try (Connection con = getConnection();
				Statement st = con.createStatement();
				PreparedStatement psmt = con.prepareStatement("Insert into bonus Values(?,?,?)")) {
				con.setAutoCommit(false); 	
				int count = 1;
				boolean hasLeftOverBatchRecords = true;

				st.execute("truncate bonus");
				for (DeptBonus d : deptbonus) {

				psmt.setInt(1, d.getDeptNum());
				psmt.setDouble(2, d.getAmount());
				psmt.setDouble(3, d.getRemainingAmount());
				psmt.addBatch();
				
				if(count%3==0){
					int[] updatecount=psmt.executeBatch();
					hasLeftOverBatchRecords = false;
				}else{
					hasLeftOverBatchRecords = true;
				}
			}
				if(hasLeftOverBatchRecords){
					int[] updatecount=psmt.executeBatch();
					
				}
				con.commit();
		}

	}

	public List<DeptBonus> getAllBonus() throws SQLException {

		List<DeptBonus> list = new ArrayList<>();

		try (Connection con = getConnection(); PreparedStatement psmt = con.prepareStatement("select * from bonus")) {

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				list.add(new DeptBonus(rs.getInt(1), rs.getDouble(2), rs.getDouble(3)));
			}
		}

		return list;
	}

	public double getRemainingAmount(int deptNum) throws SQLException {

		double rem = 0;
		try (Connection con = getConnection();
				PreparedStatement psmt = con.prepareStatement("select RemainingAmount from bonus where DeptNo=?")) {

			psmt.setInt(1, deptNum);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				rem = rs.getDouble(1);

			}
		}

		return rem;
	}

	public void setRemainingAmount(double rem, int deptNum) throws SQLException {

		try (Connection con = getConnection();
				PreparedStatement psmt = con.prepareStatement("update bonus set RemainingAmount=? where DeptNo=?")) {

			psmt.setDouble(1, rem);
			psmt.setInt(2, deptNum);
			psmt.execute();

		}

	}

}
