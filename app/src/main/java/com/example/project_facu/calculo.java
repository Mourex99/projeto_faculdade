package com.example.project_facu;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//public class calculo extends AppCompatActivity {

   // @Override
    //protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_calculo);
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            //Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            //return insets;
        //});
    //}
//}

import java.util.Scanner;

import java.util.Scanner;

public class calculo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu salário mensal: R$ ");
        double salarioMensal = scanner.nextDouble();

        System.out.print("Digite o número de horas trabalhadas por semana: ");
        int horasTrabalhadasPorSemana = scanner.nextInt();

        System.out.print("Digite a hora de início da caminhada (em minutos, 24h): ");
        int inicioCagada = scanner.nextInt();

        System.out.print("Digite a hora de fim da caminhada (em minutos, 24h): ");
        int fimDaCagada = scanner.nextInt();

        // Cálculos
        int diasNoMes = 30; // Assumindo um mês com 30 dias
        double horasTrabalhadasPorMes = horasTrabalhadasPorSemana * 4;
        double valorHora = salarioMensal / horasTrabalhadasPorMes;
        double minutosCagandoPorDia = fimDaCagada - inicioCagada;
        double horasCagandoPorMes = minutosCagandoPorDia * 30 / 60;
        double valorGanhoCagandoPorMes = valorHora * horasCagandoPorMes;
        double valorGanhoCagandoPorDia = valorGanhoCagandoPorMes / diasNoMes;

        // Exibindo o resultado
        System.out.printf("Você 'ganha' R$%.2f por dia cagando entre os pontos minutosCagadoPorDia.\n", valorGanhoCagandoPorDia);
    }
}