package ro.pub.cs.systems.eim.colocviu1_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Colocviu1_2MainActivity extends AppCompatActivity {

    Button add;
    Button compute;
    EditText editText;
    TextView textView;
    int suma = 0;

    private final ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.add) {
                if (editText.getText().toString().matches("[0-9]+")) {
                    textView.setText(textView.getText().toString() + " + " + editText.getText().toString());
                }
            } else if (v.getId() == R.id.compute) {
                Intent intent = new Intent(getApplicationContext(), Colocviu1_2SecondaryActivity.class);
                intent.putExtra("total", textView.getText().toString());
                startActivityForResult(intent, 10);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);

        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(buttonClickListener);
        compute = (Button) findViewById(R.id.compute);
        compute.setOnClickListener(buttonClickListener);
        editText = (EditText) findViewById(R.id.nextTerm);
        textView = (TextView) findViewById(R.id.textView);

//        Intent intent = getIntent();
//        if (intent != null && intent.getExtras().containsKey("total2")) {
//            int total = intent.getExtras().getInt("total2");
//            Toast.makeText(this, "Sum is " + total, Toast.LENGTH_LONG).show();
//        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("suma", textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("suma")) {
            textView.setText(savedInstanceState.getString("suma"));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 10) {
//            suma = intent.getExtras().getInt("total");
            Toast.makeText(this, "Suma este : " + intent.getExtras().getInt("total"), Toast.LENGTH_LONG).show();
        }
    }
}