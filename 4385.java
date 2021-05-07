import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int[] ram = new int[1001];
    	int idx = 0, res = 0;
    	while(sc.hasNextInt()) {
    		int num = sc.nextInt();
    		ram[idx++] = num;
    	}
    	int[] arr = new int[idx];
    	idx = 0;
    	while(true) {
    		int order = ram[idx] / 100;
    		int d = ram[idx] / 10 % 10;
    		int n = ram[idx] % 10;
    		++idx;
    		++res;
    		
    		if(order == 1) break;
    		else if(order == 2) arr[d] = n;
    		else if(order == 3) arr[d] += n;
    		else if(order == 4) arr[d] *= n;
    		else if(order == 5) arr[d] = arr[n];
    		else if(order == 6) arr[d] += arr[n];
    		else if(order == 7) arr[d] *= arr[n];
    		else if(order == 8) arr[d] = ram[arr[n]];
    		else if(order == 9) ram[arr[n]] = arr[d];
    		else {
    			if(arr[n] != 0) idx = arr[d];
    		}
    		arr[d] %= 1000;
    	}
    	
    	System.out.println(res);
	}
}