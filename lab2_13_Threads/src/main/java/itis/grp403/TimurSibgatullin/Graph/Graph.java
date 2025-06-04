package itis.grp403.TimurSibgatullin.Graph;

public class Graph {
    public int[][] matrix = {
            { 0, 5, 11, 7, 0, 0, 0,  0, 0, 0, 0},
            { 5, 0,  0, 4, 0, 3, 7,  0, 0, 0, 0},
            {11, 0,  0, 0, 8, 0, 0,  0, 0, 0, 0},
            { 7, 4,  0, 0, 5, 0, 0,  9, 0, 0, 0},
            { 0, 0,  8, 5, 0, 0, 0,  6, 0, 7, 0},
            { 0, 3,  0, 0, 0, 0, 0, 12, 8, 0, 0},
            { 0, 7,  0, 0, 0, 0, 0, 0, 11, 0, 0},
            { 0, 0,  0, 9, 6, 12,0, 0,  0, 0, 9},
            { 0, 0,  0, 0, 0, 8, 11, 0, 0, 0, 2},
            { 0, 0,  0, 0, 7, 0, 0,  0, 0, 0, 3},
            { 0, 0,  0, 0, 0, 0, 0,  9, 2, 3, 0}
    };

    private static boolean[] team1 = new boolean[11];
    private static boolean[] team2 = new boolean[11];

    public static synchronized boolean getTeam1(int n) {
        return team1[n];
    }

    public static synchronized boolean getTeam2(int n) {
        return team2[n];
    }

    public static synchronized void setTeam1(int n) {
        team1[n] = true;
    }

    public static synchronized void setTeam2(int n) {
        team2[n] = true;
    }
}
