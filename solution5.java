import java.util.ArrayList;
import java.util.Scanner;

public class solution5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Player> playerList = new ArrayList<>();

        boolean flag=true;
        while(flag){
            long a = sc.nextLong(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();

            playerList.add(new Player(a, b, c, d));

            flag = sc.nextBoolean();
        }

        int n = sc.nextInt();

        AchievementTracker tracker = new AchievementTracker();

        int[] levelsToSimulate = new int[n];

        for(int i=0;i<n;i++){
            int e = sc.nextInt();
            levelsToSimulate[i]=e;
        }

        for(int i=0;i<playerList.size();i++){
            tracker.simulateGameplay(playerList, playerList.get(i).getPlayerId(), levelsToSimulate[i]);
            tracker.displayPlayerStats(playerList.get(i));
        }
    }
}

class Player{
    long playerId;
    String playerName;
    int levelCompleted;
    int badgesEarned;
    
    public Player(long playerId, String playerName, int levelCompleted, int badgesEarned) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.levelCompleted = levelCompleted;
        this.badgesEarned = badgesEarned;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLevelCompleted() {
        return levelCompleted;
    }

    public void setLevelCompleted(int levelCompleted) {
        this.levelCompleted = levelCompleted;
    }

    public int getBadgesEarned() {
        return badgesEarned;
    }

    public void setBadgesEarned(int badgesEarned) {
        this.badgesEarned = badgesEarned;
    }

}

class AchievementTracker{
    
    public void completeLevel(Player player){
        player.setLevelCompleted(player.getLevelCompleted()+1);

        if(player.getLevelCompleted()%3==0){
            player.setBadgesEarned(player.getBadgesEarned()+1);
        }
    }

    public void displayPlayerStats(Player player){
        System.out.println("Player ID: " + player.getPlayerId());
        System.out.println("Name: " + player.getPlayerName());
        System.out.println("Levels Completed: " + player.getLevelCompleted());
        System.out.println("Badges Earned: " + player.getBadgesEarned());
    }

    public void simulateGameplay(ArrayList<Player> playerList, long playerId, int levelsToUpdate){
        for(Player p: playerList){
            if(p.getPlayerId()==playerId){
                for(int i=0;i<levelsToUpdate;i++){
                    completeLevel(p);
                }
            }
        }
    }
}
