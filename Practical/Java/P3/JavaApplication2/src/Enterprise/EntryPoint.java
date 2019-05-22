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
public class EntryPoint {

    public static void main(String[] args) 
    {
        Employee janitor = new Employee("Monroe","12345678099",2500);
        Employee janitor2 = new Employee("Monroe2","12345678099",2000);
        Employee janitor3 = new Employee("Monroe3","12345678099",2500);
        ArrayList<Employee> managedEmployees = new ArrayList<Employee>();
        managedEmployees.add(janitor);
        managedEmployees.add(janitor2);
        managedEmployees.add(janitor3);
        Manager manager = new Manager("Dylan","98765432101",8000, managedEmployees);
        System.out.println(manager);
    }
    
}
