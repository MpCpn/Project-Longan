package ssru.it.longan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;


import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    ImageView imggoa , Qr ,Bell ,  GoChat , knowledge , Gob , Goc , God , Goe ,Pt , M7 ,know, Inf ,Goct;
    Dialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Goct = findViewById(R.id.goct);
         Qr = findViewById(R.id.qr);
         Qr.setOnClickListener(this);
         knowledge=findViewById(R.id.Knowledge);

        M7 = findViewById(R.id.m7);
        Gob = findViewById(R.id.gob);
        Goc = findViewById(R.id.goc);
        God = findViewById(R.id.god);
        Goe = findViewById(R.id.goe);
        Inf = findViewById(R.id.inf);
        know = findViewById(R.id.Know);
        Bell = findViewById(R.id.bell);
        Pt =findViewById(R.id.pt);
        imggoa = findViewById(R.id.goa);
        GoChat = findViewById(R.id.gochatbott);
       GoChat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               showChat();
           }
       });
        Bell.setOnClickListener(v -> {
            Intent ff = new Intent(MainActivity3.this,alert.class);
            startActivity(ff);
        });
        Gob.setOnClickListener(v -> {
            Intent gobb = new Intent(MainActivity3.this,trace.class);
            startActivity(gobb);
        });
        imggoa.setOnClickListener(view -> {
            Intent goaa = new Intent(MainActivity3.this,MainActivity5.class);
            startActivity(goaa);
        });
        Goc.setOnClickListener(view -> {
            Intent gc = new Intent(MainActivity3.this,MainActivity6.class);
            startActivity(gc);
        });
        God.setOnClickListener(view -> {
            Intent gc = new Intent(MainActivity3.this,MainActivity7.class);
            startActivity(gc);
        });
        Pt.setOnClickListener(v -> {
            Intent pt = new Intent(MainActivity3.this,protectt.class);
            startActivity(pt);
        });
        Goe.setOnClickListener(view -> {
            Intent ge = new Intent(MainActivity3.this,MainActivity9.class);
            startActivity(ge);
        });

        M7.setOnClickListener(view -> {
            Intent m7 = new Intent(MainActivity3.this,MainActivity7.class);
            startActivity(m7);
        });
       know.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent dd = new Intent(MainActivity3.this,Knowledge.class);
               startActivity(dd);
           }
       });
       knowledge.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent kk = new Intent(MainActivity3.this,Knowledge.class);
               startActivity(kk);
           }
       });
       Inf.setOnClickListener(view -> {
           Intent in = new Intent(MainActivity3.this,information.class);
           startActivity(in);
       });
        Goct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rw = new Intent(MainActivity3.this,MainActivity4.class);
                startActivity(rw);
            }
        });


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

    @Override
    public void onClick(View v) {
        scanCode();
    }

    public void showChat(){
        AlertDialog.Builder Chat = new AlertDialog.Builder(MainActivity3.this);

        LayoutInflater inflater = this.getLayoutInflater();
        View Chatbot  = inflater.inflate(R.layout.activity_chatbott,null);

        Chat.setView(Chatbot);
        Chat.show();
    }
}