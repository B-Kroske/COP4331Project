/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Starvania2;

import java.awt.Graphics2D;

/**
 *
 * @author Branden
 */
public class Exit extends Entity {
	static int RADIUS = 25;
	int side;
	int position;
	Platform wall1, wall2;
	
	
	public Exit(int s, int p)
	{
		super(1);
		side = s;
		position = p;
		//This should set the value of wall1 and wall2 based on the radius,
		//position and side of the door
	}

	@Override
	public void logic() {
		System.out.println("We probably do not need logic for these unless we want gates built in");
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void paint(Graphics2D gIn) {
		//Draw a platform above and below the door?
		//The sides are numbered based on a clock (Up = 12, right = 3, down = 6, left = 9)
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void dispose() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
