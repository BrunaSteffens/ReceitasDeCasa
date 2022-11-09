package com.example.receitasDeCasa.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.receitasDeCasa.R;
import com.example.receitasDeCasa.model.Usuario;
import com.example.receitasDeCasa.repository.UsuarioRepositorio;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        findViewById(R.id.signUpConfirm).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Usuario usuario = new Usuario();
                        usuario.setName(((TextView) findViewById(R.id.signUpName)).getText().toString());
                        usuario.setEmail(((TextView) findViewById(R.id.signUpEmail)).getText().toString());
                        usuario.setPassword(((TextView) findViewById(R.id.signUpPassword)).getText().toString());
                        UsuarioRepositorio.getInstance().addUser(usuario);
                    }
                }
        );
    }
}