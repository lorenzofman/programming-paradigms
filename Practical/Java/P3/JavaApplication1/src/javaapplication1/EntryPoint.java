package javaapplication1;

import java.util.Random;

public class EntryPoint {

    public static void main(String[] args) 
    {
        Teacher teacher = new Teacher("Alexandre", 53, "47986432312",5400);
        Student student = new Student("Lorenzo", 18, "07084565223",201810231);
        System.out.println(teacher);
        System.out.println(student);
        Random rand = new Random();
        ITaskable task = (rand.nextInt() % 2 == 0) ? student : teacher;
        if(task.HasFinishedTask())
        {
            System.out.println(task + " finished the task");
        }
    }
    
}
