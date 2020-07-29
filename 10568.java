import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		HashMap<String, Integer> hs = new HashMap<>();
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			String[] name = new String[N];
			int[][] arr = new int[N][3];
			double[][] chk = new double[N][N];
			
			for(int i = 0; i < N; i++){
				String str = sc.next();
				
				hs.put(str, i);
				name[i] = str;
				
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
				arr[i][2] = sc.nextInt();
			}
			
			for(int i = 0; i < N; i++)
				for(int j = i + 1; j < N; j++)
					chk[i][j] = chk[j][i] = find(arr[i][0], arr[i][1], arr[i][2], arr[j][0], arr[j][1], arr[j][2]);
			
			int M = sc.nextInt();
			for(int i = 0; i < M; i++){
				String a = sc.next();
				String b = sc.next();
				chk[hs.get(a)][hs.get(b)] = 0;
			}
			
			for(int k = 0; k < N; k++)
				for(int i = 0; i < N; i++)
					for(int j = 0; j < N; j++)
						if(chk[i][k] + chk[k][j] < chk[i][j])
							chk[i][j] = chk[i][k] + chk[k][j];
			
			System.out.println("Case " + test_case + ":");
			int K = sc.nextInt();
			while(--K >= 0){
				int a = hs.get(sc.next());
				int b = hs.get(sc.next());
				
				System.out.println("The distance from " + name[a] + " to " + name[b] + " is " + Math.round(chk[a][b]) + " parsecs.");
			}
		}
	}

	private static double find(int x, int y, int z, int x2, int y2, int z2) {
		return Math.sqrt(Math.pow(x - x2, 2) + Math.pow(y - y2, 2) + Math.pow(z - z2, 2));
	}
}