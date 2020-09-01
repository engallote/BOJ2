import java.util.*;

public class Main {
	static int N, len;
	static char[][] arr;
	static ArrayList<Integer>[] list;
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][][] number = {
				{	{'#','#','#'},
					{'#','.','#'}, 
					{'#','.','#'}, 
					{'#','.','#'}, 
					{'#','#','#'}},//0
				{	{'.','.','#'}, 
						{'.','.','#'}, 
						{'.','.','#'}, 
						{'.','.','#'}, 
						{'.','.','#'}},//1
				{	{'#','#','#'}, 
					{'.','.','#'}, 
					{'#','#','#'}, 
					{'#','.','.'}, 
					{'#','#','#'}},//2
				{
						{'#','#','#'}, 
						{'.','.','#'}, 
						{'#','#','#'}, 
						{'.','.','#'}, 
						{'#','#','#'}},//3
				{
					{'#','.','#'}, 
					{'#','.','#'}, 
					{'#','#','#'}, 
					{'.','.','#'}, 
					{'.','.','#'}},//4
				{
						{'#','#','#'}, 
						{'#','.','.'}, 
						{'#','#','#'}, 
						{'.','.','#'}, 
						{'#','#','#'}},//5
				{
					{'#','#','#'}, 
					{'#','.','.'}, 
					{'#','#','#'}, 
					{'#','.','#'}, 
					{'#','#','#'}},//6
				{
						{'#','#','#'}, 
						{'.','.','#'}, 
						{'.','.','#'}, 
						{'.','.','#'}, 
						{'.','.','#'}},//7
				{
					{'#','#','#'}, 
					{'#','.','#'}, 
					{'#','#','#'}, 
					{'#','.','#'}, 
					{'#','#','#'}},//8
				{
						{'#','#','#'}, 
						{'#','.','#'}, 
						{'#','#','#'}, 
						{'.','.','#'}, 
						{'#','#','#'}}};//9
		
		N = sc.nextInt();
		len = N * 4 - 1;
		arr = new char[5][len];
		list = new ArrayList[N];
		for(int i = 0; i < 5; i++)
			arr[i] = sc.next().toCharArray();
        
		for(int i = 0; i < N; i++)
			list[i] = new ArrayList<>();
        
		int idx = 0;
		for(int i = 0; i < len; i+=4){
			findNum(number, i, idx);
			++idx;
		}
		
		double res = 0;
		
		for(int i = 0; i < idx; i++){
			if(list[i].isEmpty()){
				System.out.println(-1);
				return;
			}
			double sum = 0;
			for(int p : list[i]) sum += p;
			
			sum /= (double) list[i].size();
			res *= 10;
			res += sum;
		}
		
		System.out.printf("%.5f",res);
	}
	private static void findNum(char[][][] number, int s, int idx) {
		for(int k = 0; k <= 9; k++){
			boolean flag = true;
			loop:for(int i = 0; i < 5; i++){
				for(int j = 0; j < 3; j++){
					if(number[k][i][j] == '.' && arr[i][s+j] == '#'){
						flag = false;
						break loop;
					}
				}
			}
            
			if(flag) list[idx].add(k);
		}
	}
}