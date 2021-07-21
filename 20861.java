import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	char[][] map = new char[N][M];
    	boolean[][] chk = new boolean[N][M];
    	
    	for(int i = 0; i < N; i++)
    		map[i] = sc.next().toCharArray();
    		
    	
    	int x = 0, y = 0;
    	while(true) {
    		
    		if(map[x][y] == 'A') {
    			System.out.println("sushi");
    			return;
    		}
    		if(map[x][y] == 'B') {
    			System.out.println("samuraj");
    			return;
    		}
    		
    		if(chk[x][y]) {
    			System.out.println("cykel");
    			return;
    		}
    		
    		chk[x][y] = true;
    		if(map[x][y] == '<') y -= 1;
    		else if(map[x][y] == '>') y += 1;
    		else if(map[x][y] == '^') x -= 1;
    		else if(map[x][y] == 'v') x += 1;
    	}
	}
}