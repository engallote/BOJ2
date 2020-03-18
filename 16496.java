import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++)
			pq.offer(new Pair(sc.next()));
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) sb.append(pq.poll().str);
		
		if(sb.charAt(0) == '0') System.out.println(0);
		else System.out.println(sb.toString());
	}
}
class Pair implements Comparable<Pair>{
	String str;
	Pair(String str){
		this.str = str;
	}
	@Override
	public int compareTo(Pair o) {
		long tmp = Long.parseLong(o.str + "" + this.str), tmp2 = Long.parseLong(this.str + "" + o.str);
		if(tmp > tmp2) return 1;
		else if(tmp == tmp2) return 0;
		else return -1;
	}
}