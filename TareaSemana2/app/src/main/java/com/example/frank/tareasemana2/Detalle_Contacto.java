package com.example.frank.tareasemana2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Detalle_Contacto extends AppCompatActivity {

    TextView tvNombre;
    TextView tvFechaNacimiento;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    Button btnEditarDatos;

    int dia;
    int mes;
    int anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle__contacto);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        btnEditarDatos = (Button) findViewById(R.id.btnEditarDatos);
        recogerDatos();

        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Detalle_Contacto.this, "Validar Datos", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    public void recogerDatos(){
        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("Nombre");
        dia = bundle.getInt("Dia");
        mes = bundle.getInt("Mes");
        anio = bundle.getInt("Anio");
        tvTelefono.setText("Tel: "+bundle.getString("Telefono"));
        tvEmail.setText("Email: "+bundle.getString("Email"));
        tvDescripcion.setText("Descripcion: "+bundle.getString("Descripcion"));
        tvNombre.setText(nombre);
        tvFechaNacimiento.setText("Fecha Nacimiento: "+dia+"/"+mes+"/"+anio);
    }
}
