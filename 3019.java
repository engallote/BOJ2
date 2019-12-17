import java.util.*;

public class Main {
	static int R, C, res;
	static boolean[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		int P = sc.nextInt();
		int[] height = new int[C + 2];
		arr = new boolean[107][C + 2];
		Arrays.fill(arr[106], true);
		R = 107;
		res = 0;
		for(int i = 1; i <= C; i++)
		{
			int num = sc.nextInt();
			int row = 105;
			for(int j = 0; j < num; j++, row--)
				arr[row][i] = true;
			height[i] = row;
		}
		
		C += 1;
		for(int i = 1; i < C; i++)
			match(height[i], i, P);
		
		System.out.println(res);
	}

	private static void match(int r, int c, int p) {
		if(p == 1)
		{
			if(r - 3 >= 0)
			{
				if(!arr[r][c] && !arr[r-1][c] && !arr[r-2][c] && !arr[r-3][c])
				{
					if(r + 1 < R && arr[r + 1][c]) ++res;
				}
			}
			if(c + 3 < C)
			{
				if(!arr[r][c] && !arr[r][c+1] && !arr[r][c+2] && !arr[r][c+3])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r+1][c+1] && arr[r+1][c+2] && arr[r+1][c+3])
						++res;
				}
			}
		}
		else if(p == 2)
		{
			if(r - 1 >= 0 && c + 1 <= C)
			{
				if(!arr[r][c] && !arr[r-1][c] && !arr[r][c+1] && !arr[r-1][c+1])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r+1][c+1]) res++;
					else if(r + 1 >= R) ++res;
				}
			}
		}
		else if(p == 3)
		{
			if(r - 1 >= 0 && c + 2 <= C)
			{
				if(!arr[r][c] && !arr[r][c+1] && !arr[r-1][c+1] && !arr[r-1][c+2])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r+1][c+1] && arr[r][c+2]) res++;
				}
			}
			if(r - 2 >= 0 && c - 1 >= 0)
			{
				if(!arr[r][c] && !arr[r-1][c] && !arr[r-1][c-1] && !arr[r-2][c-1])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r][c-1]) res++;
				}
			}
		}
		else if(p == 4)
		{
			if(r - 1 >= 0 && c - 2 >= 0)
			{
				if(!arr[r][c] && !arr[r][c-1] && !arr[r-1][c-1] && !arr[r-1][c-2])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r+1][c-1] && arr[r][c-2]) res++;
				}
			}
			if(r - 2 >= 0 && c + 1 <= C)
			{
				if(!arr[r][c] && !arr[r-1][c] && !arr[r-1][c+1] && !arr[r-2][c+1])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r][c+1]) ++res;
				}
			}
		}
		else if(p == 5)//ㅗ
		{
			if(r - 1 >= 0 && c + 2 <= C)//ㅗ
			{
				if(!arr[r][c] && !arr[r][c+1] && !arr[r-1][c+1] && !arr[r][c+2])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r+1][c+1] && arr[r+1][c+2]) ++res;
				}
			}
			if(r - 2 >= 0 && c + 1 <= C)//ㅏ
			{
				if(!arr[r][c] && !arr[r-1][c] && !arr[r-2][c] && !arr[r-1][c+1])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r][c+1]) ++res;
				}
			}
			if(r - 1 >= 0 && c - 1 >= 0 && c + 1 <= C)//ㅜ
			{
				if(!arr[r][c] && !arr[r-1][c] && !arr[r-1][c+1] && !arr[r-1][c-1])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r][c+1] && arr[r][c-1]) ++res;
				}
			}
			if(r - 2 >= 0 && c - 1 >= 0)//ㅓ
			{
				if(!arr[r][c] && !arr[r-1][c] && !arr[r-1][c-1] && !arr[r-2][c])
				{
					if(r + 1 < R && arr[r][c-1] && arr[r+1][c]) ++res;
				}
			}
		}
		else if(p == 6)
		{
			if(r - 1 >= 0 && c + 2 <= C)
			{
				if(!arr[r][c] && !arr[r][c+1] && !arr[r][c+2] && !arr[r-1][c+2])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r+1][c+1] && arr[r+1][c+2]) res++;
				}
			}
			if(r - 2 >= 0 && c - 1 >= 0)
			{
				if(!arr[r][c] && !arr[r-1][c] && !arr[r-2][c] && !arr[r-2][c-1])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r][c-1] && arr[r-1][c-1]) res++;
				}
			}
			if(r - 1 >= 0 && c + 2 <= C)
			{
				if(!arr[r][c] && !arr[r-1][c] && !arr[r-1][c+1] && !arr[r-1][c+2])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r][c+1] && arr[r][c+2]) res++;
				}
			}
			if(r - 2 >= 0 && c + 1 <= C)
			{
				if(!arr[r][c] && !arr[r-1][c] && !arr[r-2][c] && !arr[r][c+1])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r+1][c+1]) res++;
				}
			}
		}
		else
		{
			if(r - 1 >= 0 && c + 2 <= C)
			{
				if(!arr[r][c] && !arr[r-1][c] && !arr[r][c+1] && !arr[r][c+2])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r+1][c+1] && arr[r+1][c+2]) res++;
				}
			}
			if(r - 2 >= 0 && c + 1 <= C)
			{
				if(!arr[r][c] && !arr[r][c+1] && !arr[r-1][c+1] && !arr[r-2][c+1])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r+1][c+1]) res++;
				}
			}
			if(r + 1 < R && c + 2 <= C)
			{
				if(!arr[r][c] && !arr[r][c+1] && !arr[r][c+2] && !arr[r+1][c+2])
					if(r + 2 < R && arr[r+1][c] && arr[r+1][c+1] && arr[r+2][c+2]) res++;
			}
			if(r - 2 >= 0 && c + 1 <= C)
			{
				if(!arr[r][c] && !arr[r-1][c] && !arr[r-2][c] && !arr[r-2][c+1])
				{
					if(r + 1 < R && arr[r+1][c] && arr[r][c+1] && arr[r-1][c+1]) res++;
				}
			}
		}
	}
}