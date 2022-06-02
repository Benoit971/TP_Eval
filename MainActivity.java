package com.example.tp5;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int flag;
    private TextView TC1,TC2,TC3,TC4,VC1,VC2,VC3,VC4,VC5;

    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()== Activity.RESULT_OK){
                        String temperatureConsigne=result.getData().getStringExtra(Setting.TAG1);
                        String posDesVolets=result.getData().getStringExtra(Setting.TAG2);

                        switch(flag){
                            case 1 : TC1.setText("Tc: "+ temperatureConsigne + " °C"); VC1.setText("Vc: "+posDesVolets); break;
                            case 2 : TC2.setText("Tc: " + temperatureConsigne + " °C"); VC2.setText("Vc: " +posDesVolets); break;
                            case 3 : TC3.setText("Tc: " +temperatureConsigne + " °C"); VC3.setText("Vc: " +posDesVolets); break;
                            case 4 : TC4.setText("Tc: " +temperatureConsigne + " °C"); VC4.setText("Vc: " +posDesVolets); break;
                            case 5 : VC5.setText("Vc: " +posDesVolets); break;
                        }
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TC1=(TextView) findViewById(R.id.Tconsigne1);
        TC2=(TextView) findViewById(R.id.Tconsigne2);
        TC3=(TextView) findViewById(R.id.Tconsigne3);
        TC4=(TextView) findViewById(R.id.Tconsigne4);
        VC1=(TextView) findViewById(R.id.Cvolet1);
        VC2=(TextView) findViewById(R.id.Cvolet2);
        VC3=(TextView) findViewById(R.id.Cvolet3);
        VC4=(TextView) findViewById(R.id.Cvolet4);
        VC5=(TextView) findViewById(R.id.Cvolet5);
    }
    public void setting(View view){

        Intent intent = new Intent(MainActivity.this, Setting.class);
        activityLauncher.launch(intent);

        switch (view.getId()){
            case R.id.btnChambre1: flag=1; break;
            case R.id.btnChambre2: flag=2; break;
            case R.id.btnChambre3: flag=3; break;
            case R.id.btnChambre4: flag=4; break;
            case R.id.btnChambre5: flag=5; break;
        }
    }
}