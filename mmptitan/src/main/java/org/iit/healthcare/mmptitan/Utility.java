package org.iit.healthcare.mmptitan;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {

	public static String getfutureDate(int noofDays,String format)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,noofDays);
		Date d  = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String expected = sdf.format(d);
		return expected;
	}
	public static String[][] readXLSX(String fileName,String sheetName) throws IOException
	{
		File f = new File(fileName);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		String data[][] = new String[rows][cols];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				XSSFCell cell = sheet.getRow(i).getCell(j);
				CellType ctype = cell.getCellType();

				switch(ctype)
				{
				case STRING:
					data[i][j] = cell.getStringCellValue();
					System.out.println("Data stored in the Arr::: " + data[i][j]);
					break;
				case NUMERIC:
					data[i][j]= cell.getNumericCellValue()+"";
					System.out.println("Data stored in the Arr::: " + data[i][j]);
					break;
				}

			}
		}
		return data;
	}
}
