import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt(); 
		long[] dist = new long[M + 2], time = new long[M + 2], min = new long[M + 2], cnt = new long[M + 2];
		String[] path = new String[M + 2];
		
		for(int i = 0; i <= M + 1; i++) {
			path[i] = "";
			if(i == 0) continue;
			int num = sc.nextInt();
			dist[i] = num + dist[i-1];
			min[i] = Long.MAX_VALUE;
		}
		
		for(int i = 1; i <= M; i++)
			time[i] = sc.nextInt();
		
		for(int i = 1; i <= M + 1; i++)
			for(int j = i - 1; j >= 0; j--)
				if(dist[i] - dist[j] <= N && min[i] > min[j] + time[i]) {
					min[i] = min[j] + time[i];
					cnt[i] = cnt[j] + 1;
					path[i] = path[j] + " " + i; 
				}
		String[] str = path[M + 1].trim().split(" ");
		System.out.println(min[M + 1]);
		System.out.println(cnt[M + 1] - 1);
		
		for(int i = 0; i < str.length - 1; i++)
			System.out.print(str[i] + " ");
	}
}