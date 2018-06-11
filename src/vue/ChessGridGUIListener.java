package vue;

import controler.ChessGameControlerModelVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;

public class ChessGridGUIListener implements MouseListener, MouseMotionListener {

    private final ChessGridGUI chessGridGUI;
    private final ChessGameControlerModelVue ChessGameControlerModelVue;
    private ChessPieceGUI chessPieceGUI;
    private int xAdjustment, yAdjustment, oldY, oldX;

    public ChessGridGUIListener(ChessGridGUI chessGridGUI, ChessGameControlerModelVue chessGameControler) {
        this.chessGridGUI = chessGridGUI;
        this.ChessGameControlerModelVue = chessGameControler;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        chessPieceGUI = null;
        Component c =  chessGridGUI.findComponentAt(e.getX(), e.getY());


        if (c instanceof JPanel)
            return;

        oldY = e.getY();
        oldX = e.getX();
        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();

        chessPieceGUI = (ChessPieceGUI)c;
        chessPieceGUI.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        chessPieceGUI.setSize(chessPieceGUI.getWidth(), chessPieceGUI.getHeight());
        chessGridGUI.add(chessPieceGUI, JLayeredPane.DRAG_LAYER);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(chessPieceGUI == null) return;

        chessPieceGUI.setVisible(false);
        Component c =  chessGridGUI.findComponentAt(e.getX(), e.getY());

        if (c instanceof JLabel){
            Container parent = c.getParent();
            parent.remove(0);
            parent.add( chessPieceGUI );
        }
        else if (c instanceof JPanel){
            Container parent = (Container)c;
            parent.add( chessPieceGUI );
        } else
        {
            Container parent = (Container) chessGridGUI.findComponentAt(oldX, oldY);
            parent.add(chessPieceGUI);
        }
        chessPieceGUI.setVisible(true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getSource() == null) return;
        chessPieceGUI.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
