package com.example.univisit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddVisitActivity extends AppCompatActivity implements View.OnClickListener {

    String strSchoolName;
    private RadioGroup rdgVisitorType;
    private RadioButton rdbtnParent, rdbtnStudent, rdbtnAlumni, rdbtnOthers;
    private TextView tvSchoolName;
    private EditText etVisitDate, etVisitTime, etIDNumber;
    private Spinner spinnerPurpose;
    private Button btnBrowse;

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
                showSuccessDialog();
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        
        switch (id) {
            case R.id.btn_browse: 
                openGalleryIntent();
                break;
        }
        
    }

    private void openGalleryIntent() {
    }
}
