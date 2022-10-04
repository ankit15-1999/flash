package com.studentmain.basic;

import com.studentdata.basic.Service;
import com.studentdata.dao.MarksheetDAO;
import com.studentdata.dto.MarksheetDTO;

public class Test {

	public static void main(String[] args) throws Exception {

		MarksheetDAO marksheetDAO = new MarksheetDAO();
		MarksheetDTO marksheetDTO = new MarksheetDTO();
		Service service = new Service();
		
		MarksheetDTO dto2 = service.insertIntoTable(marksheetDTO); 
		  dto2.setId(345);
		  dto2.setFirstname("John");
		  dto2.setLastname("Cena");
		  dto2.setClassname("11th");
		 System.out.println("123");
//		service.insertIntoTable(marksheetDTO);
		marksheetDAO.insertdata(marksheetDTO);

	}

}
