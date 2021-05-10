import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       
       //a -> 0, b -> 1と各アルファベットに対応した番号を割り当てる。
       int[] count = new int[26];
       
       while(sc.hasNext()){
           String line = sc.nextLine().toLowerCase();
           
           for(int i =0 ;i < line.length();i++){
               char ch = line.charAt(i);
               //アルファベットの'a'~'z'は連続したアスキーコードが割り当てられるので'a'を引くと対応した値が割り出せる。
               if('a' <= ch && ch <= 'z'){
                   count[line.charAt(i) - 'a']++;
               }
           }
           
           
           
       }
       
       for(int i = 0;i < count.length;i++){
               System.out.println((char)('a' + i) + " : " + count[i]);
           }
       
       sc.close();
    }
}
