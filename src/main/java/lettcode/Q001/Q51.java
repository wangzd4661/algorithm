package lettcode.Q001;

import java.util.*;

public class Q51 {
    public static void main(String[] args) {
        Q51 q=new Q51();
        q.solveNQueens(4);
        System.out.println(q.res.toString());
    }

    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i],'.');
        }
        backTrack(board,n,0);
        return res;
    }

    public void backTrack(char[][] board, int n, int row) {
        if (row == board.length) {
            List<String> text=new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                String s= String.valueOf(board[i]);
                text.add(s);
            }
            res.add(text);
            return;
        }
        for (int col = 0; col < n; col++) {
            if(!isOk(board,row,col,n))continue;
            board[row][col]='Q';
            backTrack(board,n,row+1);
            board[row][col]='.';
        }
    }

    public boolean isOk(char[][] board, int row, int col,int n) {
        //一行一行放，只需检查上方，左上方，右上方。
        for (int i = 0; i < board.length; i++) {
            if(board[i][col]=='Q')return false;
        }
        for (int i = row-1,j=col-1; i>=0&&j>=0; i--,j--) {
            if(board[i][j]=='Q')return false;
        }
        for (int i = row-1,j=col+1; i>=0&&j< n; i--,j++) {
            if(board[i][j]=='Q')return false;
        }
        return true;
    }
}
