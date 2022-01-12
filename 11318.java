import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static char[] order;
	static Dice dice;
	static int[] color = new int[7];
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	int M = sc.nextInt();
    	int P = sc.nextInt();
    	dice = new Dice(1, 2, 3, 4, 5, 6);
    	map = new int[N][N];
    	
    	for(int i = 0; i < M; i++) {
    		int y = sc.nextInt() - 1;
    		int x = N - sc.nextInt();
    		map[x][y] = sc.nextInt();
    	}
    	
    	order = sc.next().toCharArray();
    	int x = N - 1, y = 0;
    	boolean flag, clear = false;
    	for(int i = 0; i < P; i++) {
			char c = order[i];
			flag = true;
			clear = true;
			if(c == 'N') {
				flag = up(x, y);
				x -= 1;
			}
			else if(c == 'W') {
				flag = left(x, y);
				y -= 1;
			}
			else if(c == 'E') {
				flag = right(x, y);
				y += 1;
			}
			else {
				flag = down(x, y);
				x += 1;
			}
			
			for(int h = 1; h <= 6; h++) 
				if(color[h] == 0) {
					clear = false;
					break;
				}
			if(clear) break;
			if(!flag) {
				System.out.println("0 0 0 0 0 0");
				return;
			}
		}
    	
    	if(!clear) System.out.println("0 0 0 0 0 0");
    	else for(int i = 1; i <= 6; i++) System.out.print(color[i] + " ");
    }
	private static boolean left(int x, int y) {
		if(!range(x, y - 1)) return false;

		//주사위 굴리기
		//top -> rear
		//rear -> bottom
		//bottom -> front
		//front -> top	
		
		int tmp = dice.front;
		dice.front = dice.bottom;
		dice.bottom = dice.rear;
		dice.rear = dice.top;
		dice.top = tmp;
		
		if((map[x][y - 1] != 0 && color[dice.bottom] == 0) || map[x][y - 1] == 0) {
			if(color[dice.bottom] == 0) color[dice.bottom] = map[x][y - 1];
			return true;
		}
		if(map[x][y - 1] == color[dice.bottom]) return true;
		return false;
	}
	private static boolean right(int x, int y) {
		if(!range(x, y + 1)) return false;
		
		//주사위 굴리기
		//top -> front
		//front -> bottom
		//bottom -> rear
		//rear -> top	
		
		int tmp = dice.rear;
		dice.rear = dice.bottom;
		dice.bottom = dice.front;
		dice.front = dice.top;
		dice.top = tmp;
		
		if((map[x][y + 1] != 0 && color[dice.bottom] == 0) || map[x][y + 1] == 0) {
			if(color[dice.bottom] == 0) color[dice.bottom] = map[x][y + 1];
			return true;
		}
		if(map[x][y + 1] == color[dice.bottom]) return true;
		return false;
	}
	private static boolean down(int x, int y) {
		if(!range(x + 1, y)) return false;
		
		//주사위 굴리기
		//top -> right
		//right -> bottom
		//bottom -> left
		//left -> top		
		
		int tmp = dice.left;
		dice.left = dice.bottom;
		dice.bottom = dice.right;
		dice.right = dice.top;
		dice.top = tmp;
		
		if((map[x + 1][y] != 0 && color[dice.bottom] == 0) || map[x + 1][y] == 0) {
			if(color[dice.bottom] == 0) color[dice.bottom] = map[x + 1][y];
			return true;
		}
		if(map[x + 1][y] == color[dice.bottom]) return true;
		return false;
	}
	private static boolean up(int x, int y) {
		if(!range(x - 1, y)) return false;
		
		//주사위 굴리기
		//top -> left
		//left -> bottom
		//bottom -> right
		//right -> top
		
		int tmp = dice.right;
		dice.right = dice.bottom;
		dice.bottom = dice.left;
		dice.left = dice.top;
		dice.top = tmp;
		
		if((map[x - 1][y] != 0 && color[dice.bottom] == 0) || map[x - 1][y] == 0) {
			if(color[dice.bottom] == 0) color[dice.bottom] = map[x - 1][y];
			return true;
		}
		if(map[x - 1][y] == color[dice.bottom]) return true;
		return false;
	}
	private static boolean range(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= N) return false;
		return true;
	}
}
class Dice {
	int top, bottom, front, left, right, rear;
	Dice(int top, int front, int left, int right, int rear, int bottom){
		this.top = top;
		this.front = front;
		this.left = left;
		this.right = right;
		this.rear = rear;
		this.bottom = bottom;
	}
}