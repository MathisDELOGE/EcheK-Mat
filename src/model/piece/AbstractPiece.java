package model.piece;

import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

public abstract class AbstractPiece implements Pieces {
    private Coord coord;
    private Couleur couleur;
    private String name;
    private Coord oldCoord;

    @Override
    public String toString() {
        this.name = getName();
        return (this.name+","+this.coord.getX()+","+this.coord.getY());
    }

    @Override
    public int getX() {
        return this.coord.getX();
}

    @Override
    public int getY() {
        return this.coord.getY();
    }

    @Override
    public Couleur getCouleur() {
        return this.couleur;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public ActionType doMove(int xFinal, int yFinal) {
        this.oldCoord.setCoord(this.coord.getX(),this.coord.getY());
        this.coord.setX(xFinal);
        this.coord.setY(yFinal);
        return ActionType.MOVE; //temporaire - non défini
    }

    @Override
    public boolean catchPiece() {
        boolean resultat = false;
        this.oldCoord.setCoord(this.coord.getX(),this.coord.getY());
        this.coord.setX(-1);
        this.coord.setY(-1);
        if(coord.getX()== -1 && coord.getY()==-1){
            resultat = true;
        }
        return resultat;
    }

    //todo : qu'est ce que c'est cette merde ?
    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType type) {
            return false;
    }

    @Override
    public boolean undoLastMove() {
        boolean resultat=false;
        this.coord.setCoord(this.oldCoord.getX(),this.oldCoord.getY());
        if(this.coord.equals(this.oldCoord)){
            resultat = true;
        }
        return resultat;
    }

    @Override
    public boolean undoLastCatch() {
        boolean resultat=false;
        this.coord.setCoord(this.oldCoord.getX(),this.oldCoord.getY());
        if(this.coord.equals(this.oldCoord)){
            resultat = true;
        }
        return resultat;
    }
}
