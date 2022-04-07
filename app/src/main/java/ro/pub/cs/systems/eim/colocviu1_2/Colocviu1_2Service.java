package ro.pub.cs.systems.eim.colocviu1_2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Date;

public class Colocviu1_2Service extends Service {
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
}