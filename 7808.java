import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(sc.hasNextLine()) {
    		char[] ch = sc.nextLine().toCharArray();
    		int len = sc.nextInt();
    		int[] key = new int[len + 1];
    		for(int i = 0; i < len; i++)
    			key[sc.nextInt()] = i;
    		
    		sc.nextLine();
    		
    		int h = ch.length / len + (ch.length % len > 0 ? 1 : 0), w = len, idx = 0;
    		String[][] map = new String[h][w];
    		
    		for(int i = 0; i < h; i++)
    			for(int j = 0; j < w; j++) {
    				if(idx < ch.length) map[i][j] = ch[idx++] + "";
    				else map[i][j] = "not";
    			}
    		
    		
    		for(int i = 1; i <= len; i++){
    			int num = key[i];
    			
    			for(int j = 0; j < h; j++)
    				System.out.print(map[j][num].equals("not") ? "" : map[j][num]);
    		}
    		System.out.println();
    	}
	}
}