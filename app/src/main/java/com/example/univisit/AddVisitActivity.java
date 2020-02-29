package com.example.univisit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddVisitActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    String strSchoolName;
    private RadioGroup rdgVisitorType;
    private RadioButton rdbtnParent, rdbtnStudent, rdbtnAlumni, rdbtnOthers;
    private TextView tvSchoolName;
    private EditText etVisitDate, etVisitTime, etIDNumber;
    private Spinner spinnerPurpose;
    private Button btnBrowse;

    String selectedVisitorType;
    private int vYear, vMonth, vDay, vHour, vMinute;
    private String strVisitDate, strVisitTime, am_pm;
    private final Calendar c = Calendar.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_visit);

        //instantiating the declared variables
        rdgVisitorType = findViewById(R.id.rg_visitor_type);
        rdbtnParent = findViewById(R.id.rdbtn_parent);
        rdbtnStudent = findViewById(R.id.rdbtn_student);
        rdbtnAlumni = findViewById(R.id.rdbtn_alumni);
        rdbtnOthers = findViewById(R.id.rdbtn_others);
        tvSchoolName = findViewById(R.id.tv_school_name);
        etVisitDate = findViewById(R.id.et_choose_date);
        etVisitTime = findViewById(R.id.et_choose_time);
        etIDNumber = findViewById(R.id.et_val_id_num);
        spinnerPurpose = findViewById(R.id.spinner_purpose);
        btnBrowse = findViewById(R.id.btn_browse);

        btnBrowse.setOnClickListener(this);

        rdgVisitorType.setOnCheckedChangeListener(this);
        etVisitDate.setOnClickListener(this);
        etVisitTime.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        
        showDataIntent();
    }

    private void showDataIntent() {
        Bundle bundle = this.getIntent().getExtras();

        if (bundle != null) {
            strSchoolName = bundle.getString("school_name");

            setTitle(strSchoolName);

            tvSchoolName.setText(strSchoolName);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_confirm, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_confirm:
                if (isNotEmptyFields()) {
                    showSuccessDialog();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View customLayout = getLayoutInflater().inflate(R.layout.custom_success_dialog, null);
        builder.setView(customLayout);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private boolean isNotEmptyFields() {

        String visit_date = etVisitDate.getText().toString().trim();
        String visit_time = etVisitTime.getText().toString().trim();
        String id = etIDNumber.getText().toString().trim();

        if (visit_date.isEmpty()) {
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (visit_time.isEmpty()) {
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (id.isEmpty()) {
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        
        switch (id) {
            case R.id.btn_browse: 
                openGalleryIntent();
                break;
            case R.id.et_choose_date:
                getVisitDate();
                break;
            case R.id.et_choose_time:
                getVisitTime();
                break;
        }
        
    }

    private void openGalleryIntent() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (rdbtnAlumni.isChecked()) {
            selectedVisitorType = rdbtnAlumni.getText().toString();
            Toast.makeText(this, selectedVisitorType+"", Toast.LENGTH_SHORT).show();
        }else if (rdbtnParent.isChecked()) {
            selectedVisitorType = rdbtnParent.getText().toString();
            Toast.makeText(this, selectedVisitorType+"", Toast.LENGTH_SHORT).show();
        }else if (rdbtnStudent.isChecked()) {
            selectedVisitorType = rdbtnStudent.getText().toString();
            Toast.makeText(this, selectedVisitorType+"", Toast.LENGTH_SHORT).show();
        }
        else if (rdbtnOthers.isChecked()){
            selectedVisitorType = rdbtnOthers.getText().toString();
            Toast.makeText(this, selectedVisitorType+"", Toast.LENGTH_SHORT).show();
        }
    }

    public void getVisitDate() {
            vYear = c.get(Calendar.YEAR);
            vMinute = c.get(Calendar.MONTH);
            vDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    Calendar mCalendar = Calendar.getInstance();
                    mCalendar.set(year, month, dayOfMonth);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");
                    strVisitDate = simpleDateFormat.format(mCalendar.getTime());

                    etVisitDate.setText(strVisitDate);

            }
        }, vYear, vMonth, vDay);
        datePickerDialog.show();
    }

    public void getVisitTime() {
        vHour = c.get(Calendar.HOUR_OF_DAY);
        vMinute = c.get(Calendar.MINUTE);

        TimePickerDialog dialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        //to get AM or PM
                        if (c.get(Calendar.AM_PM) == Calendar.AM) {
                            am_pm = "AM";
                        } else if (c.get(Calendar.AM_PM) == Calendar.PM) {
                            am_pm = "PM";
                        }

                        strVisitTime= (hourOfDay+":"+minute +" "+am_pm);
                        etVisitTime.setText(strVisitTime);
                    }
                }, vHour, vMinute, true);
        dialog.show();
    }
}
