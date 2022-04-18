package model;

import enums.StudyProfile;

public class University {
    // внутренние переменные
    String id;
    String fullName;
    String shortName;
    int yearOfFoundation;
    StudyProfile mainProfile;

    public University() {
        super();
        System.out.println("University. Конструктор по умолчанию");
        toString();
    }

    // Конструктор с пятью аргументами
    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    // переопределение метода toString()
    @Override
    public String toString() {
        return "University {id=" + id +
                ", fullName=" + fullName +
                ", shortName=" + shortName +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile + "}";
    }
}
