import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int[][] num = {{1,1,1,0,1,1,1}, {0,0,1,0,0,1,0}, {1,0,1,1,1,0,1}, {1,0,1,1,0,1,1}, {0,1,1,1,0,1,0},{1,1,0,1,0,1,1}, {1,1,0,1,1,1,1}, {1,0,1,0,0,1,0}, {1,1,1,1,1,1,1}, {1,1,1,1,0,1,1}}; 
    	int[][] arr = new int[10][10];
    	
    	for(int i = 0; i <= 9; i++)
    		for(int j = 0; j <= 9; j++) {
    			if(i == j) continue;
    			int sum = 0;
    			for(int a = 0; a < 7; a++)
    				if(num[i][a] != num[j][a]) ++sum;
    			
    			arr[i][j] = sum;
    		}
    	
    	int N = sc.nextInt();//瞪羹 類
    	int K = sc.nextInt();//濠葬 熱
    	int P = sc.nextInt();//奩瞪 熱
    	int X = sc.nextInt();//⑷營 類
    	int res = 0;
    	
    	for(int i = 1; i <= N; i++) {
    		if(i == X) continue;
    		int sum = 0, a = i, b = X;
    		
    		for(int j = 0; j < K; j++) {
    			sum += arr[a % 10][b % 10];
    			a /= 10;
    			b /= 10;
    		}
    		
    		if(sum <= P)
    			++res;
    	}
    	
    	System.out.println(res);
	}
}