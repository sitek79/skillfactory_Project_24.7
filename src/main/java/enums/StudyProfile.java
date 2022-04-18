package enums;

public enum StudyProfile {
    //MEDICINE ("Медицина"),
    //CHEMIE ("Химия"),
    //BIOLOGIE ("Биология"),
    //BIOTECHNOLOGIE ("Биотехнология"),
    //PSYCHOLOGIE ("Психология"),
    //PHILOLOGIE ("Филология"),
    //PHILOSOPHIE ("Философия"),
    //
    PHYSICS("Физика"),
    COMPUTER_SCIENCE("Информатика"),
    MATHEMATICS("Математика"),
    JURISPRUDENCE("Юриспруденция"),
    MEDICINE("Медицина"),
    LINGUISTICS("Лингвистика");

    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}
