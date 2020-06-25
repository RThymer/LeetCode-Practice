public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[][] visited = new boolean[row][col];
                boolean found = deepSearch(board, visited, i, j, word, 0);
                if (found) return true;
            }
        }
        return false;
    }

    private boolean deepSearch(char[][] board, boolean[][] visited,
                               int xPos, int yPos, String word, int stringIndex) {
        int row = board.length, col = board[0].length;
        if (stringIndex == word.length()) return true;
        else if (xPos < 0 || yPos < 0 || xPos >= row || yPos >= col
                || visited[xPos][yPos] || word.charAt(stringIndex) != board[xPos][yPos]) {
            return false;
        } else {
            visited[xPos][yPos] = true;

            boolean left = deepSearch(board, visited, xPos - 1, yPos, word, stringIndex + 1);
            boolean right = deepSearch(board, visited, xPos + 1, yPos, word, stringIndex + 1);
            boolean up = deepSearch(board, visited, xPos, yPos + 1, word, stringIndex + 1);
            boolean down = deepSearch(board, visited, xPos, yPos - 1, word, stringIndex + 1);

            if (left || right || up || down) return true;
            else {
                visited[xPos][yPos] = false;
                return false;
            }
        }
    }
}
