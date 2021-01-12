import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		
		if(ch[0] == 'E') ch[0] = 'I';
		else ch[0] = 'E';
		
		if(ch[1] == 'S') ch[1] = 'N';
		else ch[1] = 'S';
		
		if(ch[2] == 'T') ch[2] = 'F';
		else ch[2] = 'T';
		
		if(ch[3] == 'J') ch[3] = 'P';
		else ch[3] = 'J';
		
		System.out.println(new String(ch));
	}
}