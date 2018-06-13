package model.piece;

import tools.BoardGameConfig;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.List;

public class Tour extends AbstractPiece {
    public Tour(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        boolean res = false;
        if ((xFinal == this.getX() && yFinal != this.getY()) || (yFinal == this.getX() && xFinal != this.getX()));
            if (xFinal >= 0 && xFinal <= BoardGameConfig.getNbColonne() && yFinal >= 0 && yFinal <= BoardGameConfig.getNbLigne())
                res = true;
        return res;
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        return null;
    }
}
