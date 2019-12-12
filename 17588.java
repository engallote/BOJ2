import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[201];
		int max = 0;
		for(int i = 0; i < N; i++)
		{
			int num = sc.nextInt();
			arr[num] = 1;
			max = Math.max(max, num);
		}
		
		boolean flag = true;
		for(int i = 1; i <= max; i++)
			if(arr[i] == 0)
			{
				flag = false;
				System.out.println(i);
			}
		
		if(flag) System.out.println("good job");
	}
}