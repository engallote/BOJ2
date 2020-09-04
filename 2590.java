import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[7];
		int res = 0;
		
		for(int i = 1; i <= 6; i++)
			arr[i] = sc.nextInt();
		
		res = arr[6];
		
		//5
		while(arr[5] > 0){
			--arr[5];
			
			if(arr[1] >= 11) arr[1] -= 11;
			else arr[1] = 0;
			++res;
		}
		//4
		while(arr[4] > 0){
			--arr[4];
			int sum = 16;
			
			if(arr[2] >= 5){
				arr[2] -= 5;
				sum = 36;
			}
			else{
				sum += 4 * arr[2];
				arr[2] = 0;
			}
			if(sum < 36){
				if(arr[1] >= 36 - sum) arr[1] -= 36 - sum;
				else arr[1] = 0;
			}
			++res;
		}
		//3
		while(arr[3] > 0){
			if(arr[3] / 4 > 0){
				res += arr[3] / 4;
				arr[3] %= 4;
			}
			else{
				int sum = arr[3] * 9;
				if(arr[3] == 1){
					if(arr[2] >= 5){
						arr[2] -= 5;
						sum += 20;
					}
					else if(arr[2] < 5){
						sum += 4 * arr[2];
						arr[2] = 0;
					}
					if(sum < 36){
						if(arr[1] >= 36 - sum) arr[1] -= 36 - sum;
						else arr[1] = 0;
					}
				}
				else if(arr[3] == 2){
					if(arr[2] >= 3){
						arr[2] -= 3;
						sum += 12;
					}
					else if(arr[2] < 3){
						sum += 4 * arr[2];
						arr[2] = 0;
					}
					
					if(sum < 36){
						if(arr[1] >= 36 - sum) arr[1] -= 36 - sum;
						else arr[1] = 0;
					}
				}
				else{
					if(arr[2] >= 1){
						arr[2] -= 1;
						sum += 4;
					}
					if(sum < 36){
						if(arr[1] >= 36 - sum) arr[1] -= 36 - sum;
						else arr[1] = 0;
					}
				}
				arr[3] = 0;
				++res;
			}
		}
		//2
		while(arr[2] > 0){
			if(arr[2] / 9 > 0){
				res += arr[2] / 9;
				arr[2] %= 9;
			}
			else{
				int sum = arr[2] * 4;
				arr[2] = 0;
				if(arr[1] >= 36 - sum) arr[1] -= 36 - sum;
				else arr[1] = 0;
				++res;
			}
		}
		//1
		res += arr[1] / 36 + (arr[1] % 36 > 0 ? 1 : 0);
		
		System.out.println(res);
	}
}