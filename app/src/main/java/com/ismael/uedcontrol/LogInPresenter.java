package com.ismael.uedcontrol;

import android.content.Context;
import android.text.TextUtils;

import com.ismael.uedcontrol.interfaces.ILogin;

import java.util.regex.Pattern;

public class LogInPresenter implements ILogin.Presenter {
    private ILogin.View view;

    public LogInPresenter(ILogin.View view){
        this.view = view;
    }


    public boolean validateCredentials(String user, String passw) {
        if(TextUtils.isEmpty(user) || TextUtils.isEmpty(passw)) {
            view.setMessageError(((Context) view).getResources().getString(R.string.dataEmpty), R.id.tiluser);
            return false;
        }

        else if (passw.length() <= 7) {
            view.setMessageError(((Context) view).getResources().getString(R.string.passwordLength), R.id.tilpassword);
            return false;
        }

        else if (!Pattern.matches(".*[0-9].*", passw)) {
            view.setMessageError(((Context) view).getResources().getString(R.string.passwordDigit), R.id.tilpassword);
            return false;
        }

        else if (!Pattern.matches(".*[A-Z].*", passw) || !Pattern.matches(".*[a-z].*", passw)) {
            view.setMessageError(((Context) view).getResources().getString(R.string.passwordCase), R.id.tilpassword);
            return false;
        }

        else{
            return true;
        }

    }
}
