package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinal.databinding.ActivityMainBinding;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginMenu extends AppCompatActivity {

    EditText et_email, et_password;
    Button btn_login,btn_googleLogin;
    TextView tv_go2Register;
    FirebaseAuth fAuth;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_menu);

        et_email = findViewById(R.id.alm_et_email);
        et_password = findViewById(R.id.alm_et_password);
        btn_login = findViewById(R.id.alm_btn_login);
        tv_go2Register = findViewById(R.id.alm_tv_go2Register);
        btn_googleLogin = findViewById(R.id.alm_btn_googleLogin);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser()!= null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
//        if(acct!=null){
//            navigateToSecondActivity();
//        }


        btn_googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et_email.getText().toString().trim();
                String password = et_password.getText().toString().trim();

                if(TextUtils.isEmpty(email))    { et_email.setError("Email es requerido");                          return; }
                if(TextUtils.isEmpty(password)) { et_password.setError("Password es requerido");                    return; }
                if(password.length()<6)         { et_password.setError("Password tiene que ser >=6 caracteres");    return; }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(LoginMenu.this,"Sesion iniciada exitosamente",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }else {
                            Toast.makeText(LoginMenu.this," Se produjo un ERROR! Sesion no iniciada" +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        tv_go2Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegisterMenu.class));
                finish();
            }
        });
    }

    void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }

    }
    void navigateToSecondActivity(){

        Toast.makeText(LoginMenu.this,"Sesion iniciada exitosamente",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

}