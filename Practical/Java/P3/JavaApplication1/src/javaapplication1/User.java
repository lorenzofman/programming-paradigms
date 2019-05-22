package javaapplication1;

public class User 
{
    protected String name;
    protected int age;
    protected String cpf;
    public User(String name, int age, String cpf)
    {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
    }
    @Override 
    public String toString()
    {
        return "Name: " + name + ", Age: " + age + ", CPF:" + cpf;
    }
}
