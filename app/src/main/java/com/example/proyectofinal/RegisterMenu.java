package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterMenu extends AppCompatActivity {
    EditText arm_et_fullName, arm_et_email, arm_et_password;
    Button arm_btn_register;
    TextView arm_tv_go2Login;
    FirebaseAuth fAuth; // firebase autenticacion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_menu);

        arm_et_fullName = (EditText) findViewById(R.id.arm_et_nombre);
        arm_et_email = (EditText) findViewById(R.id.arm_et_email);
        arm_et_password = (EditText) findViewById(R.id.arm_et_password);
        arm_btn_register = (Button) findViewById(R.id.arm_btn_register);
        arm_tv_go2Login = (TextView) findViewById(R.id.arm_tv_go2Login);

        arm_tv_go2Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginMenu.class));
                finish();
            }
        });

        fAuth = FirebaseAuth.getInstance(); // recibiendo la isntancia para realizar todas las operaciones

        //2*** Verificar si el user ya inicio sesion o ya lo hizo
        //*** ver la cuenta antes o despues o es un user que regreso
        // *** current = obtener usuario actual
        if(fAuth.getCurrentUser()!= null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        //**********
        arm_btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // el método trim sirve manipulación de cadenas (String), el cual sirve para quitar los espacios a la cadena
                String email = arm_et_email.getText().toString().trim();
                String password = arm_et_password.getText().toString().trim();
                //validar los datos que se ingresaron
                if(TextUtils.isEmpty(email)){
                    arm_et_email.setError("Email es requerido");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    arm_et_password.setError("Password es requerido");
                    return;
                }
                //si es nenor a 6 caracteres
                if(password.length()<6){
                    arm_et_password.setError("Password tiene que ser  >=6 caracteres");
                    return;
                }

                //REGISTRO DE USER EN FIREBASE
                // enviar datos firebase como (email - password) - oyente que nos confirme si el registro se realizo exitoso o no  <resultado autenticacion>
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // si la tarea es exitosa
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterMenu.this,"Usuario creado exitosamente",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                            // caso contrario se produjo un error
                        }else{
                            Toast.makeText(RegisterMenu.this,
                                    " Se produjo un ERROR! usuario no creado" +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            //
                        }
                    }
                });
            }
        });




    }
}