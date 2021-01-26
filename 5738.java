import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
        	int A = sc.nextInt();
        	int D = sc.nextInt();
        	
        	if(A == 0 && D == 0) break;
        	
        	int[] arr = new int[A], arr2 = new int[D];
        	
        	for(int i = 0; i < A; i++)//플레이어와 골라인까지의 거리
        		arr[i] = sc.nextInt();
        	
        	for(int i = 0; i < D; i++)//수비 선수와 골라인까지의 거리
        		arr2[i] = sc.nextInt();
        	
        	Arrays.sort(arr);
        	Arrays.sort(arr2);
        	
        	if(arr[0] >= arr2[1]) System.out.println("N");
        	else if(arr[0] == arr2[0] && arr[0] == arr2[1]) System.out.println("N");
        	else System.out.println("Y");
        }
	}
}