package com.qaautomation.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {


	

	public static Object[][] getExcelSheetToObjectArray(String filename, String sheetname) throws IOException {

		FileInputStream filestream = new FileInputStream(filename);// file	

		XSSFWorkbook book = new XSSFWorkbook(filestream); // open file

		XSSFSheet sheet = book.getSheet(sheetname);// get sheet

		int rowTotal = sheet.getPhysicalNumberOfRows();
		int colTotal = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] Data = new Object[rowTotal - 1][colTotal];

		for (int row = 1; row < rowTotal; row++) // not including the header
		{
			for (int col = 0; col < colTotal; col++) {
				XSSFRow roww = sheet.getRow(row);
				XSSFCell coll = roww.getCell(col);

				DataFormatter format = new DataFormatter();
				String CellData = format.formatCellValue(coll);

				Data[row - 1][col] = CellData;

			}

		}

		
		return Data;
	}

}
