import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int count0 = 0, count1 = 0;
        char st = s.charAt(0);
        
        if(st == '0') {
            count1++;
        } else {
            count0++;
        }
        
        for(int i=1; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c != st) {
                if(c == '0') {
                    count1++;
                } else {
                    count0++;
                }
            }
            st = c;
        }
        
        System.out.println(Math.min(count0, count1));
        
    }
}