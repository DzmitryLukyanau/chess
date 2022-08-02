public abstract class ChessPiece {
    protected String color;
    protected boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();
    protected boolean checkPos(int line, int column) {
        if (line >=0 && line <=7 && column >=0 && column <=7) return true;
        else return false;
    }
}
