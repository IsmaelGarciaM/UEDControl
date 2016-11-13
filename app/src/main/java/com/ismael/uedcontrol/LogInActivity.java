package com.ismael.uedcontrol;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ismael.uedcontrol.interfaces.ILogin;
import com.ismael.uedcontrol.model.Therapist;
import com.ismael.uedcontrol.repositories.TherapistRepository;

public class LogInActivity extends AppCompatActivity implements ILogin.View{

    private ILogin.Presenter loginMvp;
    private EditText edtUser;
    private EditText edtPassword;
    private Button btnEntry;
    private TextInputLayout tilUser;
    private TextInputLayout tilPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        loginMvp = new LogInPresenter(this);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPassword = (EditText) findViewById(R.id.edtPass);
        btnEntry = (Button) findViewById(R.id.btnEntry);
        tilUser = (TextInputLayout) findViewById(R.id.tiluser);
        tilPass = (TextInputLayout) findViewById(R.id.tilpassword);
        edtUser.setText("a");
        edtPassword.setText("aaaaaaA8");
        edtUser.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilUser.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginMvp.validateCredentials(edtUser.getText().toString(), edtPassword.getText().toString())) {
                    TherapistRepository.getInstance().add(new Therapist(edtUser.getText().toString(), "Apellidos", "DNI", "correo@gmail.com", "telefono", 454545, edtPassword.getText().toString()));
                    Intent intent = new Intent(LogInActivity.this, NavigationDrawerActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void setMessageError(String error, int idview) {

        switch (idview) {
            case R.id.tiluser: tilUser.setError(error);
                break;
            case R.id.tilpassword: tilPass.setError(error);
                break;
        }

    }
}
