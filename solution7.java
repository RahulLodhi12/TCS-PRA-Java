import java.util.Scanner;

public class solution7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        fruits[] arr = new fruits[n];

        for(int i=0;i<n;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();

            arr[i] = new fruits(a, b, c, d);
        }

        int rat = sc.nextInt();

        fruits res = maximumPriceObject(arr,rat);
        System.out.println(res.getFruitId());
    }

    public static fruits maximumPriceObject(fruits[] arr, int rat){
        int maxi = Integer.MIN_VALUE;
        for(fruits f: arr){
            if(f.getRating() > rat){
                return f;
            }
        }
        return null;
    }
}

class fruits{
    int fruitId;
    String fruitName;
    int price;
    int rating;
    
    public fruits(int fruitId, String fruitName, int price, int rating) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.rating = rating;
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    
}

/*
I/P:
4
101
apple
50
4
102
mango
100
5
103
orange
40
4
104
grapes
80
5
*/
