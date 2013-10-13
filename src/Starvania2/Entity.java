/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Starvania2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Branden
 */
public abstract class Entity {
	private int priority; 
	
	public Entity(int p)
    {
		priority = p;
    }
	
    public int getPriority()
	{
		return priority;
	}
    
    public abstract void logic();
    public abstract void paint(Graphics2D gIn);
    public abstract void dispose();
}
