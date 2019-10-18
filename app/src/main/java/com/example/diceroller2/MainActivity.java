package com.example.diceroller2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick(View view) {
        Button b = (Button) findViewById(R.id.button);
        EditText n = (EditText) findViewById(R.id.userInput);
        TextView t = (TextView) findViewById(R.id.scoreTV);
        TextView t2 = (TextView) findViewById(R.id.resultTV);
        String userInput = n.getText().toString();
        Random r = new Random();
        int randNumber;
        String randNumString;
        randNumber = r.nextInt((6 - 1) + 1) + 1;
        randNumString = String.valueOf(randNumber);
        b.setText(randNumString);
        t2.setVisibility(View.INVISIBLE);
        t2.setText("Congratulations!");

        if (userInput.equals(randNumString)) {
            if (score != 0) {
                t2.setText("Congratulations!");
                score = score + 1;
                t.setText("Score: " + String.valueOf(score));
                t2.setVisibility(View.VISIBLE);
            } else {
                score = 1;
                t.setText("Score: " + String.valueOf(score));
                 }
        }
    }
}
