import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        long[] arr = new long[B + 1];
        
        for(int i = 1; i <= B; i++)
        	for(int j = i + i; j <= B; j+=i)
        		arr[j] += i;
        
        long res = 0;
        for(int i = A; i <= B; i++)
        	res += Math.abs(i - arr[i]);
        
        System.out.println(res);
	}
}