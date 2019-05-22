/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enterprise;

import java.util.ArrayList;

/**
 *
 * @author hp43
 */
public class Manager extends Employee
{
    protected ArrayList<Employee> supervised;
    public Manager(String name, String cpf, int salary, ArrayList<Employee> supervised) 
    {
        super(name, cpf, salary);
        this.supervised = supervised;
    }
    
    public Manager(String name, String cpf, int salary) 
    {
        super(name, cpf, salary);
        this.supervised = null;
    }
    
    @Override
    public String toString()
    {
        String result = super.toString() + "\nSupervised:\n";
        for(Employee empl : supervised)
        {
            result += "\t" + empl.toString() + "\n";
        }
        return result;
    }
    
}
