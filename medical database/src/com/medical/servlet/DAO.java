package com.medical.servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.sql.DataSource;

public class DAO {

	private DataSource dataSource;

	public DAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public List<Medicine> getMedicines() throws Exception {
		List<Medicine> meds = new ArrayList<Medicine>();
		Connection myCon = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			 myCon = dataSource.getConnection();
			 st = myCon.createStatement();
			 String q = "Select * from pharmacy ORDER BY id";
			 rs = st.executeQuery(q);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("medicine");
				String manu = rs.getString("mfg");
				String expr = rs.getString("exp");
				String price = rs.getString("cost");

				Medicine temp_med = new Medicine(id, name, manu, expr, price);

				meds.add(temp_med);

			}
			return meds;
		}
		
		finally {
			Connection myConn;
			close(myCon, st, rs);
		}
	}

	public void addMedicine(Medicine m) throws Exception {
		Connection con =null;
		PreparedStatement p = null;
		
		try {
			 con = dataSource.getConnection();
			String q = "INSERT INTO pharmacy (medicine,mfg,exp,cost) VALUES (?,?,?,?)";
			 p = con.prepareStatement(q);
			p.setString(1, m.getName());
			p.setString(2, m.getManu());
			p.setString(3, m.getExpr());
			p.setString(4, m.getPrice());

			p.execute();
		} finally {
			close(con, p, null);
		}

	}

	public void delMedicine(String theid) throws Exception {
		Connection con = null;
		PreparedStatement p = null;
		try {
			int med_id = Integer.parseInt(theid);
			con = dataSource.getConnection();
			String q = "DELETE FROM pharmacy WHERE id=?";
			p =con.prepareStatement(q);
			p.setInt(1, med_id);
			p.execute();
		} finally {
			
			close(con, p, null);
		}	
		
	}

}
