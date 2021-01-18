import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[14];
        int j = N, jn = 0, s = N, sn = 0;
        int down = 1, up = 1;
        
        for(int i = 0; i < 14; i++) {
        	arr[i] = sc.nextInt();
        	
        	//ÁØÇö
        	if(j >= arr[i]) {
        		jn += j / arr[i];
        		j %= arr[i];
        	}
        	
        	//¼º¹Î
        	if(i - 1 >= 0 && arr[i - 1] > arr[i]) {
    			++down;
    			up = 0;
    		}
    		else if(i - 1 >= 0 && arr[i - 1] < arr[i]) {
    			++up;
    			down = 0;
    		}
    		else {
    			up = 0;
    			down = 0;
    		}
    		
    		if(up >= 3 && sn > 0) {
    			s += sn * arr[i];
    			sn = 0;
    		}
    		else if(down >= 3 && s >= arr[i]) {
    			sn += s / arr[i];
    			s %= arr[i];
    		}
        }
        j += jn * arr[13];
        s += sn * arr[13];
        
        if(j > s) System.out.println("BNP");
        else if(j == s) System.out.println("SAMESAME");
        else System.out.println("TIMING");
    }
}