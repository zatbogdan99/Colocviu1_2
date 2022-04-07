package ro.pub.cs.systems.eim.colocviu1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Colocviu1_2SecondaryActivity extends AppCompatActivity {

    public int findSum(String str) {
        String temp = "0";
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch))
                temp += ch;
            else {
                sum += Integer.parseInt(temp);
                temp = "0";
            }
        }
        return sum + Integer.parseInt(temp);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("total")) {
            String total = intent.getExtras().getString("total");
            int sum = findSum(total);
            intent.putExtra("total", sum);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}