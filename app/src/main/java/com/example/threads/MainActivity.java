package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    boolean isopened=false;
    TextView currentDateTime;
    Calendar dateAndTime = Calendar.getInstance();
//    MyTask mt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentDateTime=(TextView)findViewById(R.id.textView);


        Runnable runn=new Runnable() {
            @Override
            public void run() {
                View v = findViewById(R.id.mainframe);
                for (; ; ) {
                    try {
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    v.post(new Runnable() {
                        @Override
                        public void run() {

                            if (currentDateTime.getText().length() > 0) {
                                if (String.valueOf(dateAndTime.get(Calendar.HOUR_OF_DAY)).equals(String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))) &&
                                        String.valueOf(dateAndTime.get(Calendar.MINUTE)).equals(String.valueOf(Calendar.getInstance().get(Calendar.MINUTE)))) {

//                                    Toast.makeText(getApplicationContext(), "same", Toast.LENGTH_LONG).show();
                                    AlarmDialog fragment = new AlarmDialog();
                                    fragment.show(getSupportFragmentManager(), "custom");


                                }

                            }

                        }

                    });
                }
            }
        };

        Thread threa=new Thread(runn);
        threa.start();

//        mt = new MyTask();
//        mt.execute();
    }






//    public  void onClick(View v){
//
//    }

//    class MyTask extends AsyncTask<Void, Void, Void> {
//        @Override
//        protected void onProgressUpdate(Void... values) {
//            super.onProgressUpdate(values);
//            AlarmDialog fragment = new AlarmDialog();
//            fragment.show(getSupportFragmentManager(), "custom");
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            try {
//                TimeUnit.SECONDS.sleep(30);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (currentDateTime.getText().length() > 0) {
//                if (String.valueOf(dateAndTime.get(Calendar.HOUR_OF_DAY)).equals(String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))) &&
//                        String.valueOf(dateAndTime.get(Calendar.MINUTE)).equals(String.valueOf(Calendar.getInstance().get(Calendar.MINUTE)))) {
//                        onProgressUpdate();
////                                    Toast.makeText(getApplicationContext(), "same", Toast.LENGTH_LONG).show()
//
//
//                }
//            }
//            return null;
//        }
//
////        @Override
////        protected void onPostExecute(Void aVoid) {
////            super.onPostExecute(aVoid);
////        }
//    }



    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTime();
        }


    };


    public void setTime(View v){
        new TimePickerDialog(MainActivity.this,
                t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),

                dateAndTime.get(Calendar.MINUTE),
                true
        ).show();

    }

    private void setInitialDateTime(){
        currentDateTime.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                 DateUtils.FORMAT_SHOW_TIME));

    }
}