/*
Amicable numbers are two different numbers where each number is the sum of the proper divisors of the other.

🔍 Definitions:
Proper divisors of a number are all positive divisors of that number excluding the number itself.

✅ Example:
220 and 284 are the smallest pair of amicable numbers.

Let’s break it down:

➤ Proper divisors of 220:
1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110
Sum = 1 + 2 + 4 + 5 + 10 + 11 + 20 + 22 + 44 + 55 + 110 = 284

➤ Proper divisors of 284:
1, 2, 4, 71, 142
Sum = 1 + 2 + 4 + 71 + 142 = 220

✔️ So, 220 and 284 are amicable numbers.
*/

import java.util.Scanner;

public class Check_Amicable_Numbers {

    public static int sumOfDivisors(int n){
        int sum=0;
        for(int i=1;i<=n/2;i++){
            if(n%i==0){
                sum+=i;
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(sumOfDivisors(a)==b && sumOfDivisors(b)==a){
            System.out.println("The pair is amicable");
        }
        else{
            System.out.println("The pair is not amicable");
        }
    }


}
