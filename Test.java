import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws ParseException {
        int hours = 2;
        Date canReplicateAfterDate = getDate(hours);
        //System.out.println("Current date" + new Date());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse("2022-05-24 09:00:00"); //Exported Date
        Date date2 = sdf.parse("2022-05-23 10:00:00"); //24 hours minus
        System.out.println(date1 + " " + date2);

        System.out.println(date1.after(date2));

       // System.out.println("canReplicateAfterDate" + canReplicateAfterDate);
        //System.out.println(new Date().before(canReplicateAfterDate));

    }

    private static Date getDate(int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -hours);
        return calendar.getTime();
    }

}
