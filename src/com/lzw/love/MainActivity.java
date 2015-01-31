package com.lzw.love;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
  public TextView tv;
  int cnt = -1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    LinearLayout root = (LinearLayout)
        findViewById(R.id.root);
    final DrawView draw = new DrawView(this);
    draw.setMinimumWidth(200);
    draw.setMinimumHeight(300);
    root.addView(draw);

    //获取屏幕尺寸
    /*DisplayMetrics dm=new DisplayMetrics();
    super.getWindowManager().getDefaultDisplay().
		  getMetrics(dm);
		draw.setWidthAndHeight(dm.widthPixels,dm.heightPixels);*/
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    cnt++;
    if (cnt % 10 != 0) return true;
    Intent intent = new Intent();
    intent.setClass(MainActivity.this, Wonderful.class);
    MainActivity.this.startActivity(intent);
    return true;
  }
}
