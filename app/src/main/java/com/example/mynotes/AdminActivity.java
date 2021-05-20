package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    EditText user, pass, repass;
    Button btnreg;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        user = (EditText)findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.pass);
        repass = (EditText)findViewById(R.id.repass);
        btnreg = (Button)findViewById(R.id.btnreg);
        DB = new DBHelper(this);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user1 = user.getText().toString();
                String pass1 = pass.getText().toString();
                String repass1 = repass.getText().toString();

                if(user1.length()==0){
                    user.setError("This field cannot be Empty");
                    user.requestFocus();
                }
                else if(pass1.length()==0){
                    pass.setError("This field cannot be Empty");
                    pass.requestFocus();
                }
                else if(repass1.length() == 0){
                    repass.setError("This field cannot be Empty");
                    repass.requestFocus();
                }
                else{
                    boolean checkuser =DB.checkusername(user1);
                    if(checkuser == false)
                    {
                        if(pass1.equals(repass1))
                        {
                            boolean insert =DB.insertdata(user1, pass1);
                            if(insert == true)
                            {
                                Toast.makeText(AdminActivity.this, "User Registered !", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(AdminActivity.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else{
                        Toast.makeText(AdminActivity.this, "User already Exists...", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}