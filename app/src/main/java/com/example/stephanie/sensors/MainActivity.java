package com.example.stephanie.sensors;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager mngr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        final Sensor accel = mngr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        final Sensor linAccel = mngr.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        final Sensor grav = mngr.getDefaultSensor(Sensor.TYPE_GRAVITY);
        final Sensor gyro= mngr.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        final Sensor ambLit = mngr.getDefaultSensor(Sensor.TYPE_LIGHT);
        final Sensor ambMagFeild = mngr.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        final Sensor prox = mngr.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        final Sensor press = mngr.getDefaultSensor(Sensor.TYPE_PRESSURE);
        final Sensor ambTemp = mngr.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        SensorEventListener listener = new SensorEventListener() {
            double aXMax, aXMin, aYMax, aYMin,aZMax, aZMin, aCurrX, aCurrY, aCurrZ,
            alXMax, alXMin, alYMax, alYMin,alZMax, alZMin, alCurrX, alCurrY, alCurrZ,
            amfXMax, amfXMin, amfYMax, amfYMin,amfZMax, amfZMin, amfCurrX, amfCurrY, amfCurrZ,
            gyroXMax, gyroXMin, gyroYMax, gyroYMin,gyroZMax, gyroZMin, gyroCurrX, gyroCurrY, gyroCurrZ,
            gravXMax, gravXMin, gravYMax, gravYMin,gravZMax, gravZMin, gravCurrX, gravCurrY, gravCurrZ,
            ambLitMax, ambLitMin, ambLitCurr,
            proxMax, proxMin, proxCurr,
            pressMax, pressMin, pressCurr,
            ambTempMax, ambTempMin, ambTempCurr=0;

            String acc, accLin, amf, gyroS, gravS, ambLitS, proxS, pressS, ambTempS=" ";
            boolean aFlag, alFlag, amfFlag, gyroFlag, gravFlag, ambLitFlag, proxFlag, pressFlag, ambTempFlag = true;
            TextView accText = findViewById(R.id.accelText);

                TextView linAccText = findViewById(R.id.linAccelText);


                TextView gavText = findViewById(R.id.gravText);


                TextView gyroText = findViewById(R.id.gyroText);


                TextView ambLitText = findViewById(R.id.amLitText);


                TextView ambMagText = findViewById(R.id.amMagFieldText);


                TextView proxText = findViewById(R.id.proxText);


                TextView pressText = findViewById(R.id.pressText);


                TextView ambTempText = findViewById(R.id.ambTempText);


                public void onAccuracyChanged(Sensor sensor, int accuracy) {
                }

                public void onSensorChanged(SensorEvent event) {

                    if(accel != null){
                        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                            aCurrX=event.values[0];
                            aCurrY=event.values[1];
                            aCurrZ=event.values[2];

                            if(aFlag){
                                aFlag = false;
                                aXMax = event.values[0];
                                aXMin = event.values[0];
                                aYMax = event.values[1];
                                aYMin = event.values[1];
                                aZMax = event.values[2];
                                aZMin = event.values[2];
                            }
                            if (aXMax < event.values[0]) {
                                aXMax = event.values[0];
                            }
                            else if (aXMin > event.values[0]) {
                                aXMin = event.values[0];
                            }
                            if (aYMax < event.values[1]) {
                                aYMax = event.values[1];
                            }
                            else if (aYMin > event.values[1]) {
                                aYMin = event.values[1];
                            }
                            if (aZMax < event.values[2]) {
                                aZMax = event.values[2];
                            }
                            else if (aZMin > event.values[2]) {
                                aZMin = event.values[2];
                            }
                            acc=String.format("X: %f Y: %f Z: %f \nMax X: %f  Min X: %f \nMax Y: %f Min Y: %f \nMax Z: %f Min Z: %f", aCurrX, aCurrY, aCurrZ, aXMax, aXMin, aYMax, aYMin, aZMax, aZMin );
                            accText.setText(acc);
                        }
                    }
                    else{
                        accText.setText(String.valueOf("N/A"));
                    }
                    if(linAccel != null){
                        if (event.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {
                            alCurrX=event.values[0];
                            alCurrY=event.values[1];
                            alCurrZ=event.values[2];

                            if(alFlag){
                                alFlag = false;
                                alXMax = event.values[0];
                                alXMin = event.values[0];
                                alYMax = event.values[1];
                                alYMin = event.values[1];
                                alZMax = event.values[2];
                                alZMin = event.values[2];
                            }
                            if (alXMax < event.values[0]) {
                                alXMax = event.values[0];
                            }
                            else if (alXMin > event.values[0]) {
                                alXMin = event.values[0];
                            }
                            if (alYMin == 0 ) {
                                alYMin = event.values[1];
                            }
                            else if (alYMin > event.values[1]) {
                                alYMin = event.values[1];
                            }
                            if (alZMax < event.values[2]) {
                                alZMax = event.values[2];
                            }
                            else if (alZMin > event.values[2]) {
                                alZMin = event.values[2];
                            }
                            accLin=String.format("X: %f Y: %f Z: %f \nMax X: %f  Min X: %f \nMax Y: %f Min Y: %f \nMax Z: %f Min Z: %f", alCurrX, alCurrY, alCurrZ, alXMax, alXMin, alYMax, alYMin, alZMax, alZMin );
                            linAccText.setText(accLin);
                        }
                    }
                    else{
                        linAccText.setText(String.valueOf("N/A"));
                    }
                    if(grav != null){
                        if (event.sensor.getType() == Sensor.TYPE_GRAVITY) {
                            gravCurrX=event.values[0];
                            gravCurrY=event.values[1];
                            gravCurrZ=event.values[2];

                                if(gravFlag){
                                    gravFlag = false;
                                    gravXMax = event.values[0];
                                    gravXMin = event.values[0];
                                    gravYMax = event.values[1];
                                    gravYMin = event.values[1];
                                    gravZMax = event.values[2];
                                    gravZMin = event.values[2];
                                }
                                if (gravXMax < event.values[0]) {
                                    gravXMax = event.values[0];
                                }
                                else if (gravXMin > event.values[0]) {
                                    gravXMin = event.values[0];
                                }
                                if (gravYMin == 0 ) {
                                    gravYMin = event.values[1];
                                }
                                else if (gravYMin > event.values[1]) {
                                    gravYMin = event.values[1];
                                }
                                if (gravZMax < event.values[2]) {
                                    gravZMax = event.values[2];
                                }
                                else if (gravZMin > event.values[2]) {
                                    gravZMin = event.values[2];
                                }
                               gravS=String.format("X: %f Y: %f Z: %f \nMax X: %f  Min X: %f \nMax Y: %f Min Y: %f \nMax Z: %f Min Z: %f", gravCurrX, gravCurrY, gravCurrZ, gravXMax, gravXMin, gravYMax, gravYMin, gravZMax, gravZMin );
                               gavText.setText(gravS);
                        }
                    }
                    else{
                        gavText.setText(String.valueOf("N/A"));
                    }
                    if(gyro != null){
                        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
                            gyroCurrX=event.values[0];
                            gyroCurrY=event.values[1];
                            gyroCurrZ=event.values[2];

                            if(amfFlag){
                                gyroFlag = false;
                                gyroXMax = event.values[0];
                                gyroXMin = event.values[0];
                                gyroYMax = event.values[1];
                                gyroYMin = event.values[1];
                                gyroZMax = event.values[2];
                                gyroZMin = event.values[2];
                            }
                            if (gyroXMax < event.values[0]) {
                                gyroXMax = event.values[0];
                            }
                            else if (gyroXMin > event.values[0]) {
                                gyroXMin = event.values[0];
                            }
                            if (gyroYMin == 0 ) {
                                gyroYMin = event.values[1];
                            }
                            else if (gyroYMin > event.values[1]) {
                                gyroYMin = event.values[1];
                            }
                            if (gyroZMax < event.values[2]) {
                                gyroZMax = event.values[2];
                            }
                            else if (gyroZMin > event.values[2]) {
                                gyroZMin = event.values[2];
                            }
                            gyroS=String.format("X: %f Y: %f Z: %f \nMax X: %f  Min X: %f \nMax Y: %f Min Y: %f \nMax Z: %f Min Z: %f", gyroCurrX, gyroCurrY, gyroCurrZ, gyroXMax, gyroXMin, gyroYMax, gyroYMin, gyroZMax, gyroZMin );
                            gyroText.setText(gyroS);
                        }
                    }
                    else{
                        gyroText.setText(String.valueOf("N/A"));
                    }
                    if(ambLit != null){
                        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
                            ambLitCurr=event.values[0];

                            if(ambLitFlag){
                                ambLitFlag = false;
                                ambLitMax = event.values[0];
                                ambLitMin = event.values[0];
                                System.out.println("Amb Lit "+ambLitMin);
                            }
                            if (ambLitMax < event.values[0]) {
                                ambLitMax = event.values[0];
                            }
                            else if (ambLitMin > event.values[0]) {
                                ambLitMin = event.values[0];
                            }
                            ambLitS=String.format("Current: %f \nMax: %f Min: %f", ambLitCurr,ambLitMax, ambLitMin);
                            ambLitText.setText(ambLitS);
                        }
                    }
                    else{
                        ambLitText.setText(String.valueOf("N/A"));
                    }
                    if(ambMagFeild != null){
                             if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
                            amfCurrX=event.values[0];
                            amfCurrY=event.values[1];
                            amfCurrZ=event.values[2];

                            if(amfFlag){
                                amfFlag = false;
                                amfXMax = event.values[0];
                                amfXMin = event.values[0];
                                amfYMax = event.values[1];
                                amfYMin = event.values[1];
                                amfZMax = event.values[2];
                                amfZMin = event.values[2];
                            }
                            if (amfXMax < event.values[0]) {
                                amfXMax = event.values[0];
                            }
                            else if (amfXMin > event.values[0]) {
                                amfXMin = event.values[0];
                            }
                            if (amfYMin == 0 ) {
                                amfYMin = event.values[1];
                            }
                            else if (amfYMin > event.values[1]) {
                                amfYMin = event.values[1];
                            }
                            if (amfZMax < event.values[2]) {
                                amfZMax = event.values[2];
                            }
                            else if (amfZMin > event.values[2]) {
                                amfZMin = event.values[2];
                            }
                            amf=String.format("X: %f Y: %f Z: %f \nMax X: %f  Min X: %f \nMax Y: %f Min Y: %f \nMax Z: %f Min Z: %f", amfCurrX, amfCurrY, amfCurrZ, amfXMax, amfXMin, amfYMax, amfYMin, amfZMax, amfZMin );
                            ambMagText.setText(amf);
                        }
                    }
                    else{
                        ambMagText.setText(String.valueOf("N/A"));
                    }
                    if(prox != null){
                        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                            proxCurr=event.values[0];

                            if(proxFlag){
                                proxFlag = false;
                                proxMax = event.values[0];
                                proxMin = event.values[0];
                            }
                            if (proxMax < event.values[0]) {
                                proxMax = event.values[0];
                            }
                            else if (proxMin > event.values[0]) {
                                proxMin = event.values[0];
                            }
                            proxS=String.format("Current: %f \nMax: %f Min: %f", proxCurr, proxMax, proxMin);
                            proxText.setText(proxS);
                        }
                    }
                    else{
                        proxText.setText(String.valueOf("N/A"));
                    }
                    if(press != null){
                       if (event.sensor.getType() == Sensor.TYPE_PRESSURE) {
                            pressCurr=event.values[0];

                            if(pressFlag){
                                pressFlag = false;
                                pressMax = event.values[0];
                                pressMin = event.values[0];
                            }
                            if (pressMax < event.values[0]) {
                                pressMax = event.values[0];
                            }
                            else if (pressMin > event.values[0]) {
                                pressMin = event.values[0];
                            }
                            pressS=String.format("Current: %f \nMax: %f Min: %f", pressCurr, pressMax, pressMin);
                            pressText.setText(pressS);
                        }
                    }
                    else{
                        pressText.setText(String.valueOf("N/A"));
                    }
                    if(ambTemp != null){
                        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
                            ambTempCurr=event.values[0];

                            if(ambTempFlag){
                                ambTempFlag = false;
                                ambTempMax = event.values[0];
                                ambTempMin = event.values[0];
                            }
                            if (ambTempMax < event.values[0]) {
                                ambTempMax = event.values[0];
                            }
                            else if (ambTempMin > event.values[0]) {
                                ambTempMin = event.values[0];
                            }
                            ambTempS=String.format("Current: %f \nMax: %f Min: %f", ambTempCurr, ambTempMax, ambTempMin);
                            ambTempText.setText(ambTempS);
                        }
                    }
                    else{
                        ambTempText.setText(String.valueOf("N/A"));
                    }
                }
            };

            mngr.registerListener(listener, accel, SensorManager.SENSOR_DELAY_FASTEST);
            mngr.registerListener(listener, linAccel, SensorManager.SENSOR_DELAY_FASTEST);
            mngr.registerListener(listener, gyro, SensorManager.SENSOR_DELAY_FASTEST);
            mngr.registerListener(listener, ambLit, SensorManager.SENSOR_DELAY_FASTEST);
            mngr.registerListener(listener, ambMagFeild, SensorManager.SENSOR_DELAY_FASTEST);
            mngr.registerListener(listener, grav, SensorManager.SENSOR_DELAY_FASTEST);
            mngr.registerListener(listener, prox, SensorManager.SENSOR_DELAY_FASTEST);
            mngr.registerListener(listener, press, SensorManager.SENSOR_DELAY_FASTEST);
            mngr.registerListener(listener, ambTemp, SensorManager.SENSOR_DELAY_FASTEST);

    }
}

