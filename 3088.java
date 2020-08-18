import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[1000001];
        int res = 0;
        
        for(int i = 0; i < N; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	
        	if(arr[a] == 1 || arr[b] == 1 || arr[c] == 1){
        		arr[a] = 1;
        		arr[b] = 1;
        		arr[c] = 1;
        	}
        	else{
        		arr[a] = 1;
        		arr[b] = 1;
        		arr[c] = 1;
        		++res;
        	}
        }
        
        System.out.println(res);
	}
}