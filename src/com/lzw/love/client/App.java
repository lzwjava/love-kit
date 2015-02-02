package com.lzw.love.client;

import android.app.Application;
import android.content.Context;
import com.avos.avoscloud.AVOSCloud;
import com.lzw.commons.Logger;

/**
 * Created by lzw on 15/1/31.
 */
public class App extends Application {
  public static Context ctx;

  @Override
  public void onCreate() {
    ctx = this;
    super.onCreate();
    AVOSCloud.initialize(this, "1rkbs33bqmjficfoessvuejvgfzyk7s8x9gfd2ldhsbebq0f",
        "qx2vwcpjo3irzvg6ui55lwe7ppf14n9dq4sysahat7wb4jz7");
    AVOSCloud.setDebugLogEnabled(true);
    Logger.open = true;
  }
}
