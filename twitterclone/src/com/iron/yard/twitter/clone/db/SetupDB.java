package com.iron.yard.twitter.clone.db;

import java.sql.Connection;

/**
 * 
 * @author Shuvo Ahmed
 *
 */
public class SetupDB {

	public static void main(String[] args) {
		
		Connection conn = DBConnection.getConnection();
		CreateTables ct = new CreateTables();
		ct.start(conn);
		
		PopulateTables pt = new PopulateTables();
		pt.start(conn);
		
		DBConnection.closeConnection(conn);
	}
}