package com.cursoandroid.teste.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView imagemResultado = findViewById(R.id.imagemResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int num = new Random().nextInt(3);//0 1 2
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[num];

        switch (opcaoApp) {
            case "Pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;

        }

        if ( //App ganhador
                (opcaoApp == "Tesoura" && opcaoSelecionada == "Papel") ||
                (opcaoApp == "Pedra" && opcaoSelecionada == "Tesoura") ||
                (opcaoApp == "Papel" && opcaoSelecionada == "Pedra")
        ) {
            textoResultado.setText("Você perdeu!");

        } else if ( //Usuario ganhador
                (opcaoSelecionada == "Tesoura" && opcaoApp == "Papel") ||
                (opcaoSelecionada == "Pedra" && opcaoApp == "Tesoura") ||
                (opcaoSelecionada == "Papel" && opcaoApp == "Pedra")
        ) {
            textoResultado.setText("Você ganhou!");

        } else { //Empate
            textoResultado.setText("Empatamos!");

        }

        System.out.println("Item clicado: " + opcaoApp);


    }

}