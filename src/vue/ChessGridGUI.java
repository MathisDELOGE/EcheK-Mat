package vue;

import tools.BoardGameConfig;
import tools.data.ChessPiecePos;
import tools.data.Coord;
import tools.data.Couleur;
import tools.factory.ChessImageProvider;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessGridGUI  extends JLayeredPane implements ChessGameGUI {
    private int ligne = BoardGameConfig.getNbLigne();
    private int colonne = BoardGameConfig.getNbColonne();
    private Map<Coord, ChessSquareGUI> map;
    private ChessPieceGUI chessPieceGUI;
    private ChessSquareGUI chessSquareGUI;

    public ChessGridGUI ()
    {
        ChessSquareGUI square = null;
        ChessPieceGUI chessPieceGUI = null;
        int index;

        this.setLayout(new GridLayout(ligne, colonne));

        map = new HashMap<Coord, ChessSquareGUI>();
        //Mettre en place le quadrillage Noir/Blanc du plateau
        for (int i = 0; i < ligne; i++)
        {
            for (int j = 0; j < colonne; j++)
            {
                if ((j%2 == 0 && i%2 == 0) || (j%2 != 0 && i%2 != 0))
                {
                    //Couleur Blanche
                    square = new ChessSquareGUI(i, j, BoardGameConfig.getWhiteSquareColor());
                } else
                {
                    //Couleur Noire
                    square = new ChessSquareGUI(i, j, BoardGameConfig.getBlackSquareColor());
                }
                this.add(square);
                map.put(square.getCoord(), square);
            }
        }

        //Mise en place des pions sur les cases
        for (int i = 0; i < ChessPiecePos.values().length; i++)
        {
            for (int j = 0; j < ChessPiecePos.values()[i].coords.length; j++)
            {
                chessPieceGUI = new ChessPieceGUI(
                        ChessPiecePos.values()[i].couleur,
                        new ImageIcon(
                                ChessImageProvider.getImageFile(
                                        ChessPiecePos.values()[i].nom,
                                        ChessPiecePos.values()[i].couleur
                                )
                        ));
                index = ChessPiecePos.values()[i].coords[j].getY()*8+ChessPiecePos.values()[i].coords[j].getX();
                square = (ChessSquareGUI) this.getComponent(index);
                square.add(chessPieceGUI);
            }
        }
    }

    //Récupération des coordonnées de l'événement
    public Coord getSquareCoord(int x, int y)
    {
        Component c = this.findComponentAt(x, y);
        ChessSquareGUI square = (ChessSquareGUI) c.getParent();
        return square.getCoord();
    }

    //Récupération de la couleur selon les coordonnées choisies
    public Couleur getCouleur(Coord coord)
    {
        Component c = this.findComponentAt(coord.getX(), coord.getY());
        ChessPieceGUI piece = (ChessPieceGUI) c.getParent();
        return piece.getCouleur();
    }

    @Override
    public void setPieceToMove(Coord coord) {
        chessSquareGUI = map.get(coord);
        chessPieceGUI = (ChessPieceGUI) chessSquareGUI.getComponent(0);
    }

    @Override
    public void resetLight(List<Coord> coords, boolean isLight) {

    }

    @Override
    public void movePiece(Coord targetCoord) {
        chessSquareGUI = map.get(targetCoord);
        chessSquareGUI.removeAll();
        chessSquareGUI.add(chessPieceGUI);
    }

    @Override
    public void undoMovePiece(Coord pieceToMoveInitCoord) {
        chessSquareGUI = map.get(pieceToMoveInitCoord);
        chessSquareGUI.removeAll();
        chessSquareGUI.add(chessPieceGUI);
    }

    @Override
    public String getPromotionType() {
        return null;
    }

    @Override
    public void promotePiece(Coord coord, String promotionType) {

    }
}
