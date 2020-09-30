import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();//¼ö
		int M = sc.nextInt();//Á¤¿ø
		Pair[] arr = new Pair[P];
		int[] score = new int[P];
		PriorityQueue<Pair>[] q = new PriorityQueue[P];
		
		for(int i = 0; i < P; i++) {
			q[i] = new PriorityQueue<>();
			
			int num = sc.nextInt();
			String name = sc.next();
			arr[i] = new Pair(num, name);
		}
		
		int idx = 1;
		score[0] = arr[0].num;
		q[0].offer(arr[0]);
		
		for(int i = 1; i < P; i++) {
			boolean flag = false;
			for(int j = 0; j < idx; j++)
				if(score[j] - 10 <= arr[i].num && arr[i].num <= score[j] + 10 && q[j].size() < M) {
					q[j].offer(arr[i]);
					flag = true;
					break;
				}
			if(!flag) {
				q[idx].offer(arr[i]);
				score[idx] = arr[i].num;
				++idx;
			}
		}
		
		for(int i = 0; i < idx; i++) {
			if(q[i].size() == M) System.out.println("Started!");
			else System.out.println("Waiting!");
			
			while(!q[i].isEmpty())
				System.out.println(q[i].peek().num + " " + q[i].poll().name);
		}
	}
}
class Pair implements Comparable<Pair>{
	int num;
	String name;
	Pair(int num, String name){
		this.num = num;
		this.name = name;
	}
	@Override
	public int compareTo(Pair o) {
		char[] a = o.name.toCharArray(), b = this.name.toCharArray();
		int len = Math.min(a.length, b.length);
		
		for(int i = 0; i < len; i++) {
			if(a[i] > b[i]) return -1;
			else if(a[i] < b[i]) return 1;
		}
		
		if(a.length > b.length) return -1;
		else return 1;
	}
}