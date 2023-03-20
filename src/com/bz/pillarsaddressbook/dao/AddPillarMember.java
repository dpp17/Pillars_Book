package com.bz.pillarsaddressbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bz.pillarsaddressbook.connection.ConnectDB;
import com.bz.pillarsaddressbook.model.PillarsPojo;

public class AddPillarMember {

	public static void add(PillarsPojo person) throws SQLException {
		
		Connection con = ConnectDB.getInstance().getConnection();
		
		PreparedStatement statement = con.prepareStatement("insert into demoPillars(firstName,age,phoneNumber) values(?,?,?);");
		statement.setString(1, person.getFirstName());
		statement.setInt(2, person.getAge());
		statement.setString(3, person.getPhoneNumber());
		
		statement.execute();
		
		statement.close();
		con.close();
		
	}
}
