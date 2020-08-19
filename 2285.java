import java.util.*;

public class Main {
	static int N;
	static Pair[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new Pair[N];
        long sum = 0, tmp = 0;
        
        for(int i = 0; i < N; i++){
        	arr[i] = new Pair(sc.nextInt(), sc.nextInt());
        	sum += (long)arr[i].y;
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i < N; i++){
        	tmp += arr[i].y;
        	if(tmp * 2 >= sum){
        		System.out.println(arr[i].x);
        		return;
        	}
        }
	}
}
class Pair implements Comparable<Pair>{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.x > this.x) return -1;
		else if(o.x == this.x) return 0;
		else return 1;
	}
}