import java.util.Scanner;

public class solution6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        TravelAgencies[] arr = new TravelAgencies[n];
        
        for(int i=0;i<n;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            boolean e = sc.nextBoolean();

            arr[i] = new TravelAgencies(a, b, c, d, e);
        }

        int no = sc.nextInt(); sc.nextLine();
        String type = sc.nextLine();

        System.out.println(findAgencyWithHighestPackagePrice(arr));

        TravelAgencies res = agencyDetailsForGivenIdAndType(arr, no, type);
        System.out.println(res.getAgencyName()+":"+res.getPrice());
    }

    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] arr){
        int maxi=Integer.MIN_VALUE;
        for(TravelAgencies t: arr){
            if(t.getPrice() > maxi){
                maxi = t.getPrice();
            }
        }
        return maxi;
    }

    public static TravelAgencies agencyDetailsForGivenIdAndType(TravelAgencies[] arr, int no, String type){
        TravelAgencies ans=null;
        for(TravelAgencies t: arr){
            if(t.isFlightFacility() && t.getRegNo()==no && t.getPackageType().equalsIgnoreCase(type)){
                ans=t;
            }
        }
        return ans;
    }
}

class TravelAgencies{
    int regNo;
    String agencyName;
    String packageType;
    int price;
    boolean flightFacility;
    
    public TravelAgencies(int regNo, String agencyName, String packageType, int price, boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isFlightFacility() {
        return flightFacility;
    }

    public void setFlightFacility(boolean flightFacility) {
        this.flightFacility = flightFacility;
    }

    
}

/*
I/P:
4
123
a2z agency
platinum
50000
true
345
sss agency
gold
30000
false
987
cox and kings
diamond
40000
true
888
global tours
silver
20000
false

O/P:
50000
cox and kings:40000
*/
