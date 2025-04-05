import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class solution2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Brand[] arr = new Brand[n];

        for(int i=0;i<n;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();

            int size = sc.nextInt();

            Mobile[] mobb = new Mobile[size];
            for(int j=0;j<size;j++){
                int aa = sc.nextInt(); sc.nextLine();
                String bb = sc.nextLine();
                double cc = sc.nextDouble();
                int dd = sc.nextInt();

                mobb[j] = new Mobile(aa, bb, cc, dd);
            }

            arr[i] = new Brand(a, b, mobb);
        }


        int mini = sc.nextInt();
        int maxi = sc.nextInt();


        LinkedHashMap<String,Double> ans = calculateAveragePrice(arr);

        //This is Alt. Method for isNaN() case.
        // Double val = ans.values().iterator().next();
        // if(val.isNaN()){
        //     System.out.println("Average cannot be calculated!");
        // }
        if(ans.size()==0){
            System.out.println("Not Found!");
        }
        else{
            System.out.println("Average Price of each brand: ");
            for(Map.Entry<String,Double> it: ans.entrySet()){
                System.out.println(it.getKey() + ": " + it.getValue());
            }
        }

        
        
        List<String> res = findMobilesInStorageRange(arr, mini, maxi);

        for(String i: res){
            System.out.println(i+" ");
        }
        
    }

    public static LinkedHashMap<String,Double> calculateAveragePrice(Brand[] arr){
        LinkedHashMap<String,Double> mpp = new LinkedHashMap<>();
        
        for(int i=0;i<arr.length;i++){
            String bName = arr[i].getBrandName();
            int sum=0;
            int size = arr[i].mob.length;

            //"Not-a-Number" (NaN) means 0.0/0.0, isNaN() method is used with Double and Float wrapper classes.
            if(size==0){ //For dealing with isNaN() case
                return new LinkedHashMap<>();
            }
            for(int j=0;j<size;j++){
                sum+=arr[i].mob[j].getPrice();
            }
            double avg = (double)sum/size;
            mpp.put(bName, avg);
        }
        
        return mpp;
    }

    public static List<String> findMobilesInStorageRange(Brand[] arr, int mini, int maxi){
        List<String> ans = new ArrayList<>(); //List – Interface, ArrayList – Concrete Class

        for(int i=0;i<arr.length;i++){
            int size = arr[i].mob.length;
            for(int j=0;j<size;j++){
                int st = arr[i].mob[j].getStorageCapacity();
                if(st>=mini && st<=maxi){
                    ans.add("Brand: " +arr[i].getBrandName()+arr[i].getMob()[j]);
                }
            }
        }

        return ans;
    }
}

class Brand{
    int brandId;
    String brandName;
    Mobile[] mob;
    
    public Brand(int brandId, String brandName, Mobile[] mob) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.mob = mob;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Mobile[] getMob() {
        return mob;
    }

    public void setMob(Mobile[] mob) {
        this.mob = mob;
    }

}

class Mobile{
    int modelNumber;
    String modelName;
    double price;
    int storageCapacity;
    
    public Mobile(int modelNumber, String modelName, double price, int storageCapacity) {
        this.modelNumber = modelNumber;
        this.modelName = modelName;
        this.price = price;
        this.storageCapacity = storageCapacity;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String toString() {
        return ", Model Number: " + getModelNumber() + ", Model Name: " + getModelName() + ", Price: " + getPrice() + ", Storage: " + getStorageCapacity();
    }

}


/*
I/P:
2
101
Samsung
2
1001
Galaxy S21
20300
128
1002
Galaxy Note 20
34000
256
102
Apple
2
2001
Iphone 13
60000
256
2002
Iphone 14
70400
64
128
256

O/P:
Average Price of each brand:
Samsung: 27150.0
Apple: 65200.0
Brand: Samsung, Model Number: 1001, Model Name: Galaxy S21, Price: 20300.0, Storage: 128 
Brand: Samsung, Model Number: 1002, Model Name: Galaxy Note 20, Price: 34000.0, Storage: 256
Brand: Apple, Model Number: 2001, Model Name: Iphone 13, Price: 60000.0, Storage: 256
*/