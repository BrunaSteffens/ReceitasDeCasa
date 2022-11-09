package com.example.receitasDeCasa.presenter;

import android.content.Intent;
import com.example.receitasDeCasa.model.Usuario;
import com.example.receitasDeCasa.repository.UsuarioRepositorio;
import com.example.receitasDeCasa.view.MainActivity;

public class LoginPresenter implements LoginPresenterContract.presenter {
    private LoginPresenterContract.view view;

    public LoginPresenter(LoginPresenterContract.view view){
        this.view = view;
    }

    @Override
    public void checkLogin(String email, String password) {
        UsuarioRepositorio repo = UsuarioRepositorio.getInstance(view.getActivity());
        Usuario u = repo.getUserByEmail(email);
        if (u== null || !u.getPassword().equals(password)){
            view.message("Usuário ou senha inválidos");
            //Testar usar dentro da mensagem: Resources.getSystem().getString(R.string.userpassinvalid)
        } else {
            validLogin(u);
        }
    }

    @Override
    public void validLogin(Usuario usuario) {
        Intent intent = new Intent(view.getActivity(), MainActivity.class);
        intent.putExtra("userObj", usuario);
        view.getActivity().startActivity(intent);
    }
}
