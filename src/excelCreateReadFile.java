import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class excelCreateReadFile {
    static File f = new File("tools");
    // Get the absolute path of file f
    static String absolute = f.getAbsolutePath();
    private static final String EXCEL_FILE_PATH = absolute+"\\Balance.xlsx";
    public static void main(String[] args) throws IOException {

        try {
//declare file name to be create
            String filename = EXCEL_FILE_PATH;
//creating an instance of HSSFWorkbook class
            HSSFWorkbook workbook = new HSSFWorkbook();
//invoking creatSheet() method and passing the name of the sheet to be created
            HSSFSheet sheet2 = workbook.createSheet("January");
//creating the 0th row using the createRow() method
            HSSFRow rowhead = sheet2.createRow((short) 0);
//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method
            rowhead.createCell(0).setCellValue("S.No.");
            rowhead.createCell(1).setCellValue("Customer Name");
            rowhead.createCell(2).setCellValue("Account Number");
            rowhead.createCell(3).setCellValue("e-mail");
            rowhead.createCell(4).setCellValue("Balance");
//creating the 1st row
            HSSFRow row = sheet2.createRow((short) 1);
//inserting data in the first row
            row.createCell(0).setCellValue("1");
            row.createCell(1).setCellValue("John William");
            row.createCell(2).setCellValue("9999999");
            row.createCell(3).setCellValue("william.john@gmail.com");
            row.createCell(4).setCellValue("700000.00");
//creating the 2nd row
            HSSFRow row1 = sheet2.createRow((short) 2);
//inserting data in the second row
            row1.createCell(0).setCellValue("2");
            row1.createCell(1).setCellValue("Mathew Parker");
            row1.createCell(2).setCellValue("22222222");
            row1.createCell(3).setCellValue("parker.mathew@gmail.com");
            row1.createCell(4).setCellValue("200000.00");
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
//closing the Stream
            fileOut.close();
//closing the workbook
            workbook.close();
//prints the message on the console
            System.out.println("Excel file has been generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileInputStream fis = new FileInputStream(new File(EXCEL_FILE_PATH));
//creating workbook instance that refers to .xls file
        HSSFWorkbook wb = new HSSFWorkbook(fis);
//creating a Sheet object to retrieve the object
        HSSFSheet sheet = wb.getSheetAt(0);
//evaluating cell type
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        for (Row row : sheet)     //iteration over row using for each loop
        {
            for (Cell cell : row)    //iteration over cell using for each loop
            {
                switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:   //field that represents numeric cell type
//getting the value of the cell as a number
                        System.out.print(cell.getNumericCellValue() + "\t\t");
                        break;
                    case Cell.CELL_TYPE_STRING:    //field that represents string cell type
//getting the value of the cell as a string
                        System.out.print(cell.getStringCellValue() + "\t\t");
                        break;
                }
            }
            System.out.println();
        }
    }
}


