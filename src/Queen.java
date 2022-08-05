public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine, toColumn)) {
            if (line != toLine && Math.abs(toLine - line) == Math.abs(toColumn - column))   {
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
            }
            if ((line == toLine && column != toColumn) || (line != toLine && column == toColumn)) {
                int something = 0;
                if (line == toLine) {
                    if (column < toColumn) {
                        for (int i = 1; i < toColumn - column; i++) {
                            if (chessBoard.board[line][column + i] == null) something++;
                            else return false;
                        }
                    } else {
                        for (int i = 1; i < column - toColumn; i++) {
                            if (chessBoard.board[line][column - i] == null) something++;
                            else return false;
                        }
                    }
                } else {
                    if (line < toLine) {
                        for (int i = 1; i < toLine - line; i++) {
                            if (chessBoard.board[line + i][column] == null) something++;
                            else return false;
                        }
                    } else {
                        for (int i = 1; i < line - toLine; i++) {
                            if (chessBoard.board[line - i][column] == null) something++;
                            else return false;
                        }
                    }
                }
                return chessBoard.board[toLine][toColumn] == null ||
                        !color.equals(chessBoard.board[toLine][toColumn].getColor());
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
