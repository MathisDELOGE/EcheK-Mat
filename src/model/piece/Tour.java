package model.piece;

import tools.data.Coord;
import tools.data.Couleur;

import java.util.List;

public class Tour extends AbstractPiece {
    public Tour(Couleur couleur, Coord coord) {
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
