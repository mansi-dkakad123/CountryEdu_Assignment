import java.util.Scanner;

public class NQueenProblem {

    static int totalSolutions = 0;

    static void placeQueen(int row, int n, boolean[] cols, boolean[] mainDiagonal, boolean[] antiDiagonal){

        if(row == n){
            totalSolutions++;
            return ;
        }

        for(int c = 0; c < n; c++){

            int main = row - c + n - 1;
            int anti = row + c;
            

            if(cols[c] || mainDiagonal[main] || antiDiagonal[anti]){
                continue;
            }

            cols[c] = true;
            mainDiagonal[main] = true;
            antiDiagonal[anti] = true;

            placeQueen(row + 1, n, cols, mainDiagonal, antiDiagonal);

            cols[c] = false;
            mainDiagonal[main] = false;
            antiDiagonal[anti] = false;

            }
        }


        public static void main(String[] args){

        Scanner sc =  new Scanner(System.in);

        int n = sc.nextInt();

        boolean[] cols = new boolean[n];
        boolean[] mainDiagonal = new boolean[2 * n - 1];
        boolean[] antiDiagonal = new boolean[2* n - 1];

        placeQueen(0, n, cols, mainDiagonal, antiDiagonal);

        System.out.println(totalSolutions);

        sc.close();
        }
    }
