import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String notLast = "QWE";
		HashSet<String> hs = new HashSet<>();
		init(hs);
		
		char[] ch = sc.nextLine().toCharArray();
		
		int res = 0;
		boolean f = false, m = false, l = false, l2 = false;
		char lc = '.', lc2 = '.';
		for(int i = 0; i < ch.length; i++){
			if(ch[i] == ' ') f = m = l = l2 = false;
			else{
				if(hs.contains(ch[i]+"")){//초성 or 종성
					if(!f){//초성
						f = true;
						m = l = l2 = false;
						lc = lc2 = '.';
					}
					else{//종성
						if(notLast.contains(ch[i]+"")){//종성에 오면 안 되는 애들
							f = true;
							m = l = l2 = false;
							lc = lc2 = '.';
						}
						else{
							if(l){
								if(l2){//다 찼다
									f = true;
									m = l = l2 = false;
									lc = lc2 = '.';
								}
								else{
									if(isOk(lc, ch[i])){
										l2 = true;
										lc2 = ch[i];
									}
									else{
										f = true;
										m = l = l2 = false;
										lc = lc2 = '.';
									}
								}
							}
							else {
								l = true;
								lc = ch[i];
								l2 = false;
								lc2 = '.';
							}
						}
					}
				}
				else{//중성
					if(l || l2){//종성에 잇기(도깨비불)
						l = l2 = false;
						lc = lc2 = '.';
						m = true;
						++res;
					}
					else m = true;
				}
			}
		}
		
		System.out.println(res);
	}

	private static boolean isOk(char lc, char c) {
		if(lc == 'f'){//ㅀ, ㄺ, ㄼ, ㄻ, ㄾ, ㄿ, ㄽ
			if(c == 't' || c == 'g' || c == 'r' || c == 'q' || c == 'a' || c == 'x' || c == 'v') return true;
		}
		else if(lc == 'r' && c == 't') return true;//ㄳ
		else if(lc == 'q' && c == 't') return true;//ㅄ
		else if(lc == 's' && (c == 'w' || c == 'g')) return true;//ㄵ, ㄶ
		return false;
	}

	private static void init(HashSet<String> hs) {
		hs.add("q");
		hs.add("w");
		hs.add("e");
		hs.add("r");
		hs.add("t");
		hs.add("a");
		hs.add("s");
		hs.add("d");
		hs.add("f");
		hs.add("g");
		hs.add("z");
		hs.add("x");
		hs.add("c");
		hs.add("v");
		
		hs.add("Q");
		hs.add("W");
		hs.add("E");
		hs.add("R");
		hs.add("T");
	}
}