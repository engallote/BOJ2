import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.nextLine().toLowerCase().toCharArray();
		String[] str = new String['z'+1];
		
		str['a'] = "@";
		str['b'] = "8";
		str['c'] = "(";
		str['d'] = "|)";
		str['e'] = "3";
		str['f'] = "#";
		str['g'] = "6";
		str['h'] = "[-]";
		str['i'] = "|";
		str['j'] = "_|";
		str['k'] = "|<";
		str['l'] = "1";
		str['m'] = "[]\\/[]";
		str['n'] = "[]\\[]";
		str['o'] = "0";
		str['p'] = "|D";
		str['q'] = "(,)";
		str['r'] = "|Z";
		str['s'] = "$";
		str['t'] = "\'][\'";
		str['u'] = "|_|";
		str['v'] = "\\/";
		str['w'] = "\\/\\/";
		str['x'] = "}{";
		str['y'] = "`/";
		str['z'] = "2";
		
		for(char c : ch){
			if(c >= 'a' && c <= 'z') System.out.print(str[c]);
			else System.out.print(c);
		}
	}
}