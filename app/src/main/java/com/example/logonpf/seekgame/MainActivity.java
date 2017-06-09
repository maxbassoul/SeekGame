package com.example.logonpf.seekgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper vf_nav;
    private Button btn_selecionar_1;
    int imagemPersonagem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_escolha_personagem);
        //
        vf_nav = (ViewFlipper) findViewById(R.id.vf_nav);
        btn_selecionar_1 = (Button) findViewById(R.id.btn_selecionar_1);
        //
        vf_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf_nav.showNext();
            }
        });
        btn_selecionar_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ConfiguracaoActivity.class);
                imagemPersonagem = 1;
                i.putExtra("imagemPersonagem", imagemPersonagem);
                startActivity(i);

            }
        });

    }
}
