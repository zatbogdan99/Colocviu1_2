package ro.pub.cs.systems.eim.colocviu1_2;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

public class Colocviu1_2Service extends Service {
    private IntentFilter intentFilter = new IntentFilter();

    public Colocviu1_2Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int sum = intent.getIntExtra("suma", -1);
        intent.putExtra("message", new Date(System.currentTimeMillis()) + " " + sum);
        sendBroadcast(intent);

        return super.onStartCommand(intent, flags, startId);
    }

    private MessageBroadcastReceiver messageBroadcastReceiver = new MessageBroadcastReceiver();
    private class MessageBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("[Message]", intent.getStringExtra("message"));
        }
    }
}