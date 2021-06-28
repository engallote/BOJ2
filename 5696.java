import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		int A = sc.nextInt();
    		int B = sc.nextInt();
    		
    		if(A == 0 && B == 0) break;
    		
    		int[] arr = new int[10];
    		
    		cal1(B, arr);
    		cal2(A - 1, arr);
    		
    		for(int i = 0; i < 10; i++)
    			System.out.print(arr[i] + " ");
    		System.out.println();
    	}
	}

	private static void cal2(int num, int[] arr) {
		for(int i = 1; i <= num; i*=10) {
			for(int j = 0; j < 10; j++) {
				if(j < (num / i) % 10) arr[j] -= (num / (i * 10) + 1) * i;
				else if(j == (num / i) % 10) arr[j] -= (num / (i * 10)) * i + (num % i) + 1;
				else arr[j] -= (num / (i * 10)) * i;
			}
			arr[0] += i;
		}
	}

	private static void cal1(int num, int[] arr) {
		for(int i = 1; i <= num; i*=10) {
			for(int j = 0; j < 10; j++) {
				if(j < (num / i) % 10) arr[j] += (num / (i * 10) + 1) * i;
				else if(j == (num / i) % 10) arr[j] += (num / (i * 10)) * i + (num % i) + 1;
				else arr[j] += (num / (i * 10)) * i;
			}
			arr[0] -= i;
		}
	}
}