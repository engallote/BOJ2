import java.util.*;

public class Main {
	static char[][] arr = new char[3][3];
	static boolean xwin, owin;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(--T >= 0){
        	int x = 0, o = 0;
        	xwin = owin = false;
        	for(int i = 0; i < 3; i++){
        		arr[i] = sc.next().toCharArray();
        		for(int j = 0; j < 3; j++)
        			if(arr[i][j] != '.'){
        				if(arr[i][j] == 'X') ++x;
        				else ++o;
        			}
        	}
        	
        	if(x < o || x > o + 1) System.out.println("no");
        	else{
        		for(int i = 0; i < 3; i++)
        			for(int j = 0; j < 3; j++)
        				if(arr[i][j] != '.')
        					win(i, j);
        		
        		if((xwin && owin) || (xwin && !owin && x <= o) || (!xwin && owin && x != o)) 
        			System.out.println("no");
        		else System.out.println("yes");
        	}
        }
    }
	private static void win(int x, int y) {
		int cnt = 0;
		//가로 검사
		char c = arr[x][y];
		for(int i = 0; i < 3; i++)
			if(arr[x][i] == c) ++cnt;
		
		if(cnt == 3){
			if(c == 'X') xwin = true;
			else owin = true;
			return;
		}
		
		//세로 검사
		cnt = 0;
		for(int i = 0; i < 3; i++)
			if(arr[i][y] == c) ++cnt;
		
		if(cnt == 3){
			if(c == 'X') xwin = true;
			else owin = true;
			return;
		}
		
		//대각선 검사
		int nx = 0, ny = 0;
		cnt = 0;
		while(nx < 3){
			if(arr[nx][ny] == c) ++cnt;
			++nx;
			++ny;
		}
		
		if(cnt == 3){
			if(c == 'X') xwin = true;
			else owin = true;
			return;
		}
		
		nx = 0;
		ny = 2;
		cnt = 0;
		while(nx < 3){
			if(arr[nx][ny] == c) ++cnt;
			++nx;
			--ny;
		}
		
		if(cnt == 3){
			if(c == 'X') xwin = true;
			else owin = true;
			return;
		}
	}
}