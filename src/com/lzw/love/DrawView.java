package com.lzw.love;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class DrawView extends View {
  public float currentX, currentY;
  public float YesX, YesY, NoX = 200, NoY = 200;
  float textSize = 100;
  int cntYes = 0, widthPixels, heightPixels, width, height;
  Paint p = new Paint();
  Paint p1 = new Paint();
  TextView tv;
  int cnt = 0;

  public DrawView(Context context) {
    super(context);
  }

  public DrawView(Context context, AttributeSet set) {
    super(context, set);
  }

  public void setTextView(TextView tv1) {
    this.tv = tv1;
  }

  public void setWidthAndHeight(int width, int height) {
    widthPixels = width;
    heightPixels = height - 500;
  }

  @Override
  public void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    p1.setColor(Color.YELLOW);
    p.setColor(Color.GREEN);
    p.setTextSize(100);
    p1.setTextSize(100);
    if (cnt == 0) {
      width = getWidth();
      height = getHeight();
      int margin = 200;
      YesX = width / 2 - margin;
      NoX = (float) (width / 2 + margin);
      YesY = NoY = (float) (height - 200);
    }
    cnt++;
    canvas.drawText("No", NoX, NoY, p1);
    canvas.drawText("Yes", YesX, YesY, p);
  }

  boolean rightXY(float x1, float y1, float x, float y, float width,
                  float height) {
    return x1 > x && x1 < x + width && y1 < y && y1 > y - height;
  }

  boolean inWindow(float x, float y) {
    return x > 0 && x < width && y > 0 && y < height;
  }

  public boolean onTouchEvent(MotionEvent event) {
    currentX = event.getX();
    currentY = event.getY();
    if (rightXY(currentX, currentY, YesX, YesY, 170, 100)) {
      if (cntYes % 50 == 0) {
        //Toast.makeText(getContext(), "我一定会好好对你的！", Toast.LENGTH_SHORT).show();
        return false;
      }
      cntYes++;
      return true;
    }
    if (rightXY(currentX, currentY, NoX, NoY, 120, 100)) {
      float nx, ny;
      do {
        nx = (float) (Math.random() * width);
        ny = (float) (Math.random() * height);
      } while (rightXY(nx, ny, NoX, NoY, 120, 100)
          || rightXY(nx, ny, YesX, YesY, 170, 100) || (!inWindow(nx, ny))
          || (!inWindow(nx + 120, ny - 100))
          || rightXY(nx + 120, ny - 100, YesX, YesY, 170, 100));
      NoX = nx;
      NoY = ny;
      invalidate();
    }
    return true;
  }
}
