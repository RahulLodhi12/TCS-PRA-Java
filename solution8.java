import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class solution8 {
    public static void main(String[] args) throws ViewisNegative {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<MusicApp> l1 = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();

            int size = sc.nextInt();
            List<Song> l2 = new ArrayList<>(size);
            for(int j=0;j<size;j++){
                int aa = sc.nextInt(); sc.nextLine();
                String bb = sc.nextLine();
                String cc = sc.nextLine();
                int dd = sc.nextInt();

                l2.add(new Song(aa, bb, cc, dd));
            }
            l1.add(new MusicApp(a, b, c, l2));
        }
        sc.nextLine();

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        CalculateAvgViewsBySingerName(l1, s1);
        findmusicAppOfSongsBySongName(l1, s2);
        
    }

    public static void CalculateAvgViewsBySingerName(List<MusicApp> l1, String name) throws ViewisNegative{
        int c=0;
        int sum=0;
        int cnt=0;
        for(MusicApp m: l1){
            for(Song s: m.song){
                if(s.getSongViews()<0){
                    throw new ViewisNegative("Invalid songsview");
                }
                if(s.getSingerNamer().equalsIgnoreCase(name)){
                    sum+=s.getSongViews();
                    cnt++;
                }
                else{
                    c++;
                }
            }
        }
        if(sum==0 && cnt==0){
            System.out.println("No song found!!");
        }
        else{
            int avg = sum/cnt;
            System.out.println(avg);
        }
    }

    public static void findmusicAppOfSongsBySongName(List<MusicApp> l1, String name){
        List<String> ans=new ArrayList<>();
        for(MusicApp m: l1){
            for(Song s: m.song){
                if(s.getSongName().equalsIgnoreCase(name)){
                    ans.add(m.getAppName());
                }
            }
        }

        if(ans.size()==0){
            System.out.println("No matching musicApp Found!");
        }

        for(String s: ans){
            System.out.println(s);
        }
    }
}

class Song{
    int songId;
    String songName;
    String singerNamer;
    int songViews;
    
    public Song(int songId, String songName, String singerNamer, int songViews) {
        this.songId = songId;
        this.songName = songName;
        this.singerNamer = singerNamer;
        this.songViews = songViews;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingerNamer() {
        return singerNamer;
    }

    public void setSingerNamer(String singerNamer) {
        this.singerNamer = singerNamer;
    }

    public int getSongViews() {
        return songViews;
    }

    public void setSongViews(int songViews) {
        this.songViews = songViews;
    }

    
}

class MusicApp{
    int appId;
    String appName;
    int appSub;
    List<Song> song;
    public MusicApp(int appId, String appName, int appSub, List<Song> song) {
        this.appId = appId;
        this.appName = appName;
        this.appSub = appSub;
        this.song = song;
    }
    public int getAppId() {
        return appId;
    }
    public void setAppId(int appId) {
        this.appId = appId;
    }
    public String getAppName() {
        return appName;
    }
    public void setAppName(String appName) {
        this.appName = appName;
    }
    public int getAppSub() {
        return appSub;
    }
    public void setAppSub(int appSub) {
        this.appSub = appSub;
    }
    public List<Song> getSong() {
        return song;
    }
    public void setSong(List<Song> song) {
        this.song = song;
    }

    
}

class ViewisNegative extends Exception {
    public ViewisNegative(String s){
        super(s);
    }
}

/*
I/P:
3
1234
wynk
500
3
988
kingshit
shubh
70000
653
apnabanalepiya
arjit
90000
345
aabadbarbadd
arjit
55000
1235
spotify
350
3
988
kingshit
shubh
9000
653
saware
arjit
100000
345
tumhare hi rahenge hum
varun
120000
1236
jiiosaavn
450
3
980
numb
linkanpark
9000
653
jotunamila
asimazhar
100000
345
humraah
asimazhar
120000

*/
