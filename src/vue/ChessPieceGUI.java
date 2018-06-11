package vue;

import tools.data.Couleur;

import javax.swing.*;

public class ChessPieceGUI extends JLabel {
    private Couleur couleur;

    public ChessPieceGUI(Couleur couleur, ImageIcon imageIcon) {
        super(imageIcon);
        this.couleur = couleur;
    }

    public Couleur getCouleur() {
        return couleur;
    }
}
