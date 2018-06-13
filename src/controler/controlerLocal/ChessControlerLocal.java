package controler.controlerLocal;

import controler.ChessGameControlerModelVue;
import model.business.ChessGameModel;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;
import vue.ChessGameGUI;
import vue.ChessGridGUI;

import javax.swing.*;

public class ChessControlerLocal implements ChessGameControlerModelVue{
    private ChessGameModel chessModel;
    private ChessGameGUI chessGridGUI;

    public ChessControlerLocal(ChessGameModel chessGame) {
        this.chessGridGUI = new ChessGridGUI();
        this.chessModel=chessGame;
    }

    @Override
    public void setGridPanel(ChessGameGUI panel) {

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
        chessGridGUI.setPieceToMove(pieceToMoveCoord);
    }

    @Override
    public void actionsWhenPieceIsMovedOnGUI(Coord pieceToMoveCoord, Coord targetCoord) {
        int xDeb,yDeb,xFin,yFin;
        xDeb = pieceToMoveCoord.getX();
        yDeb = pieceToMoveCoord.getY();
        xFin = targetCoord.getX();
        yFin = targetCoord.getY();

        if (chessModel.move(xDeb,yDeb,xFin,yFin) == ActionType.ILLEGAL)
            chessGridGUI.undoMovePiece(targetCoord);
    }


    public void setChessGridGUI(ChessGameGUI chessGridGUI) {
        this.chessGridGUI = chessGridGUI;
    }
}
