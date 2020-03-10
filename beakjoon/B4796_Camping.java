package beakjoon;
 
import java.util.Scanner;
 
public class B4796_Camping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while(true) {
            int l = sc.nextInt(); 
            int p = sc.nextInt(); 
            int v = sc.nextInt(); 
            if(l==0) break;
            int result = 0;
            for(int i=0;i<v;) {
                result += l;
                i += l;
                if(i>=v) result -= i-v;
                i+=p-l;
            }
            System.out.println("Case "+tc+": "+result);
            tc++;
        }
    }
}
 
