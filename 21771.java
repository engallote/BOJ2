import java.util.*;

public class Main {
	static int R, C;
	static char[][] map;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	R = sc.nextInt();
    	C = sc.nextInt();
    	int rg = sc.nextInt(), cg = sc.nextInt();
    	int rb = sc.nextInt(), cb = sc.nextInt();
    	map = new char[R][C];
    	chk = new boolean[R][C];
    	
    	for(int i = 0; i < R; i++)
    		map[i] = sc.next().toCharArray();
    	
    	boolean flag = true;
    	int cnt = 0;
    	
    	//베개 일부분이 없다면 베개 위에서 자는 것
    	for(int i = 0; i < R; i++)
    		for(int j = 0; j < C; j++)
    			if(map[i][j] == 'P')
    				++cnt;
    			
    	if(cnt == rb * cb) flag = false;
    	
    	System.out.println(flag ? 1 : 0);
	}
}