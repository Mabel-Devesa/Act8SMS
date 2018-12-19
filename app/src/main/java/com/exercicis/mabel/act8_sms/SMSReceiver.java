package com.exercicis.mabel.act8_sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        //Rebre l'SMS

        //Obtenim els extres de l'Intent
        Bundle bundle = intent.getExtras();

        SmsMessage[] missatges = null;
        String s = "";

        //Si hi ha extres
        if(bundle !=null) {
            //obtenir llistat d'SMS
            Object[] pdus = (Object[]) bundle.get("pdus");

            missatges = new SmsMessage[pdus.length];

            SmsMessage missatge = null;

            for(int i=0; i<pdus.length; i++) {
                //Aquesta linia ja no es pot utilitzar en les noves versions (obsoleta)
                //missatge = SmsMessage.createFromPdu((byte[])pdus[i]);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    String format = bundle.getString("format");
                    //missatges[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                    missatge = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                }
                else {
                    //missatges[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    missatge = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }


                s += "SMS de " + missatge.getOriginatingAddress();
                s += ": ";
                s += missatge.getMessageBody().toString();
                s += "\n";
            }

            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
        }
    }
}
