public class Interface {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves();

        // Rook r = new Rook();
        // r.moves();
    }
}


interface ChessPlayer{
    void moves();
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("Moves in all directions");
    }
}

class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("Moves in straight lines");
    }
}