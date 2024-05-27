public class Program {
    public class ChessPiece {
        private int row;
        private char column;
        private String side; // "Red" hoặc "Black"

        public ChessPiece(int row, char column, String side) {
            this.row = row;
            this.column = column;
            this.side = side;
        }

        public int getRow() {
            return row;
        }

        public char getColumn() {
            return column;
        }

        public String getSide() {
            return side;
        }

        // Phương thức kiểm tra xem quân cờ có ăn được quân cờ khác hay không.
        public boolean couldCapture(ChessPiece p) {
            return false;
        }
    }
    public class Pawn extends ChessPiece {

        public Pawn(int row, char column, String side) {
            super(row, column, side);
        }

        @Override
        public boolean couldCapture(ChessPiece p) {
            // Quân tốt chỉ ăn chéo theo hàng
            if (this.getSide().equals("Red")) {
                // Quân tốt Red đi xuống dưới
                return (p.getRow() == this.getRow() + 1) &&
                        (Math.abs(p.getColumn() - this.getColumn()) == 1);
            } else if (this.getSide().equals("Black")) {
                // Quân tốt Black đi lên trên
                return (p.getRow() == this.getRow() - 1) &&
                        (Math.abs(p.getColumn() - this.getColumn()) == 1);
            }
            return false;
        }
    }
    public class Main {
        public void main(String[] args) {
            Pawn redPawn = new Pawn(2, 'd', "Red");
            ChessPiece blackPiece = new ChessPiece(3, 'e', "Black");

            System.out.println(redPawn.couldCapture(blackPiece)); // Kết quả: true, vì quân tốt đỏ ở (2, d) có thể ăn quân ở (3, e)

            ChessPiece anotherBlackPiece = new ChessPiece(4, 'e', "Black");
            System.out.println(redPawn.couldCapture(anotherBlackPiece)); // Kết quả: false, vì quân tốt đỏ ở (2, d) không thể ăn quân ở (4, e)
        }
    }
}
