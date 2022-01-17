import java.util.*;

public class Main {
	static char[][] map = new char[5][5];
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String str = sc.nextLine().toUpperCase();
    	str = str.replaceAll(" ", "");
    	char[] ch = str.toCharArray();
    	
    	HashSet<Character> hs = new HashSet<>();
    	int idx = 0;
    	char c = 'A';
    	for(int i = 0; i < 5; i++)
    		for(int j = 0; j < 5; j++) {
    			while(idx < ch.length && hs.contains(ch[idx])) ++idx;
    			if(idx < ch.length) {
    				map[i][j] = ch[idx];
    				hs.add(ch[idx]);
    				++idx;
    			}
    			else {
    				while(hs.contains(c) || c == 'Q') ++c;
    				map[i][j] = c;
    				hs.add(c);
    				++c;
    			}
    		}
    	
//    	for(int i = 0; i < 5; i++)
//    		System.out.println(new String(map[i]));
    	
    	str = sc.nextLine().toUpperCase();
    	str = str.replaceAll(" ", "");
    	ch = str.toCharArray();
    	idx = 0;
    	StringBuilder sb = new StringBuilder();
    	while(idx < ch.length) {
    		if(idx + 1 >= ch.length) {//ch[idx] + X
    			sb.append(find(ch[idx], 'X'));
    			break;
    		}
    		if(ch[idx] == ch[idx + 1]) {//ch[idx] + X
    			sb.append(find(ch[idx], 'X'));
    			idx += 1;
    		}
    		else {//ch[idx] + ch[idx + 1]
    			sb.append(find(ch[idx], ch[idx + 1]));
    			idx += 2;
    		}
    	}
    	
    	System.out.println(sb.toString());
    }

	private static String find(char a, char b) {
		int ar = -1, ac = 0, br = -1, bc = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(map[i][j] == a) {
					ar = i;
					ac = j;
				}
				if(map[i][j] == b) {
					br = i;
					bc = j;
				}
			}
			
			if(ar != -1 && br != -1) {
				if(ar == br) {//row
					if(ac + 1 < 5 && bc + 1 < 5) return map[ar][ac + 1] + "" + map[br][bc + 1];
					else if(ac + 1 < 5 && bc + 1 == 5) return map[ar][ac + 1] + "" + map[br][0];
					else if(ac + 1 == 5 && bc + 1 < 5) return map[ar][0] + "" + map[br][bc + 1];
				}
				else if(ac == bc) {//col
					if(ar + 1 < 5 && br + 1 < 5) return map[ar + 1][ac] + "" + map[br + 1][bc];
					else if(ar + 1 < 5 && br + 1 == 5) return map[ar + 1][ac] + "" + map[0][bc];
					else if(ar + 1 == 5 && br + 1 < 5) return map[0][ac] + "" + map[br + 1][bc];
				}
				else {//rec
					return map[ar][bc] + "" + map[br][ac];
				}
			}
		}
		return null;
	}
}