package com.example.loveappreal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_results);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String name1, age1, gender1, name2, age2, gender2;

        Intent i = getIntent();
        name1 = i.getStringExtra("name1");
        age1 = i.getStringExtra("age1");
        gender1 = i.getStringExtra("gender1");
        name2 = i.getStringExtra("name2");
        age2 = i.getStringExtra("age2");
        gender2 = i.getStringExtra("gender2");


       /* double match = calculateMatch(Integer.parseInt(age1),Integer.parseInt(age2),name1,name2);



        EditText text1 = findViewById(R.id.edit1);
        EditText text2 = findViewById(R.id.edit2);

        text1.setText("Match:"+(int)match + "%");

        text2.setText(relationRemark(match));*/

        EditText text1 = findViewById(R.id.edit1);
        EditText text2 = findViewById(R.id.edit2);

        text1.setText(name1 + " and " + name2);
        
        String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 .,-'~";
        
        int sum1 = 0;
        int sum2 = 0;
        
        for(int i1 = 0;i1<name1.length();++i1){
            sum1+=alpha.indexOf(name1.charAt(i1));
            
        }
        for(int i1 = 0;i1<name2.length();++i1){
            sum2+=alpha.indexOf(name2.charAt(i1));

        }

        text2.setText(relationRemark((sum1+sum2) % 10));

    }
/*
    private double calculateNameDiff(String name1, String name2){
        int min = Math.min(name1.length(),name2.length());
        int max = Math.max(name1.length(),name2.length());

        double difference = max - min;

        for(int i = 0;i<min;++i){
            if(name1.charAt(i) != name2.charAt(i)){
                difference++;
            }
        }
        return difference;
    }

    private double calculateMatch(int age1, int age2, String name1, String name2){
        double ageDiff = Math.abs(age1 - age2);
        double nameDiff = calculateNameDiff(name1,name2);

        return 100 - ageDiff - nameDiff;
    }*/


    private String relationRemark(double matchPercentage){
        if (matchPercentage == 1) {
            return "Home (Permanent)";
        } else if (matchPercentage == 2) {
            return "Hotel (Love bombing)";
        } else if (matchPercentage == 3) {
            return "Tent (Person of convenience)";
        } else if (matchPercentage == 4) {
            return "Motel (Friends with benefits)";
        } else if (matchPercentage == 5) {
            return "Apartment (Panmatagalan but not permanent)";
        } else if (matchPercentage == 6) {
            return "Hometown (Binalik balikan when things didn't end well)";
        } else if (matchPercentage == 7) {
            return "Boarding House (Rebound or Safety net)";
        } else if (matchPercentage == 8) {
            return "Office (Nagtitiis nalang)";
        } else if (matchPercentage == 9) {
            return "Waiting Shed (Walang label waiting for next rs)";
        } else {
            return "Homeless (No chance at all, hopeless romantic)";
        }
    }
}