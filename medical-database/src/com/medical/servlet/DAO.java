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

	public List<Medicine> getMedicines() throws Exception {
		List<Medicine> meds = new ArrayList<Medicine>();

		try {
			Connection myCon = dataSource.getConnection();
			Statement st = myCon.createStatement();
			String q = "Select * from pharmacy ORDER BY id";
			ResultSet rs = st.executeQuery(q);

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
		}
	}

	public void addMedicine(Medicine m) throws Exception {
		try {
			Connection con = dataSource.getConnection();
			String q = "INSERT INTO pharmacy (medicine,mfg,exp,cost) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, m.getName());
			ps.setString(2, m.getManu());
			ps.setString(3, m.getExpr());
			ps.setString(4, m.getPrice());

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delMedicine(int theid) throws Exception {
		try {
			Connection con = dataSource.getConnection();
			String q = "DELETE FROM pharmacy WHERE id=theid";
			PreparedStatement p = con.prepareStatement(q);
			p.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
