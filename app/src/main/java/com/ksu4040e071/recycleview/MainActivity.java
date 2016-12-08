package com.ksu4040e071.recycleview;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    private final static int NOTIFICATION_ID = 0;
    private NotificationManager notificationManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void onlistClick(View view){
        ImageButton imageButton =(ImageButton)findViewById(R.id.imageButton);
        startActivity(new Intent(this, listView.class));
    }
    public void onGridClick(View view){
        ImageButton imageButton2 =(ImageButton)findViewById(R.id.imageButton2);
        startActivity(new Intent(this, gridView.class));
    }
    public void oncardClick(View view){
        ImageButton imageButton3 =(ImageButton)findViewById(R.id.imageButton3);
        startActivity(new Intent(this, cardView.class));
    }
    public void onRecycleClick(View view){
        startActivity(new Intent(this, recycleView.class));
    }


    public void onSendClick(View view) {

        String title = "天氣好冷~ >w<";
        String content = "今天溫度18度! 覺得好冷～";
        Email email = new Email(title, content);
        Intent intent = new Intent(this, EmailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("email", email);
        intent.putExtras(bundle);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this)
                .setTicker("You got a mail") // ticker text is no longer displayed in Android 5.0
                .setContentTitle(email.getTitle())
                .setContentText(email.getContent())
                .setSmallIcon(android.R.drawable.ic_dialog_email)
                .setAutoCancel(false)
                .setContentIntent(pendingIntent)
                .setProgress(0, 0,true)
                //進度條
                .setWhen(System.currentTimeMillis())
                //發送通知時間
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                //顯示完整資訊
                .setPriority(Notification.PRIORITY_HIGH)
                //
                .build();
        notification. defaults |= Notification.DEFAULT_VIBRATE ;
        //震動
        notification.ledARGB = 0xff00ff00; // LED燈的顏色，綠燈
        notification.ledOnMS = 300; // LED燈顯示的毫秒數，300毫秒
        notification.ledOffMS = 1000; // LED燈關閉的毫秒數，1000毫秒
        notification.flags |= Notification.FLAG_SHOW_LIGHTS; // 必須加上這個標誌
        notification.defaults |= Notification.DEFAULT_SOUND;
        //聲音
        notificationManager.notify(NOTIFICATION_ID, notification);


    }

    public void onCancelClick(View view) {
        notificationManager.cancel(NOTIFICATION_ID);
    }
}
