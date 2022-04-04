import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ReadXLSXFile {
    private static final String fileLocation = "src/main/resources/universityInfo.xlsx";

    private ReadXLSXFile() {
    }

    public static void readXLSFFile(String listId) {
        String list = listId;
        //XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        try(FileInputStream file = new FileInputStream(new File(fileLocation)))
        {
            System.out.printf("File size: %d bytes \n", file.available());
            //
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //XSSFSheet datatypeSheet = workbook.getSheet("Студенты");
            //XSSFSheet datatypeSheet = workbook.getSheetAt(0);
            XSSFSheet datatypeSheet = workbook.getSheet(list);
            // перебираем лист 0
            Iterator<Row> iterator = datatypeSheet.iterator();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellType() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }
                }
                System.out.println();
            }
            //
            /*System.out.println(sh.getLastRowNum());
            System.out.println("Name: "+sh.getSheetName());
            Row row = sh.getRow(1);
            System.out.println(row.getRowNum());
            System.out.println("Val: "+sh.getRow(1).getCell(1).getStringCellValue());
            // Университеты
            XSSFSheet sh2 = wb.getSheet("Университеты");
            System.out.println(sh2.getLastRowNum());
            System.out.println("Name: "+sh2.getSheetName());
            Row row2 = sh2.getRow(1);
            System.out.println(row2.getRowNum());
            System.out.println("Val: "+sh2.getRow(1).getCell(1).getStringCellValue());*/
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
