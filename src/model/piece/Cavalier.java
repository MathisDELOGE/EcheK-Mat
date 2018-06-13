package model.piece;

import tools.data.Coord;
import tools.data.Couleur;

import java.util.List;

public class Cavalier extends AbstractPiece {
    public Cavalier(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        return false;
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        return null;
    }
}
