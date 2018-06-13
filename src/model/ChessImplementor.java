package model;

import model.piece.Pieces;
import tools.data.ActionType;
import tools.data.Couleur;
import tools.factory.ChessPiecesFactory;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class ChessImplementor implements ChessGameImplementor {
    private List<Pieces> listePiecesNoires = null, listePiecesBlanches = null;

    public ChessImplementor(){
        //Création des listes de pièces
        listePiecesBlanches = new LinkedList<>();
        listePiecesNoires = new LinkedList<>();

        //Ajout de tous les pionts blancs et noirs aux listes
        listePiecesBlanches.addAll(ChessPiecesFactory.newPieces(Couleur.BLANC));
        listePiecesNoires.addAll(ChessPiecesFactory.newPieces(Couleur.NOIR));
        System.out.println(this);
    }

    @Override
    public String toString() {
        return listePiecesNoires+","+listePiecesBlanches;
    }

    public ActionType move(int xInit, int yInit, int xFinal, int yFinal) {
        ActionType res = ActionType.ILLEGAL;
        Pieces movePiece = getPieceAtPos(xInit, yInit);
        if (movePiece.isAlgoMoveOk(xFinal, yFinal))
        {
            res = ActionType.MOVE;
            movePiece.doMove(xFinal, yFinal);
        }
        return res;
    }
    //todo : parcourir les pièces
    public Pieces getPieceAtPos(int x, int y){
        Pieces res = null;
        for (Pieces p: listePiecesBlanches) {
            if(p.getX() == x && p.getY() == y)
                res = p;
        }
        for (Pieces p: listePiecesNoires) {
            if(p.getX() == x && p.getY() == y)
                res = p;
        }
        return res;
    }
}
