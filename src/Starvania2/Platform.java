/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Starvania2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Branden
 */
class Platform extends Entity {
	int width, height;
	int startX, startY;
	Image art;
	
	//Constructor to create the platforms
	public Platform(int l, int h, int cx, int cy)
	{
		super(3);
		width = l;
		height = h;
		startX = cx - l/2;
		startY = cy - h/2;
	}

	@Override
	public void logic() {
		//System.out.println("Not used"); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void paint(Graphics2D gIn) {
		System.out.println(startX + " " + startY );
		gIn.setColor(Color.WHITE);
		gIn.fillRect(startX, startY, width, height);
	}

	@Override
	public void dispose() {
		//System.out.println("Not used"); //To change body of generated methods, choose Tools | Templates.
	}
	
}
