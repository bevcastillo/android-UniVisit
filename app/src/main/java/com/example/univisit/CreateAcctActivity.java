package com.example.univisit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.scottyab.showhidepasswordedittext.ShowHidePasswordEditText;

public class CreateAcctActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etFname, etLname, etAddr, etPhone, etUsername, etEmail;
    private ShowHidePasswordEditText etPassw;
    private Button btnCreate;
    private TextView tvSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acct);

        etFname = (EditText) findViewById(R.id.et_fname);
        etLname = (EditText) findViewById(R.id.et_lname);
        etAddr = (EditText) findViewById(R.id.et_addr);
        etPhone = (EditText) findViewById(R.id.et_phone);
        etUsername = (EditText) findViewById(R.id.et_username);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassw = (ShowHidePasswordEditText) findViewById(R.id.et_passw);
        btnCreate = (Button) findViewById(R.id.btn_user_create);
        tvSignin = (TextView) findViewById(R.id.tv_user_sign);

        btnCreate.setOnClickListener(this);
        tvSignin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_user_create:
                break;
            case R.id.tv_user_sign:
                break;
        }
    }
}
