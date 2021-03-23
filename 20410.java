import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int seed = sc.nextInt();
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();

        loop:for(int i = 0; i < m; i++)
        	for(int j = 0; j < m; j++)
        		if((i * seed + j) % m == x1 && (i * x1 + j) % m == x2) {
        			System.out.println(i + " " + j);
        			break loop;
        		}
        	
    }
}