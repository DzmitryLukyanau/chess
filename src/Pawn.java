public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (color == "White") {
            return whiteCanMoveToPosition(chessBoard, line, column, toLine, toColumn);
        } else return blackCanMoveToPosition(chessBoard, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    public boolean whiteCanMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toColumn == column && toLine > line && chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (line == 1) {
                return toLine - line <= 2;
            } else return toLine - line == 1;
        } else return false;
    }

    private boolean blackCanMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toColumn == column && toLine < line && checkPos(toLine, toColumn)) {
            if (line == 6) {
                return line - toLine <= 2;
            } else return line - toLine == 1;
        } else return false;
    }
}
