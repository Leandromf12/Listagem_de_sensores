package com.example.sensoreslistagem;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity{
    SensorManager mSensorManager;
    Sensor mSensorLight;
    TextView mTvSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvSensor=findViewById(R.id.tvSensor);
        mSensorManager= (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);

       List<Sensor> listSensor = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        StringBuilder sensorListText = new StringBuilder();
        for(Sensor s:listSensor){
            sensorListText.append(s.getName()).append(System.getProperty("line.separator"));
        }
        mTvSensor.setText(sensorListText);
    }
}