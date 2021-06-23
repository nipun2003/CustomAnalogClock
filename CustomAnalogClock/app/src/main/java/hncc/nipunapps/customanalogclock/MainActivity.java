package hncc.nipunapps.customanalogclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nipunapps.AnalogClockView.AnalogClockView;

public class MainActivity extends AppCompatActivity {

    private AnalogClockView analogClockView;
    private Button button;
    private boolean isHour=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        analogClockView=findViewById(R.id.anlogClock);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isHour){
                    isHour=false;
                    analogClockView.setIshour(isHour);
                }
                else {
                    isHour=true;
                    analogClockView.setIshour(isHour);
                }
            }
        });

    }
}