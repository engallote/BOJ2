import java.util.*;

public class Main {
	static HashMap<Integer, String> hs = new HashMap<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        hs.put(1000, "M");
        hs.put(900, "CM");
        hs.put(500, "D");
        hs.put(400, "CD");
        hs.put(100, "C");
        hs.put(90, "XC");
        hs.put(50, "L");
        hs.put(40, "XL");
        hs.put(10, "X");
        hs.put(9, "IX");
        hs.put(5, "V");
        hs.put(4, "IV");
        
        while(--T >= 0){
        	char[] ch = sc.next().toCharArray();
        	
        	if(ch[0] >= '0' && ch[0] <= '9') System.out.println(findRome(ch));
        	else System.out.println(findNum(ch));
        }
    }

	private static String findRome(char[] ch) {
		StringBuilder ans = new StringBuilder();
		int num = Integer.parseInt(new String(ch)), cnt = 0;
		
		while(num > 0){
			if(num / 1000 > 0) num = cal(num, 1000, ans);
			if(num / 900 > 0) num =  cal(num, 900, ans);
			if(num / 500 > 0) num = cal(num, 500, ans);
			if(num / 400 > 0) num = cal(num, 400, ans);
			if(num / 100 > 0) num = cal(num, 100, ans);
			if(num / 90 > 0) num = cal(num, 90, ans);
			if(num / 50 > 0) num = cal(num, 50, ans);
			if(num / 40 > 0) num = cal(num, 40, ans);
			if(num / 10 > 0) num = cal(num, 10, ans);
			if(num / 9 > 0) num = cal(num, 9, ans);
			if(num / 5 > 0) num = cal(num, 5, ans);
			if(num / 4 > 0) num = cal(num, 4, ans);
			if(num < 4){
				while(--num >= 0) ans.append("I");
				break;
			}
		}
		
		return ans.toString();
	}

	private static int cal(int num, int div, StringBuilder ans) {
		int cnt = num / div;
		num %= div;
		while(--cnt >= 0) ans.append(hs.get(div));
		return num;
	}

	private static int findNum(char[] ch) {
		int num = 0;
		boolean[] chk = new boolean[ch.length];
		
		for(int i = 0; i < ch.length; i++){
			if(chk[i]) continue;
			if(ch[i] == 'M') num += 1000;
			else if(ch[i] == 'D') num += 500;
			else if(ch[i] == 'C'){
				if(i + 1 < ch.length && ch[i+1] == 'D'){
					chk[i+1] = true;
					num += 400;
				}
				else if(i + 1 < ch.length && ch[i+1] == 'M'){
					chk[i+1] = true;
					num += 900;
				}
				else num += 100;
			}
			else if(ch[i] == 'L'){
				num += 50;
			}
			else if(ch[i] == 'X'){
				if(i + 1 < ch.length && ch[i+1] == 'L'){
					chk[i+1] = true;
					num += 40;
				}
				else if(i + 1 < ch.length && ch[i+1] == 'C'){
					chk[i+1] = true;
					num += 90;
				}
				else num += 10;
			}
			else if(ch[i] == 'V') num += 5;
			else if(ch[i] == 'I'){
				if(i + 1 < ch.length && ch[i+1] == 'V'){
					chk[i+1] = true;
					num += 4;
				}
				else if(i + 1 < ch.length && ch[i+1] == 'X'){
					chk[i+1] = true;
					num += 9;
				}
				else num += 1;
			}
		}
		
		
		return num;
	}
}