package com.mostafa.sna.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import com.mostafa.sna.connection.DBConnection;
import com.mostafa.sna.model.Person;

public class PersonDao {

	public int insertData(String firstName, String lastName, String userName, String password, String email,
			String phone, InputStream stream) throws ClassNotFoundException, SQLException, IOException {
		
		int id =0;
		
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();
		
		PreparedStatement pst = null;
		pst = con.prepareStatement("SELECT user_details_seq.NEXTVAL FROM dual");
		ResultSet rs = pst.executeQuery();
		
		if (rs != null && rs.next()) {
			
			id = rs.getInt(1);
			System.out.println(id);
			
			pst = con.prepareStatement("INSERT INTO USER_DETAILS(ID, FIRST_NAME, LAST_NAME,USER_NAME,PASSWORD,"
					+ "EMAIL, PHONE, PHOTO) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");			
			
			pst.setInt(1, id);
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			pst.setString(4, userName);
			pst.setString(5, password);
			pst.setString(6, email);
			pst.setString(7, phone);
			
			//pst.setBinaryStream(8, stream);
			pst.setBlob(8, stream);
			
			int s = pst.executeUpdate();
			
			if (s > 0) {
				System.out.println("Added successfully !");
			}else {
				System.out.println("Failed.");
			}
			
		}
		
		rs.close();
		pst.close();
		con.close();
		
		return id;
	}

	public Person get(int id) throws ClassNotFoundException, SQLException, IOException {
		
		Person person = null;
		
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();
		
		PreparedStatement pst = null;
		pst = con.prepareStatement("SELECT * FROM USER_DETAILS WHERE ID = ?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		
		if (rs.next()) {
            person = new Person();
            person.setFirstName(rs.getString(1));
            person.setLastName(rs.getString(2));
            person.setUserName(rs.getString(3));
            person.setPassword(rs.getString(4));
            person.setEmail(rs.getString(5));
            person.setPhone(rs.getString(6));
            person.setId(rs.getInt(7));
            Blob blob = rs.getBlob(8);
             
            InputStream inputStream = blob.getBinaryStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
             
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);                  
            }
             
            byte[] imageBytes = outputStream.toByteArray();
            String encoded = Base64.getEncoder().encodeToString(imageBytes);
            byte [] decoded = Base64.getDecoder().decode(encoded);
            String base64Image = new String(decoded);
            
            inputStream.close();
            outputStream.close();
            
            person.setBase64Image(base64Image);
        }
		
		rs.close();
		pst.close();
		con.close();
		
		return person;
	}

}
