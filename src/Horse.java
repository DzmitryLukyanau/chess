public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine, toColumn) && ((Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 1) ||
                (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 2))) {
            return chessBoard.board[toLine][toColumn] == null || !color.equals(chessBoard.board[toLine][toColumn].getColor());

        } else return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

}
