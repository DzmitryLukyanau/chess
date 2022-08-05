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
        if (color.equals("White")) {
            return whiteCanMoveToPosition(chessBoard, line, column, toLine, toColumn);
        } else return blackCanMoveToPosition(chessBoard, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    public boolean whiteCanMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toColumn == column && toLine > line && checkPos(toLine, toColumn) &&
                chessBoard.board[line + 1][toColumn] == null) {
            if (line == 1 && toLine - line == 2 && chessBoard.board[line + 2][toColumn] == null) {
                return true;
            } else return toLine - line == 1;
        } else {
            if (Math.abs(column - toColumn) == 1 && toLine - line == 1 &&
                    chessBoard.board[toLine][toColumn] != null) {
                return !color.equals(chessBoard.board[toLine][toColumn].getColor());
            } else return false;
        }
    }

    private boolean blackCanMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toColumn == column && toLine < line && checkPos(toLine, toColumn) &&
                chessBoard.board[line - 1][toColumn] == null) {
            if (line == 6 && line - toLine == 2 && chessBoard.board[line - 2][toColumn] == null) {
                return true;
            } else return line - toLine == 1;
        } else {
            if (Math.abs(column - toColumn) == 1 && line - toLine == 1 &&
                    chessBoard.board[toLine][toColumn] != null) {
                return !color.equals(chessBoard.board[toLine][toColumn].getColor());
            } else return false;
        }
    }
}
