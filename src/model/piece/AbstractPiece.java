package model.piece;

import tools.data.ActionType;
import tools.data.Couleur;

public abstract class AbstractPiece implements Pieces {
    private int x,y;
    private Couleur couleur;
    private String name;

    @Override
    public String toString() {
        this.x = getX();
        this.y = getX();
        this.name = getName();
        return (this.x+this.y+this.name);
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
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
        return null;
    }

    @Override
    public boolean catchPiece() {
        return false;
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType type) {
        return false;
    }

    @Override
    public boolean undoLastMove() {
        return false;
    }

    @Override
    public boolean undoLastCatch() {
        return false;
    }
}
