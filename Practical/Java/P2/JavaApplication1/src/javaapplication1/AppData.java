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
public class AppData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        User user = new User("Lorenzo",Date.addDays(new Date(23,06,2000),2401),"07087921975",true);
        System.out.println(user);
    }
}
