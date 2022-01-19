import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		int N = sc.nextInt();
        	int M = sc.nextInt();
        	int K = sc.nextInt();
        	
        	if(N == 0) break;
        	
        	char[] board = sc.next().toCharArray();
        	int[] player = new int[N];
        	Arrays.fill(player, -1);
        	boolean end = false;
        	
        	int idx = 0;
        	for(int i = 0; i < K; i++) {
        		char[] ch = sc.next().toCharArray();
        		
        		int chIdx = 0;
        		for(int j = player[idx] + 1; j < M; j++) {
        			if(board[j] == ch[chIdx]) {
        				player[idx] = j;
        				++chIdx;
        			}
        			if(chIdx == ch.length) break;
        		}
        		
        		if(!end && (chIdx < ch.length || player[idx] == M - 1)) {
        			end = true;
        			System.out.println("Player " + (idx + 1) + " won after " + (i + 1) + " cards.");
        		}
        		++idx;
        		if(idx == N) idx = 0;
        	}
        	
        	if(!end) System.out.println("No player won after " + K + " cards.");
    	}
    }
}