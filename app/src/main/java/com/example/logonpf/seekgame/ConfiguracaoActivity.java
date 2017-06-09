package com.example.logonpf.seekgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class ConfiguracaoActivity extends AppCompatActivity {
    private SeekBar seek1;
    private EditText et_nome;
    private RatingBar rt_avaliacao;
    private Button btn_enviar;
    int velocidade = 0;
    float avaliacao = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_configuracao_personagem);
        //
        seek1 = (SeekBar) findViewById(R.id.seek1);
        et_nome = (EditText) findViewById(R.id.et_nome);
        rt_avaliacao = (RatingBar) findViewById(R.id.rt_avaliacao);
        btn_enviar = (Button) findViewById(R.id.btn_enviar);
        //
        seek1.setMax(100);
        seek1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                velocidade = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //
        rt_avaliacao.setNumStars(5);
        rt_avaliacao.setMax(5);
        rt_avaliacao.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                avaliacao = rating;
            }
        });
        //

       btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomePersonagem = String.valueOf(et_nome.getText());
                String avaliacaoPontos = String.valueOf(avaliacao);
                String velocidadeTexto = Integer.toString(velocidade);
                //
                ArrayList<String> configuracoes = new ArrayList<String>();
                configuracoes.add(nomePersonagem);
                configuracoes.add(avaliacaoPontos);
                configuracoes.add(velocidadeTexto);
                //
                Intent i = new Intent(getBaseContext(), ViewConfiguracaoActivity.class);
                i.putExtra("configuracoes", configuracoes);
                startActivity(i);
            }
        });
    }
}
