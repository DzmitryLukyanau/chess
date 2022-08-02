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
        if (!checkPos(toLine, toColumn)) return false;
        if ((line != toLine && Math.abs(toLine-line) == Math.abs(toColumn-column)) ||
                (line == toLine && column !=toColumn) || (line != toLine && column ==toColumn)) {
            return true;
        } else return false;

    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
