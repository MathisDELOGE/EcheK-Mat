package model.piece;

import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.List;

public class Pion extends PremierMouvement  {
    public Pion(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        boolean resultat=false;
        if(this.getX()== xFinal && this.getY() < yFinal) {
            if(yFinal <= (this.getY()+2) && !this.hasMoved()){
                resultat = true;
            }else if(yFinal <= (this.getY()+1)){
                resultat = true;
            }
        }
        return resultat;
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
