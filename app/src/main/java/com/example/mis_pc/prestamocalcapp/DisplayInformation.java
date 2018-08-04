package com.example.mis_pc.prestamocalcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.text.DecimalFormat;
import java.time.Month;
import java.util.ArrayList;

public class DisplayInformation extends AppCompatActivity {
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_information);
        Intent in = getIntent();
        // Create amortization schedule
        int meses = in.getIntExtra("Meses",12);
        double interes= in.getDoubleExtra("Intereses",10);
        double monto  = in.getDoubleExtra("Monto",10000);
        double monthlyPayment = PrestamoHelper.CalcImpuesto(meses,monto,interes);
        String[] Amortizacion = new String[meses+10];
        Amortizacion[0] = "Payment#     Interest     Principal     Balance";
        int years = meses/12;

        double annualRate = interes;
        DecimalFormat df = new DecimalFormat("0.00##");


         double monthlyRate = annualRate / 1200;
        double balance = monto,
                principal, interest;

        for (int i = 1; i <= years * 12; i++) {
            interest = monthlyRate * balance;
            principal = monthlyPayment - interest;
            balance = balance - principal;

            Amortizacion[i] = i + " | " + df.format(interes)+ "% | " +df.format(principal)  + "$ | " + df.format(balance)+ "$";
        }

//        String[] periodos = {"hola","klk","hi"};
//        String[] periodos = (String[])getIntent().getSerializableExtra("periodos");

        ListView lista;


        lista = findViewById(R.id.DesgloseList);

//        adaptador = new ArrayAdapter<>(this,R.layout.activity_listview,R.id.label,periodos);

//        lista.setAdapter(adaptador);
          lista.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Amortizacion));


    }


}
