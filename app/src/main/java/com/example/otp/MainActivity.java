package com.example.otp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {



    private CountryCodePicker countryCodePicker;
    private EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryCodePicker = findViewById(R.id.ccp);
        number = findViewById(R.id.editText);
        Button next = findViewById(R.id.btn);
        countryCodePicker.registerCarrierNumberEditText(number);

        next.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if(number.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter No ....", Toast.LENGTH_SHORT).show();
                }
                else if(number.getText().toString().replace(" ","").length()!=10){
                    Toast.makeText(MainActivity.this, "Enter Correct No ...", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this,otpactivity.class);
                    intent.putExtra("number",countryCodePicker.getFullNumberWithPlus().replace(" ",""));
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}