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

import java.io.File;
import java.util.ArrayList;

import constants.TokenConstants;

/**
 * Simple scanner.
 *   -recognizes the keywords of the language 
 *   -recognizes special characters or groups of them
 *   -recognizes identifiers, integers, reals, decimals, strings, etc
 *   -ignores whitespaces (tabs and blanks) and comments
 *   -ignores meaningless groups of characters
 * 
 */
public class Scanner {

	//global variables
	private static IOFiles files;
	private static int opt_cell = 0;
	private static int cell_num=0;

	public static int getOpt_cell() {
		return opt_cell;
	}

	public static void setOpt_cell(int opt_cell) {
		Scanner.opt_cell = opt_cell;
	}

	public static int getCell_num() {
		return cell_num;
	}

	public static void setCell_num(int cell_num) {
		Scanner.cell_num = cell_num;
	}

	/**
	 * Main.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//set input file
		IOFiles.setInputFile(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "inputfile.txt")); //for testing

		//set output file
		IOFiles.setOutputFile(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "tokenfile.txt"));

		//get all lines from the input file and save them as array of chars
		ArrayList<char[]> lines = IOFiles.loadFile(IOFiles.getInputFile().getAbsolutePath());
		
		//go through every line in the file (now arraylist)
		for(char[] line : lines) {
			scan(line);
			System.out.println();
		}

	}

	private static void scan(char[] tmp_str) {
		int result=0;
		int result_op=0;
		char extra_ch=0; //next character in the stream
		char extra_ch2=0; //second next character in the stream

		//go through every character in the file
		for(cell_num=0; cell_num < tmp_str.length; cell_num++) {
			if(cell_num < tmp_str.length-2) {
				extra_ch = tmp_str[cell_num+1];
			}
			if(cell_num < tmp_str.length-3) {
				extra_ch2 = tmp_str[cell_num+2];
			}
			
			if(PrintToken.printKeyword(tmp_str, cell_num)) { //check for keywords
				//do nothing -> break
			} else if( (result = ScanToken.isDelimiter(tmp_str[cell_num], extra_ch, extra_ch2, tmp_str, cell_num)) != TokenConstants.NOT_DELIMITER) {
				PrintToken.printDelimiter(result, opt_cell);
			}
			else if(result == TokenConstants.NOT_DELIMITER){
				if((result_op = ScanToken.isOperator(tmp_str[cell_num], extra_ch)) != TokenConstants.NOT_OPERATION){
					PrintToken.printOperator(result_op);
				}  
				else if(result_op == TokenConstants.NOT_OPERATION) {
					PrintToken.printVarOrNum(tmp_str, cell_num);
				}
			}  	
		}
		return;
	}
	
	/**
	 * Write token to a file.
	 */
	public static void writeTokenToFile(String s) {
		files.writeLine(s);
	}

}
