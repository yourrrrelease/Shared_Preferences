package com.example.shared_prefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editData;
    private Button btnSave, btnDelete;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editData = findViewById(R.id.data);
        btnSave = findViewById(R.id.btn_save);
        btnDelete = findViewById(R.id.btn_delete);

        sharedPreferences = getSharedPreferences("myapp-data", MODE_PRIVATE);

        if (sharedPreferences.getString("title", null) != null){
            editData.setText(sharedPreferences.getString("title", null));
        }

        btnSave.setOnClickListener(v -> {
            @SuppressLint("CommitPrefEdits")
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString( "title", editData.getText().toString());
            editor.apply();
            Toast.makeText(getApplicationContext(), "Data tersimpan!", Toast.LENGTH_SHORT).show();
        });
        btnDelete.setOnClickListener(v -> {
            @SuppressLint("CommitPrefEdits")
            SharedPreferences.Editor editor = sharedPreferences.edit();

            // menghapus semua data
            editor.clear().apply();
        });
    }
}
