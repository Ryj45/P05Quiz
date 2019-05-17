package c346.rp.edu.sg.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    CheckBox cbOneWay, cbRoundTrip;
    Button btnSubmit, btnMinus, btnPlus;
    EditText edPax;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbOneWay = findViewById(R.id.cbOneWay);
        cbRoundTrip = findViewById(R.id.cbRoundTrip);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        edPax = findViewById(R.id.edPax);


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paxString = edPax.getText().toString();
                int pax = Integer.parseInt(paxString);
                int pax2 = pax - 1;
                edPax.setText(pax2+"");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paxString = edPax.getText().toString();
                int pax = Integer.parseInt(paxString);
                int pax2 = pax + 1;
                edPax.setText(pax2+"");
            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pax = Integer.parseInt(edPax.getText().toString());
                double total;

                if(cbOneWay.isChecked() && cbRoundTrip.isChecked()){
                    Toast.makeText(MainActivity.this, "Cannot check two type at the same time", Toast.LENGTH_LONG).show();
                }
                else if(cbOneWay.isChecked()==false && cbRoundTrip.isChecked()==false){
                    Toast.makeText(MainActivity.this, "Please select one type", Toast.LENGTH_LONG).show();
                }
                else if(pax<=0){
                    Toast.makeText(MainActivity.this, "Pax cannot less than 1", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(getBaseContext(), SecondActivity.class);

                    if(cbOneWay.isChecked()){
                        total = pax * 100;
                        intent.putExtra("type", "One Way Trip");
                        intent.putExtra("costs", total);
                    }
                    else if(cbRoundTrip.isChecked()){
                        total = pax * 100 * 2;
                        intent.putExtra("type", "Round Trip");
                        intent.putExtra("cost", total);
                    }
                    startActivity(intent);
                }
            }

        });
    }
}
