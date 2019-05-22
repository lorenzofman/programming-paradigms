package javaapplication1;

public class Student extends User implements ITaskable
{
    private int id;

    public Student(String name, int age, String cpf, int id) 
    {
        super(name, age, cpf);
        this.id = id;
    }
    
    public Student(User user, int id) 
    {
        super(user.name, user.age, user.cpf);
        this.id = id;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + ", ID: " + id;
    }

    @Override
    public boolean HasFinishedTask() {
        return true;
    }
}
