package com.lzw.love.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.avos.avoscloud.Session;

import java.util.Arrays;

/**
 * Created by lzw on 15/1/31.
 */
public class Login extends Activity {
  @InjectView(R.id.editText)
  EditText codeEdit;
  Rtm rtm;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login);
    ButterKnife.inject(this);
    rtm = Rtm.getInstance();
  }

  @OnClick(R.id.go)
  void login() {
    String code = codeEdit.getText().toString();
    rtm.setClientId(code + "_c");
    rtm.setMasterId(code + "_m");
    Session session = rtm.getSession();
    session.open(Arrays.asList(rtm.getMasterId()));

    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }
}

