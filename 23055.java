import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	char[][] map = new char[N][N];
    	int l = 0, r = N - 1;
    	
    	for(int i = 0; i < N; i++) {
    		Arrays.fill(map[i], ' ');
    		if(i == 0 || i == N - 1) Arrays.fill(map[i], '*');
    		else map[i][0] = map[i][N - 1] = '*';
    		
    		map[i][l] = map[i][r] = '*';
    		l += 1;
    		r -= 1;
    		
    	}
    	
    	for(int i = 0; i < N; i++)
    		System.out.println(new String(map[i]));
	}
}