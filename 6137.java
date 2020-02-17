import java.util.*;

public class Main {
	static int N;
	static char[] ch;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ch = new char[N];
        
        for(int i = 0; i < N; i++) 
        	ch[i] = sc.next().charAt(0);
        
        int l = 0, r = N - 1, cnt = 0, nl, nr;
        boolean flag;
        
        while(l <= r){
        	nl = l;
            nr = r;
        	flag = true;
        	while(nl <= nr){
        		if(ch[nl] > ch[nr]){
        			flag = false;
        			break;
        		}
        		else if(ch[nl] < ch[nr]){
        			flag = true;
        			break;
        		}
        		++nl;
        		--nr;
        	}
        	
        	if(flag){
        		System.out.print(ch[l]);
        		++l;
        	}
        	else{
        		System.out.print(ch[r]);
        		--r;
        	}
            ++cnt;
        	if(cnt > 0 && cnt % 80 == 0) System.out.println();
        }
    }
}