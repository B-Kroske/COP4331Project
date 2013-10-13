/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Starvania2;

/**
 *
 * @author Branden
 */
public class ParserTest2 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
        Parser data = new Parser("start.lvl");
		
		data.getBackground();
		data.getPlatforms();

	}
}
