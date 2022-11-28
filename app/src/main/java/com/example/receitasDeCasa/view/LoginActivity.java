package com.example.receitasDeCasa.view;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.receitasDeCasa.R;
import com.example.receitasDeCasa.presenter.LoginPresenter;
import com.example.receitasDeCasa.presenter.LoginPresenterContract;
import com.example.receitasDeCasa.repository.CategoriaRepositorio;
import com.example.receitasDeCasa.repository.ReceitaRepositorio;
import com.example.receitasDeCasa.repository.UsuarioRepositorio;

public class LoginActivity extends AppCompatActivity implements LoginPresenterContract.view {
    private static final String TAG = "LoginActivity";
    private LoginPresenterContract.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView email = findViewById(R.id.loginEmailAddress);
        TextView password = findViewById(R.id.loginPassword);

        UsuarioRepositorio.getInstance(this).addUserTest();
        ReceitaRepositorio.getInstance(this).addReceitaTeste();

        this.presenter = new LoginPresenter(this);

        findViewById(R.id.loginConfirm).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        SharedPreferences preferences = getSharedPreferences("dados", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("email", email.getText().toString());
                        editor.commit();

                        presenter.checkLogin(
                                email.getText().toString(),
                                password.getText().toString()
                        );
                    }
                }
        );

        SharedPreferences preferences = getSharedPreferences("dados", MODE_PRIVATE);
        String email1=preferences.getString("email", "");
        email.setText(email1);


        findViewById(R.id.loginSignUp).setOnClickListener(
            (view) ->{
                Intent intentCadastro = new Intent(this, CadastroActivity.class);
                startActivity(intentCadastro);
                Log.d(TAG, "onCreate: Partiu para activity de cadastro");
            }
        );
    }

    @Override
    public void message(String msg) {

    }

    @Override
    public Activity getActivity() {
        return this;
    }
}