import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] ch = sc.next().toCharArray();
        char[][] arr = new char[5][N/5];
		int r = 0, c = 0, idx = 0;
		while(r < 5){
			arr[r][c] = ch[idx];
			++c;
			++idx;
			if(c == N/5){
				c = 0;
				++r;
			}
		}
		
		solve(arr, N/5);
    }

	private static void solve(char[][] arr, int ii) {
		boolean[][] chk = new boolean[5][ii];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < ii; i++)
			if(!chk[0][i] && arr[0][i] == '#'){
				if(i + 2 < ii){
					if(arr[0][i+1] == '#' && arr[0][i+2] == '#'){//0,2,3,4,5,6,7,8,9
						if(arr[2][i+1] == '.'){//0, 7
							if(arr[2][i] == '#')//0
								sb.append(0);
							else sb.append(7);
						}
						else if(arr[3][i+2] == '.')//2
							sb.append(2);
						else if(arr[3][i] == '.'){//3,5,9
							if(arr[1][i] == '.')//3 
								sb.append(3);
							else if(arr[1][i+2] == '.')//5
								sb.append(5);
							else sb.append(9);
						}
						else if(arr[1][i+2] == '.')//6
							sb.append(6);
						else sb.append(8);
						
						for(int k = i; k < i + 3; k++)
							chk[0][k] = true;
					}
					else{
						if(arr[0][i+1] == '.' && arr[0][i+2] == '#' &&
							arr[1][i] == '#' && arr[1][i+1] == '.' && arr[1][i+2] == '#' &&
							arr[2][i] == '#' && arr[2][i+1] == '#' && arr[2][i+2] == '#'){
							
							sb.append(4);
							
							for(int k = i; k < i + 3; k++)
								chk[0][k] = true;
						}
						else if(arr[0][i+1] == '.' && arr[1][i+1] == '.' && arr[2][i+1] == '.' && arr[3][i+1] == '.' && arr[4][i+1] == '.')
							sb.append(1);
					}
				}
				else sb.append(1);
			}
		System.out.println(sb.toString());
	}
}