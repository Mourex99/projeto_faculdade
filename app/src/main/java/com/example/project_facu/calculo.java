package com.example.project_facu;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class calculo extends AppCompatActivity {

    private EditText salarioEditText;
    private EditText horasTrabalhadasEditText;
    private EditText inicioCagadaEditText;
    private EditText fimDaCagadaEditText;
    private TextView resultadoTextView;
    private ConstraintLayout miniTelaLayout;
    private Button fecharButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        // Encontrar as Views pelo ID
        salarioEditText = findViewById(R.id.salarioEditText);
        horasTrabalhadasEditText = findViewById(R.id.horasTrabalhadasEditText);
        inicioCagadaEditText = findViewById(R.id.inicioCagadaEditText);
        fimDaCagadaEditText = findViewById(R.id.fimDaCagadaEditText);
        resultadoTextView = findViewById(R.id.resultadoTextView);
        miniTelaLayout = findViewById(R.id.miniTelaLayout);
        fecharButton = findViewById(R.id.fecharButton);

        // Configurar o listener de clique do botão calcular
        findViewById(R.id.calcularButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });

        // Configurar listener de fecharButton
        fecharButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miniTelaLayout.setVisibility(View.GONE);
            }
        });

        // Configurar TextWatcher para inicioCagadaEditText
        inicioCagadaEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 2 && before == 0) {
                    inicioCagadaEditText.append(":");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // Configurar TextWatcher para fimDaCagadaEditText
        fimDaCagadaEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 2 && before == 0) {
                    fimDaCagadaEditText.append(":");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void calcular() {
        try {
            // Obter os valores das Views
            double salarioMensal = Double.parseDouble(salarioEditText.getText().toString());
            int horasTrabalhadasPorSemana = Integer.parseInt(horasTrabalhadasEditText.getText().toString());
            String inicioCagada = inicioCagadaEditText.getText().toString();
            String fimDaCagada = fimDaCagadaEditText.getText().toString();

            // Calcular valor por hora
            double horasTrabalhadasPorMes = horasTrabalhadasPorSemana * 4;
            double valorPorHora = salarioMensal / horasTrabalhadasPorMes;

            // Converter horas para minutos
            int inicioEmMinutos = converterHoraParaMinutos(inicioCagada);
            int fimEmMinutos = converterHoraParaMinutos(fimDaCagada);

            // Calcular a diferença em minutos
            int diferencaEmMinutos = fimEmMinutos - inicioEmMinutos;

            // Calcular ganhos durante o tempo no banheiro
            double diferencaEmHoras = diferencaEmMinutos / 60.0;
            double valorGanhoCagando = valorPorHora * diferencaEmHoras;

            // Exibir o resultado na TextView
            resultadoTextView.setText(String.format("Você ganhou R$%.2f", valorGanhoCagando));
            miniTelaLayout.setVisibility(View.VISIBLE);

        } catch (NumberFormatException e) {
            // Lidar com erro de formato de número
            resultadoTextView.setText("Erro: Formato de número inválido.");
        }
    }

    private int converterHoraParaMinutos(String hora) {
        String[] partes = hora.split(":");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        return horas * 60 + minutos;
    }
}