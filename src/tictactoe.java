import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        char[][] board=new char[3][3];
        int xscore=0;
        int yscore=0;



        boolean play=true;
        while (play) {
            for (int i = 0; i <board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    board[i][j] = ' ';

                }
            }
            char player='O';
            boolean gameover=false;
            while(!gameover){
                display(board);
                System.out.println(player + " place your move");
                int row=in.nextInt();
                int col=in.nextInt();
                if(isvalid(row,col,board) && board[row][col]==' '  ){
                    board[row][col]=player;
                    gameover=iswon(board,player);
                    if(gameover){
                        System.out.println("player :" + player + " has won");
                        if(player=='X')
                            xscore++;
                        else {
                            yscore++;
                        }

                    }
                    else if(isDraw(board)){
                        System.out.println("game is draw");
                    }
                    else{
                        player=player=='O'?'X':'O';
                    }
                }
                else{
                    System.out.println("invalid move");
                }
            }
            display(board);
            System.out.println(" game is completeed you want to play one more(y/n)");
            System.out.println(" score of x is "+ xscore+ " and score of O is " +yscore);
            char ch=in.next().charAt(0);
            play=(ch=='Y'|| ch=='y');



        }



    }

    private static boolean isDraw(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }


    private static boolean iswon(char[][] board, char player) {
        for (int i = 0; i <board.length; i++) {
            if(board[i][0]==player && board[i][1]==player && board[i][2]==player)
                return true;

            if(board[0][i]==player && board[1][i]==player && board[2][i]==player)
                return true;





            }
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player)
            return true;

        if(board[0][2]==player && board[1][1]==player && board[2][0]==player)
            return true;
        return false;
    }

    private static boolean isvalid(int row, int col, char[][] board) {
        if(row<0 || col<0 || row>board.length-1|| col>board[0].length-1){
            return false;
        }
        return true;
    }


    public static void display(char[][] board){
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print ( " "+board[i][j] +" |");

            }
            System.out.println();

        }
    }
}
