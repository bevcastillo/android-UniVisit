package com.example.univisit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mikhaellopez.circularimageview.CircularImageView;

public class MyAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etLastname, etFirstname, etPhone, etAddress, etUsername, etEmail, etPassword;
    private CircularImageView civImage;
    private Button btnBrowse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        setTitle("My Account");

        //instantiate variables
        etLastname = findViewById(R.id.et_lastname);
        etFirstname = findViewById(R.id.et_firstname);
        etPhone = findViewById(R.id.et_phone_number);
        etAddress = findViewById(R.id.et_address);
        etUsername = findViewById(R.id.et_username);
        etEmail = findViewById(R.id.et_email_address);
        etPassword = findViewById(R.id.et_password);
        civImage = findViewById(R.id.civ_user_image);
        btnBrowse = findViewById(R.id.btn_browse_image);

        btnBrowse.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_browse_image:
                break;
        }
    }
}
