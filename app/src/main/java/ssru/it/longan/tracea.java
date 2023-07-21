package ssru.it.longan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class tracea extends AppCompatActivity implements View.OnClickListener {
    ImageView LLL , Back, M7 , Inf , Qr , Home , know ,GoChat ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracea);

        LLL = findViewById(R.id.ltra);
        Back = findViewById(R.id.btra);
        M7 = findViewById(R.id.mtar);
        Inf =findViewById(R.id.inftar);
        Qr = findViewById(R.id.qrtar);
        Qr.setOnClickListener(this);
        Home = findViewById(R.id.htar);
        know = findViewById(R.id.ktar);
        GoChat = findViewById(R.id.chatbot25);
        GoChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChat();
            }
        });
        Back.setOnClickListener(v -> {
            Intent b = new Intent(tracea.this,trace.class);
            startActivity(b);
        });
        LLL.setOnClickListener(v -> {
            Intent l = new Intent(tracea.this,MainActivity4.class);
            startActivity(l);
        });
        M7.setOnClickListener(view -> {
            Intent m7 = new Intent(tracea.this,MainActivity7.class);
            startActivity(m7);
        });
        Inf.setOnClickListener(view -> {
            Intent in = new Intent(tracea.this,information.class);
            startActivity(in);
        });
        Home.setOnClickListener(v -> {
            Intent h = new Intent(tracea.this,MainActivity3.class);
            startActivity(h);
        });
        know.setOnClickListener(view -> {
            Intent kn = new Intent(tracea.this,Knowledge.class);
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
        AlertDialog.Builder Chat = new AlertDialog.Builder(tracea.this);

        LayoutInflater inflater = this.getLayoutInflater();
        View Chatbot  = inflater.inflate(R.layout.activity_chatbott,null);

        Chat.setView(Chatbot);
        Chat.show();
    }
}