package vue;

import controler.ChessGameControlerModelVue;
import controler.controlerLocal.ChessControlerLocal;
import tools.data.Coord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;

public class ChessGridGUIListener implements MouseListener, MouseMotionListener {

    private final ChessGridGUI chessGridGUI;
    private final ChessGameControlerModelVue chessGameControlerModelVue;
    private ChessPieceGUI chessPieceGUI;
    private int xAdjustment, yAdjustment, oldY, oldX;
    private Coord squareDest, squareSrc;

    public ChessGridGUIListener(ChessGridGUI chessGridGUI, ChessGameControlerModelVue chessGameControler) {
        this.chessGridGUI = chessGridGUI;
        this.chessGameControlerModelVue = chessGameControler;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        chessPieceGUI = null;
        Component c =  chessGridGUI.findComponentAt(e.getX(), e.getY());
        Component parent;

        //vérifie si c instance de chesspiecegui et si c'est son tour de jouer
        if (c instanceof ChessPieceGUI &&
                chessGameControlerModelVue.isPlayerOk(((ChessPieceGUI)c).getCouleur())) {
            oldY = e.getY();
            oldX = e.getX();
            Point parentLocation = c.getParent().getLocation();
            xAdjustment = parentLocation.x - e.getX();
            yAdjustment = parentLocation.y - e.getY();

            chessPieceGUI = (ChessPieceGUI) c;
            chessPieceGUI.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
            chessPieceGUI.setSize(chessPieceGUI.getWidth(), chessPieceGUI.getHeight());
            chessGridGUI.add(chessPieceGUI, JLayeredPane.DRAG_LAYER);
        }
        if (c instanceof JLabel) {
                parent = c.getParent();
            } else if (c instanceof JPanel) {
                parent = (Container) c;
            } else {
                parent = (Container) chessGridGUI.findComponentAt(oldX, oldY);
            }
            ChessSquareGUI caseSquare = (ChessSquareGUI)parent;
            squareSrc = new Coord(caseSquare.getCoord().getX(),caseSquare.getCoord().getY());
        }

    @Override
    public void mouseReleased(MouseEvent e) {
        Container parent;

        if(chessPieceGUI != null) {
            chessPieceGUI.setVisible(false);
            Component c = chessGridGUI.findComponentAt(e.getX(), e.getY());
            //Au relâchement : retrouver le parent (la case) avec pièce ou non
            if (c instanceof JLabel) {
                parent = c.getParent();
                parent.remove(0);
            } else if (c instanceof JPanel) {
                parent = (Container) c;
            } else {
                parent = (Container) chessGridGUI.findComponentAt(oldX, oldY);
            }
            parent.removeAll();
            parent.add(chessPieceGUI);
            chessPieceGUI.setVisible(true);
            //transmission du move du listener au controler + transformation en case
            ChessSquareGUI caseSquare = (ChessSquareGUI)parent;
            squareDest = new Coord(caseSquare.getX(),caseSquare.getY());
            chessGameControlerModelVue.actionsWhenPieceIsMovedOnGUI(squareSrc,squareDest);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (chessPieceGUI != null) {
            chessPieceGUI.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
