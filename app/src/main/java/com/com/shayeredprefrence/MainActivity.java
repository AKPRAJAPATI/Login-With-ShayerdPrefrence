package com.com.shayeredprefrence;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText enter_your_password,loginEdit;
    Button button_Login, showYourdata;
    String myPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enter_your_password = findViewById(R.id.passwordEdit);
        loginEdit = findViewById(R.id.logindEdit);

        button_Login = findViewById(R.id.buttonClick);
        showYourdata = findViewById(R.id.seeClick);
        button_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        showYourdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enterSavePassword = loginEdit.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("shareAkash",MODE_PRIVATE);
                String value = sharedPreferences.getString("text","");
                if (enterSavePassword.equals(value)){
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void saveData() {
        String enterpass = enter_your_password.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("shareAkash",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("text",enterpass);
        editor.apply();
    }
}

