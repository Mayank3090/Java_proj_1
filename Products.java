import Orm.Orm;
import Petrol_engine.Petrol;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import DB_beta.maindb;

public class Products {
    public int sail_id;
    public long payment;
    public String Order_sent;
    public String recieved;
    public String Product;

    Products(int id,long pm,String ords,String rec,String prod){
        this.sail_id = id;
        this.Order_sent = ords;
        this.Product = prod;
        this.payment = pm;
        this.recieved = rec;
    }
    
    public static void total_detail(String dat_name){
        maindb writer = new maindb();
        try {
            writer.printer(dat_name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void total_seller(String sel_path){
        maindb writer = new maindb();
        try {
            writer.printer(sel_path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pretty_print(ArrayList<ArrayList<ArrayList<String>>> p1,ArrayList<String> n){
        for (int i = 0; i < p1.size(); i++) {  //0(n^2)
           for (int j = 0; j < p1.get(i).size(); j++) {
                // System.out.printf("%15s",);
                System.out.printf("%15s",p1.get(i).get(j).get(0));
           }
           System.out.print(" ");
        }
    }

    public static void merge_detail(Class c1,Class c2,int id_no,String[] arrc1,String []brrc2){
        String p2 = c1.toString().split(" ")[1];
        String p1 = c2.toString().split(" ")[1]; 
        StringBuilder newp1 = new StringBuilder(p1);
        StringBuilder newp2 = new StringBuilder(p2);

        newp1.append(".Petrol");
        newp2.append(".Petrol");
        
        ArrayList<ArrayList<ArrayList<String>>> p = new ArrayList<ArrayList<ArrayList<String>>>();
        
        Petrol pet = new Petrol(new String(newp1));
        ArrayList<ArrayList<String>> __db_nb_sec = new ArrayList<ArrayList<String>>();
        
        for (int i = 0; i < arrc1.length; i++) {
            __db_nb_sec.add(pet.query_one("id_no",Integer.toString(id_no) ,arrc1[i]));
        }

        p.add(__db_nb_sec);
        pet = new Petrol(new String(newp2));
        
        ArrayList<ArrayList<String>> db_sec = new ArrayList<ArrayList<String>>();
        
        for (int i = 0; i < brrc2.length; i++) {
            db_sec.add(pet.query_one("sail_id",Integer.toString(id_no) ,brrc2[i]));
        }
        p.add(db_sec);
        ArrayList<String> n = new ArrayList<>();
        
        for (int i = 0; i < arrc1.length; i++) {
            n.add(arrc1[i]);
        }

        for (int i = 0; i < brrc2.length; i++) {
            n.add(brrc2[i]);
        }
        for (int i = 0; i < n.size(); i++) {
            System.out.printf("%15s",n.get(i));
        }
        System.out.println();
        pretty_print(p,n);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        Orm.Stringify(Products.class, "sail_id");
        System.out.println("Press 1 to enter details , 2 to print details of product and 3 to print series of report.");
        int n=sc.nextInt();
        if(n==1){
            System.out.println("enter id:");
            int id=sc.nextInt();
            System.out.println("enter payment done:");
            int pm=sc.nextInt();
            System.out.println("enter date of order sent:");
            String ords=sc.next();
            System.out.println("enter date of order received:");
            String rec=sc.next();
            System.out.println("enter product name:");
            String produ=sc.next();

        
        Products prod = new Products(id, pm,ords,rec, produ);
        Orm.O_inserter(prod);
    System.out.println("Details entered successfully");}
        else if(n==2){

        System.out.println("enter id no:");
        int no=sc.nextInt();
        merge_detail(Products.class, seller.class,no,new String[]{"name","Address","phone_no"},new String[]{"Product","payment","Order_sent"});
        }
        else if(n==3){
            BufferedReader br = new BufferedReader(new FileReader("Products.Petrol"));
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