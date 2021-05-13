import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int N = Integer.parseInt(br.readLine());
    	char[] ch = br.readLine().trim().toCharArray();
    	boolean flag = false;
    	
    	int res = 0, num = 0, op = 4;
    	for(int i = 0; i < ch.length; i++) {
    		if(ch[i] >= '0' && ch[i] <= '9') {
    			num *= 10;
    			num += ch[i] - '0';
    			continue;
    		}
    		
    		if(op == 4) res = num;
    		else if(op == 0) res -= num;
    		else if(op == 1) res *= num;
    		else if(op == 2) res /= num;
    		else if(op == 3) res += num;
    		
    		if(ch[i] == 'C') {
    			flag = true;
    			bw.write(res + " ");
    			op = 6;
    			continue;
    		}
    		
    		if(ch[i] == 'S') op = 0;
    		else if(ch[i] == 'M') op = 1;
    		else if(ch[i] == 'U') op = 2;
    		else if(ch[i] == 'P') op = 3;
    		num = 0;
    	}
    	
    	if(!flag) bw.write("NO OUTPUT");
    	bw.flush();
	}
}