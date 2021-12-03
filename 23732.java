import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	ArrayList<Integer> aly = new ArrayList<>();
    	for(int i = 1; i < N; i++)
    		if(ch[i - 1] == ch[i]) aly.add(i);
    		
    	int idx = 0;
    	long res = 0;
    	
    	for(int i = 0; i < N; i++) {
    		while(idx < aly.size() && i >= aly.get(idx)) ++idx;
    		if(idx >= aly.size()) break;
    		if(i < aly.get(idx)) {
    			res += (long)(N - aly.get(idx));
    		}
    	}
    	
    	System.out.println(res);
    }
}