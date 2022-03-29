import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // ---- все поля класса StudyProfile ----
        System.out.println(Arrays.toString(StudyProfile.values()));
        // только одно поле класса StudyProfile
        int sundayIndex = StudyProfile.MEDICINE.ordinal();
        System.out.println(sundayIndex);
        //
        StudyProfile medicine = StudyProfile.valueOf("MEDICINE");
        System.out.println(medicine);
        //
        //System.out.println(Arrays.toString(new Student[]{new Student()}));
        //
        //System.out.println(Arrays.toString(new University[]{new University()}));
        //
        // Вызываем конструктор с параметрами для класса Student
        System.out.println("конструктор с параметрами для Student");
        Student stud = new Student("Tikhonov Andrey", "Dude", 42, 4);
        // создаем объект ArrayList для хранения записей сотрудников
        ArrayList<Student> studentsRecords = new ArrayList<Student>();
        // добавляем записи сотрудников в объект AL
        studentsRecords.add(new Student("Andrey Tikhonov", "MFPU", 19, 20));
        studentsRecords.add(stud);
        // извлекаем записи сотрудников с помощью улучшенного цикла forEach
        for(Student student : studentsRecords) {
            System.out.println(student);
        }
        //
        // Вызываем конструктор с параметрами для класса University
        System.out.println("конструктор с параметрами для University");
        University univer = new University("1", "MGU", "MGU", 1380, StudyProfile.valueOf("PSYCHOLOGIE"));
        StudyProfile studyProfile = StudyProfile.MEDICINE;
        // создаем объект ArrayList для хранения записей сотрудников
        ArrayList<University> univerRecords = new ArrayList<University>();
        // добавляем записи сотрудников в объект AL
        univerRecords.add(new University("1", "MGU", "MGU", 1380, studyProfile));
        // извлекаем записи сотрудников с помощью улучшенного цикла forEach
        for(University university : univerRecords) {
            System.out.println(university);
        }
    }
}
