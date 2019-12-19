import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int A = sc.nextInt();
		int[][] arr = new int[N][2], arr2 = new int[N][2];
		int[] coke = new int[N];
		Arrays.fill(coke, K);
		for(int i = 0; i < N; i++)
		{
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		boolean flag = false;
		int time = 0;
		while(true)
		{
			++time;
			for(int i = 0; i < N; i++)
			{
				if(arr2[i][0] < arr[i][0])
				{
					arr2[i][0] += 1;
					coke[i] -= A;
					if(coke[i] <= 0)
					{
						flag = true;
						break;
					}
				}
				else 
				{
					arr2[i][1] += 1;
					if(arr2[i][1] >= arr[i][1]) arr2[i][0] = arr2[i][1] = 0;
				}
			}
			if(flag) break;
		}
		System.out.println(time);
	}
}