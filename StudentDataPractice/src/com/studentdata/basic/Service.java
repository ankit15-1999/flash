package com.studentdata.basic;

import com.studentdata.dao.MarksheetDAO;
import com.studentdata.dto.MarksheetDTO;

public class Service {

	public MarksheetDTO insertIntoTable(MarksheetDTO marksheetDTO) throws Exception
	{
		MarksheetDAO marksheetDAO = new MarksheetDAO();
		
		//marksheetDAO.insertdata(marksheetDTO);
		return marksheetDAO.insertdata(marksheetDTO);
	}
}
