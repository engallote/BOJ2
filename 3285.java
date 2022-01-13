import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] keyword = sc.next().toCharArray();
    	int K = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	HashSet<Character> hs = new HashSet<>();
    	HashMap<Character, Character> hm = new HashMap<>();
    	char start = (char)(K - 1 + 'A');
    	
    	int idx = 0, cnt = keyword.length;
    	char i = start, alp = 'A';
    	while(idx < keyword.length) {
    		hm.put(keyword[idx], i);
    		hs.add(keyword[idx]);
    		++idx;
    		if(i == 'Z') i = 'A';
    		else ++i;
    	}
    	
    	while(cnt < 26) {
    		while(hs.contains(alp)) {
    			if(alp == 'Z') alp = 'A';
        		else ++alp;
    		}
    		hm.put(alp, i);
    		hs.add(alp);
    		if(i == 'Z') i = 'A';
    		else ++i;
    		++cnt;
    	}
    	
    	for(char c : ch)
    		System.out.print(hm.get(c));
    }
}