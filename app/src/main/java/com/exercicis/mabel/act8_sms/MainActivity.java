package com.exercicis.mabel.act8_sms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText numTel;
    EditText msg;
    SmsManager sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b_enviar = (Button) findViewById(R.id.enviar);

        sms = SmsManager.getDefault();

        b_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CAPTURAR ELEMENTS
                numTel = (EditText) findViewById(R.id.numTel);
                msg = (EditText) findViewById(R.id.sms);

                //Enviar un SMS amb aquest intent, em dona error
                //Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                //i.putExtra("address", numTel.getText().toString());
                //i.putExtra("sms_body",msg.getText().toString());
                //i.setType("vnd.android-dir/mms-sms");
                //startActivity(i);

                //Com alternativa, enviar el missatge amb aquest codi
                sms.sendTextMessage(numTel.getText().toString(), null, msg.getText().toString(), null, null);
            }
        });

    }
}
