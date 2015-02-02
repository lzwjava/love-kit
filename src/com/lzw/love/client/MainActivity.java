package com.lzw.love.client;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.avos.avoscloud.AVMessage;
import com.lzw.love.base.AgreeActivity;
import com.lzw.love.base.MsgListener;
import com.lzw.love.base.SoundUtils;

public class MainActivity extends Activity implements MsgListener {
  int cnt = -1;
  Rtm rtm;

  @InjectView(R.id.networkState)
  View networkStateView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    ButterKnife.inject(this);

    rtm = Rtm.getInstance();
    LinearLayout root = (LinearLayout)
        findViewById(R.id.root);
    final DrawView draw = new DrawView(this);
    draw.setMinimumWidth(200);
    draw.setMinimumHeight(300);
    root.addView(draw);

    draw.setOnClickListener(new DrawView.OnClickListener() {
      @Override
      public void onClickYes() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, AgreeActivity.class);
        MainActivity.this.startActivity(intent);
        //SoundUtils.playAgreeSound(MainActivity.this);

        int resID = getResources().getIdentifier("good", "raw", getPackageName());
        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, resID);
        mediaPlayer.start();
        rtm.sendYes();
      }

      @Override
      public void onClickNo(int times) {
        rtm.sendNo(times);
      }
    });

    //获取屏幕尺寸
    /*DisplayMetrics dm=new DisplayMetrics();
    super.getWindowManager().getDefaultDisplay().
		  getMetrics(dm);
		draw.setWidthAndHeight(dm.widthPixels,dm.heightPixels);*/

    MsgReceiver.registerListener(this);
    setNetworkStateView(MsgReceiver.isSessionConnected(this));
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    return true;
  }

  @Override
  public void onMessageReceive(AVMessage msg) {
  }

  @Override
  public void onStatusChanged(boolean online) {

  }

  @Override
  public void onSessionChanged(boolean connected) {
    setNetworkStateView(connected);
  }

  public void setNetworkStateView(boolean connected) {
    networkStateView.setVisibility(connected ? View.GONE : View.VISIBLE);
  }

  @Override
  protected void onDestroy() {
    MsgReceiver.unregisterListener();
    super.onDestroy();
  }
}
