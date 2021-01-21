import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Pair[] arr = new Pair[N];
        int res = 0;
        
        for(int i = 0; i < N; i++)
        	arr[i] = new Pair(i, sc.nextInt());
        
        Arrays.sort(arr);
        
        for(int i = 0; i < N; i++)
        	if(i < arr[i].idx) 
        		res = Math.max(res, arr[i].idx - i);
        
        System.out.println(res + 1);
    }
}
class Pair implements Comparable<Pair> {
	int idx, num;
	Pair(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.num > this.num) return -1;
		else return 1;
	}
}