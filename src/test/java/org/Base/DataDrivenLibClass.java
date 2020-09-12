package org.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.model.WorkbookRecordList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class DataDrivenLibClass extends SupportClass{
	
	Workbook workbook;
	
//======================To read from excel file==========================
	// To read from xls file
	public Workbook readXLS(String path) throws IOException {
		FileInputStream fin = new FileInputStream(new File(path));
		workbook = new HSSFWorkbook(fin);
		return workbook;

	}

	// To read from xlsx file
	public Workbook readXLSX(String path) throws IOException {
		FileInputStream fin = new FileInputStream(new File(path));
		workbook = new XSSFWorkbook(fin);
		return workbook;

	}

	// To Read the Sheet
	public Sheet getSheet(Workbook workbook, String name) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Sheet sheet = workbook.getSheet(name);
		 return sheet;
	}

	// To get Physical Number of Rows
	public int getPhysicalRows(Sheet sheet) {
		return sheet.getPhysicalNumberOfRows();
	}

	// To Read the Row
	public Row getRow(Sheet s, int row) {
		return s.getRow(row);
	}

	// To get Physical Number of Column
	public int getPhysicalColumn(Row row) {
		return row.getPhysicalNumberOfCells();
	}

	// To Read the Column
	public Cell getCell(Row r, int cell) {
		return r.getCell(cell);
	}

	// To Check the CellType
	public int getCellType(Cell cell) {
		return cell.getCellType();
	}

	// To getStringCell Value
	public String getStringCell(Cell cell) {
		return cell.getStringCellValue();
	}

	// To getNumericCell Value
	public Double getNumericCell(Cell cell) {
		return cell.getNumericCellValue();
	}

	// To getdateCell Value
	public Date getDateCell(Cell cell) {
		return cell.getDateCellValue();
	}

	// To Check Cell is Date Format
	public boolean isdateFormat(Cell cell) {
		return DateUtil.isCellDateFormatted(cell);
	}
	
	//Convert Numeric Cell to String Cell 
	public String convertDoubletoString(Cell cell) {
		double numericCellValue = cell.getNumericCellValue();
		long longVal = (long)numericCellValue;
		return String.valueOf(longVal);
	}
	//Convert Date Cell to String Cell with Pattern MM/dd/yyyy
	public String convertDatetoString(Cell cell) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date dateCellValue = cell.getDateCellValue();
		return sdf.format(dateCellValue);
		
	}

//======================To write from excel file==========================	
	// To create an Sheet/Update the Sheet
	public Sheet createSheet(Workbook workbook, String sheetName) {
		return workbook.createSheet(sheetName);
	}

	// To create New Row
	public Row createRow(Sheet sheet, int rowNum) {
		return sheet.createRow(rowNum);
	}

	// To create New Cell
	public Cell createColumn(Row row, int cellNum) {
		return row.createCell(cellNum);
	}

	// To send String value to cell
	public void insertValue(Cell cell, String value) {
		cell.setCellValue(value);
	}
	//To write into File
	public void writeFile(Workbook workbook,String path,String fileType) throws IOException {
		if(fileType.equals("xls")) {
			workbook = new HSSFWorkbook();
		}
		else {
			workbook = new XSSFWorkbook();
		}
		FileOutputStream fout = new FileOutputStream(new File(path));
		workbook.write(fout);
	}
//======================To delete row from excel file==========================	
	public void removeRow(Sheet sheet,int rowNum) {
		sheet.removeRowBreak(rowNum);
	}

}
