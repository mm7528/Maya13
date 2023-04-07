package com.example.maya13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    int count = 0;

    String name;

    EditText inputName;

    TextView countView;
    
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings=getSharedPreferences("SAVED_INPUT",MODE_PRIVATE);
        inputName = findViewById(R.id.inputText);
        countView = findViewById(R.id.countView);
        read();
    }

    /**
     * progresses the count
     *
     * @param view the view
     */
    public void progressCount(View view) {
        count++;
        countView.setText("" + count);
    }

    /**
     * Resets the count and the input
     *
     * @param view the view
     */
    public void resetCount(View view) {
        count = 0;
        name = "";
        inputName.setText("");
        countView.setText("0");
    }

    /**
     * Saves the input in the SharedPreferences file and exits the program
     *
     * @param view the view
     */
    public void saveAndExit(View view) {
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("count", count);
        name = inputName.getText().toString();
        editor.putString("name", name);
        editor.commit();
        finish();
    }


    /**
     * Reads the last saved input
     */
    public void read()
    {
        count = settings.getInt("count", 0);
        name = settings.getString("name", "");
        countView.setText("" + count);
        inputName.setText(name);
    }

}