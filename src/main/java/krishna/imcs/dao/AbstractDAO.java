package krishna.imcs.dao;

import java.sql.Connection;

import krishna.imcs.util.DatabaseFactory;

public abstract class AbstractDAO {

	public Connection getConnection(){
		return DatabaseFactory.getConnection();
		
	}
	
}
