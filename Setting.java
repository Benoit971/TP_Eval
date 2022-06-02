package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Setting extends AppCompatActivity {

    public final static String TAG1="temperature";
    public final static String TAG2="volet";
    private Spinner posVolet;
    private String[] position = {"Ouvert","Fermé"};
    private Button btn_annuler, btn_valider;
    String temp, positionVolet;
    private EditText inTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        posVolet=(Spinner) findViewById(R.id.spinner);
        btn_annuler=(Button)findViewById(R.id.btnAnnuler);
        btn_valider=(Button)findViewById((R.id.btnValider));
        inTemp=(EditText) findViewById((R.id.intemp));

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,position);
        this.posVolet.setAdapter(adapter);

        //BOUTON ANNULER POUR PASSER A ACTIVITE 0
        btn_annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.super.onBackPressed(); //permet de faire un retour au menu d'avant
            }
        });

        btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = inTemp.getText().toString();
                if (posVolet.getSelectedItem().toString() == "Ouvert"){
                    positionVolet = "O";
            }
                else{
                    positionVolet="F";
                }
                Intent intent= new Intent(); //création d'un objet de la classe intent
                intent.putExtra(TAG1,temp); //associer l'intent : clé(déclarer en haut) / valeur comme en python cf(dictionnaire)
                intent.putExtra(TAG2,positionVolet); //associer l'intent : clé(déclarer en haut) / valeur comme en python cf(dictionnaire)
                setResult(RESULT_OK, intent); //présiser à android que l'activité c'est bien terminé
                finish(); //finir l'activité
            }
        });
    }
}