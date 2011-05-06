/**************************************************************************
 *  Copyright (C) 2011  Petri Tuononen                                    *
 * 	                                                                      *
 *  This program is free software: you can redistribute it and/or modify  *
 *  it under the terms of the GNU General Public License as published by  *
 *  the Free Software Foundation, either version 3 of the License, or     *
 *  (at your option) any later version.                                   *
 *                                                                        *
 *  This program is distributed in the hope that it will be useful,       *
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *  GNU General Public License for more details.                          *
 *                                                                        *
 *  You should have received a copy of the GNU General Public License     *
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>. *
 **************************************************************************/
package scanner;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Simple scanner.
 *   -recognizes the keywords of the language 
 *   -recognizes special characters or groups of them
 *   -recognizes identifiers, integers, reals, decimals, strings, etc
 *   -ignores whitespaces (tabs and blanks) and comments
 * 
 */
public class Scanner {

	//global variables
	private static IOFiles files;
	private static char current = ' ';
	private FileInputStream fin;
	private static DataInputStream din;
	private static StringBuilder sB;
	
	/**
	 * Main.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		files = new IOFiles();
		//set input file
//		if (args.length > 0 ) {
//			files.setInputFile(new File(args[0]));
//		} else { //stop program
//			System.exit(0);
//		}

		files.setInputFile(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "test.txt")); //for testing
		
		//set output file
		files.setOutputFile(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "tokenfile.txt"));
		
		//initialize
		new Scanner();
		
//		scan();
	}

	/**
	 * Initialize.
	 */
	public Scanner() {
		try {
			fin = new FileInputStream(files.getInputFile());
			din = new DataInputStream(fin);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sB = new StringBuilder();
	}

	/***
	 * Read next character from the file.
	 */
	public static char readNextChar() {
		try {
			//read in next char
			current = din.readChar();
			return current;

			//close DataInputStream
//			din.close(); //TODO: move at the end of scan
		}
		catch(FileNotFoundException fe) {
			System.out.println("FileNotFoundException : " + fe);
		}
		catch(IOException ioe) {
			System.out.println("IOException : " + ioe);
		}
		return ' ';
	}
	
	/**
	 * Write token to a file.
	 */
	public static void writeTokenToFile(String s) {
		files.writeLine(s);
	}
	
	/**
	 * Read in characters as long as white space is encountered.
	 */
	public static void scan() {
		do {
			//read in next character
			readNextChar();
			do {
				sB.append(current);
			} while (readNextChar() != ' ');
//			if (sB.length() > 0) {
				writeTokenToFile(sB.toString());
				//flush string builder
				sB.replace(0, sB.length(), "");
//			}
		} while (current != -1); //end of stream
	}

}
