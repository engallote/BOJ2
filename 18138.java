import java.util.*;

public class Main {
	static int N, M;
	static int[] shirt, kara, chk;
	static boolean[] visit;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        shirt = new int[N];
        kara = new int[M];
        chk = new int[M];
        visit = new boolean[N];
        
        for(int i = 0; i < N; i++) shirt[i] = sc.nextInt();
        for(int i = 0; i < M; i++){
        	kara[i] = sc.nextInt();
        	chk[i] = -1;
        }
        
        int res = 0;
        for(int i = 0; i < N; i++){
        	Arrays.fill(visit, false);
        	if(find(i)) ++res;
        }
        
        System.out.println(res);
    }
	private static boolean find(int idx) {
		if(visit[idx]) return false;
		visit[idx] = true;
		
		for(int i = 0; i < M; i++){
			double l = shirt[idx] / 2.0, r = shirt[idx] * 3.0 / 4.0;
			if((kara[i] >= l && kara[i] <= r) && (chk[i] == -1 || find(chk[i]))){
				chk[i] = idx;
				return true;
			}
			l = shirt[idx];
			r = shirt[idx] * 5.0 / 4.0;
			if((kara[i] >= l && kara[i] <= r) && (chk[i] == -1 || find(chk[i]))){
				chk[i] = idx;
				return true;
			}
		}
		
		return false;
	}
}