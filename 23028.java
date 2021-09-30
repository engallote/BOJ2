import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();//현재 학기
    	int A = sc.nextInt();//전공학점
    	int B = sc.nextInt();//총 학점
    	
    	//전공학점 66점 이상
    	//총 학점 130점 이상
    	
    	boolean flag = false;
    	for(int i = 1; i <= 10; i++) {
    		int X = sc.nextInt();
    		int Y = sc.nextInt();
    		
    		if(X * 3 + A < 66) {
    			A += X * 3;
    			if(Y >= 6 - X) B += X * 3 + (6 - X) * 3;
    			else B += X * 3 + Y * 3;
    		}
    		else {
    			int num = 0;
    			for(int j = 1; j <= X; j++) {
    				num = j;
    				if(j * 3 + A >= 66) break;
    			}
    			
    			A += num * 3;
    			
    			if(Y >= 6 - num) B += num * 3 + (6 - num) * 3;
    			else B += num * 3 + Y * 3;
    		}
    		
    		if(A >= 66 && B >= 130) {
    			if(N + i <= 8) flag = true;
    		}
    	}
    	
    	if(flag) System.out.println("Nice");
    	else System.out.println("Nae ga wae");
	}
}