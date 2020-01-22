import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.next().split(":");
		String[] res = new String[8];
		Arrays.fill(res, "");
		int idx = 0;
		for(int i = 0; i < str.length; i++){
			if(str[i].equals("")){//0000
				toLeft(str, res);
				break;
			}
			else{
				for(int j = 0; j < 4 - str[i].length(); j++) res[idx] += "0";
				res[idx] += str[i];
				++idx;
			}
		}
		
		for(int i = 0; i < 8; i++){
			if(res[i].equals("")) System.out.print("0000");
			if(i == 7){
				System.out.println(res[i]);
				break;
			}
			else System.out.print(res[i]);
			System.out.print(":");
		}
	}

	private static void toLeft(String[] str, String[] res) {
		int idx = 7;
		for(int i = str.length - 1; i >= 0; i--){
			if(str[i].equals("")) return;
			for(int j = 0; j < 4 - str[i].length(); j++) res[idx] += "0";
			res[idx] += str[i];
			--idx;
		}
	}
}