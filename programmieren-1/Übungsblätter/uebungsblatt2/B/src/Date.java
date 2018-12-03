import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {

   private static Calendar calendar = new GregorianCalendar();

    private int year       = calendar.get(Calendar.YEAR);
    private int month      = calendar.get(Calendar.MONTH);
    private int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

//    private String year1= Integer.toString( year);
//    private String month1= Integer.toString( month);
//    private String dayofmonth1= Integer.toString( dayOfMonth);
    private Date(int dayOfMonth, int month, int year){
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.year = year;

    }

    private String date = dayofmonth1 + "." + month1 +"." + year1;

    public void printDate(){
        System.out.println(date);
    }


    public String getDate() {
        return date;
    }
}
