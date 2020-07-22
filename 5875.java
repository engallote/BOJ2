import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		int res = 0, tmp = 0, l = 0, r = 0;
		for(int i = 0; i < ch.length; i++){
			if(ch[i] == '('){
				++tmp;
				++l;
			}
			else{
				--tmp;
				++r;
			}
			
			if(tmp <= 1) l = 0;
			if(tmp == -1){
				res = r;
				break;
			}
			
		}
		
		if(tmp > 0) res = l;
		System.out.println(res);
	}
}