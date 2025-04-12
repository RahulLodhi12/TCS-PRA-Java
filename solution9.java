import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class solution9{
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Patients> p = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            
            p.add(new Patients(a,b,c));
        }
        
        int m = sc.nextInt();
        ArrayList<Hospital> h = new ArrayList<>(m);
        for(int i=0;i<m;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            
            h.add(new Hospital(a,b,c));
        }
        
        // System.out.println("okk");
        
        int id = sc.nextInt();
        Map<Integer,List<Patients>> ans = getPatientsByHospital(h, p, id);
        if(ans.size()==0){
            System.out.println("Hospital with ID: "+id+" does not exist.");
        }
        else{
            System.out.println("Hospital ID: "+id);
            for(Map.Entry<Integer,List<Patients>> it: ans.entrySet()){
                int idd = it.getKey();
                for(Patients pp: it.getValue()){
                    System.out.println("Patient: "+pp.getPname());
                }
            }
        }

        int nn = sc.nextInt();
        List<Hospital> res = getHospitalWithMoreThanNPatients(h, p, nn);
        if(res.size()==0){
            System.out.println("No hospitals found with more than "+nn+" patients.");
        }
        else{
            System.out.println("Hospital with more than "+nn+" patients:");
            for(Hospital hh: res){
                System.out.println(hh.getHname());
            }
        }
    }
    
    public static Map<Integer,List<Patients>> getPatientsByHospital(ArrayList<Hospital> h, ArrayList<Patients> p, int id){
        Map<Integer, List<Patients>> mpp = new HashMap<>();
        
        for(Hospital a: h){
            if(a.getHid() == id){
                List<Patients> res = new ArrayList<>();
                for(Patients b: p){
                    if(b.getHpid()==a.getHid()){
                        res.add(b);
                    }
                }
                mpp.put(id, res);
            }
        }
        return mpp;
    }
    
    public static List<Hospital> getHospitalWithMoreThanNPatients(ArrayList<Hospital> h, ArrayList<Patients> p, int nn){
        List<Hospital> ans = new ArrayList<>();
        
        for(Hospital a: h){
            int cnt=0;
            int id = a.getHid();
            for(Patients b: p){
                if(b.getHpid()==id){
                    cnt++;
                }
            }
            if(cnt>nn){
                ans.add(a);
            }
        }
        
        return ans;

    }
    
}

class Hospital{
    int hid;
    String hname;
    String hloc;
    
    public Hospital(int hid, String hname, String hloc){
        this.hid = hid;
        this.hname = hname;
        this.hloc = hloc;
    }
    
    public int getHid() {
        return hid;
    }
    
    public String getHloc() {
        return hloc;
    }
    
    public String getHname() {
        return hname;
    }
    
    public void setHid(int hid) {
        this.hid = hid;
    }
    
    public void setHloc(String hloc) {
        this.hloc = hloc;
    }
    
    public void setHname(String hname) {
        this.hname = hname;
    }
}

class Patients{
    int pid;
    String pname;
    int hpid;
    
    public Patients(int pid, String pname, int hpid){
        this.pid = pid;
        this.pname = pname;
        this.hpid = hpid;
    }
    
    public int getHpid() {
        return hpid;
    }
    
    public int getPid() {
        return pid;
    }
    
    public String getPname() {
        return pname;
    }
    
    public void setHpid(int hpid) {
        this.hpid = hpid;
    }
    
    public void setPid(int pid) {
        this.pid = pid;
    }
    
    public void setPname(String pname) {
        this.pname = pname;
    }
}