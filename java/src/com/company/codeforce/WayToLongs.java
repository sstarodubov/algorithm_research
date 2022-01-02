import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class WayToLongs {
    public static void main(String[] args) {
       var sc = new Scanner(System.in);
       
       int size = sc.nextInt();

       while (sc.hasNext()) {
            String word = sc.next();
            if (word.length() <= 10) {
                System.out.println(word);
                continue;
            } 
            int n = word.length() - 2;
            System.out.println(String.valueOf(word.charAt(0)) + n + String.valueOf(word.charAt(word.length() - 1)));
       }

       sc.close();
    }    
}
