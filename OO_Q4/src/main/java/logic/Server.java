package logic;

import java.util.ArrayList;

import static logic.TemplateType.*;

public class Server {
    private String name;
    private User owner;
    private ArrayList<Channel> channelList;
    private ArrayList<User> memberList;

    public Server(String name, User owner, TemplateType template){
        this.owner = owner;
        memberList = new ArrayList<>();
        channelList = new ArrayList<>();
        memberList.add(owner);
        owner.addJoinedServersList(this);
        this.name = name;
        if(template == BASIC){
            addChannel(owner,"general");
        }else if(template == GAMING){
            addChannel(owner,"gaming");
        }else if(template == STUDY){
            addChannel(owner,"homework-help");
        }
    }
    public Channel addChannel(User user, String channelName){
        Channel nw = new Channel(channelName);
        if(user==owner){
            channelList.add(nw);
            return nw;
        }
        return null;
    }
    public User addUser(User user){
        if(!memberList.contains(user)){
            memberList.add(user);
            user.addJoinedServersList(this);
            return user;
        }else{
            return null;
        }
    }
    public boolean kickUser(User kicker, User kicked) throws Exception{
        if(kicker != owner){
            throw new Exception("hahaha");
        }else if(!memberList.contains(kicked)||this.owner==kicked){
            return false;
        }else{
            kicked.getJoinedServersList().remove(this);
            memberList.remove(kicked);
            return true;
        }
    }
    public void setName(String name){
        if(name.isBlank()){
            this.name = owner.getName() + " home";
        }else this.name = name;
    }

    public boolean isMemberInServer(User ck){
        return memberList.contains(ck);
    }

    public String getName() {
        if(name.isBlank()){
            return this.name = owner.getName() + " home";
        }
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ArrayList<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(ArrayList<Channel> channelList) {
        this.channelList = channelList;
    }

    public ArrayList<User> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<User> memberList) {
        this.memberList = memberList;
    }
}


