import java.util.Scanner;

public class RegexMatcher {

    static boolean isValidPattern(String pattern){

        if(pattern.length() == 0 || pattern.charAt(0) == '+')
            return false;
        

        for(int i = 0; i < pattern.length(); i++){


            char ch = pattern.charAt(i);

            if(!(ch >= 'A' && ch <= 'Z') && ch != '+')
                return false;

            if(i > 0 && ch == '+' && pattern.charAt(i - 1) == '+')
                return false;
        }
            return true;
     }

     static boolean isMatch(String text, String pattern){

        int i = 0, j = 0;

        while(j < pattern.length()){

            if(j + 1 < pattern.length() && pattern.charAt(j + 1) == '+'){

                char ch = pattern.charAt(j);

                if(i >= text.length() || text.charAt(i) != ch)
                    return false;

                while(i < text.length() && text.charAt(i) == ch){
                    i++;
                }

                    j += 2;
                }

                else {
                    if(i >= text.length() || text.charAt(i) != pattern.charAt(j))
                        return false;

                    i++;
                    j++;
                }

            }

           return i == text.length(); 
        }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);

            String P = sc.next();
            String Q = sc.next();

            if(!isValidPattern(Q))
                System.out.println("Invalid Pattern");
            else if(isMatch(P, Q))
                System.out.println("True");
            else
                System.out.println("False");

            sc.close();
        }


     }