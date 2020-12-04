import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] arr = new double[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextDouble();
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N - 1; i++)
			arr[N - 1] += arr[i] / 2;
		
		System.out.println(arr[N - 1]);
	}
}