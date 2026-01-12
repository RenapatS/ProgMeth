package logic;

import java.util.ArrayList;

public class Channel {
    private String name;
    private ArrayList<Message> messageList;
    public Channel(String name){
        this.name = name;
        messageList = new ArrayList<>();
    }
    public void addMessage(Message message){
        messageList.add(message);
    }
    public void setName(String name){
        if(name.isBlank())name = "off-topic";
        this.name = name;
    }
    public int getMessageCount() {
        return messageList.size();
    }

    public String getName() {
        if(name.isBlank())return  "off-topic";
        return name;
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<Message> messageList) {
        this.messageList = messageList;
    }
}
