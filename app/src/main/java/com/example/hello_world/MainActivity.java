package com.example.hello_world;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText nameTextField;
    EditText groupTextField;
    Spinner careerComboBox;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Utils.hideKeyboard(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameTextField = findViewById(R.id.nameTextField);
        groupTextField = findViewById(R.id.groupTextField);
        careerComboBox = findViewById(R.id.careerComboBox);

        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(v -> {
            String name = nameTextField.getText().toString();
            String group = groupTextField.getText().toString();
            String career = careerComboBox.getSelectedItem().toString();

    Intent intent = new Intent(MainActivity.this, DataDisplay.class);
        intent.putExtra("name", name);
        intent.putExtra("group", group);
        intent.putExtra("career", career);
    startActivity(intent);
});

    }
}