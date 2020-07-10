import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i = 1;;i++){
			if(i * i > 500000) break;
			arr.add(i * i);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < arr.size(); i++){
			if(arr.get(i) == N){
				System.out.println(1);
				return;
			}
			for(int j = i; j < arr.size(); j++){
				if(arr.get(i) + arr.get(j) == N){
					min = Math.min(min, 2);
					break;
				}
				else if(arr.get(i) + arr.get(j) > N) break;
				for(int k = j; k < arr.size(); k++){
					if(arr.get(i) + arr.get(j) + arr.get(k) == N){
						min = Math.min(min, 3);
						break;
					}
					else if(arr.get(i) + arr.get(j) + arr.get(k) > N) break;
					for(int p = k; p < arr.size(); p++){
						if(arr.get(i) + arr.get(j) + arr.get(k) + arr.get(p) == N){
							min = Math.min(min, 4);
							break;
						}
						else if(arr.get(i) + arr.get(j) + arr.get(k) + arr.get(p) > N) break;
					}
				}
			}
		}
		
		System.out.println(min);
	}
}