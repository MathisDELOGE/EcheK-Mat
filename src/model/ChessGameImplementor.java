package model;

import model.piece.Pieces;
import tools.data.ActionType;

public interface ChessGameImplementor {
    ActionType move(int xInit, int yInit, int xFinal, int yFinal);
}
