import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		String str = sc.nextLine();
    		if(str.equals("#")) break;
    		char[] ch = str.toCharArray();
    		
    		StringBuilder sb = new StringBuilder(), res = new StringBuilder();
    		Queue<Boolean> q = new LinkedList<>();
    		for(int i = 0; i < ch.length; i++) {
    			if(ch[i] == ' ') {
    				if(sb.toString().length() == 0) {
    					res.append(" ");
    					continue;
    				}
    				
    				//reverse
    				int l = 0, r = sb.toString().length() - 1;
    				char[] tmp = sb.toString().toCharArray();
    				
    				while(l < r) {
    					int a = character(tmp[l]), b = character(tmp[r]);
    					if(a <= 1 && b <= 1) {
    						if(a == b) {
    							char c = tmp[r];
    							tmp[r] = tmp[l];
    							tmp[l] = c;
    						}
    						else {
    							if(a == 0 && b == 1) {
    								char nr = new String(tmp[r]+"").toLowerCase().charAt(0);
    								char nl = new String(tmp[l]+"").toUpperCase().charAt(0);
    								tmp[r] = nl;
    								tmp[l] = nr;
    							}
    							else {
    								char nr = new String(tmp[r]+"").toUpperCase().charAt(0);
    								char nl = new String(tmp[l]+"").toLowerCase().charAt(0);
    								tmp[r] = nl;
    								tmp[l] = nr;
    							}
    						}
    						
    						++l;
    						--r;
    					}
    					else if(a == 2 && b == 2) {
    						++l;
    						--r;
    					}
    					else if(a <= 1 && b == 2) --r;
    					else if(a == 2 && b <= 1) ++l;
    				}
    				res.append(new String(tmp) + " ");
    				sb = new StringBuilder();
    			}
    			else {
    				sb.append(ch[i]);
    				if('A' <= ch[i] && ch[i] <= 'Z') q.offer(true);
    				else q.offer(false); 
    			}
    		}
    		
    		//reverse
			int l = 0, r = sb.toString().length() - 1;
			char[] tmp = sb.toString().toCharArray();
			
			while(l < r) {
				int a = character(tmp[l]), b = character(tmp[r]);
				if(a <= 1 && b <= 1) {
					if(a == b) {
						char c = tmp[r];
						tmp[r] = tmp[l];
						tmp[l] = c;
					}
					else {
						if(a == 0 && b == 1) {
							char nr = new String(tmp[r]+"").toLowerCase().charAt(0);
							char nl = new String(tmp[l]+"").toUpperCase().charAt(0);
							tmp[r] = nl;
							tmp[l] = nr;
						}
						else {
							char nr = new String(tmp[r]+"").toUpperCase().charAt(0);
							char nl = new String(tmp[l]+"").toLowerCase().charAt(0);
							tmp[r] = nl;
							tmp[l] = nr;
						}
					}
					
					++l;
					--r;
				}
				else if(a == 2 && b == 2) {
					++l;
					--r;
				}
				else if(a <= 1 && b == 2) --r;
				else if(a == 2 && b <= 1) ++l;
			}
			res.append(new String(tmp));
    		System.out.println(res.toString());
    	}
	}

	private static int character(char c) {
		if('a' <= c && c <= 'z') return 0;
		if('A' <= c && c <= 'Z') return 1;
		return 2;
	}
}