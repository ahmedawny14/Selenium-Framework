package utilies;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilies {

	private static Workbook workbook;
	private static Sheet sheet;

	public static Object[][] getDataFromExcel(String filePath, String fileName)
			throws IOException, InvalidFormatException {
		FileInputStream file = new FileInputStream(filePath);

		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(fileName);

		int rows = sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(0).getPhysicalNumberOfCells();
		Object data[][] = new Object[rows-1][columns];

		for (int i = 1; i < rows; i++) {
            Row row = sheet.getRow(i);

			for (int k = 0; k < columns; k++) {

				data[i-1][k] = sheet.getRow(i).getCell(k).toString();
			}

		}

		return data;
	}

}
