package com.marmat.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import com.marmat.dto.MarksheetDTO;

public class MarksheetDAO 
{
	private static final String DBL = "db.driver";
	private static final String DURL ="db.url";	
	private static final String DBUSER	="db.username";
	private static final String DBPas = "db.password";

	
	private static Properties properties =null;
	Statement st=null;
	Connection con=null;
	
	public void common() throws Exception{
		properties = new Properties();
		properties.load(new FileInputStream("C:\\Users\\user\\eclipse-workspace\\MyProject\\database.properties"));
		Class.forName(properties.getProperty(DBL));
		con = DriverManager.getConnection(properties.getProperty(DURL),properties.getProperty(DBUSER),properties.getProperty(DBPas));
		st=con.createStatement();
	}
	public void executeUpdate(String sql) throws Exception
	{
		st.executeUpdate(sql);
		con.close();
	}
	public MarksheetDTO selectMarksheetDTO(MarksheetDTO dto) throws Exception
	{
		common();
		MarksheetDTO marksheetdto = new MarksheetDTO();
		ResultSet rs = st.executeQuery("Select * from schoolmarks");
		while(rs.next())
		{
			System.out.println(marksheetdto.setId(rs.getInt(1))+" "+
			marksheetdto.setFirstName(rs.getString(2))+" "+
			marksheetdto.setLastName(rs.getString(3))+" "+
			marksheetdto.setClassname(rs.getString(4)));
		}
		return marksheetdto;
	}
	  public MarksheetDTO insertMarksheetDTO(MarksheetDTO dto) throws Exception
	  {	
		  	common();
		  	MarksheetDTO marksheetdto = new MarksheetDTO();
		  String sql="INSERT INTO schoolmarks(id,firstname,lastName,classname) "+"values"+"("+dto.getId()+","+"'"+dto.getFirstname()
		  				+"'"+","+"'"+dto.getLastName()+"'"+","+"'"+dto.getClassname()+"'"+")";
		  	executeUpdate(sql);
			System.out.println("data Inserted...");
			return marksheetdto;
	  }
	  public MarksheetDTO updateMarksheetDTO(MarksheetDTO dto) throws Exception
	  {
		  	common();
		  	MarksheetDTO marksheetdto = new MarksheetDTO();
		  	String sql ="update schoolmarks SET firstname= "+"'"+dto.getFirstname()+"'"+"where id="+dto.getId();
		  	executeUpdate(sql);
		  	System.out.println("Query Updated...");
		  	return marksheetdto;
	  }
	  public void deleteMarksheetDTO(MarksheetDTO dto) throws Exception
	  {
		  common();
		  String sql ="delete from schoolmarks where id ="+dto.getId();
		  System.out.println("Query deleted...");
		  executeUpdate(sql);
	  }	
	  
	  public MarksheetDTO findById(MarksheetDTO dto){
		 try {
			common();
		} 
		 catch (Exception e1) 
		 {
			e1.printStackTrace();
		 } 
		 String srl = "Select from schoolmarks where id ="+dto.getId();
		 try {
		 ResultSet rs = st.executeQuery(srl);
			while(rs.next())
			{
				MarksheetDTO marksheetdto = new MarksheetDTO();
				System.out.println(marksheetdto.setId(rs.getInt(1))+" "+
				marksheetdto.setFirstName(rs.getString(2))+" "
//				marksheetdto.setLastName(rs.getString(3))+" "+
//				marksheetdto.setClassname(rs.getString(4))
		  );} 
		 }
		 catch (Exception e) {
			System.out.println(e);
		}
		return dto;
	}

	  public List<MarksheetDTO> getList() throws Exception 
	  {	
		common();
		List<MarksheetDTO> list = new ArrayList(); 
		
		ResultSet rs = st.executeQuery("Select * from schoolmarks");
		while(rs.next())
		{
			MarksheetDTO marksheetdto = new MarksheetDTO();
				marksheetdto.setId(rs.getInt(1));
				marksheetdto.setFirstName(rs.getString(2));
				marksheetdto.setLastName(rs.getString(3));
				marksheetdto.setClassname(rs.getString(4));
				list.add(marksheetdto);
		}
		return list;
	  }
	 public MarksheetDTO getUpdate(MarksheetDTO dto) throws Exception
	 {
		common(); 
		String sql ="update schoolmarks SET firstname = "+"'"+dto.getFirstname()+"'"+"where id ="+dto.getId();
	  	executeUpdate(sql);
		return dto;
	 }
	
	 public List<MarksheetDTO> getCharName() throws Exception 
	  {	
		common();
		List<MarksheetDTO> list = new ArrayList<>(); 
		
		ResultSet rs = st.executeQuery("Select firstname From schoolmarks Where firstname like 'A%' order by firstname ");
		MarksheetDTO marksheetdto=null;
		while(rs.next())
		{
			 marksheetdto = new MarksheetDTO();
			marksheetdto.setFirstName(rs.getString(1));
			list.add(marksheetdto);
		}
		return list;
	  }
}
	  











