import java.util.Calendar;
import java.util.GregorianCalendar;

    public class Date {
    private Calendar calendar = new GregorianCalendar();
    private int year = calendar.get(Calendar.YEAR);
    private int month = calendar.get(Calendar.MONTH);
    private int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    private String date = Integer.toString(dayOfMonth) + "." + Integer.toString(month) +"." + Integer.toString(year);

    //Static Class Reference
    private static Date obj = null;

    private Date() {
        print();
    }


    public static Date createDate() {
//        This will make sure only one object can be created
        if (obj == null) {
            obj = new Date();
        }
        return obj;
    }

    private void print() {
        System.out.println(date);
    }

}
