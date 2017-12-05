package com.zhp.leetcode.linked;

/**
 * @author zhp.dts
 * @date 2017/12/5.
 * @info 数独组合是否有效
 */
public class ValidSudoku {
    public static boolean solution(char[][] board){
        for(int i=0;i<9;i++){
            boolean [] hengHad = new boolean[9];
            boolean [] shuHad = new boolean[9];
            boolean [] kuaiHad = new boolean[9];
            int xIndex = (i/3)*3;
            int yIndex = (i%3)*3;
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(hengHad[board[i][j]-'1']){
                        return false;
                    }else{
                        hengHad[board[i][j]-'1'] = true;
                    }
                }
                if(board[j][i]!='.'){
                    if(shuHad[board[j][i]-'1']){
                        return false;
                    }else{
                        shuHad[board[j][i]-'1'] = true;
                    }
                }
                int x=xIndex+j/3;
                int y =yIndex+j%3;
                if(board[x][y]!='.'){
                    if(kuaiHad[board[x][y]-'1']){
                        return false;
                    }else{
                        kuaiHad[board[x][y]-'1'] = true;
                    }
                }

            }
        }
        return true;
    }
    public static void main(String[] args){
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution(board));
    }
}
