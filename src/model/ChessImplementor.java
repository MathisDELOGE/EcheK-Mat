package model;

import model.piece.Pieces;
import tools.data.Couleur;
import tools.factory.ChessPiecesFactory;

import java.util.LinkedList;
import java.util.List;

public class ChessImplementor extends ChessGameImplementor {
    private List<Pieces> listePiecesNoires = null, listePiecesBlanches = null;

    public ChessImplementor(){
        listePiecesBlanches = new LinkedList<>();
        listePiecesNoires = new LinkedList<>();

        listePiecesBlanches.addAll(ChessPiecesFactory.newPieces(Couleur.BLANC));
        listePiecesNoires.addAll(ChessPiecesFactory.newPieces(Couleur.NOIR));
        System.out.println(this);
    }

    @Override
    public String toString() {
        return listePiecesNoires+","+listePiecesBlanches;
    }
}
