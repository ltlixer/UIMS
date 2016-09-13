package com.lixer.uims.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.lixer.uims.config.UserRole;
import com.lixer.uims.entity.User;

public class StudentExcel {
	
	public List<User> readStudentExcel(String file){
		InputStream is = null;
		List<User> studentList = new ArrayList<User>();
		try {
			is = new FileInputStream(file);
			//Workbook wb = new HSSFWorkbook(fis);
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
			int rowNum = hssfSheet.getLastRowNum();
			for (int i = 0; i <= rowNum; i++) {
				User student = new User();
				HSSFRow hssfRow = hssfSheet.getRow(i);
				HSSFCell username = hssfRow.getCell(0);
				HSSFCell password = hssfRow.getCell(1);
				HSSFCell realname = hssfRow.getCell(2);
				
				student.setUsername(Long.parseLong(getValue(username)));
				student.setPassword(getValue(password));
				student.setRealname(getValue(realname));
				student.setRole(UserRole.STUDENT);
				
				studentList.add(student);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return studentList;
		// 构建一个excel2003工作簿
	}
	private String getValue(HSSFCell hssfCell) {
		return String.valueOf(hssfCell.getStringCellValue());
	}
}
