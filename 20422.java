import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Character> hm = new HashMap<>();
		hm.put('A', 'A');
		hm.put('E', '3');
		hm.put('H', 'H');
		hm.put('I', 'I');
		hm.put('M', 'M');
		hm.put('O', 'O');
		hm.put('S', '2');
		hm.put('T', 'T');
		hm.put('U', 'U');
		hm.put('V', 'V');
		hm.put('W', 'W');
		hm.put('X', 'X');
		hm.put('Y', 'Y');
		hm.put('Z', '5');
		hm.put('b', 'd');
		hm.put('d', 'b');
		hm.put('i', 'i');
		hm.put('l', 'l');
		hm.put('m', 'm');
		hm.put('n', 'n');
		hm.put('o', 'o');
		hm.put('p', 'q');
		hm.put('q', 'p');
		hm.put('r', '7');
		hm.put('u', 'u');
		hm.put('v', 'v');
		hm.put('w', 'w');
		hm.put('x', 'x');
		hm.put('0', '0');
		hm.put('1', '1');
		hm.put('2', 'S');
		hm.put('3', 'E');
		hm.put('5', 'Z');
		hm.put('7', 'r');
		hm.put('8', '8');
		
		char[] ch = sc.next().toCharArray();
		
		int l = 0, r = ch.length - 1;
		while(l < r) {
			if(hm.containsKey(ch[l]) && hm.get(ch[l]) == ch[r]) {
				--r;
				++l;
			}
			else {
				if(hm.containsKey(ch[l])) {
					ch[r] = hm.get(ch[l]);
					++l;
					--r;
				}
				else {
					char c = Character.toLowerCase(ch[l]);
					if(c!= ch[l] && hm.containsKey(c)) {
						if(ch[r] == Character.toLowerCase(hm.get(c)) || ch[r] == Character.toUpperCase(hm.get(c))) {
							ch[l] = c;
							ch[r] = hm.get(c);
							++l;
							--r;
							continue;
						}
						else {
							System.out.println(-1);
							return;
						}
					}
					
					c = Character.toUpperCase(ch[l]);
					if(hm.containsKey(c)) {
						if(ch[r] == Character.toLowerCase(hm.get(c)) || ch[r] == Character.toUpperCase(hm.get(c))) {
							ch[l] = c;
							ch[r] = hm.get(c);
							++l;
							--r;
							continue;
						}
						else {
							System.out.println(-1);
							return;
						}
					}
					else {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		if(l >= r) System.out.println(new String(ch));
	}
}