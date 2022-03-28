public enum StudyProfile {

    MEDICINE ("Медицина"),
    CHEMIE ("Химия"),
    BIOLOGIE ("Биология"),
    BIOTECHNOLOGIE ("Биотехнология"),
    PSYCHOLOGIE ("Психология"),
    PHILOLOGIE ("Филология"),
    PHILOSOPHIE ("Философия");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    @Override
    public String toString() {
        return "StudyProfile{" +
                "profileName='" + profileName + '\'' +
                '}';
    }
}
