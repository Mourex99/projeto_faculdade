package com.example.project_facu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class oque_fazer extends AppCompatActivity {

    private Button calcular_vaso;
    private Button bt_deslogar;
    private Button historico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_oque_fazer);

        CalcularVaso();
        IniciarComponentes();
        Historico();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        calcular_vaso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(oque_fazer.this, calculo.class);
                startActivity(intent);
            }
        });

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(oque_fazer.this, FormLogin.class);
                startActivity(intent);
                finish();

            }
        });

        historico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(oque_fazer.this, FormHistorico.class);
                startActivity(intent);
            }
        });

    }

    private void Historico() {
        historico = findViewById(R.id.historico);
    }

    private void IniciarComponentes(){
        bt_deslogar = findViewById(R.id.bt_deslogar);
    }

    private void CalcularVaso() {
        calcular_vaso = findViewById(R.id.calcular_vaso);
    }
}