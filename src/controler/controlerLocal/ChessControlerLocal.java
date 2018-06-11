package controler.controlerLocal;

import controler.ChessGameControlerModelVue;
import model.business.ChessGameModel;
import tools.data.Coord;
import tools.data.Couleur;

import javax.swing.*;

public class ChessControlerLocal implements ChessGameControlerModelVue{
    public ChessControlerLocal(ChessGameModel chessGame) {
    }

    @Override
    public void setGridPanel(JLayeredPane panel) {

    }

    @Override
    public boolean isPlayerOk(Couleur pieceToMoveCouleur) {

        return false;
    }

    @Override
    public void actionsWhenPieceIsSelectedOnGUI(Coord pieceToMoveCoord, Couleur pieceToMoveCouleur) {

    }

    @Override
    public void actionsWhenPieceIsMovedOnGUI(Coord pieceToMoveCoord, Coord targetCoord) {

    }
}
