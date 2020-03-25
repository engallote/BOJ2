import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N + 1], res = new int[M];
		int min = 0;
		boolean flag = false;
		
		for(int i = 0; i < M; i++){
			int num = sc.nextInt();
			min = Integer.MAX_VALUE;
			flag = false;
			for(int j = 1; j <= N; j++)
				min = Math.min(arr[j], min);
			
			for(int j = 1; j <= N; j++){
				arr[j] -= min;
				if(arr[j] == 0 && !flag){
					arr[j] = num;
					res[i] = j;
					flag = true;
				}
			}
		}
		
		for(int i = 0; i < M; i++)
			System.out.print(res[i] + " "); 
	}
}