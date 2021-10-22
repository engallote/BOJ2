import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int L = sc.nextInt();
    	int sum = 0;
    	
    	for(int i = 0; i < N; i++) sum += sc.nextInt(); 
    	
    	if(sum == M) System.out.println(0);
    	else if(L > M || sum > M || (sum < L && sum + L > M)) System.out.println(-1);
    	else System.out.println(1);
	}
}