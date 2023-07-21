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

public class alerta extends AppCompatActivity implements View.OnClickListener{
    ImageView LLL , Back,M7,Inf,Home,know ,Qr,GoChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerta);

        LLL = findViewById(R.id.lal12);
        Back = findViewById(R.id.bal12);
        M7 = findViewById(R.id.malt12);
        Inf = findViewById(R.id.inflt12);
        Home = findViewById(R.id.halt12);
        know = findViewById(R.id.kalt12);
        Qr = findViewById(R.id.qralt12);
        Qr.setOnClickListener(this);
        GoChat = findViewById(R.id.chatbot3);
        GoChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChat();
            }
        });
        Back.setOnClickListener(v -> {
            Intent b = new Intent(alerta.this,alert.class);
            startActivity(b);
        });
        LLL.setOnClickListener(v -> {
            Intent l = new Intent(alerta.this,MainActivity4.class);
            startActivity(l);
        });
        M7.setOnClickListener(view -> {
            Intent m7 = new Intent(alerta.this,MainActivity7.class);
            startActivity(m7);
        });

        Inf.setOnClickListener(view -> {
            Intent in = new Intent(alerta.this,information.class);
            startActivity(in);
        });
        Home.setOnClickListener(v -> {
            Intent h = new Intent(alerta.this,MainActivity3.class);
            startActivity(h);
        });
        know.setOnClickListener(view -> {
            Intent kn = new Intent(alerta.this,Knowledge.class);
            startActivity(kn);
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
        AlertDialog.Builder Chat = new AlertDialog.Builder(alerta.this);

        LayoutInflater inflater = this.getLayoutInflater();
        View Chatbot  = inflater.inflate(R.layout.activity_chatbott,null);

        Chat.setView(Chatbot);
        Chat.show();
    }
}
