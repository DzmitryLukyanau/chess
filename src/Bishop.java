public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line != toLine && checkPos(toLine, toColumn) &&
                Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            int nothing = 0;
            if (toLine > line) {
                if (toColumn > column) {
                    for (int i = 1; i < toLine - line; i++) {
                        if (chessBoard.board[line + i][column + i] == null) nothing++;
                        else return false;
                    }

                } else {
                    for (int i = 1; i < toLine - line; i++) {
                        if (chessBoard.board[line + i][column - i] == null) nothing++;
                        else return false;
                    }
                }
            } else {
                if (toColumn > column) {
                    for (int i = 1; i < line - toLine; i++) {
                        if (chessBoard.board[line - i][column + i] == null) nothing++;
                        else return false;
                    }
                } else {
                    for (int i = 1; i < line - toLine; i++) {
                        if (chessBoard.board[line - i][column - i] == null) nothing++;
                        else return false;
                    }
                }
            }
            return chessBoard.board[toLine][toColumn] == null ||
                    !color.equals(chessBoard.board[toLine][toColumn].getColor());
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
