package com.example.loveappreal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Person1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_person1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void continueButton(View view){
        Intent i = new Intent(this,Person2.class);
        EditText name = findViewById(R.id.editTextText);
        EditText age = findViewById(R.id.editTextNumber);
        EditText gender = findViewById(R.id.editTextText3);

        i.putExtra("name1",name.getText().toString());
        i.putExtra("age1",age.getText().toString());
        i.putExtra("gender1",gender.getText().toString());

        startActivity(i);
    }
}