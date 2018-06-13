package model.piece;

import tools.BoardGameConfig;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.List;

public class Fou extends AbstractPiece {
    public Fou(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        boolean res = false;
        int deltaX = Math.abs(xFinal-this.getX());
        int deltaY = Math.abs(yFinal-this.getY());
        if (deltaX != 0 && deltaY != 0 && deltaX == deltaY);
            if (xFinal >= 0 && xFinal <= BoardGameConfig.getNbColonne() && yFinal >= 0 && yFinal <= BoardGameConfig.getNbLigne())
                res = true;
        return res;
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        return null;
    }
}
