package com.example.api;

import android.content.Intent;
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

public class singup extends AppCompatActivity {
    EditText etNombre, etApellido, etDireccion, etEdad, etTelefono, etMail, etPassword, etSexo;
    Button btnRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        conect();
        btnRegister.setOnClickListener(v -> comprobar());
    }

    private void conect() {
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etDireccion = findViewById(R.id.etDireccion);
        etEdad = findViewById(R.id.etEdad);
        etTelefono = findViewById(R.id.etTelefono);
        etMail = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPassword);
        etSexo = findViewById(R.id.etSexo);
        btnRegister = findViewById(R.id.btnRegister);
    }

    private void comprobar() {
        if (etNombre.getText().toString().equals("") || etSexo.getText().toString().equals("") ||
                etPassword.getText().toString().equals("") || etMail.getText().toString().equals("") ||
                etTelefono.getText().toString().equals("") || etApellido.getText().toString().equals("") ||
                etEdad.getText().toString().equals("") || etDireccion.getText().toString().equals("")) {
            Toast.makeText(this, "Por favor asegurese de llenar todos los campos",
                    Toast.LENGTH_LONG).show();
        }else if(etPassword.getText().toString().length() < 6){
            Toast.makeText(getApplicationContext(), "La contraseña debe ser de al menos 6 caracteres",
                    Toast.LENGTH_LONG).show();
        } else{
            crearUsuario(etMail.getText().toString(), etPassword.getText().toString());
        }
    }

    private void crearUsuario(String mail, String password) {
        mAuth.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(getApplicationContext(), "Usuario valido",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(),singin.class));
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(getApplicationContext(), "Asegurese de haber ingresado un correo valido",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
