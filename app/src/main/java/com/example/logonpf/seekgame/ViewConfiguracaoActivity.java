package com.example.logonpf.seekgame;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import static com.example.logonpf.seekgame.R.drawable.xzo1;

public class ViewConfiguracaoActivity extends AppCompatActivity {
    //Criação de Atributos
    private TextView tv_nome_personagem;
    private RatingBar rt_avaliacao_config;
    private ProgressBar progressBar2;
    private ImageView img1;
    int imagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_view_configuracao_personagem);
        //Relacionamento de atributo com ID de Layout
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        tv_nome_personagem = (TextView) findViewById(R.id.tv_nome_personagem);
        rt_avaliacao_config = (RatingBar) findViewById(R.id.rt_avaliacao_config);
        img1 = (ImageView) findViewById(R.id.img1);
        //
        if (imagem == 1) {
            img1.setImageResource(R.drawable.xzo1);
        }
        //
        rt_avaliacao_config.setEnabled(false);
        //
        ArrayList<String> viewConfig =
                (ArrayList<String>)
                        getIntent().getSerializableExtra("configuracoes");
        tv_nome_personagem.setText(viewConfig.get(0));
        rt_avaliacao_config.setRating(Float.parseFloat(viewConfig.get(1)));
        progressBar2.setProgress(Integer.parseInt(viewConfig.get(2)));
    }
}
