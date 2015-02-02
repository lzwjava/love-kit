package com.lzw.love.client;

import com.avos.avoscloud.AVMessage;
import com.avos.avoscloud.Session;
import com.avos.avoscloud.SessionManager;
import com.lzw.love.base.command.AgreeCommand;
import com.lzw.love.base.command.RefuseCommand;

import java.util.Arrays;

/**
 * Created by lzw on 15/1/31.
 */
public class Rtm {
  static Rtm rtm;
  String masterId;
  String clientId;

  public static Rtm getInstance() {
    if (rtm == null) {
      rtm = new Rtm();
    }
    return rtm;
  }

  public String getMasterId() {
    return masterId;
  }

  public void setMasterId(String masterId) {
    this.masterId = masterId;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public Session getSession() {
    return SessionManager.getInstance(getClientId());
  }

  public void sendYes() {
    Session session = getSession();
    AgreeCommand agreeCommand = new AgreeCommand();
    AVMessage msg = new AVMessage(agreeCommand.toJSONString(), Arrays.asList(getMasterId()), true);

    session.sendMessage(msg);
  }

  public void sendNo(int times) {
    Session session = getSession();

    RefuseCommand refuseCommand = new RefuseCommand();
    refuseCommand.setTimes(times);

    AVMessage msg = new AVMessage(refuseCommand.toJSONString(),
        Arrays.asList(getMasterId()), true);
    session.sendMessage(msg);
  }
}
