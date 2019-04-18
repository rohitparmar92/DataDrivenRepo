package dataDivernTest;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XSSFWorkbook ExcelWBook;
	    XSSFSheet ExcelWSheet;
	    XSSFCell Cell;
		
		// Location of Excel File...
		String path = "C:\\Users\\ms\\Desktop\\eclipse\\Work Book\\ExcelRead.xlsx.xlsx";
	    String sheetName = "Sheet1";
	    
	    try {
	    	FileInputStream ExcelFile = new FileInputStream(path);
	    	// Initiate the ExcelBook instance
	    	 ExcelWBook = new XSSFWorkbook(ExcelFile);
	    	 ExcelWSheet = ExcelWBook.getSheet(sheetName);
	    	 Cell =  ExcelWSheet.getRow(1).getCell(1);
	         
	    	 String cellData = Cell.getStringCellValue();
	         System.out.println(cellData);
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    }
	}

}
