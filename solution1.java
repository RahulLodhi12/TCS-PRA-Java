import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class solution1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Customer[] arr = new Customer[n];
        
        for(int i=0;i<n;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            char d = sc.next().charAt(0);
            
            int size = sc.nextInt();
            sc.nextLine();
            Account[] acc = new Account[size];
            for(int j=0;j<size;j++){
                int aa = sc.nextInt(); sc.nextLine();
                String cc = sc.nextLine(); 
                double dd = sc.nextDouble();
                
                acc[j] = new Account(aa, cc, dd);
            }
            sc.nextLine();
            arr[i] = new Customer(a, b, c, d, acc);
        }
        
        int id = sc.nextInt();

        Customer res = findAccountDetails(arr, id);
        if(res==null){
            System.out.println("No account found.");
        }
        else{
            System.out.println("Customer ID: " + res.getCustomerId());
            System.out.println("Customer Name: " + res.getName());
            System.out.println("Age: " + res.getAge());
            System.out.println("Account Details:");
            for(int i=0;i<res.account.length;i++){
                System.out.println(res.account[i].getAccountType() + " - " + res.account[i].getAccountNo());
                
            }
        }
        
    }
    
    public static Customer findAccountDetails(Customer[] arr, int id){
        for(int i=0;i<arr.length;i++){
            if(arr[i].getCustomerId()==id){
                return arr[i];
            }
        }
        return null;
    }
}

class Customer{
    int customerId;
    String name;
    int age;
    char gender;
    Account[] account;
    
    public Customer(int customerId, String name, int age, char gender, Account[] account){
        this.customerId = customerId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.account = account;
    }
    
    public Account[] getAccount() {
        return account;
    }
    
    public int getAge() {
        return age;
    }
    
    public int getCustomerId() {
        return customerId;
    }
    
    public char getGender() {
        return gender;
    }
    
    public String getName() {
        return name;
    }
    
    public void setAccount(Account[] account) {
        this.account = account;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public void setGender(char gender) {
        this.gender = gender;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}

class Account{
    int accountNo;
    String accountType;
    double balance;
    
    public Account(int accountNo, String accountType, double balance){
        this.accountNo = accountNo;
        this.accountType = accountType;
        this.balance = balance;
    }
    
    public int getAccountNo() {
        return accountNo;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public double getBalance() {
        return balance;
    }
    
    
    
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}