import java.util.*;

public class Main {
	static int N;
	static boolean end;
	static int[] arr = new int['z'];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if(String.valueOf(N).length() > 6 || String.valueOf(N).length() < 5){
        	System.out.println("No Answer");
        	return;
        }
        end = false;
        Arrays.fill(arr, -1);
        char[] ch = {'h','e','l','l','o','w','o','r','l','d'};
        
        solve(0, 0, ch);       
        
        if(!end) 
        	System.out.println("No Answer");
    }
	private static void solve(int idx, int chk, char[] ch) {
		if(end) return;
		if(idx == 10){
			if(arr['h'] == 0 || arr['w'] == 0) return;
			int num1 = 0, num2 = 0;
			for(int i = 0; i < 5; i++){
				num1 *= 10;
				num1 += arr[ch[i]];
			}
			for(int i = 5; i < 10; i++){
				num2 *= 10;
				num2 += arr[ch[i]];
			}
			
			if(num1 + num2 == N){
				end = true;
				System.out.println("  " + num1);
				System.out.println("+ " + num2);
				System.out.println("-------");
				for(int i = 0; i < 7 - String.valueOf(N).length(); i++)
					System.out.print(" ");
				System.out.println(N);
			}
			return;
		}
		if(arr[ch[idx]] != -1){
			solve(idx + 1, chk, ch);
			return;
		}
		for(int i = 0; i <= 9; i++)
			if((chk&(1<<i)) == 0){
				arr[ch[idx]] = i;
				solve(idx + 1, chk|(1<<i), ch);
				arr[ch[idx]] = -1;
			}
	}
}