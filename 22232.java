import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	String[] arr = new String[N];
    	HashSet<String> hs = new HashSet<>();
    	
    	for(int i = 0; i < N; i++)
    		arr[i] = br.readLine().trim();
    	
    	for(int i = 0; i < M; i++) {
    		String str = br.readLine().trim();
    		hs.add(str);
    	}
    	
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	for(int i = 0; i < N; i++) {
    		int idx = arr[i].indexOf('.');
    		String ext = arr[i].substring(idx + 1);
    		int k = 0;
    		if(hs.contains(ext)) k = 1;
    		
    		pq.offer(new Pair(arr[i].substring(0, idx), ext, k));
    	}
    	
    	while(!pq.isEmpty())
    		bw.write(pq.peek().name + "." + pq.poll().ext + "\n");
    	
    	bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	String name, ext;
	int k;
	Pair(String name, String ext, int k) {
		this.name = name;
		this.ext = ext;
		this.k = k;
	}
	@Override
	public int compareTo(Pair o) {
		//파일명 먼저
		char[] a = this.name.toCharArray(), b = o.name.toCharArray();
		int len = Math.min(a.length, b.length);
		for(int i = 0; i < len; i++) {
			if(a[i] > b[i]) return 1;
			else if(a[i] == b[i]) continue;
			else return -1;
		}
		
		if(a.length > b.length) return 1;
		else if(a.length < b.length) return -1;
		else {//파일 확장자 순으로
			if(o.k > this.k) return 1;
			else if(o.k < this.k) return -1;
			else {
				char[] aa = this.ext.toCharArray(), bb = o.ext.toCharArray();
				len = Math.min(aa.length, bb.length);
				for(int i = 0; i < len; i++) {
					if(aa[i] > bb[i]) return 1;
					else if(aa[i] == bb[i]) continue;
					else return -1;
				}
				
				if(aa.length > bb.length) return 1;
				else if(aa.length == bb.length) return 0;
				else return -1;
			}
		}
	}
}