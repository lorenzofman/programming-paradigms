/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enterprise;

/**
 *
 * @author hp43
 */
public class Employee 
{
    protected String name;
    protected String cpf;
    protected int salary;
    public Employee(String name, String cpf, int salary)
    {
        setName(name);
        setCPF(cpf);
        setSalary(salary);
    }
        
    public String getName()
    {
        return name;
    }
    
    public String getCPF()
    {
        return cpf;
    }
    
    public int getSalary()
    {
        return salary;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    private void setCPF(String cpf) 
    {
        this.cpf = cpf;
    }

    private void setSalary(int salary) 
    {
        this.salary = salary;
    }
    
    @Override
    public String toString()
    {
        return name;
    }
    
}
