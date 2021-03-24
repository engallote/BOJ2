import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for(int i = 0; i < N; i++) {
        	int dec = Integer.parseInt(sc.next(), 16);
        	if(dec >= 64 && dec <= 95) System.out.print("-");
        	else System.out.print(".");
        }
    }
}