package week5.day3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel
{
    public static void main(String[] args) throws IOException {
        //File path
        String filePath = "./data/CreateLead.xlsx";
        //Create workbook
        XSSFWorkbook workBook = new XSSFWorkbook(filePath);
    int sheetCount = workBook.getNumberOfSheets();
    for(int i=0; i< sheetCount;i++)
    {
        System.out.println(workBook.getSheetName(i));
    }

        //Get sheet
       XSSFSheet sheet = workBook.getSheet("Sheet1");
       //Row and Column count
       int totalRowCount = sheet.getLastRowNum();
       int totalCellCount = sheet.getRow(0).getLastCellNum();

       //Loop through rows
       for(int i=0; i<=totalRowCount; i++)
       {
        System.out.print("|\t");

        //Loo through columns
        for(int j=0; j<totalCellCount; j++)
        {
            String data = sheet.getRow(i).getCell(j).getStringCellValue();
            System.out.print(data + "\t|\t");
            //System.out.printf("%-15s | ", data);
        }
       System.out.println(); // new line

       }

    }
}