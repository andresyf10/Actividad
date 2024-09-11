package com.example.actividad;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText numero1, numero2;
    Button botonPotencia;
    RadioGroup radioGroup;
    RadioButton hipotenusa, mcm, mayor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //se inicializan los objetos
        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        botonPotencia = findViewById(R.id.botonPotencia);
        radioGroup = findViewById(R.id.radioGroup);
        hipotenusa = findViewById(R.id.hipotenusa);
        mcm = findViewById(R.id.mcm);
        mayor = findViewById(R.id.mayor);

        //se ejecuta al presionar el botón
        botonPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double n1 = Double.parseDouble(numero1.getText().toString());
                    double n2 = Double.parseDouble(numero2.getText().toString());

                    //se calcula la potencia
                    double potencia = Math.pow(n1, n2);
                    Toast.makeText(MainActivity.this, "Potencia: " + potencia, Toast.LENGTH_SHORT).show();

                    //se verifica qué botón está seleccionado
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    if (selectedId == hipotenusa.getId()) {
                        calcularHipotenusa(n1, n2);
                    } else if (selectedId == mcm.getId()) {
                        calcularMCM(n1, n2);
                    } else if (selectedId == mayor.getId()) {
                        calcularMayor(n1, n2);
                    } else {
                        Toast.makeText(MainActivity.this, "Seleccione una opción", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Ingrese números válidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //se calcula la hipotenusa
    private void calcularHipotenusa(double n1, double n2) {
        double hipotenusa = Math.sqrt(Math.pow(n1, 2) + Math.pow(n2, 2));
        Toast.makeText(this, "Hipotenusa: " + hipotenusa, Toast.LENGTH_SHORT).show();
    }

    //se calcula el mcm
    private void calcularMCM(double n1, double n2) {
        int a = (int) n1;
        int b = (int) n2;
        int mcm = (a * b) / calcularMCD(a, b);
        Toast.makeText(this, "MCM: " + mcm, Toast.LENGTH_SHORT).show();
    }

    //se calcula el mcd (se necesita para calcular el mcm)
    private int calcularMCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calcularMCD(b, a % b);
    }

    //se calcula el mayor de los dos números
    private void calcularMayor(double n1, double n2) {
        double mayor = Math.max(n1, n2);
        Toast.makeText(this, "Mayor: " + mayor, Toast.LENGTH_SHORT).show();
    }
}