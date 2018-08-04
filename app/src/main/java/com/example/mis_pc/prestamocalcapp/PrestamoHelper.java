package com.example.mis_pc.prestamocalcapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrestamoHelper {
    public static double CalcImpuesto(int month, double monto, double interes) {



        double _deuda = monto;

        int years = month/12;

        double annualRate = interes;


        double monthlyRate = annualRate / 1200;


        double monthlyPayment = _deuda * monthlyRate / (1 - 1 /
                Math.pow(1 + monthlyRate, years * 12));



        return monthlyPayment;
    }
}
