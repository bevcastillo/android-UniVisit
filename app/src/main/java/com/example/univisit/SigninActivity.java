package com.example.univisit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsername, etPassw;
    private Button btnSignin;
    private TextView tvCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        etUsername = (EditText) findViewById(R.id.et_username);
        etPassw = (EditText) findViewById(R.id.et_passw);
        btnSignin = (Button) findViewById(R.id.btn_user_sign);
        tvCreate = (TextView) findViewById(R.id.tv_user_create);

        btnSignin.setOnClickListener(this);
        tvCreate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_user_sign:
                break;
            case R.id.tv_user_create:
                toCreate();
                break;
        }
    }

//    private void toHome() {
//        Intent intent = new Intent(SigninActivity.this, CreateAcctActivity.class);
//        startActivity(intent);
//    }

    private void toCreate() {
        Intent intent = new Intent(SigninActivity.this, CreateAcctActivity.class);
        startActivity(intent);
    }
}
