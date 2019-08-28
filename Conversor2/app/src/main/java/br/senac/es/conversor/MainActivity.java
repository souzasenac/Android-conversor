package br.senac.es.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int alturaEmCentimetros = 0;

            private String formatarValorComDoisDigitos (double valor){
                return String.format(Locale.FRANCE,"%.2f", valor);

            }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //estanciando as variaveis
        final TextView txtAltura = (TextView) findViewById(R.id.altura);

        final TextView txtMetros = (TextView) findViewById(R.id.txtMetros);
        final TextView txtPes = (TextView) findViewById(R.id.txtPes);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.skbMetros);
        final Button button = (Button) findViewById(R.id.bntConverter);

        seekBar.setMax(230);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        //criando o progresso do seekbar
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                alturaEmCentimetros=progress;
                String txt = formatarValorComDoisDigitos(progress / 100.0);
                txt += "m.";
                txtMetros.setText(txt);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        button.setOnClickListener(new View.OnClickListener() {

           //função do botão converter
            @Override
            public void onClick(View view) {
                double alturaPes = alturaEmCentimetros /30.48;
                String texto = formatarValorComDoisDigitos(alturaPes);
                texto += " pé(s)";
                txtPes.setText(texto);
            }
        });
    }
}