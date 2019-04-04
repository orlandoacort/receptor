package com.example.jmy1.receptor;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null){
            if ("text/plain".equals(type)){
                //MANIPULACION DE CADENA ENVIADA
                manipularTexto(intent);
            }
        }
    }

    private void manipularTexto(Intent intent) {
        String sharedText = intent.getStringExtra(
                Intent.EXTRA_TEXT);
        if (sharedText != null){
          //  Toast.makeText(MainActivity.this,sharedText,Toast.LENGTH_LONG).show();

            TextView textView = (TextView)findViewById(R.id.txtPedido);
            textView.setText(sharedText);

            Snackbar snackbar = Snackbar
                    .make(findViewById(R.id.idCL), sharedText, Snackbar.LENGTH_LONG);
            snackbar.show();

        }
    }
}
