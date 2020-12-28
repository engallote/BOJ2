import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char left = sc.next().charAt(0);
		char right = sc.next().charAt(0);
		char[] ch = sc.next().toCharArray();
		
		int[] map = new int['z' + 1]; 
		map['q'] = 0;
		map['w'] = 1;
		map['e'] = 2;
		map['r'] = 3;
		map['t'] = 4;
		map['y'] = 5;
		map['u'] = 6;
		map['i'] = 7;
		map['o'] = 8;
		map['p'] = 9;
		
		
		map['a'] = 10;
		map['s'] = 11;
		map['d'] = 12;
		map['f'] = 13;
		map['g'] = 14;
		map['h'] = 15;
		map['j'] = 16;
		map['k'] = 17;
		map['l'] = 18;
		
		map['z'] = 20;
		map['x'] = 21;
		map['c'] = 22;
		map['v'] = 23;
		map['b'] = 24;
		map['n'] = 25;
		map['m'] = 26;
		
		int lx = map[left] / 10, ly = map[left] % 10;
		int rx = map[right] / 10, ry = map[right] % 10;
		int res = 0;
		
		for(char c : ch) {
			int nx = map[c] / 10, ny = map[c] % 10;
			
			if((nx == 0 && ny <= 4) || (nx == 1 && ny <= 4) || (nx == 2 && ny <= 3)) {
				res += Math.abs(lx - nx) + Math.abs(ly - ny);
				lx = nx;
				ly = ny;
			}
			else {
				res += Math.abs(rx - nx) + Math.abs(ry - ny);
				rx = nx;
				ry = ny;
			}
			++res;
		}
		
		System.out.println(res);
	}
}