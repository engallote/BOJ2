import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	String str = sc.next();
    	
    	System.out.println(str.substring(N - 5));
	}
}