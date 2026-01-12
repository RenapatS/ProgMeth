package logic;

import java.util.ArrayList;

import static java.lang.Math.round;
import static logic.Status.AVAILABLE;

public class Region {
    private String name;
    private ArrayList<Player> playerList;
    private ArrayList<Quest> questList;
    public Region(String name){
        this.name = name;
        playerList = new ArrayList<>();
        questList = new ArrayList<>();
    }
    public void setName(String name){
        if(name.isBlank())name = "Nowhere";
        this.name = name;
    }
    public int getPlayerCount(){
        return playerList.size();
    }
    public double getRegionRank(){

        double ans = 0.00;
        for(Player x : playerList){
            ans += x.getRank();
        }
        ans /= playerList.size();
        return round(ans*100.0)/100.0;

    }

    public ArrayList<Quest> getAvailableQuests(Player viewer){
        ArrayList<Quest> newList = new ArrayList<>();
        for( Quest x :questList){
            if(x.getAuthor().equals(viewer))continue;
            if(x.getStatus() == AVAILABLE) newList.add(x);
        } return newList;
    }

    public void addPlayerToRegion(Player p) {
        playerList.add(p);
    }
    public void addQuestToRegion(Quest q) {
        questList.add(q);
    }

    public String getName() {
        if(name.isBlank())name = "Nowhere";
        return name;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<Quest> getQuestList() {
        return questList;
    }

    public void setQuestList(ArrayList<Quest> questList) {
        this.questList = questList;
    }
}
