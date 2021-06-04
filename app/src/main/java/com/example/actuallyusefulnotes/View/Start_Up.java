package com.example.actuallyusefulnotes.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actuallyusefulnotes.ViewModel.AUNViewModel;
import com.example.actuallyusefulnotes.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import static java.sql.Types.NULL;

public class Start_Up extends AppCompatActivity {
    EditText usertext, emailtext, passtext, emaillogin, passlogin;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        AUNViewModel model = new ViewModelProvider(this).get(AUNViewModel.class);
        setContentView(R.layout.signin);

        Button bt_signin = findViewById(R.id.bt_signin);
        Button go_login = findViewById(R.id.bt_lay_login);

        usertext = findViewById(R.id.usuario);
        emailtext = findViewById(R.id.correo);
        passtext = findViewById(R.id.contraseña);

        go_login.setOnClickListener((v -> {
            setContentView(R.layout.login);

            pre_log_in();

        }));


        bt_signin.setOnClickListener((v -> {

            sign_up();
        }));

    }

    public void sign_up() {
        setContentView(R.layout.signin);

        Button bt_signin = findViewById(R.id.bt_signin);
        Button go_login = findViewById(R.id.bt_lay_login);


        String username = usertext.getText().toString();
        String email = emailtext.getText().toString();
        String pass = passtext.getText().toString();

        System.out.println("email" + email);
        System.out.println("pass" + pass);

        if (username.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(Start_Up.this, "Todos los campos son necesarios.", Toast.LENGTH_SHORT).show();
        } else {


            auth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d("TAG", "Success");
                                FirebaseUser user = auth.getCurrentUser();
                                UserProfileChangeRequest name = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(username).build();
                                user.updateProfile(name);
                                Toast.makeText(Start_Up.this, "Authentication successful.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Start_Up.this, MainActivity.class);
                                startActivity(intent);

                            } else {
                                Log.w("Failed register", "failure", task.getException());
                                Toast.makeText(Start_Up.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        go_login.setOnClickListener((v -> {

            pre_log_in();
        }));
    }

    public void pre_log_in() {
        setContentView(R.layout.login);
        Button bt_login = findViewById(R.id.bt_login);
        bt_login.setOnClickListener((v -> {
            log_in();
        }));

    }

    public void log_in() {


        Button bt_login = findViewById(R.id.bt_login);
        Button go_signup = findViewById(R.id.bt_lay_signup);

        emaillogin = findViewById(R.id.usuario_login);
        passlogin = findViewById(R.id.contraseña_login);

        String email = emaillogin.getText().toString();
        String password = passlogin.getText().toString();

        if (!email.isEmpty() && !password.isEmpty()) {

            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("Log in", "signInWithEmail:success");
                                FirebaseUser user = auth.getCurrentUser();
                                Intent intent = new Intent(Start_Up.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("Log in", "signInWithEmail:failure", task.getException());
                                Toast.makeText(Start_Up.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }

    }
}