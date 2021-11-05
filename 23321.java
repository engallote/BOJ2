import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[][] arr = new char[5][];
    	
    	for(int i = 0; i < 5; i++)
    		arr[i] = sc.next().toCharArray();
    	
    	int N = arr[0].length;
    	
    	for(int j = 0; j < N; j++) {
    		int next = 0;
    		for(int i = 0; i < 5; i++) {
    			if(arr[i][j] == 'm') {
    				next = 1;
    				break;
    			}
    			else if(arr[i][j] == 'w') {
    				next = 2;
    				break;
    			}
    		}
    		
    		if(next == 0) continue;
    		if(next == 1) {//준비->도약
    			arr[0][j] = 'o';
        		arr[1][j] = 'w';
        		arr[2][j] = 'l';
        		arr[3][j] = 'n';
        		arr[4][j] = '.';
    		}
    		else {//도약->준비
    			arr[0][j] = '.';
        		arr[1][j] = 'o';
        		arr[2][j] = 'm';
        		arr[3][j] = 'l';
        		arr[4][j] = 'n';
    		}
    	}
    	
    	for(int i = 0; i < 5; i++)
    		System.out.println(new String(arr[i]));
	}
}