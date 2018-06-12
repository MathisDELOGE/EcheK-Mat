package model.business;

import model.ChessGameImplementor;
import model.ChessImplementor;
import tools.BoardGameConfig;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.List;

public class ChessModel implements ChessGameModel {
    private Couleur colorCurrentPlayer;
    private ChessGameImplementor chessImplementor;

    public ChessModel() {
        colorCurrentPlayer = BoardGameConfig.getBeginColor();
        chessImplementor = new ChessImplementor();
        System.out.println(this);
    }

    @Override
    public Couleur getColorCurrentPlayer() { return colorCurrentPlayer;
    }

    @Override
    public Couleur getPieceColor(int x, int y) {
        return null;
    }

    @Override
    public List<Coord> getPieceListMoveOK(int xInit, int yInit) {
        return null;
    }

    //TODO : reprendre le action type
    @Override
    public ActionType move(int xInit, int yInit, int xFinal, int yFinal) {
        System.out.println("Deplacement de "+xInit+","+yInit+" à "+xFinal+","+yFinal);
        return ActionType.MOVE;
    }

    @Override
    public boolean pawnPromotion(int x, int y, String promotionType) {
        return false;
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public String toString() {
        return this.colorCurrentPlayer.toString();
    }
}
