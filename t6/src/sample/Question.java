package sample;

import javafx.beans.property.SimpleStringProperty;

public class Question
{
    //public enum TestType{General, Specific};
    //public enum QuestionType{Discursive, Objective};

    private SimpleStringProperty year;
    private SimpleStringProperty testType;
    private SimpleStringProperty questionType;
    private SimpleStringProperty id;
    private SimpleStringProperty object;
    private SimpleStringProperty courseRightQuestions;
    private SimpleStringProperty regionRightQuestions;
    private SimpleStringProperty countryRightQuestions;
    private SimpleStringProperty dif;

    public String getYear()
    {
        return year.get();
    }

    public SimpleStringProperty yearProperty()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year.set(year);
    }

    public String getTestType()
    {
        return testType.get();
    }

    public SimpleStringProperty testTypeProperty()
    {
        return testType;
    }

    public void setTestType(String testType)
    {
        this.testType.set(testType);
    }

    public String getQuestionType()
    {
        return questionType.get();
    }

    public SimpleStringProperty questionTypeProperty()
    {
        return questionType;
    }

    public void setQuestionType(String questionType)
    {
        this.questionType.set(questionType);
    }

    public String getId()
    {
        return id.get();
    }

    public SimpleStringProperty idProperty()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id.set(id);
    }

    public String getObject()
    {
        return object.get();
    }

    public SimpleStringProperty objectProperty()
    {
        return object;
    }

    public void setObject(String object)
    {
        this.object.set(object);
    }

    public String getCourseRightQuestions()
    {
        return courseRightQuestions.get();
    }

    public SimpleStringProperty courseRightQuestionsProperty()
    {
        return courseRightQuestions;
    }

    public void setCourseRightQuestions(String courseRightQuestions)
    {
        this.courseRightQuestions.set(courseRightQuestions);
    }

    public String getRegionRightQuestions()
    {
        return regionRightQuestions.get();
    }

    public SimpleStringProperty regionRightQuestionsProperty()
    {
        return regionRightQuestions;
    }

    public void setRegionRightQuestions(String regionRightQuestions)
    {
        this.regionRightQuestions.set(regionRightQuestions);
    }

    public String getCountryRightQuestions()
    {
        return countryRightQuestions.get();
    }

    public SimpleStringProperty countryRightQuestionsProperty()
    {
        return countryRightQuestions;
    }

    public void setCountryRightQuestions(String countryRightQuestions)
    {
        this.countryRightQuestions.set(countryRightQuestions);
    }

    public String getDif()
    {
        return dif.get();
    }

    public SimpleStringProperty difProperty()
    {
        return dif;
    }

    public void setDif(String dif)
    {
        this.dif.set(dif);
    }


    public Question(String year, String testType, String questionType, String id, String object, String courseRightQuestions, String regionRightQuestions, String countryRightQuestions, String dif)
    {
        this.year = new SimpleStringProperty(year);
        this.testType = new SimpleStringProperty(testType);
        this.questionType = new SimpleStringProperty(questionType);
        this.id = new SimpleStringProperty(id);
        this.object = new SimpleStringProperty(object);
        this.courseRightQuestions = new SimpleStringProperty(courseRightQuestions);
        this.regionRightQuestions = new SimpleStringProperty(regionRightQuestions);
        this.countryRightQuestions = new SimpleStringProperty(countryRightQuestions);
        this.dif = new SimpleStringProperty(dif);
    }
}
