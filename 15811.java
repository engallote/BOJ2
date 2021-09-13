import java.util.*;

public class Main {
	static char[] a, b, c;
	static boolean[] chk;
	static int[] arr;
	static HashSet<Character> hs = new HashSet<>();
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	chk = new boolean[10];
    	arr = new int[27];
    	Arrays.fill(arr, -1);
    	
    	a = sc.next().toCharArray();
    	b = sc.next().toCharArray();
    	c = sc.next().toCharArray();
    	
    	for(char ch : a) hs.add(ch);
    	for(char ch : b) hs.add(ch);
    	for(char ch : c) hs.add(ch);
    	
    	ArrayList<Character> path = new ArrayList<>();
    	Iterator<Character> it = hs.iterator();
    	
    	while(it.hasNext()) path.add(it.next());
    	
    	boolean res = solve(0, hs.size(), path);
    	System.out.println(res ? "YES" : "NO");
	}
	private static boolean solve(int idx, int len, ArrayList<Character> path) {
		if(idx == len) {
			long A = 0, B = 0, C = 0;
			for(char ch : a) {
				A *= 10l;
				A += (long)arr[ch-'A'];
			}
			
			for(char ch : b) {
				B *= 10l;
				B += (long)arr[ch-'A'];
			}
			
			for(char ch : c) {
				C *= 10l;
				C += (long)arr[ch-'A'];
			}
			
//			System.out.println(A + " + " + B + " = " + C);
			if(A + B == C) return true;
			else return false;
		}
		
		boolean ret = false;
		
		for(int i = 0; i < 10; i++)
			if(!chk[i]) {
				chk[i] = true;
				char ch = path.get(idx);
				
				if(arr[ch-'A'] == -1) arr[ch-'A'] = i;
				ret |= solve(idx + 1, len, path);
				
				arr[ch-'A'] = -1;
				chk[i] = false;
			}
		
		return ret;
	}
}