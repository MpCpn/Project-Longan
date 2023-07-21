package ssru.it.longan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Matrix4f;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity4 extends AppCompatActivity {
    TextView Logout , Th , A,A4, C4,D4 ,D5 , Infa4 , Infa5 ;
    ImageView B4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        A = findViewById(R.id.a);
        A4 = findViewById(R.id.a4);
        Th = findViewById(R.id.th);
        C4 = findViewById(R.id.c4);
        D4 = findViewById(R.id.d4);
        D5 = findViewById(R.id.d5);
        B4 = findViewById(R.id.infb4);
        Infa4 =findViewById(R.id.infa4);
        Infa5 = findViewById(R.id.infa5);
        Logout = findViewById(R.id.logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent Logout = new Intent(MainActivity4.this,MainActivity.class);
                startActivity(Logout);
            }
        });
        C4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c4 = new Intent(MainActivity4.this,MainActivity6.class);
                startActivity(c4);
            }
        });
        Th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new Intent(MainActivity4.this,MainActivity3.class);
                startActivity(f);
            }
        });
        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent a = new Intent(MainActivity4.this,MainActivity5.class);
                startActivity(a);
            }
        });
        D5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  b =new Intent(MainActivity4.this,Aboutme.class);
                startActivity(b);
            }
        });
        D4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(MainActivity4.this,MainActivity9.class);
                startActivity(c);
            }
        });
        Infa5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(MainActivity4.this,information.class);
                startActivity(d);
            }
        });
        Infa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(MainActivity4.this,information.class);
                startActivity(e);
            }
        });
        A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w = new Intent(MainActivity4.this,trace.class);
                startActivity(w);
            }
        });
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new  Intent(MainActivity4.this,MainActivity3.class);
                startActivity(f);
            }
        });
    }
}