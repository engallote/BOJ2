import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		boolean[] chk = new boolean[ch.length];
		
		for(int i = 0; i < ch.length; i++){
			if(chk[i]) continue;
			if(ch[i] == 'w'){
				int w = 0, o = 0, l = 0, f = 0;
				boolean fw = false, fo =false, fl = false, ff = false;
				for(int j = i; j < ch.length; j++){
					if(ch[j] == 'w'){
						if(!fo && !fl && !ff){
							++w;
							fw = true;
						}
						else break;
					}
					else if(ch[j] == 'o' && !fl && !ff){
						fo = true;
						++o;
					}
					else if(ch[j] == 'l' && !ff){
						fl = true;
						++l;
					}
					else if(ch[j] == 'f'){
						++f;
						ff = true;
					}
					else{
						System.out.println(0);
						return;
					}
					chk[j] = true;
				}
				if(w == o && o == l && l == f) continue;
				else{
					System.out.println(0);
					return;
				}
			}
		}
		
        for(int i = 0; i < ch.length; i++)
			if(!chk[i]){
				System.out.println(0);
				return;
			}
		System.out.println(1);
	}
}