package vue;

import tools.data.Coord;

import javax.swing.*;
import java.awt.*;

public class ChessSquareGUI extends JPanel {
    private Coord coords;
    private Color color;

    public ChessSquareGUI(int x, int y, Color color) {
        coords = new Coord(x,y);
        this.color = color;

        this.setBackground(this.color);
    }
}
