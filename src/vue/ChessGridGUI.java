package vue;

import tools.BoardGameConfig;
import tools.data.ChessPiecePos;
import tools.factory.ChessImageProvider;

import javax.swing.*;
import java.awt.*;

public class ChessGridGUI  extends JLayeredPane {
    private int ligne = BoardGameConfig.getNbLigne();
    private int colonne = BoardGameConfig.getNbColonne();

    public ChessGridGUI()
    {
        JPanel square = new JPanel();
        ChessPieceGUI chessPieceGUI = null;
        int index;

        this.setLayout(new GridLayout(ligne, colonne));


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
                square = (JPanel) this.getComponent(index);
                square.add(chessPieceGUI);
            }
        }
    }
}
