public class Student {
    // внутренние переменные
    String fullName;
    String universityId;
    int currentCourseNumber;
    float avgExamScore;

    public Student() {
        super();
        System.out.println("Student. Конструктор по умолчанию");
        toString();
    }

    // Конструктор с четырьмя аргументами
    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    // переопределение метода toString()
    @Override
    public String toString() {
        return "Student {fullName=" + fullName +
                ", universityId=" + universityId +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore + "}";
    }
}
