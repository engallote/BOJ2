import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String[] arr = new String[N];
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.next();
        
        Arrays.sort(arr);
        int res = 0;
        
        for(int i = 0; i < N; i++) {
        	boolean flag = true;
        	for(int j = i + 1; j < N; j++)
        		if(arr[j].startsWith(arr[i])) {
        			flag = false;
        			break;
        		}
        	
        	if(flag) ++res;
        }
        
        System.out.println(res);
	}
}