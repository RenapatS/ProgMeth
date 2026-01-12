package logic;

import java.util.ArrayList;

public class Database {
    ArrayList<Player> playerList;
    ArrayList<Region> regionList;

    public Database()  {
        playerList = new ArrayList<>();
        regionList = new ArrayList<>();
    }
    public Database(ArrayList<Player> playerList,ArrayList<Region> regionList){
        this.playerList = playerList;
        this.regionList = regionList;
    }
    public Player addPlayer(String name,Region region)throws Exception{

        for(Player x : playerList){
            if(x.getName().equals(name)){
                throw new Exception("hahaha");
            }
        }

        Player nw = new Player(name);
        playerList.add(nw);
        if (region != null) region.addPlayerToRegion(nw);
        return nw;
    }
    public boolean addRegion(String name) {
        boolean ck = false;
        for(Region x : regionList){
            if(x.getName().equals(name)){
                ck = true;
                break;
            }
        }
        if(!ck)regionList.add(new Region(name));
        return !ck;
    }
    public Region getRegionByName(String name){
        for(Region x : regionList){
            if(x.getName().equals(name)){
                return x;
            }
        } return null;
    }
    public void addQuest(Player author, Region region, String name, String description){
        region.addQuestToRegion(new Quest(author,region,name,description));
    }

    public ArrayList<Region> getRegionList() {
        return regionList;
    }

    public void setRegionList(ArrayList<Region> regionList) {
        this.regionList = regionList;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }
}
