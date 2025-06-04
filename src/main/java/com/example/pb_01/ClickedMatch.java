package com.example.pb_01;

public class    ClickedMatch {
    private int macSiraNo;
    private String betType;
    private String oran;
    private String team1Name;
    private String team2Name;

    // Constructor
    public ClickedMatch(int macSiraNo, String betType, String oran, String team1Name, String team2Name) {
        this.macSiraNo = macSiraNo;
        this.betType = betType;
        this.oran = oran;
        this.team1Name = team1Name;
        this.team2Name = team2Name;
    }

    // Getters and Setters
    public int getMacSiraNo() {
        return macSiraNo;
    }

    public void setMacSiraNo(int macSiraNo) {
        this.macSiraNo = macSiraNo;
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }

    public String getOran() {
        return oran;
    }

    public void setOran(String oran) {
        this.oran = oran;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }
}
