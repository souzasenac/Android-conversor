package br.senac.es.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    double altura1 = 1.50,
            altura2 = 1.60,
            altura3 = 1.80;

    int alturaEmCentimetros = 0;


    private String formatarValorComDoisDigitos(double valor) {
        return String.format(Locale.FRANCE, "%.2f", valor);

    }

    private Double calculaMedia(double valor1, double valor2, double valor3) {

        double mediafinal = valor1 + valor2 + valor3 / 3;
        return mediafinal;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //istanciando as variaveis
        final TextView txtAltura = (TextView) findViewById(R.id.altura);

        final TextView media = (TextView) findViewById(R.id.txtMedia);

        final TextView txtMetros = (TextView) findViewById(R.id.txtMetros);
        final TextView txtPes = (TextView) findViewById(R.id.txtPes);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.skbMetros);
        final Button button = (Button) findViewById(R.id.bntConverter);

        media.setText("Media");

        seekBar.setMax(230);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //criando o progresso do seekbar

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                alturaEmCentimetros = progress;
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
                double alturaPes = alturaEmCentimetros / 30.48;
                String texto = formatarValorComDoisDigitos(alturaPes);
                texto += " pé(s)";
                txtPes.setText(texto);

                double cabrito = calculaMedia(altura1, altura2, altura3);


                if (alturaEmCentimetros < cabrito ) {
                    media.setText("maior que a média (media:'" + cabrito +"')");


                } if (alturaEmCentimetros > cabrito ){
                    media.setText("menor que a média (media:'" + cabrito +"')");
                }
                if (alturaEmCentimetros == cabrito){
                    media.setText("esta na média (media:'" + cabrito +"')");
                }
            }
        });
    }
}