import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	
    	int div1 = N / 2, div2 = M / 2;
    	
    	System.out.println(Math.min(div1, div2));
    }
}