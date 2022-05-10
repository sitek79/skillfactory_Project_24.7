import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import io.JsonWriter;
import io.ReadXLSXFile;
import io.WriteJSON;
import io.WriteXMLfile;
import io.WriteXlsFile;
import io.XmlWriter;
import model.FullInfo;
import model.Statistics;
import model.Student;
import model.University;
import util.ComparatorUtil;
import util.JsonUtil;
import util.StatisticsUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Application {

    private static final Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(Application.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        logger.log(INFO, "Application started, Logger configured");

        //
        List<University> universities = ReadXLSXFile.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.sort(universityComparator);

        List<Student> students = ReadXLSXFile.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.sort(studentComparator);

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        WriteXlsFile.writeXlsStatistics(statisticsList, "statistics.xlsx");

        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        WriteXMLfile.generateXmlReq(fullInfo);
        WriteJSON.writeJsonReq(fullInfo);

        logger.log(INFO, "Application finished");
    }
}
