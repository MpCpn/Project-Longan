package ssru.it.longan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Knowledge4 extends AppCompatActivity implements View.OnClickListener {
    ImageView L ,Back,M7,Inf,Qr,Home,know,GoChat ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge4);
        L = findViewById(R.id.l3);
        Back = findViewById(R.id.back3);
        M7 = findViewById(R.id.m4);
        Inf = findViewById(R.id.inf5);
        Qr = findViewById(R.id.qr5);
        Qr.setOnClickListener(this);
        Home = findViewById(R.id.homek4);
        know = findViewById(R.id.Kw4);
        GoChat = findViewById(R.id.chatbot9);
        GoChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChat();
            }
        });
        M7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m7 = new Intent(Knowledge4.this,MainActivity7.class);
                startActivity(m7);
            }
        });

        Inf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Knowledge4.this,information.class);
                startActivity(in);
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h = new Intent(Knowledge4.this,MainActivity3.class);
                startActivity(h);
            }
        });
        know.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kn = new Intent(Knowledge4.this,Knowledge.class);
                startActivity(kn);
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(Knowledge4.this,Knowledge.class);
                startActivity(b);
            }
        });
        L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(Knowledge4.this,MainActivity4.class);
                startActivity(l);
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
        AlertDialog.Builder Chat = new AlertDialog.Builder(Knowledge4.this);

        LayoutInflater inflater = this.getLayoutInflater();
        View Chatbot  = inflater.inflate(R.layout.activity_chatbott,null);

        Chat.setView(Chatbot);
        Chat.show();
    }
}