package model.piece;

import tools.BoardGameConfig;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.List;

public class Roi extends PremierMouvement {
    public Roi(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        boolean res = false;
        int deltaX = Math.abs(xFinal-this.getX());
        int deltaY = Math.abs(yFinal-this.getY());
        if (deltaX == 1 && deltaY == 1)
            if (xFinal >= 0 && xFinal <= BoardGameConfig.getNbColonne() && yFinal >= 0 && yFinal <= BoardGameConfig.getNbLigne())
                res = true;
        return res;
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        return null;
    }

    public ActionType doMove(int xFinal, int yFinal) {
        ActionType resultat = super.doMove(xFinal, yFinal);
        this.premierMove = true;
        return  resultat;
    }
}
