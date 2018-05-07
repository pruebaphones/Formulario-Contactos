package com.example.frank.tareasemana2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnSiguiente;
    TextInputEditText txtInputNombre;
    TextInputEditText txtFechaNacimiento;
    TextInputEditText txtInputTelefono;
    TextInputEditText txtInputCorreo;
    TextInputEditText txtInputDescripcion;
    Calendar calendar = Calendar.getInstance();

    String nombre;
    // variables fecha para mostrar en el picker
    int dia = calendar.get(Calendar.DAY_OF_MONTH);
    int mes = calendar.get(Calendar.MONTH);
    int anio = calendar.get(Calendar.YEAR);
    // variables fecha obtenidas
    int year;
    int month;
    int dayOfMonth;

    String telefono;
    String email;
    String descripcion;
    final String CERO = "0";
    final String BARRA = "/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        txtInputNombre = (TextInputEditText) findViewById(R.id.txtInputNombre);
        txtInputTelefono = (TextInputEditText) findViewById(R.id.txtInputTelefono);
        txtInputCorreo = (TextInputEditText) findViewById(R.id.txtInputCorreo);
        txtInputDescripcion = (TextInputEditText) findViewById(R.id.txtInputDescripcion);
        txtFechaNacimiento = (TextInputEditText)findViewById(R.id.txtFechaNacimiento);

        txtFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerFechaNac();
            }
        });


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarActivity();
            }
        });

    }

    public void obtenerFechaNac(){
        DatePickerDialog recogerFecha = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener(){
            //i year, i1 month, i2 dayOfMonth
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                year = i;
                month = i1;
                dayOfMonth = i2;
                final int mesActual = month+1;
                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual): String.valueOf(mesActual);
                txtFechaNacimiento.setText(diaFormateado+BARRA+mesFormateado+BARRA+year);
            }
        },anio,mes,dia);

        recogerFecha.show();
    }

    public void cambiarActivity(){
        Intent intent = new Intent(MainActivity.this,Detalle_Contacto.class);

        nombre = txtInputNombre.getText().toString();
        telefono = txtInputTelefono.getText().toString();
        email = txtInputCorreo.getText().toString();
        descripcion = txtInputDescripcion.getText().toString();

        intent.putExtra("Nombre",nombre);
        intent.putExtra("Dia",dayOfMonth);
        intent.putExtra("Mes",month);
        intent.putExtra("Anio",year);
        intent.putExtra("Telefono",telefono);
        intent.putExtra("Email",email);
        intent.putExtra("Descripcion",descripcion);
        startActivity(intent);
    }

}
