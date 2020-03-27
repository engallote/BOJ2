import java.util.*;

public class Main {
	static int res;
	static boolean[] chk = new boolean[10001];
	static ArrayList<Pair>[] arr = new ArrayList[10001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i <= 10000; i++)
			arr[i] = new ArrayList<>();
		
		while(sc.hasNext()){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		res = 0;
		
		for(int i = 1; i <= 10000; i++){
			chk[i] = true;
			find(i, 0);
			chk[i] = false;
		}
		
		System.out.println(res);
	}
	private static void find(int idx, int sum) {
		res = Math.max(res, sum);
		
		for(Pair p : arr[idx])
			if(!chk[p.v]){
				chk[p.v] = true;
				find(p.v, sum + p.c);
				chk[p.v] = false;
			}
	}
}
class Pair{
	int v, c;
	Pair(int v, int c){
		this.v = v;
		this.c = c;
	}
}