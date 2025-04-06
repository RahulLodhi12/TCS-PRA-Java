import java.util.ArrayList;
import java.util.Scanner;

public class solution4 {
    public static void main(String[] args) throws PriceCannotBeNegativeException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Manufacturer> l1 = new ArrayList<>(n);

        for(int i=0;i<n;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();

            ArrayList<Car> l2 = new ArrayList<>(c);

            for(int j=0;j<c;j++){
                int aa = sc.nextInt(); sc.nextLine();
                String bb = sc.nextLine();
                double cc = sc.nextDouble();
                double dd = sc.nextDouble();

                l2.add(new Car(aa, bb, cc, dd));
            }
            l1.add(new Manufacturer(a, b, c, l2));
        }
        sc.nextLine();

        String name = sc.nextLine();

        AveragePriceByManufacturerName(l1, name);
        findCarWithMaximumMileage(l1);
    }

    public static void AveragePriceByManufacturerName(ArrayList<Manufacturer> l1, String name) throws PriceCannotBeNegativeException{
        int count=0;
        double sum=0;
        int cnt=0;
        for(Manufacturer m: l1){
            if(m.getManufacturerName().equals(name)){
                for(Car c: m.cars){
                    if(c.getPrice()<0){
                        throw new PriceCannotBeNegativeException("Invalid Price: car price cannot be negative.");
                    }
                    sum+=c.getPrice();
                    cnt++;
                }
            }
            else{
                count++;
            }
        }
        if(count==l1.size() || (sum==0 && cnt==0)){
            System.out.println("No cars produced by the given manufacturer");
            return;
        }
        double avg = sum/cnt;
        System.out.println("Average price of cars produced by "+name+" is: "+avg);
    }

    public static void findCarWithMaximumMileage(ArrayList<Manufacturer> l1){
        double maxi=Double.MIN_VALUE;
        String ans="";

        for(Manufacturer m: l1){
            for(Car c: m.cars){
                if(c.getMileage() > maxi){
                    maxi = c.getMileage();
                    ans = c.getName();
                }
            }
        }

        System.out.println("Name - " + ans);
        System.out.println("Mileage - " + maxi);
    }
}

class Car{
    int cardId;
    String name;
    double mileage;
    double price;
    
    public Car(int cardId, String name, double mileage, double price) {
        this.cardId = cardId;
        this.name = name;
        this.mileage = mileage;
        this.price = price;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
}

class Manufacturer{
    int manufacturerId;
    String manufacturerName;
    int noOfCars;
    ArrayList<Car> cars;
    
    public Manufacturer(int manufacturerId, String manufacturerName, int noOfCars, ArrayList<Car> cars) {
        this.manufacturerId = manufacturerId;
        this.manufacturerName = manufacturerName;
        this.noOfCars = noOfCars;
        this.cars = cars;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getNoOfCars() {
        return noOfCars;
    }

    public void setNoOfCars(int noOfCars) {
        this.noOfCars = noOfCars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

}

class PriceCannotBeNegativeException extends Exception {
    public PriceCannotBeNegativeException(String message) {
        super(message);
    }
}

/*
I/P:
2
101
tata
3
1001
nexon
17.8
1300000
1002
punch
18
800000
1003
curvv
20
1500000
102
mahindra
2
201
xuv700
14
1400000
202
scorpio
15
1350000
tata
*/