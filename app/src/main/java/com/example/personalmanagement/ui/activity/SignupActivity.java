package com.example.personalmanagement.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalmanagement.R;

import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtEmail, edtPassword;
    TextView tvToSignin;
    Button btnSignup;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnSignup = findViewById(R.id.btnSignup);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        tvToSignin = findViewById(R.id.tvToLogin);
        progressDialog = new ProgressDialog(SignupActivity.this);
        progressDialog.setMessage("Đăng ký...");
        // views on click
        btnSignup.setOnClickListener(this);
        tvToSignin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (btnSignup.equals(v)) {

            signup();
        } else if (tvToSignin.equals(v)) {
            startActivity(new Intent(SignupActivity.this, SigninActivity.class));
            SignupActivity.this.finish();
        }
    }

    private void signup() {
        // to do here
        String email = edtEmail.getText().toString().trim();
        String passowrd = edtPassword.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.setError("Sai định dạng Email! VD: example@gmail.com");
            edtEmail.setFocusable(true);

        } else if (passowrd.length() < 6) {
            edtPassword.setError("Mời nhập mật khẩu dài ít nhất 6 kí tự!");
            edtPassword.setFocusable(true);

        } else {
            progressDialog.show();

                        new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(2000);
                        progressDialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {

                    }
                }
            }.start();
            Toast.makeText(SignupActivity.this, "Đăng kí thành công!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(SignupActivity.this, SigninActivity.class));
            SignupActivity.this.finish();
        }




    }



}