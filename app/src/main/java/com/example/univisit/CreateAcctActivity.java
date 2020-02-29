package com.example.univisit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                if (isNotEmptyFields()) {
                    toHome();
                }
                break;
            case R.id.tv_user_sign:
                toSignin();
                break;
        }
    }

    public void toSignin() {
        Intent intent = new Intent(CreateAcctActivity.this, SigninActivity.class);
        startActivity(intent);
    }

    public void toHome() {
        Intent intent = new Intent(CreateAcctActivity.this, UserNavigationActivity.class);
        startActivity(intent);
    }

    public boolean isNotEmptyFields() {
        String lastname = etLname.getText().toString().trim();
        String firstname = etFname.getText().toString().trim();
        String address = etAddr.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassw.getText().toString().trim();

        if (lastname.isEmpty()) {
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (firstname.isEmpty()) {
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (address.isEmpty()) {
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (phone.isEmpty()) {
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (username.isEmpty()) {
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (email.isEmpty()) {
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;

    }
}
