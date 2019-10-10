package com.example.lab_exam_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //DAVID LYNCH C16394221

    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextConfirm;
    EditText editTextDuration;

    Button button;

    String email, password, confirm;
    int duration;

    Boolean valid = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirm = (EditText) findViewById(R.id.editTextConfirm);
        editTextDuration = (EditText) findViewById(R.id.editTextDuration);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString().trim();
                confirm = editTextConfirm.getText().toString().trim();
                duration = Integer.parseInt(editTextDuration.getText().toString());
                if(!(password.length() >=6) || password.contains(" ")){
                    Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_LONG).show();
                    valid = false;
                }
                if(!password.equals(confirm)){
                    Toast.makeText(MainActivity.this, "Passwords Must Match !", Toast.LENGTH_LONG).show();
                    valid = false;
                }

                if(email.contains(" ") || !email.contains("@") || email.startsWith("@") || email.endsWith("@")){
                    Toast.makeText(MainActivity.this, "Invalid Email", Toast.LENGTH_LONG).show();
                    valid = false;
                }
                if(duration < 0){
                    Toast.makeText(MainActivity.this, "Duration Cant be negative", Toast.LENGTH_LONG).show();
                    valid = false;
                }


                if(valid == true) {
                    Intent intent = new Intent(MainActivity.this, Display.class);
                    intent.putExtra("Email", email);
                    intent.putExtra("Password", password);
                    intent.putExtra("Confirm", confirm);

                    intent.putExtra("Duration", Integer.toString(duration));
                    startActivity(intent);
                }
                valid =true; //Used to reset the variable
            }
        });
    }
}
