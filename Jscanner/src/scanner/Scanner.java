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

//import java.io.DataInputStream;
import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
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
		IOFiles.setInputFile(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "inputfile.txt")); //for testing

		//set output file
//		IOFiles.setOutputFile(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "tokenfile.txt"));

		ArrayList<char[]> lines = IOFiles.loadFile(IOFiles.getInputFile().getAbsolutePath());
		
		for(char[] line : lines) {
			scan(line);
			System.out.println();
		}

	}

	/**
	 * Write token to a file.
	 */
	public static void writeTokenToFile(String s) {
		files.writeLine(s);
	}

	public static boolean isNumber(char ch) {
		if(ch >= '0' && ch <= '9') 
			return true;
		else
			return false;
	}

	public static boolean isVar(char ch) {
		if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '_' || ch == '.')
			return true;
		else 
			return false;
	}

	public static boolean isBlank(char ch) {
		if(ch == ' ' || ch == '\n')
			return true;
		else 
			return false;
	}

	private static int isDelimiter(char ch, char extra_ch, char extra_ch2, char[] str, int dq_i) {
		int flag = TokenConstants.FALSE;
		int i=0;
		int tmp_cnt=0;

		if (str.length > dq_i + 1) {
			i = dq_i + 1;
			flag = TokenConstants.TRUE;
		}	

		if (ch == '/' && extra_ch == '/')
			return TokenConstants.S_CMT;
		else if(ch=='/' && extra_ch=='*')
			return TokenConstants.OB_CMT;
		else if(ch=='*' && extra_ch=='/') 
			return TokenConstants.CB_CMT;
		else if(ch == '\''){
			while(str[i] != '\n') {	
				if(str[i] == '\'' && tmp_cnt == 1) {
					opt_cell = i; 
					return TokenConstants.CONST_CHAR;
				}
				tmp_cnt++;
				i++;
			}								
		}
		else if(ch == '\"' && flag == TokenConstants.TRUE) {
			while(str[i] != '\n') {	
				if(str[i] == '\"') {
					opt_cell=i;
					return TokenConstants.CONST_STRING;
				}
				i++;
			}								
		}

		switch(ch){
		case ';' : return TokenConstants.SEMI; 	
		case '(' : return TokenConstants.O_PA; 	
		case ')' : return TokenConstants.C_PA; 	
		case '{' : return TokenConstants.O_SB; 	
		case '}' : return TokenConstants.C_SB; 	
		case ',' : return TokenConstants.COMM; 	
		case '\'' : return TokenConstants.S_QUOT; 	
		case '\"' : return TokenConstants.D_QUOT; 
		default : return TokenConstants.NOT_DELIMITER;
		}
	}

	private static int isOperator(char ch, char extra_ch) {
		if (ch == '=' && extra_ch == '=')
			return TokenConstants.EQ;
		else if(ch == '/' && extra_ch == '=')
			return TokenConstants.DIV_ASSIGN;
		else if(ch == '*' && extra_ch == '=')
			return TokenConstants.MUL_ASSIGN;
		else if(ch == '+' && extra_ch == '=')
			return TokenConstants.ADD_ASSIGN;
		else if(ch == '-' && extra_ch == '=')
			return TokenConstants.SUB_ASSIGN;
		else if(ch == '<' && extra_ch == '=')
			return TokenConstants.EOL;
		else if(ch == '>' && extra_ch == '=')
			return TokenConstants.GOL;
		else if(ch == '!' && extra_ch == '=')
			return TokenConstants.NOT_EQ;

		switch(ch){
		case '=' : return TokenConstants.ASSIGN ; 		
		case '/' : return TokenConstants.DIV; 	
		case '*' : return TokenConstants.MUL; 	
		case '+' : return TokenConstants.ADD; 	
		case '<' : return TokenConstants.LT; 
		case '>' : return TokenConstants.GT;
		case '-' : return TokenConstants.SUB; 	
		default : return TokenConstants.NOT_OPERATION;
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
			} else if( (result = isDelimiter(tmp_str[cell_num], extra_ch, extra_ch2, tmp_str, cell_num)) != TokenConstants.NOT_DELIMITER) {
				PrintToken.printDelimiter(result, opt_cell);
			}
			else if(result == TokenConstants.NOT_DELIMITER){
				if((result_op = isOperator(tmp_str[cell_num], extra_ch)) != TokenConstants.NOT_OPERATION){
					PrintToken.printOperator(result_op);
				}  
				else if(result_op == TokenConstants.NOT_OPERATION) {
					PrintToken.printVarOrNum(tmp_str, cell_num);
				}
			}  	
		}
		return;
	}
	
}
