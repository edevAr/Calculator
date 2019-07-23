package com.gogenesiss.calculator;

import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.gogenesiss.calculator.adapters.ButtonAdapter;
import com.gogenesiss.calculator.models.Key;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView buttons;
    private TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUIElements();
    }
    private void initializeUIElements(){
        buttons=(GridView)findViewById(R.id.id_buttons);
        screen = (TextView)findViewById(R.id.id_screen);

        populateNumbers();
    }
    private void populateNumbers(){
        ArrayList<Key> keys = new ArrayList<>();
        String[] values;
        values = new String[]{"MRC", "M-", "M+", "CE", "ON/OFF", "7", "8", "9",
        "%", "n2", "4", "5", "6", "*", "/", "1", "2", "3", "+", "-", "0", ".", "+/-", "="};
        for (String value : values) {
            Key key = new Key(value);
            keys.add(key);
        }

        createButtons(keys);
    }
    private void createButtons(ArrayList<Key> keys){
        ButtonAdapter buttonAdapter = new ButtonAdapter(this, 0, keys);
        buttons.setAdapter(buttonAdapter);
    }
    public void displayButtonPressed(Key key){
        String currentValue = screen.getText().toString();
        switch (key.getValue()){
            case "CE": screen.setText("");
                break;
            case "=":
                Toast.makeText(this, "Function not development yet", Toast.LENGTH_LONG).show();
                // aqui llamaran a su algoritmo de calculo aritmetico, sugiero utilizar el strategy pattern
                break;
            default:
                currentValue = currentValue+key.getValue();
                screen.setText(currentValue);

        }

    }
}
