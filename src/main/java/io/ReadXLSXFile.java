package io;

import enums.StudyProfile;
import model.Student;
import model.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadXLSXFile {
    //private static final String fileLocation = "src/main/resources/universityInfo.xlsx";

    private ReadXLSXFile() {
    }

    /*public static void readXLSFFile(String listId) {
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
            *//*System.out.println(sh.getLastRowNum());
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
            System.out.println("Val: "+sh2.getRow(1).getCell(1).getStringCellValue());*//*
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }*/

    public static List<University> readXlsUniversities(String filePath) throws IOException {

        List<University> universities = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Университеты");

        Iterator<Row> rows = sheet.iterator();
        rows.next();

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            University university = new University();
            universities.add(university);
            university.setId(currentRow.getCell(0).getStringCellValue());
            university.setFullName(currentRow.getCell(1).getStringCellValue());
            university.setShortName(currentRow.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int)currentRow.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
        }

        return universities;
    }

    public static List<Student> readXlsStudents(String filePath) throws IOException {

        List<Student> students = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Студенты");

        Iterator<Row> rows = sheet.iterator();
        rows.next();

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            Student student = new Student();
            students.add(student);
            student.setUniversityId(currentRow.getCell(0).getStringCellValue());
            student.setFullName(currentRow.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int)currentRow.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float)currentRow.getCell(3).getNumericCellValue());
        }

        return students;
    }
}
