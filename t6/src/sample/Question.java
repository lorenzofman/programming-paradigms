package sample;

public class Question
{
    //public enum TestType{General, Specific};
    //public enum QuestionType{Discursive, Objective};

    private String year;
    private String testType;
    private String questionType;
    private String id;
    private String object;
    private String courseRightQuestions;
    private String regionRightQuestions;
    private String countryRightQuestions;
    private String dif;

    public Question(String year, String testType, String questionType, String id, String object, String courseRightQuestions, String regionRightQuestions, String countryRightQuestions, String dif)
    {
        this.year = year;
        this.testType = testType;
        this.questionType = questionType;
        this.id = id;
        this.object = object;
        this.courseRightQuestions = courseRightQuestions;
        this.regionRightQuestions = regionRightQuestions;
        this.countryRightQuestions = countryRightQuestions;
        this.dif = dif;
    }
}
