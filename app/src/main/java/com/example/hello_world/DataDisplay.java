package com.example.hello_world;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DataDisplay extends AppCompatActivity {

    @SuppressLint("SetTextI18n")

    TextView nameLabel;
    TextView groupLabel;
    TextView careerLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        String name = getIntent().getStringExtra("name");
        String group = getIntent().getStringExtra("group");
        String  career = getIntent().getStringExtra("career");


        nameLabel = findViewById(R.id.nameLabel);
        groupLabel = findViewById(R.id.groupLabel);
        careerLabel = findViewById(R.id.careerLabel);

        Button backButton = findViewById(R.id.backButton);

        nameLabel.setText("Nombre: "+name);
        groupLabel.setText("Grupo: "+group);
        careerLabel.setText("Carrera: "+career);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataDisplay.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}