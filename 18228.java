import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int idx = -1, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.nextInt();
			if(arr[i] == -1) idx = i;
			else if(idx == -1) min1 = Math.min(min1, arr[i]);
			else if(idx != -1) min2 = Math.min(min2, arr[i]);
		}
		
		System.out.println(min1+min2);
	}
}