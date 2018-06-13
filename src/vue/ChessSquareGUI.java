package vue;

import tools.data.Coord;

import javax.swing.*;
import java.awt.*;

public class ChessSquareGUI extends JPanel {
    private Coord coords;
    private Color color;

    public ChessSquareGUI(int x, int y, Color color) {
        coords = new Coord(y,x);
        this.color = color;

        this.setBackground(this.color);
    }

    public Coord getCoord() {
        return coords;
    }
}
