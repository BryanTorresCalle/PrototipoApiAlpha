package com.example.api;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class singin extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText etUsuario, etPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mAuth = FirebaseAuth.getInstance();
        conectar();
        btnLogin.setOnClickListener(v -> login(etUsuario.getText().toString(),
                etPassword.getText().toString()));
    }

    private void conectar() {
        etUsuario = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnIngresar);

    }

    private void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(),"Usuario valido",Toast.
                                LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(),solicitud.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Asegurese de tener conexion" +
                                        " a internet o haber ingresado una contraseña correcta",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
