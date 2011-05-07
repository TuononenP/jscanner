/**************************************************************************
 *  Copyright (C) 2011  Petri Tuononen, 박영덕                                                                              *
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Handles input and output file operations. 
 *
 */
public class IOFiles {

	private static File inputFile;
	private static File outputFile;
	private PrintWriter pw = null;

	public static File getInputFile() {
		return inputFile;
	}

	public static void setInputFile(File inputFile) {
		IOFiles.inputFile = inputFile;
	}

	public static File getOutputFile() {
		return outputFile;
	}

	public static void setOutputFile(File outputFile) {
		IOFiles.outputFile = outputFile;
	}

	public void writeLine(String s) {
		try {
			pw = new PrintWriter(new FileWriter(getOutputFile(), true));
			pw.println(s);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			//close the PrintWriter
			if (pw != null)
				pw.close();
		}
	}

	public static ArrayList<char[]> loadFile(String fileName) {
		if ((fileName == null) || (fileName == ""))
			throw new IllegalArgumentException();

		String line;
		ArrayList<char[]> file = new ArrayList<char[]>();

		try {    
			BufferedReader in = new BufferedReader(new FileReader(fileName));

			if (!in.ready())
				throw new IOException();

			while ((line = in.readLine()) != null)
				file.add(line.toCharArray());

			in.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return file;
	}

}
