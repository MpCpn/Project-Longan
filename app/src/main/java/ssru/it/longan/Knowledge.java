package ssru.it.longan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Knowledge extends AppCompatActivity implements View.OnClickListener {
    ImageView M7 , Inf , Home , Qr , GoChat ,Back , L;
    TextView knl,knl1,knl2,knl3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge);
        M7 = findViewById(R.id.m);
        Home = findViewById(R.id.homek);
        Inf = findViewById(R.id.inf1);
        Qr = findViewById(R.id.qr1);
        Qr.setOnClickListener(this);
        L = findViewById(R.id.l);
        Back = findViewById(R.id.bk);
        knl = findViewById(R.id.textaa1);
        GoChat = findViewById(R.id.chatbot5);
        GoChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChat();
            }
        });
        knl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent knlgo1 = new Intent(Knowledge.this,Knowledge1.class);
                startActivity(knlgo1);
            }
        });
        knl1 = findViewById(R.id.textbb1);
        knl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent knlgo2 = new Intent(Knowledge.this,Knowledge2.class);
                startActivity(knlgo2);
            }
        });
        knl2 = findViewById(R.id.textcc1);
        knl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent knlgo3 = new Intent(Knowledge.this,Knowledge3.class);
                startActivity(knlgo3);
            }
        });
        knl3 = findViewById(R.id.textdd1);
        knl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent knlgo4 = new Intent(Knowledge.this,Knowledge4.class);
                startActivity(knlgo4);
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(Knowledge.this,MainActivity3.class);
                startActivity(b);
            }
        });
        L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(Knowledge.this,MainActivity4.class);
                startActivity(l);
            }
        });
        M7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m7 = new Intent(Knowledge.this,MainActivity7.class);
                startActivity(m7);
            }
        });

        Inf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Knowledge.this,information.class);
                startActivity(in);
            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h = new Intent(Knowledge.this,MainActivity3.class);
                startActivity(h);
            }
        });
    }

    @Override
    public void onClick(View v) {
        scanCode();
    }
    private void scanCode(){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(CaptrueAct.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("คุณสามารถสแกนคิวอาร์โค้ดเพื่อค้นหาข้อมูล\n" +
                "หรือเพิ่มข้อมูลต่างๆ ของลำไยต้นนี้ได้");
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (result !=null){
            if(result.getContents() != null){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(result.getContents());
                builder.setTitle("Scanning Result");
                builder.setPositiveButton("scan Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        scanCode();
                    }
                }).setNegativeButton("finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else {
                Toast.makeText(this, "No Results",Toast.LENGTH_SHORT).show();
            }
        }else {
            super.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    public void showChat(){
        AlertDialog.Builder Chat = new AlertDialog.Builder(Knowledge.this);

        LayoutInflater inflater = this.getLayoutInflater();
        View Chatbot  = inflater.inflate(R.layout.activity_chatbott,null);

        Chat.setView(Chatbot);
        Chat.show();
    }
}
