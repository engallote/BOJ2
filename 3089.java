import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] u = new int[N+1], d = new int[N+1], l = new int[N+1], r = new int[N+1];
		ArrayList<Pair> arr = new ArrayList<>(), arr1 = new ArrayList<>(), arr2 = new ArrayList<>();
		
		arr.add(new Pair(0, 0));//index 0을 위해 미리 추가
		arr1.add(new Pair(0, 0, 0));
		arr2.add(new Pair(0, 0, 0));
		int idx = 1;
		
		for(int i = 1; i <= N; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(x == 0 && y == 0) continue;
			
			arr.add(new Pair(x, y));
			arr1.add(new Pair(idx, x, y));
			arr2.add(new Pair(idx, x, y));
			++idx;
		}
		
		Collections.sort(arr1, new sortX());
		Collections.sort(arr2, new sortY());
		
		for(int i = 1; i < arr1.size(); i++){
			if(arr1.get(i).x == arr1.get(i-1).x){
				d[arr1.get(i).idx] = arr1.get(i-1).idx;
				u[arr1.get(i-1).idx] = arr1.get(i).idx;
			}
			if(arr2.get(i).y == arr2.get(i-1).y){
				r[arr2.get(i-1).idx] = arr2.get(i).idx;
				l[arr2.get(i).idx] = arr2.get(i-1).idx;
			}
		}
		
		char[] order = br.readLine().trim().toCharArray();
		idx = 0;
		
		for(int k = 0; k < M; k++){
			switch(order[k]){
			case 'U': idx = u[idx]; break;
			case 'D': idx = d[idx]; break;
			case 'L': idx = l[idx]; break;
			case 'R': idx = r[idx]; break;
			}
		}
		
		bw.write(arr.get(idx).x + " " + arr.get(idx).y);
		bw.flush();
	}
}
class Pair{
	int x, y, idx;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	Pair(int idx, int x, int y){
		this.idx = idx;
		this.x = x;
		this.y = y;
	}
}
class sortX implements Comparator<Pair>{
	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.x > o2.x) return 1;
		else if(o1.x == o2.x){
			if(o1.y > o2.y) return 1;
			else return -1;
		}
		else return -1;
	}
}
class sortY implements Comparator<Pair>{
	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.y > o2.y) return 1;
		else if(o1.y == o2.y){
			if(o1.x > o2.x) return 1;
			else return -1;
		}
		else return -1;
	}
}