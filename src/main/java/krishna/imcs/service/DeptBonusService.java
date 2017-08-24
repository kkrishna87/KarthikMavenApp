package krishna.imcs.service;

import java.sql.SQLException;
import java.util.List;

import krishna.imcs.dao.DeptBonusDAO;
import krishna.imcs.pojo.DeptBonus;

public class DeptBonusService {
	
	DeptBonusDAO deptbonusdao=new DeptBonusDAO();
	
	public void loadAllDeptBonus(List<DeptBonus> deptbonus) throws SQLException{
		
		deptbonusdao.loadAllDeptBonus(deptbonus);
	
	}

	public List<DeptBonus> getAllBonus() throws SQLException {
		
		return deptbonusdao.getAllBonus();
	}

	public double getRemainingAmount(int deptNum) throws SQLException {
		
		
		return deptbonusdao.getRemainingAmount(deptNum);
	}

	public void setremainingAmount(double rem,int deptNum) throws SQLException {
		
		deptbonusdao.setRemainingAmount(rem,deptNum);
		
	}

}
