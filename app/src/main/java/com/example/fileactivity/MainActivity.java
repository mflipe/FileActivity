package com.example.fileactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private String[] array = new String[] {"Arquivo 1", "Arquivo 2", "Arquivo 3", "Arquivo 4", "Arquivo 5"};
    private String arquivo;
    private EditText entrada, exibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exibicao = (EditText) findViewById(R.id.edVisualiza);
        entrada = (EditText) findViewById(R.id.edEntrada);

        ArrayAdapter<String> arrayAd = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array);
        ListView lista = (ListView) findViewById(R.id.ListView);
        lista.setAdapter(arrayAd);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                arquivo = (String) parent.getItemAtPosition(position);
                exibirDadosArquivo();
            }
        });
    }

    public void exibirDadosArquivo() {
        exibicao.setText("");
        FileInputStream in;
        try {
            in = openFileInput(arquivo);

            Scanner scan = new Scanner(in);
            while (scan.hasNext()) {
                exibicao.append(scan.nextLine() + "\n");
            }
        } catch (IOException e) {
            exibicao.setHint("Vazio");
        }
    }

    public void gravarDadosArquivos(View view) {
        FileOutputStream out;
        try {
            out = openFileOutput(arquivo, Context.MODE_APPEND);
            out.write(entrada.getText().toString().concat("\n").getBytes());
            out.close();
        } catch (IOException e) {
            // Do nothing
        }

        exibirDadosArquivo();
    }

}