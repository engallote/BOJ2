import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] str = br.readLine().trim().split(" ");
    	String[] tmp = str[0].split(":");
    	int sh = Integer.parseInt(tmp[0]), sm = Integer.parseInt(tmp[1]);
    	tmp = str[1].split(":");
    	int eh = Integer.parseInt(tmp[0]), em = Integer.parseInt(tmp[1]);
    	tmp = str[2].split(":");
    	int esh = Integer.parseInt(tmp[0]), esm = Integer.parseInt(tmp[1]);
    	
    	HashSet<String> in = new HashSet<>(), out = new HashSet<>();
    	String input = "";
    	
    	while((input = br.readLine()) != null) {
    		str = input.trim().split(" ");
    		String[] time = str[0].split(":");
    		String name = str[1];
//    		System.out.println(str[0] + ".." + str[1]);
    		int h = Integer.parseInt(time[0]), m = Integer.parseInt(time[1]);
    		
    		if(sh > h || (sh == h && sm >= m)) in.add(name);//시작 전 출석
    		if(((eh == h && em <= m) || eh < h) && (esh > h || (esh == h && esm >= m))) out.add(name);
    	}
    	
    	int res = 0;
    	for(String i : in)
    		if(out.contains(i)) ++res;
    	
    	System.out.println(res);
    }
}