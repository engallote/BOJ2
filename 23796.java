import java.util.*;

public class Main {
	static long[][] arr = new long[8][8];
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	for(int i = 0; i < 8; i++)
    		for(int j = 0; j < 8; j++)
    			arr[i][j] = sc.nextLong();
    	
    	char c = sc.next().charAt(0);
    	if(c == 'U') up();
		else if(c == 'D') down();
		else if(c == 'L') left();
		else right();
    	
    	for(int i = 0; i < 8; i++) {
    		for(int j = 0; j < 8; j++)
    			System.out.print(arr[i][j] + " ");
    		System.out.println();
    	}
    }
	private static void right() {
		for(int j = 7; j >= 0; j--)
			for(int i = 0; i < 8; i++) {
				int y = j - 1;
				while(y >= 0) {
					if(arr[i][y] != 0) {
						if(arr[i][j] == 0) {
							arr[i][j] = arr[i][y];
							arr[i][y] = 0;
						}
						else if(arr[i][j] == arr[i][y]) {
							arr[i][j] *= 2;
							arr[i][y] = 0;
							break;
						}
						else break;
					}
					y -= 1;
				}
			}
	}
	private static void left() {
		for(int j = 0; j < 8; j++)
			for(int i = 0; i < 8; i++) {
				int y = j + 1;
				while(y < 8) {
					if(arr[i][y] != 0) {
						if(arr[i][j] == 0) {
							arr[i][j] = arr[i][y];
							arr[i][y] = 0;
						}
						else if(arr[i][j] == arr[i][y]) {
							arr[i][j] *= 2;
							arr[i][y] = 0;
							break;
						}
						else break;
					}
					y += 1;
				}
			}
	}
	private static void down() {
		for(int i = 7; i >= 0; i--)
			for(int j = 0; j < 8; j++) {
				int x = i - 1;
				while(x >= 0) {
					if(arr[x][j] != 0) {
						if(arr[i][j] == 0) {
							arr[i][j] = arr[x][j];
							arr[x][j] = 0;
						}
						else if(arr[i][j] == arr[x][j]) {
							arr[i][j] *= 2;
							arr[x][j] = 0;
							break;
						}
						else break;
					}
					x -= 1;
				}
			}
	}
	private static void up() {
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++) {
				int x = i + 1;
				while(x < 8) {
					if(arr[x][j] != 0) {
						if(arr[i][j] == 0) {
							arr[i][j] = arr[x][j];
							arr[x][j] = 0;
						}
						else if(arr[i][j] == arr[x][j]) {
							arr[i][j] += arr[x][j];
							arr[x][j] = 0;
							break;
						}
						else break;
					}
					x += 1;
				}
			}
	}
}