import Orm.Orm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Scanner.*;
public class seller {
    public int id_no;
    public String name;
    public long phone_no;
    public String Address;

    seller(int i,String n,long p,String ap){
        this.id_no = i;
        this.name = n;
        this.phone_no = p;
        this.Address = ap;
    }

    public static void main(String[] args) throws IOException {
        Orm.Stringify(seller.class, "id_no");
        Scanner sc=new Scanner(System.in);
        System.out.println("Press 1 to enter details and 2 to print report.");
        int q=sc.nextInt();
        if(q==1){
        System.out.println("How many details u want to enter ");
        int z=sc.nextInt();
        for(int i=0;i<z;i++){
        System.out.println("enter id: ");
        int id=sc.nextInt();
        System.out.println("enter name: ");
        String name=sc.next();
        System.out.println("enter mobile number: ");
        long mno=sc.nextLong();
        System.out.println("enter address: ");
        var address=sc.next();
        seller arman = new seller(id, name,mno, address);
        Orm.O_inserter(arman);}
        System.out.println("Details updated successfully.");}
        else if(q==2){
            BufferedReader br = new BufferedReader(new FileReader("seller.Petrol"));
            String line;
            while ((line = br.readLine()) != null) {
              System.out.println(line);
            }

        }
        else{
            System.out.println("Please check your number!!");
        }
    }
}