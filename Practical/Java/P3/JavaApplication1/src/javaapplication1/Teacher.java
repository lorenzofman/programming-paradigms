package javaapplication1;

public class Teacher extends User implements ITaskable
{
    private int salary;
    
    public Teacher(String name, int age, String cpf, int salary) 
    {
        super(name, age, cpf);
        this.salary = salary;
    }
    
    public Teacher(User user, int salary) 
    {
        super(user.name, user.age, user.cpf);
        this.salary = salary;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + ", Salary: " + salary;
    }

    @Override
    public boolean HasFinishedTask() {
        return true;
    }

    
}
