import java.util.*;

public class Main {
	static int len;
	static int[] arr, number = new int[10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		number[0] = 4;
		number[1] = number[2] = number[6] = 3;
		number[3] = number[7] = number[8] = 5;
		number[4] = number[5] = number[9] = 4;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] ch = sc.next().toCharArray();
			len = ch.length;
			arr = new int['Z'+1];
			StringBuilder ans = new StringBuilder();
			PriorityQueue<Character> pq = new PriorityQueue<>();
			for(char c : ch) arr[c]++;
			
			while(arr['Z'] > 0){
				if(isThere(0)){
					mul(0, -1);
					pq.offer('0');
				}
				else break;
			}
			while(arr['W'] > 0){
				if(isThere(2)){
					mul(2, -1);
					pq.offer('2');
				}
				else break;
			}
			while(arr['X'] > 0){
				if(isThere(6)){
					mul(6, -1);
					pq.offer('6');
				}
				else break;
			}
			while(arr['U'] > 0){
				if(isThere(4)){
					mul(4, -1);
					pq.offer('4');
				}
				else break;
			}		
			while(arr['F'] > 0){
				if(isThere(5)){
					mul(5, -1);
					pq.offer('5');
				}
				else break;
			}
			while(arr['G'] > 0){
				if(isThere(8)){
					mul(8, -1);
					pq.offer('8');
				}
				else break;
			}
			while(arr['H'] > 0){
				if(isThere(3)){
					mul(3, -1);
					pq.offer('3');
				}
				else break;
			}
			while(arr['I'] > 0){
				if(isThere(9)){
					mul(9, -1);
					pq.offer('9');
				}
				else break;
			}
			while(arr['S'] > 0){
				if(isThere(7)){
					mul(7, -1);
					pq.offer('7');
				}
				else break;
			}
			while(arr['N'] > 0){
				if(isThere(1)){
					mul(1, -1);
					pq.offer('1');
				}
				else break;
			}
			
			while(!pq.isEmpty()) ans.append(pq.poll());
			System.out.println("Case #" + test_case + ": " + ans);
		}
	}
	private static void mul(int idx, int num) {
		switch(idx){
		case 0 : arr['Z'] += num; arr['E'] += num; arr['R'] += num; arr['O'] += num; break;
		case 1 : arr['O'] += num; arr['N'] += num; arr['E'] += num; break;
		case 2 : arr['T'] += num; arr['W'] += num; arr['O'] += num; break;
		case 3 : arr['T'] += num; arr['H'] += num; arr['R'] += num; arr['E'] += (num * 2); break;
		case 4 : arr['F'] += num; arr['O'] += num; arr['U'] += num; arr['R'] += num; break;
		case 5 : arr['F'] += num; arr['I'] += num; arr['V'] += num; arr['E'] += num; break;
		case 6 : arr['S'] += num; arr['I'] += num; arr['X'] += num; break;
		case 7 : arr['S'] += num; arr['E'] += (num * 2); arr['V'] += num; arr['N'] += num; break;
		case 8 : arr['E'] += num; arr['I'] += num; arr['G'] += num; arr['H'] += num; arr['T'] += num; break;
		case 9 : arr['I'] += num; arr['N'] += (num * 2); arr['E'] += num; break;
		}
	}
	private static boolean isThere(int num) {
		switch(num){
		case 0 : if(arr['O'] > 0 && arr['Z'] > 0 && arr['E'] > 0 && arr['R'] > 0) return true;
		case 1 : if(arr['O'] > 0 && arr['N'] > 0 && arr['E'] > 0) return true;
		case 2 : if(arr['T'] > 0 && arr['W'] > 0 && arr['O'] > 0) return true;
		case 3 : if(arr['T'] > 0 && arr['H'] > 0 && arr['R'] > 0 && arr['E'] > 1) return true;
		case 4 : if(arr['F'] > 0 && arr['O'] > 0 && arr['U'] > 0 && arr['R'] > 0) return true;
		case 5 : if(arr['F'] > 0 && arr['I'] > 0 && arr['V'] > 0 && arr['E'] > 0) return true;
		case 6 : if(arr['S'] > 0 && arr['I'] > 0 && arr['X'] > 0) return true;
		case 7 : if(arr['S'] > 0 && arr['E'] > 1 && arr['V'] > 0 && arr['N'] > 0) return true;
		case 8 : if(arr['E'] > 0 && arr['I'] > 0 && arr['G'] > 0 && arr['H'] > 0 && arr['T'] > 0) return true;
		case 9 : if(arr['I'] > 0 && arr['N'] > 1 && arr['E'] > 0) return true;
		}
		return false;
	}
}