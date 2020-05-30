import java.util.*;

public class Main {
	static int N, res = 0;
	static int[][] arr, sum;
	static ArrayList<Integer> a, b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		sum = new int[N][N];//각 열의 합
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
			
		for(int i = N - 1; i >= 0; i--)
			for(int j = 0; j < N; j++){
				if(i < N - 1) sum[i][j] = sum[i+1][j];
				sum[i][j] += arr[i][j];
			}
		
		
		a = new ArrayList<>();
		b = new ArrayList<>();
		
		for(int i = 0; i < N - 1; i++)
			for(int j = 0; j < N - 1; j++){
				a.clear();
				b.clear();
				
				leftUp(i, j);
				rightDown(i + 1, j + 1);
				
				for(int k : a)
					for(int l : b)
						if(k == l) ++res;
				
				a.clear();
				b.clear();
				
				rightUp(i, j + 1);
				leftDown(i + 1, j);
				
				for(int k : a)
					for(int l : b)
						if(k == l) ++res;
			}
		
		
		System.out.println(res);
	}
	private static void leftUp(int x, int y) {
		int tmp = 0;
		for(int i = x; i >= 0; i--){
			tmp = 0;
			for(int j = y; j >= 0; j--){
				tmp += sum[i][j] - sum[x+1][j];
				a.add(tmp);
			}
		}
	}
	private static void leftDown(int x, int y) {
		int tmp = 0;
		for(int i = x; i < N; i++){
			tmp = 0;
			for(int j = y; j >= 0; j--){
				tmp += sum[x][j] - (i != N - 1 ? sum[i+1][j] : 0);
				a.add(tmp);
			}
		}
	}
	private static void rightUp(int x, int y) {
		int tmp = 0;
		for(int i = x; i >= 0; i--){
			tmp = 0;
			for(int j = y; j < N; j++){
				tmp += sum[i][j] - sum[x+1][j];
				b.add(tmp);
			}
		}
	}
	private static void rightDown(int x, int y) {
		int tmp = 0;
		for(int i = x; i < N; i++){
			tmp = 0;
			for(int j = y; j < N; j++){
				tmp += sum[x][j] - (i != N - 1 ? sum[i+1][j] : 0);
				b.add(tmp);
			}
		}
	}
}