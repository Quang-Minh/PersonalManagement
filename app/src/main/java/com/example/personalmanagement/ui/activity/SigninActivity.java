package com.example.personalmanagement.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalmanagement.R;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtEmail, edtPassword;
    TextView tvForgotPassword, tvToSignup;
    Button btnLogin;
    CheckBox cboRememberAcc;
    private String fileName = "account.txt";
    private String filePath = "MyAccount";
    private String keyEmail = "email";
    private String keyPassword = "password";
    private String keyCheck = "isRemember";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        initViews();
        restoreInfoAccountRemembered();
        // views on click
        btnLogin.setOnClickListener(this);
        tvToSignup.setOnClickListener(this);
        //  tvForgotPassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btnLogin) {
            login();
        } else if (v == tvToSignup) {
            startActivity(new Intent(SigninActivity.this, SignupActivity.class));
        }
    }

    private void initViews() {
        btnLogin = findViewById(R.id.btnLogin);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvToSignup = findViewById(R.id.tvToSignup);
        cboRememberAcc = findViewById(R.id.cboRemamberAcc);
    }

    private void login() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(getApplicationContext(),"Mời nhập đầy đủ thông tin đăng nhập!",Toast.LENGTH_LONG).show();
            if (email.isEmpty()){
                edtEmail.setError("Mời nhập Email!");
                edtEmail.setFocusable(true);
            }else if (password.isEmpty()){
                edtPassword.setError("Mời nhập mật khẩu!");
                edtPassword.setFocusable(true);
            }
        }else{
            saveInfoAccountRemembered();
            startActivity(new Intent(SigninActivity.this, MainActivity.class));
            SigninActivity.this.finish();
        }

    }

    public void saveInfoAccountRemembered() {
        boolean isRemember = cboRememberAcc.isChecked();
        SharedPreferences sharedPreferences = getSharedPreferences("my_account", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (!isRemember) {
            editor.clear();
        } else {
            editor.putString(keyEmail, email);
            editor.putString(keyPassword, password);
            editor.putBoolean(keyCheck, isRemember);
        }
        editor.commit();

    }

    public void restoreInfoAccountRemembered() {
        SharedPreferences sharedPreferences = getSharedPreferences("my_account", MODE_PRIVATE);
        boolean isRemember = sharedPreferences.getBoolean(keyCheck, false);
        if (isRemember) {
            edtEmail.setText(sharedPreferences.getString(keyEmail, ""));
            edtPassword.setText(sharedPreferences.getString(keyPassword, ""));
        }
        cboRememberAcc.setChecked(isRemember);
    }

}