package policybazaar.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTesting 
{
	public static XSSFWorkbook WB;
	public static XSSFSheet WS;
	public static XSSFRow RW;
	public static XSSFCell CL;
	public static FileInputStream FN;
	
	public static int getRowCount(String filename,String sheet) throws Exception
	{
		FN=new FileInputStream(filename);
		WB=new XSSFWorkbook(FN);
		WS=WB.getSheet(sheet);
		int totalrow=WS.getLastRowNum()+1;
		return totalrow;
		
	}
	public static int getCellCount(String filename,String sheet) throws Exception
	{
		FN=new FileInputStream(filename);
		WB=new XSSFWorkbook(FN);
		WS=WB.getSheet(sheet);
		int totalcell=WS.getRow(0).getLastCellNum();
		return totalcell;
		
	}
	public static String getCellValue(String filename,String sheet,int row,int col) throws Exception
	{
		FN=new FileInputStream(filename);
		WB=new XSSFWorkbook(FN);
		CL=WB.getSheet(sheet).getRow(row).getCell(col);
		return CL.getStringCellValue();
		
		
	}
	
}
