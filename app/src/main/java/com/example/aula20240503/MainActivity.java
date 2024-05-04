package com.example.aula20240503;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spn;
    TextView txtResposta;

    private static final String[] tab = {"Escolha a tabuada", "1","2","3","4","5","6","7","8","9","10"};
    ArrayAdapter<String> tabView;
    int aux=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
            spn =findViewById(R.id.spn);
            txtResposta = findViewById(R.id.txtResposta);
            tabView = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,tab);
            spn.setAdapter(tabView);

            spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int ItemPosicao, long l) {
                    aux = ItemPosicao;
                    if(aux!=0) {
                        tabuada();
                    } else{txtResposta.setText("");}
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

    }

    public void tabuada(){
        String res="";
        for(int i=0; i<11; i++){
        res = res+aux+" * "+i+" = "+(aux*i)+"\n";
        }
        txtResposta.setText(res);

    }

    }

