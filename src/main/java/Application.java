import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import io.ReadXLSXFile;
import model.Student;
import model.University;
import util.ComparatorUtil;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {

        List<University> universities =
                ReadXLSXFile.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

        List<Student> students =
                ReadXLSXFile.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
        //
        //ReadXLSXFile.readXLSFFile("Студенты");
        //ReadXLSXFile.readXLSFFile("Университеты");
    }
}
