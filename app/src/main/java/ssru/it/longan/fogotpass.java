package ssru.it.longan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class fogotpass extends AppCompatActivity {
    ImageView Back ;
    Button G ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fogotpass);
        Back = findViewById(R.id.bpass);
        G = findViewById(R.id.gotpass);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(fogotpass.this,MainActivity.class);
                startActivity(b);
            }
        });
        G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(fogotpass.this,fogotpassa.class);
                startActivity(c);
            }
        });

    }
}