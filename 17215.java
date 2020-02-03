import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		int len = ch.length, p = 0, cnt = 0;
		int res = 0;
		
		for(int i = 0; i < len; i++){
			if(ch[i] == '-'){
				++cnt;
				if(cnt == 2){
					cnt = 0;
					++p;
				}
			}
			else if(ch[i] == 'S'){
				res += 10;
				cnt = 0;
				++p;
				if(p < 10 && i + 2 < len){
					if(ch[i+1] == 'S') res += 10;
					else if(ch[i+1] != '-') res += ch[i+1]-'0';
					if(ch[i+2] == 'S') res += 10;
					else{
						if(ch[i+2] == 'P'){
							if(ch[i+1] != '-') res -= ch[i+1]-'0';
							res += 10;
						}
						else if(ch[i+2] != '-') res += ch[i+2]-'0';
					}
				}
			}
			else if(ch[i] == 'P'){
				++p;
				cnt = 0;
				if(ch[i-1] != '-') res -= (ch[i-1] - '0');
				res += 10;
				if(p < 10 && i + 1 < len){
					if(ch[i+1] == 'S') res += 10;
					else if(ch[i+1] != '-') res += ch[i+1]-'0';
				}
			}
			else{
				res += ch[i]-'0';
				++cnt;
				if(cnt == 2){
					cnt = 0;
					++p;
				}
			}
		}
		System.out.println(res);
	}
}