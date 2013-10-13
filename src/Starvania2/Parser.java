/**
 * @author Branden
 *
 */
package Starvania2;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {

	//This is the scanner used to track the postiton in the file
	Scanner parser;
	File roomFile;
	
	public Parser(String roomFileName)
	{
		try {
			roomFile = new File("bin/roomFiles/" + roomFileName);
			parser = new Scanner(roomFile);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	//Checks if a given string is in the file and parses up to the thing 
	// after it
	private boolean findStr(String target)
	{
		while(parser.hasNext() && !target.equals(parser.next()));
		//There must be something after the target string
		return parser.hasNext();
	}
	
	//Returns the value right after the word "Background", which should be the
	// background image for the room
	String getBackground()
	{
		String backImgName = "defaultBackground.png";
		
		//Get the name of the room
		if(findStr("Background"))
			backImgName = parser.next();
		
		//Reset the parser
		this.reset();
		System.out.println(backImgName);
		return backImgName;
	}
	
	Exit[] readExits()
	{
		//There can only be one exit per side of the room
		Exit[] exits = new Exit[4];
		
	}
	
	ArrayList<Entity> getPlatforms()
	{
		ArrayList<Entity> platforms = new ArrayList();
		String next;
		Platform tmpPlat;
		
		//The list of platforms stats with a line "StartPlatforms"
		if(findStr("StartPlatforms"))
		{
			next = parser.next();
			//And ends with a line "EndPlatforms
			while(!next.equals("EndPlatforms"))
			{
				tmpPlat = parsePlatform();
				if(tmpPlat != null)
				{
					platforms.add(tmpPlat);
					next = parser.next();
				}
			}
		}
		return platforms;
	}
	
	Platform parsePlatform()
	{
		int xPos = 0, yPos = 0;
		int width = 150;
		int height = 50;
		String field = parser.next();
		for(int i = 0; i < 2; i++)
		{
			//Get the position of the platform (x, y)
			if(field.equals("Position"))
			{
				xPos = parser.nextInt();
				yPos = parser.nextInt();
			}
			//Get the size of the platform (Width then height)
			else if(field.equals("Size"))
			{
				width = parser.nextInt();
				height = parser.nextInt();
			}
			//If you want default values for something, just type Default
			else if (field.equals("Default"));
			else
			{
				//Throw an error (Parse Error)
				System.out.println("ERROR");
				return null;
			}
			if(i == 0)
				field = parser.next();
		}
		
		return new Platform(width, height, xPos, yPos);	
	}
	
	//Returns the parser to the start of the file, this may be changed
	// depending on how much time it takes
	private void reset()
	{
		//Close the parser
		parser.close();
		try {
			//Open a new pareser
			parser = new Scanner(roomFile);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
