import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[10001];
    	
    	while(--N >= 0) {
    		int num = Integer.parseInt(br.readLine());
    		arr[num] += 1;
    	}
    	
    	for(int i = 1; i <= 10000; i++)
    		while(--arr[i] >= 0) bw.write(i + "\n");
    	
    	bw.flush();
	}
}