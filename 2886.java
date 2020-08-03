import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static ArrayList<Pair> x = new ArrayList<>(), l = new ArrayList<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        
        for(int i = 0; i < N; i++){
        	arr[i] = sc.next().toCharArray();
        	for(int j = 0; j < M; j++){
        		if(arr[i][j] == 'X') x.add(new Pair(i, j));
        		else if(arr[i][j] == 'L') l.add(new Pair(i, j));
        	}
        }
        
        find();
    }
	private static void find() {
		int res = 0;
		boolean[] v = new boolean[x.size()];
		HashSet<Integer> hs = new HashSet<>();
		double[] dist = new double[x.size()];
		int[] chk = new int[x.size()];
		int p, cnt, idx;
		boolean flag = true;
		
		while(flag){
			flag = false;
			cnt = 0;
			idx = 0;
			p = -1;
			
			for(int j = 0; j < x.size(); j++){
				if(v[j]) continue;//자리에 앉거나 전쟁 중인 사람들 패스
				dist[j] = 1000000000;
				idx = -1;
				
				for(int k = 0; k < l.size(); k++){
					if(hs.contains(k)) continue;//누군가 앉은 자리 패스
					double d = findDist(x.get(j), l.get(k));
					if(idx == -1 || dist[j] > d){
						dist[j] = d;
						idx = k;
					}
				}
				
				if(idx == -1) break;
				
				flag = true;
				chk[j] = idx;
				
				//X와 가장 가까운 자리 찾기
				if(p == -1 || findDist(x.get(j), l.get(idx)) < findDist(x.get(p), l.get(chk[p])))
					p = j;
			}
			
			if(!flag) break;
			
			//현재 자리와의 거리가 최소값인 사람 찾기
			for(int j = 0; j < x.size(); j++){
				if(v[j]) continue;//이미 자리에 앉았거나 전쟁 중인 사람들 패스
				
				//가장 가까운 자리가 같고 거리도 같은 경우
				if(chk[j] == chk[p] && findDist(x.get(j), l.get(chk[p])) == findDist(x.get(p), l.get(chk[p]))){
					++cnt;
					v[j] = true;//앉거나 전쟁
				}
			}
			
			if(cnt > 1) ++res;
			hs.add(chk[p]);//자리 체크
		}
		
		System.out.println(res);
	}
	private static double findDist(Pair p1, Pair p2) {
		return Math.sqrt(Math.pow(Math.abs(p1.x-p2.x), 2) + Math.pow(Math.abs(p1.y-p2.y), 2));
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}