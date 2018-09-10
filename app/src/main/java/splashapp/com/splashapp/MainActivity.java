package splashapp.com.splashapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Date i ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t = (TextView) findViewById(R.id.textvie);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar_cyclic);


        /*Calendar c = Calendar.getInstance();
        String s = String.valueOf(c.get(Calendar.MONTH)+1);*/

        /*DateFormat sdf = SimpleDateFormat.getDateInstance();
         String currentDate = sdf.format(new Date());*/

        /*Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String todayAsString = dateFormat.format(today);
        String tomorrowAsString = dateFormat.format(tomorrow);

        System.out.println(todayAsString);
        System.out.println(tomorrowAsString);*/

        final long ONE_MINUTE_IN_MILLIS=60000;//millisecs

        Calendar date = Calendar.getInstance();
        /*long tex= date.getTimeInMillis();
        Date afterAddingTenMins=new Date(tex + (1 * ONE_MINUTE_IN_MILLIS));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

        Date today = Calendar.getInstance().getTime();
        String date1 = simpleDateFormat.format(today);
        Log.d("date string",date1);

        /*String todayAsString = dateFormat.format(afterAddingTenMins);
        Log.d("date string",todayAsString);*/

       /* try {
            Date date1 = dateFormat.parse(todayAsString);
            String s = simpleDateFormat.format(date1);
            Log.d("date stringsss",s);

        } catch (ParseException e) {
            e.printStackTrace();
        }*/


    }
}
