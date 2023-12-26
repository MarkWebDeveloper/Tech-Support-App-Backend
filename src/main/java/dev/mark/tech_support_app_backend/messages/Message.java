package dev.mark.tech_support_app_backend.messages;

import java.util.HashMap;

public class Message {

  private HashMap<String, String> message;

  public Message() {
  }

  public HashMap<String, String> getMessage() {
    return message;
  }

  public void setMessage(HashMap<String, String> message) {
    this.message = message;
  }

  public void setMessage(String msg) {
    HashMap<String, String> newMessage = new HashMap<String, String>();
    newMessage.put("message", msg);
    this.message = newMessage;
  }

}