package sample;

public class Question
{
    public enum TestType{General, Specific};
    public enum QuestionType{Discursive, Objective};

    private int year;
    private TestType testType;
    private QuestionType questionType;
    private int id;
    private String object;
    private float courseRightQuestions;
    private float regionRightQuestions;
    private float countryRightQuestions;
    private float dif;

    public Question(int year, TestType testType, QuestionType questionType, int id, String object, float courseRightQuestions, float regionRightQuestions, float countryRightQuestions, float dif)
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
