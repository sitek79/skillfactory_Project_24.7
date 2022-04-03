import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadXLSXFile {
    private ReadXLSXFile() {

    }

    public static void readXLSFFile() {
        //XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        try(FileInputStream fin=new FileInputStream("src/main/resources/universityInfo.xlsx"))
        {
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fin);
            //System.out.printf("File size: %d bytes \n", fin.available());
            /*int i=-1;
            while((i=fin.read())!=-1){
                System.out.print((char)i);
            }*/
            xssfWorkbook.workbook.getSheet(имя_страницы).
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
