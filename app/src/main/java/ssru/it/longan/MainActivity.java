package ssru.it.longan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText Email , Password ;
    Button btnLogin ;
    TextView register , fp;
    FirebaseAuth mFirebaseAuth;
    private  FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mFirebaseAuth = FirebaseAuth.getInstance();
        Password = findViewById(R.id.password);
        Email = findViewById(R.id.email);
        btnLogin = findViewById(R.id.login1);
        register = findViewById(R.id.register);
        fp = findViewById(R.id.fogotpassword);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser !=null){
                    Toast.makeText(MainActivity.this,"เข้าสู่ระบบแล้ว",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this,"เข้าสู่ระบบก่อนใช้แอพ",Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emil = Email.getText().toString();
                String pwd = Password.getText().toString();
                if (emil.isEmpty()){
                    Email.setError("ใส่อีเมลล์");
                    Email.requestFocus();
                }
                else if (pwd.isEmpty()){
                    Password.setError("ใส่รหัสผ่าน");
                    Password.requestFocus();
                }
                else if (emil.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else if (!(emil.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(emil,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"ล็อคอินไม่สำเร็จ",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent goToMain = new Intent(MainActivity.this,MainActivity3.class);
                                startActivity(goToMain);
                            }
                        }
                    });
                    register.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent Register = new Intent(MainActivity.this,MainActivity2.class);
                            startActivity(Register);
                        }
                    });
                }

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent re = new Intent(MainActivity.this,MainActivity2.class);
                 startActivity(re);
            }
        });
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ew = new Intent(MainActivity.this,fogotpass.class);
                startActivity(ew);
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

}