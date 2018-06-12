package controler.controlerLocal;

import controler.ChessGameControlerModelVue;
import model.business.ChessGameModel;
import tools.data.Coord;
import tools.data.Couleur;

import javax.swing.*;

public class ChessControlerLocal implements ChessGameControlerModelVue{
    private ChessGameModel chessModel;

    public ChessControlerLocal(ChessGameModel chessGame) {
        this.chessModel=chessGame;
    }

    @Override
    public void setGridPanel(JLayeredPane panel) {

    }

    //Vérification de la couleur récupérée
    @Override
    public boolean isPlayerOk(Couleur pieceToMoveCouleur) {
        boolean resultat;
        if(pieceToMoveCouleur == this.chessModel.getColorCurrentPlayer()){
            resultat = true;
        } else{ resultat = false;}
        return resultat;
    }

    @Override
    public void actionsWhenPieceIsSelectedOnGUI(Coord pieceToMoveCoord, Couleur pieceToMoveCouleur) {

    }

    @Override
    public void actionsWhenPieceIsMovedOnGUI(Coord pieceToMoveCoord, Coord targetCoord) {

    }
}
