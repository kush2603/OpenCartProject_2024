package com.opencart.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {

	String path = "C:\\Users\\Sandeep Kushawaha\\eclipse-workspace\\CartOpen\\resources\\TestData.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;	
	
	public Excelutils() throws IOException
	{
		file = new File(path);
		fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);	
	}
	 public String readData(String sheet_name, int row_num, int cell_num) throws IOException
     {
        XSSFSheet sheet = wb.getSheet(sheet_name);
        String data = sheet.getRow(row_num).getCell(cell_num).getStringCellValue();
        return data;
     }
	 
	 public void writeData(String sheet_name, int row_num, int cell_num, String data) throws IOException
		{
		    XSSFSheet sheet = wb.getSheet(sheet_name);
		    sheet.getRow(row_num).createCell(cell_num).setCellValue(data);
		    FileOutputStream fos = new FileOutputStream(file);
		    wb.write(fos);
		}

}
