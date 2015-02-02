package com.lzw.love.client;

import android.content.Context;
import com.avos.avoscloud.AVMessage;
import com.avos.avoscloud.Session;
import com.lzw.love.base.BaseMsgReceiver;

import java.util.List;

/**
 * Created by lzw on 15/1/31.
 */
public class MsgReceiver extends BaseMsgReceiver {
  @Override
  public void onSessionOpen(Context context, Session session) {
    super.onSessionOpen(context, session);
  }

  @Override
  public void onSessionPaused(Context context, Session session) {
    super.onSessionPaused(context, session);
  }

  @Override
  public void onSessionResumed(Context context, Session session) {
    super.onSessionResumed(context, session);
  }

  @Override
  public void onPeersWatched(Context context, Session session, List<String> peerIds) {

  }

  @Override
  public void onPeersUnwatched(Context context, Session session, List<String> peerIds) {

  }

  @Override
  public void onMessage(Context context, Session session, AVMessage msg) {

  }

  @Override
  public void onMessageSent(Context context, Session session, AVMessage msg) {

  }

  @Override
  public void onMessageDelivered(Context context, Session session, AVMessage msg) {

  }

  @Override
  public void onMessageFailure(Context context, Session session, AVMessage msg) {

  }

  @Override
  public void onStatusOnline(Context context, Session session, List<String> peerIds) {

  }

  @Override
  public void onStatusOffline(Context context, Session session, List<String> peerIds) {

  }

  @Override
  public void onError(Context context, Session session, Throwable e) {

  }
}
