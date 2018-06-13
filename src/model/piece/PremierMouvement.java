package model.piece;

import tools.data.Coord;
import tools.data.Couleur;

public abstract class PremierMouvement extends AbstractPiece implements MemoriseSonPremierMouvement {

    protected boolean premierMove=false;

    public PremierMouvement(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean hasMoved() {
        return premierMove;
    }
}
