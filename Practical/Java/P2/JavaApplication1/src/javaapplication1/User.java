/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author hp43
 */
public class User 
{
    private String name;
    private Date birthday;
    private String cpf;
    private boolean gender; // False - Female, True - Male
    public User(String name, Date birthday, String cpf, boolean gender)
    {
        this.name = name;
        this.birthday = birthday;
        this.cpf = cpf;
        this.gender = gender;
    }
    public User(String name, int day, int month, int year, String cpf, boolean gender)
    {
        this.name = name;
        this.birthday = new Date(day,month,year);
        this.cpf = cpf;
        this.gender = gender;
    }
    @Override
    public String toString()
    {
        return String.format("Name: %s, Birthday: %s, Gender: %s, CPF: %s",
                name,
                birthday.toString(),
                gender ? "M" : "F",
                cpf);
    }
}
