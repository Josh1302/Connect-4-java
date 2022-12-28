public class connect4 {

        /** Student Self-Explanation
         * In this function we need to go through the columns and rows to find the non zero values. 
         * Anytime there is a zero value we need to replace that with the player value
         * In order to accomplish this we should use two for loops to increment the through the 2d array.
         * Then check those values for zeros and replace them
         * 
         */
        public boolean play(int player, int column, int[][] board) {
            //TODO: Student
            boolean game = false;
            for(int i=5; i>=0;i--){
                if(board[i][column-1]==0){
                        board[i][column-1]=player;
                        game = true;
                        break;
                    }
                        else{
                            game =  false;
                        }
                        
                }
                return game;
            }
    
        /** Student Self-Explanation
         * In this section I need to compare each value in the array to see if anyone has 4 in a row.
         * In order to do this like in the previous method I need to use nested for loops as well as if statements to compare.     *
         * I did this for each instance to find the winner in any of the possible direction.
         * 
         * 
         */
        public int checkForWin(int[][] board) {
            //TODO: Student
            int winner = 0;
            for(int i = 0;i<=5;i++){
                for(int j = 0; j<=3;j++){
                    if(board[i][j]!=0&&board[i][j]==board[i][j+1]&&board[i][j]==board[i][j+2]&&board[i][j]==board[i][j+3]){
                        winner = board[i][j];
                        break;
                    }
                    
                    
                }
            }
            for(int i = 0;i<=2;i++){
                for(int j = 0; j<=6;j++){
                   if (board[i][j]!=0&&board[i][j]==board[i+1][j]&&board[i][j]==board[i+2][j]&&board[i][j]==board[i+3][j]){
                        winner = board[i][j];
                        break;
                   }
                   
                }
                
            }
            for(int i = 0;i<=2;i++){
                for(int j = 3; j<=3;j++){
                   if (board[i][j]!=0&&board[i][j]==board[i+1][j-1]&&board[i][j]==board[i+2][j-2]&&board[i][j]==board[i+3][j-3]){
                        winner = board[i][j];
                        break;
                   }
                   
                }
                }
                for(int i = 0;i<=2;i++){
                    for(int j = 0; j<=3;j++){
                       if (board[i][j]!=0&&board[i][j]==board[i+1][j+1]&&board[i][j]==board[i+2][j+2]&&board[i][j]==board[i+3][j+3]){
                            winner = board[i][j];
                            break;
                       }
                    }
                }
                return winner;
            }
        }
    
        
    
