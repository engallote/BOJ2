import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int[] score = {100, 100, 200, 200, 300, 300, 400, 400, 500};
    	boolean hac = false;
    	int res = 0;
    	
    	for(int i = 0; i < 9; i++) {
    		int num = sc.nextInt();
    		if(score[i] < num) hac = true;
    		res += num;
    	}
    	
    	if(hac) System.out.println("hacker");
    	else System.out.println(res >= 100 ? "draw" : "none");
	}
}