package javaapplication1;
public class Date 
{
    private int day;
    private int month;
    private int year;
    public Date(int day, int month, int year)
    {
        this.year = Utils.Clamp(year,0,year);
        this.month = Utils.Clamp(month,1,12);
        this.day = Utils.Clamp(day,1,lastDayOfMonth(this.month,this.year));
    }
    
    private static int lastDayOfMonth(int month, int year)
    {
        switch(month)
        {
            case 2:
                return (isLeapYear(year)) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
    private static boolean isLeapYear(int year)
    {
        if(year % 400 == 0)
            return true;
        if(year % 4 == 0 && year % 100 != 0)
            return true;
        return false;
    }
    
    public static Date addDays(Date dt1, int days)
    {
        int day = dt1.day + days;
        int month = dt1.month;
        int year = dt1.year;
        while(day > lastDayOfMonth(month,year))
        {
            day -= lastDayOfMonth(month,year);
            if(++month == 13)
            {
                month = 1;
                year++;
            }
        }
        return new Date(day, month, year);
    }
    
    @Override
    public String toString()
    {
      return String.format("%d/%d/%d",day,month,year);  
    }
}
