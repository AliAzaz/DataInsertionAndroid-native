package com.example.ali.trialapp;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener  {

    TextView que1_text,que1_b_text;
    EditText que2_text,que2_b_text,que4_text,que4_b_text,que5_text,que6_text,que10_text;
    Spinner que3_Spinner,que6_Spinner,que7_Spinner,que8_Spinner,que9_Spinner,que10_Spinner;
    Button btn_submit,dateButton,timeButton;

//    TimePicker que1_b_text;
//    CalendarView que1_text;

    ArrayAdapter<CharSequence> adapter;

    String[] familyCode = {"X","Y","Z"};

    String date = "",time="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        que1_text = (TextView) findViewById(R.id.que1_text);
        que1_b_text = (TextView) findViewById(R.id.que1_b_text);

        que2_text = (EditText)findViewById(R.id.que2_text);
        que2_b_text = (EditText)findViewById(R.id.que2_b_text);
        que4_text = (EditText)findViewById(R.id.que4_text);
        que4_b_text = (EditText)findViewById(R.id.que4_b_text);
        que5_text = (EditText)findViewById(R.id.que5_text);
        que6_text = (EditText)findViewById(R.id.que6_text);
        que10_text = (EditText)findViewById(R.id.que10_text);

        que3_Spinner = (Spinner)findViewById(R.id.que3_Spinner);
        que6_Spinner = (Spinner)findViewById(R.id.que6_Spinner);
        que7_Spinner = (Spinner)findViewById(R.id.que7_Spinner);
        que8_Spinner = (Spinner)findViewById(R.id.que8_Spinner);
        que9_Spinner = (Spinner)findViewById(R.id.que9_Spinner);
        que10_Spinner = (Spinner)findViewById(R.id.que10_Spinner);


        que10_text.setVisibility(View.INVISIBLE);

        btn_submit = (Button)findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);

        dateButton = (Button) findViewById(R.id.date_button);
        dateButton.setOnClickListener(this);

        timeButton = (Button) findViewById(R.id.time_button);
        timeButton.setOnClickListener(this);

        adapter = ArrayAdapter.createFromResource(this, R.array.que3_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        que3_Spinner.setAdapter(adapter);

        que6_Spinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,Arrays.asList(familyCode)));

        adapter = ArrayAdapter.createFromResource(this, R.array.que7_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        que7_Spinner.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.que8_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        que8_Spinner.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.que9_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        que9_Spinner.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.que10_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        que10_Spinner.setAdapter(adapter);

        que10_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (que10_Spinner.getSelectedItemId() == 4){
                    que10_text.setVisibility(View.VISIBLE);
                }
                else {
                    que10_text.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        que1_b_text.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
//                time = String.valueOf(timePicker.getCurrentHour()).toString() + ":" + String.valueOf(timePicker.getCurrentMinute()).toString();
//
//                Toast.makeText(getApplicationContext(),time,Toast.LENGTH_SHORT).show();
//            }
//        });

//        que1_text.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
//                date = i2 + " / " + i1 + " / " + i;
//
//                Toast.makeText(getApplicationContext(),date,Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_submit){

//            DatabaseHandler db = new DatabaseHandler(this);
//
//            db.addRecord(new Record());

//            if(que2_text.getText().toString().trim().equals("") && que2_b_text.getText().toString().trim().equals("") &&
//                    que4_text.getText().toString().trim().equals("") && que4_b_text.getText().toString().trim().equals("") &&
//                    que4_b_text.getText().toString().trim().equals("") && que5_text.getText().toString().trim().equals("") &&
//                    que6_text.getText().toString().trim().equals("")) {

                if (que2_text.getText().toString().trim().equals("")) {
                    que2_text.setError("Required! " + getString(R.string.que2).toString());

                    Toast.makeText(getApplicationContext(), getString(R.string.que2), Toast.LENGTH_LONG).show();
                }
                if (que2_b_text.getText().toString().trim().equals("")) {
                    que2_b_text.setError("Required! " + getString(R.string.que2_b).toString());

                    Toast.makeText(getApplicationContext(), getString(R.string.que2_b), Toast.LENGTH_LONG).show();
                }
                if (que4_text.getText().toString().trim().equals("")) {
                    que4_text.setError("Required! " + getString(R.string.que4).toString());

                    Toast.makeText(getApplicationContext(), getString(R.string.que4), Toast.LENGTH_LONG).show();
                }
                if (que4_b_text.getText().toString().trim().equals("")) {
                    que4_b_text.setError("Required! " + getString(R.string.que4_b).toString());

                    Toast.makeText(getApplicationContext(), getString(R.string.que4_b), Toast.LENGTH_LONG).show();
                }
                if (que5_text.getText().toString().trim().equals("")) {
                    que5_text.setError("Required! " + getString(R.string.que5).toString());

                    Toast.makeText(getApplicationContext(), getString(R.string.que5), Toast.LENGTH_LONG).show();
                }
                if (que6_text.getText().toString().trim().equals("")) {
                    que6_text.setError("Required! " + getString(R.string.que6).toString());

                    Toast.makeText(getApplicationContext(), getString(R.string.que6), Toast.LENGTH_LONG).show();
                }
            else {

                DatabaseHandler db = new DatabaseHandler(this);


                db.addRecord(new Record("Que1_date",date));
                db.addRecord(new Record("Que1_time",time));
                db.addRecord(new Record("Que2",que2_text.getText().toString()));
                db.addRecord(new Record("Que2_code",que2_b_text.getText().toString()));
                db.addRecord(new Record("Que2",que4_text.getText().toString()));
                db.addRecord(new Record("Que4_code",que4_b_text.getText().toString()));
                db.addRecord(new Record("Que5",que5_text.getText().toString()));
                db.addRecord(new Record("Que6_code",que6_text.getText().toString()));


                db.addRecord(new Record("Que3",que3_Spinner.getSelectedItem().toString()));
                db.addRecord(new Record("Que6",que6_Spinner.getSelectedItem().toString()));
                db.addRecord(new Record("Que7",que7_Spinner.getSelectedItem().toString()));
                db.addRecord(new Record("Que8",que8_Spinner.getSelectedItem().toString()));
                db.addRecord(new Record("Que9",que9_Spinner.getSelectedItem().toString()));


                if(que10_Spinner.getSelectedItemId() == 4) {
                    db.addRecord(new Record("Que10",que10_text.getText().toString()));
                }else {
                    db.addRecord(new Record("Que10",que10_Spinner.getSelectedItem().toString()));
                }

                Toast.makeText(getApplicationContext(),"Form Submitted", Toast.LENGTH_LONG).show();
            }
        }
        else if(view.getId() == R.id.date_button){
            Calendar now = Calendar.getInstance();
            DatePickerDialog dpd = DatePickerDialog.newInstance(
                    MainActivity.this,
                    now.get(Calendar.YEAR),
                    now.get(Calendar.MONTH),
                    now.get(Calendar.DAY_OF_MONTH)
            );

            dpd.setAccentColor(Color.parseColor("#3f51b5"));

            dpd.setTitle(getString(R.string.que1));

            dpd.show(getFragmentManager(), "Datepickerdialog");
        }
        else if (view.getId() == R.id.time_button){
            Calendar now = Calendar.getInstance();
            TimePickerDialog tpd = TimePickerDialog.newInstance(
                    MainActivity.this,
                    now.get(Calendar.HOUR_OF_DAY),
                    now.get(Calendar.MINUTE),
                    false
            );

            tpd.setAccentColor(Color.parseColor("#3f51b5"));
            tpd.setTitle(getString(R.string.que1_b));

            tpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    Log.d("TimePicker", "Dialog was cancelled");
                }
            });
            tpd.show(getFragmentManager(), "Timepickerdialog");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        DatePickerDialog dpd = (DatePickerDialog) getFragmentManager().findFragmentByTag("Datepickerdialog");
        if(dpd != null) dpd.setOnDateSetListener(this);

        TimePickerDialog tpd = (TimePickerDialog) getFragmentManager().findFragmentByTag("Timepickerdialog");
        if(tpd != null) tpd.setOnTimeSetListener(this);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        date = dayOfMonth+ " / " + (++monthOfYear)  + " / " + year;

//        Toast.makeText(getApplicationContext(),date,Toast.LENGTH_SHORT).show();

        que1_text.setText("Date: "+date);
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String hourString = hourOfDay < 10 ? "0"+hourOfDay : ""+hourOfDay;
        String minuteString = minute < 10 ? "0"+minute : ""+minute;
        String secondString = second < 10 ? "0"+second : ""+second;
        time = hourString+":"+minuteString+":"+secondString;

//        Toast.makeText(getApplicationContext(),time,Toast.LENGTH_SHORT).show();

        que1_b_text.setText("Time: "+time);
    }
}
