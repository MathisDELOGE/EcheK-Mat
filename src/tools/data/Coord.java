package tools.data;

import tools.BoardGameConfig;

import java.io.Serializable;


/**
 * @author francoise.perrin
 *
 */
public class Coord implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x, y;
	
	/**
	 * @param x
	 * @param y
	 */
	public Coord(int x, int y) {
		if(x>=0 && x<=BoardGameConfig.getNbColonne())
			this.x = x;
		if(y>=0 && y<=BoardGameConfig.getNbLigne())
			this.y = y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */

	public boolean equals(Coord coord) {
		boolean resultat = false;
		if(this.getX()==coord.getX() && this.getY()==coord.getY())
			resultat = true;
		return resultat;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}


	public void setX(int x) {
		if(x>=0 && x<=BoardGameConfig.getNbColonne())
		this.x = x;
	}

	public void setY(int y) {
		if(y>=0 && y<=BoardGameConfig.getNbLigne())
			this.y = y;
	}

	public void setCoord(int x, int y) {
		if(x>=0 && x<=BoardGameConfig.getNbColonne())
		this.x = x;
		if(y>=0 && y<=BoardGameConfig.getNbLigne())
		this.y = y;
	}
}
