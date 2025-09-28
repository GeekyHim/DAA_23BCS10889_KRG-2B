import java.util.Scanner;

public class viva{
    public static void main(String[] args) {
        String s;
        Scanner scn = new Scanner(System.in);
        s = scn.nextLine();
        int i =0,j=0, close =0, open=0, len=0, mxlen=0;
        int n = s.length();
        while(i<n){
            if(s.charAt(i)==')') close++;
            else open++;
            if(open>=close) {
                len = i-j+1;
                mxlen = Math.max(mxlen, len);
                i++;
            }
            else {
                i++;
                j = i;
                close = 0; open =0;
            }
        }
        if(open>=close){
            len = i-j;
            mxlen = Math.max(mxlen, len);
        }
        System.out.println(mxlen);
    }
}