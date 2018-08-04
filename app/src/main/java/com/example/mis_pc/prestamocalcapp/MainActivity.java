package com.example.mis_pc.prestamocalcapp;

import android.content.Intent;
import android.content.SyncStatusObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    private double PagoMensual;
    private double InteresMensual;
    private double Total;
    private EditText mesesP,montoP,tasaP;
    private TextView pagoMensualP;
    private Button calcularP;
    private Button AmortizarButton;
    private double PagosMensual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Componentes
        mesesP = findViewById(R.id.MesesEdit);
        montoP = findViewById(R.id.MontoEdit);
        tasaP = findViewById(R.id.TasaEdit);
        pagoMensualP = findViewById(R.id.PagoMenEdit);
        calcularP = findViewById(R.id.CalcularButton);
        AmortizarButton = findViewById(R.id.amortizarButton);

        calcularP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mesesP.length() != 0 && montoP.length() != 0 && tasaP.length() != 0) {

                    PagosMensual = PrestamoHelper.CalcImpuesto(
                            parseInt(mesesP.getText().toString()),
                            parseDouble(montoP.getText().toString()),
                            parseFloat(tasaP.getText().toString())

                    );

                    pagoMensualP.setText(Double.toString(PagosMensual));
                }


            }

           // Toast toast = Toast.makeText(this, "Debe de rellenar los campos", Toast.LENGTH_SHORT);
            //toast.show();


        });

        AmortizarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, DisplayInformation.class);

//                String[] periodos = (String[])PagosMensual.get(2);

//                in.putExtra("periodos",periodos);
                in.putExtra("meses",mesesP.getText().toString());
                in.putExtra("interes",tasaP.getText().toString());
                in.putExtra("monto",montoP.getText().toString());

                startActivity(in);
            }
        });

    }
}
