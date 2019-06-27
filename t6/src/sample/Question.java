package sample;

public class Question
{
    public enum TestType{General, Specific};
    public enum QuestionType{Discursive, Objective};

    public int year;
    public TestType testType;
    public QuestionType questionType;
    public int id;
    public String object;
    public float courseRightQuestions;
    public float regionRightQuestions;
    public float countryRightQuestions;
    public float dif;
}
