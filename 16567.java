import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N + 3];
		int dir = 0;
		
		for(int i = 1; i <= N; i++){
			arr[i] = sc.nextInt();
			if(arr[i] == 1)
			{
				if(arr[i-1] != 0 || arr[i+1] != 0) continue;
				else ++dir;
			}
		}
		
		while(--M >= 0)
		{
			int num = sc.nextInt();
			if(num == 0) System.out.println(dir);
			else{
				int idx = sc.nextInt();
				if(arr[idx] == 1) continue;
				
				arr[idx] = 1;
				
				int cnt = 0;
				if(arr[idx-1] != 0) ++cnt;
				if(arr[idx+1] != 0) ++cnt;
				
				if(cnt == 2) --dir;
				else if(cnt == 1) continue;
				else ++dir;
			}
		}
	}
}