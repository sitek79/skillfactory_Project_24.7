import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(StudyProfile.values()));
        //
        int sundayIndex = StudyProfile.MEDICINE.ordinal();
        System.out.println(sundayIndex);
        //
        StudyProfile medicine = StudyProfile.valueOf("MEDICINE");
        System.out.println(medicine);
        //
        //
        // создаем объект ArrayList для хранения записей сотрудников
        ArrayList<University> univerRecords = new ArrayList<University>();
        // добавляем записи сотрудников в объект AL
        univerRecords.add(new University("1", "MGU", "MGU", 1380, "Writer"));
        univerRecords.add(new University("1", "MGU", "MGU", 1380, "Writer"));
        univerRecords.add(new University("1", "MGU", "MGU", 1380, "Writer"));
        // извлекаем записи сотрудников с помощью улучшенного цикла forEach
        for(University university : univerRecords) {
            System.out.println(university);
        }
        // создаем объект ArrayList для хранения записей сотрудников
        ArrayList<Student> studentsRecords = new ArrayList<Student>();
        // добавляем записи сотрудников в объект AL
        studentsRecords.add(new Student("Andrey Tikhonov", "MFPU", 19, 20));
        studentsRecords.add(new Student("1", "SJ", 19, 20));
        studentsRecords.add(new Student("1", "SJ", 19, 20));
        // извлекаем записи сотрудников с помощью улучшенного цикла forEach
        for(Student student : studentsRecords) {
            System.out.println(student);
        }
    }
}
