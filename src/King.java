public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine, toColumn) && (line != toLine || column != toColumn) &&
                Math.abs(toLine - line) <= 1 && Math.abs(toColumn - column) <= 1) {
            return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (!color.equals(board.board[i][j].getColor()) &&
                        board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                    return true;
                }
            }
        return false;
    }
}
