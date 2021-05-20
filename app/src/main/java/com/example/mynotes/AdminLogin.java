package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    EditText admin_user, admin_pass;
    Button btnadm;
    private int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        admin_user = (EditText)findViewById(R.id.admin_user);
        admin_pass = (EditText)findViewById(R.id.admin_pass);
        btnadm = (Button)findViewById(R.id.btnadm);

        btnadm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(admin_user.getText().toString(), admin_pass.getText().toString());
            }
        });
    }

    public void validate(String UserName, String Password)
    {
        String user = UserName;
        String pass = Password;
        if(user.length()==0){
            admin_user.setError("This field cannot be Empty");
            admin_user.requestFocus();
        }
        else if(pass.length()==0){
            admin_pass.setError("This field cannot be Empty");
            admin_pass.requestFocus();
        }
        else{
            if(UserName.equals("admin") && Password.equals("12345")) {
                Intent i = new Intent(AdminLogin.this, AdminActivity.class);
                startActivity(i);
            }
            else{
                count--;

                Toast.makeText(AdminLogin.this, "Invalid Credentials !", Toast.LENGTH_SHORT).show();

                if(count == 0)
                {
                    btnadm.setEnabled(false);
                }
            }
        }
    }
}