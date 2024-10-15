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

public class Person2 extends AppCompatActivity {


    private String name1, age1, gender1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_person2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Intent i = getIntent();
        name1 = i.getStringExtra("name1");
        age1 = i.getStringExtra("age1");
        gender1 = i.getStringExtra("gender1");

    }

    public void continueButton(View view){
        Intent i = new Intent(this,ResultsActivity.class);

        EditText name = findViewById(R.id.editTextText);
        EditText age = findViewById(R.id.editTextNumber);
        EditText gender = findViewById(R.id.editTextText3);

        i.putExtra("name1",name1);
        i.putExtra("age1",age1);
        i.putExtra("gender1",gender1);

        i.putExtra("name2",name.getText().toString());
        i.putExtra("age2",age.getText().toString());
        i.putExtra("gender2",gender.getText().toString());





        startActivity(i);
    }

}