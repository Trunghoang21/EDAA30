package lab6.bin;

public class test {
    public static void mystery(int n) {
        if (n > 0){
           mystery(n-1);
           System.out.print(n * 4);
           mystery(n-1);
        } 
     }
  
     public static void main(String[] args) {
        // test.mystery(3);
        System.out.println(4371%10);

     } 
  }

