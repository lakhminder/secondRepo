package excel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import net.sf.jxls.transformer.XLSTransformer;
import java.io.*;

public class Worksheet
{
	public static String templateFileName = "src/excel/xlsTemplate/OrderSummary_tmpl.xls";
	public void make()
	{
		try
		{
		//XLSTransformer transformer = new XLSTransformer();
		FileInputStream fis = new FileInputStream(templateFileName);
		//FileOutputStream fos = new FileOutputStream(templateFileName);
		//HSSFWorkbook wb     = new HSSFWorkbook();
		HSSFWorkbook wb     = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheet("VOIP");
		int rows=sheet.getPhysicalNumberOfRows();
		System.out.println("Rows: " + rows);
		int cols=3;
		for (int r=0;r<rows;r++)
		{
			HSSFRow row = sheet.getRow(r);//((sheet.getRow(r))!= null ? sheet.getRow(r) : sheet.createRow((short)r)); //sheet.createRow((short)r);sheet.getr
			if(row == null) continue;
			System.out.println(row.getRowNum());
			cols=row.getPhysicalNumberOfCells();
			System.out.println("Cols: " + cols);
			for(int c=0;c<cols;c++)
			{
				HSSFCell cell = row.getCell((short)c);
				if(cell == null) continue;
				//HSSFCell cell   = ((row.getCell((short)c))!= null ? row.getCell((short)c) : row.createCell((short)c));;//;
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue("Test");

			}

		}
		fis.close();
		FileOutputStream fos = new FileOutputStream(templateFileName);
		wb.write(fos);
		fos.close();
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}