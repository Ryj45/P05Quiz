package c346.rp.edu.sg.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvType, tvCosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvType = findViewById(R.id.tvType);
        tvCosts = findViewById(R.id.tvCosts);

        Intent intentReceived = getIntent();
        String type = intentReceived.getStringExtra("type");
        double cost = intentReceived.getDoubleExtra("cost", 0.0);

        tvType.setText("You have selected " + type);
        tvCosts.setText("Your air ticket costs $" + cost);
    }
}
