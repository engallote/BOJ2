import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Q = Integer.parseInt(br.readLine());
        
        while(--Q >= 0) {
        	int N = Integer.parseInt(br.readLine());
        	
        	if((N & (-N)) == N) bw.write("1");
        	else bw.write("0");
        	bw.newLine();
        }
        bw.flush();
    }
}