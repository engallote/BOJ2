import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N+1];
		int[][] num = new int[N+1][26];
		int P = sc.nextInt();
		int min = 0, idx = 0, pass = 0;
		for(int i = 0; i < P; i++)
		{
			String name = sc.next();
			int dd = name.charAt(0)-'a';
			pass = min = Integer.MAX_VALUE;
			for(int j = 1; j <= N; j++)
			{
				if(arr[j] == K) continue;
				if(min > num[j][dd])
				{
					pass = arr[j];
					min = num[j][dd];
					idx = j;
				}
				else if(min == num[j][dd])
				{
					if(pass > arr[j])
					{
						pass = arr[j];
						idx = j;
					}
				}
			}
			arr[idx] += 1;
			num[idx][dd] += 1;
		}
		
		for(int i = 1; i <= N; i++)
			System.out.print(arr[i] + " ");
	}
}