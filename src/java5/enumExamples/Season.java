package java5.enumExamples;

public enum Season {
    SPRING("Spring"),
    SUMMER("Summer"),
    FALL("Fall"),
    WINTER("Winter");

    private String currentSeason;

    private Season(String type) {
        this.currentSeason =type;
    }

    public String getType() {
        return currentSeason;
    }
}

