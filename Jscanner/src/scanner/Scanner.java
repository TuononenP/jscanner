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
import constants.TokenNames;

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
//	private static char current = ' ';
//	private FileInputStream fin;
//	private static DataInputStream din;
//	private static StringBuilder sB;
	private static int opt_i = 0;

	/**
	 * Main.
	 * 
	 * @param args
	 */
	//	public static void main(String[] args) {
	//		files = new IOFiles();
	//		//set input file
	////		if (args.length > 0 ) {
	////			files.setInputFile(new File(args[0]));
	////		} else { //stop program
	////			System.exit(0);
	////		}
	//
	//		files.setInputFile(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "test.txt")); //for testing
	//		
	//		//set output file
	//		files.setOutputFile(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "tokenfile.txt"));
	//		
	//		//initialize
	//		new Scanner();
	//		
	////		scan();
	//	}

	public static void main(String[] args) {
		//	char str[];
		//	char ch;
		//	char p;
		//	int i=0;
		//	int result=0;

		IOFiles.setInputFile(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "inputfile.txt")); //for testing

		//set output file
//		IOFiles.setOutputFile(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "tokenfile.txt"));

		ArrayList<char[]> lines = IOFiles.loadFile(IOFiles.getInputFile().getAbsolutePath());
		
		for(char[] line : lines) {
			scan(line);
			System.out.println();
		}

	}

//	/**
//	 * Initialize.
//	 */
//	public Scanner() {
//		try {
//			fin = new FileInputStream(files.getInputFile());
//			din = new DataInputStream(fin);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		sB = new StringBuilder();
//	}

//	/***
//	 * Read next character from the file.
//	 */
//	public static boolean readNextChar() {
//		try {
//			//read in next char
//			current = din.readChar();
//			return true; //TODO: Change: now always true.
//
//			//close DataInputStream
//			//			din.close(); //TODO: move at the end of scan
//		}
//		catch(FileNotFoundException fe) {
//			System.out.println("FileNotFoundException : " + fe);
//		}
//		catch(IOException ioe) {
//			System.out.println("IOException : " + ioe);
//		}
//		return false;
//	}

	/**
	 * Write token to a file.
	 */
	public static void writeTokenToFile(String s) {
		files.writeLine(s);
	}

	//	/**
	//	 * Read in characters as long as white space is encountered.
	//	 */
	//	public static void scan() {
	//		do {
	//			//read in next character
	//			readNextChar();
	//			do {
	//				sB.append(current);
	//			} while (readNextChar() != ' ');
	////			if (sB.length() > 0) {
	//				writeTokenToFile(sB.toString());
	//				//flush string builder
	//				sB.replace(0, sB.length(), "");
	////			}
	//		} while (current != -1); //end of stream
	//	}


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
					opt_i = i; 
					return TokenConstants.CONST_CHAR;
				}
				tmp_cnt++;
				i++;
			}								
		}
		else if(ch == '\"' && flag == TokenConstants.TRUE) {
			while(str[i] != '\n') {	
				if(str[i] == '\"') {
					opt_i=i;
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
		int i=0;
		int result=0;
		int result_op=0;
		char extra_ch=0;
		char extra_ch2=0;

		for(i=0; i < tmp_str.length; i++) {
			if(i < tmp_str.length-2) {
				extra_ch = tmp_str[i+1];
			}
			if(i < tmp_str.length-3) {
				extra_ch2 = tmp_str[i+2];
			}
			
			if( (i < tmp_str.length-3) && (tmp_str[i] == 'i' && tmp_str[i+1] == 'n' && tmp_str[i+2] == 't')) {
				System.out.print(TokenNames.INT);
				i+=2;
			} 
			else if( (i < tmp_str.length-4) && (tmp_str[i] == 'c' && tmp_str[i+1] == 'h' && tmp_str[i+2] == 'a' && tmp_str[i+3] == 'r')) {
				System.out.print(TokenNames.CHAR);
				i+=3;
			}
			else if( (i < tmp_str.length-2) && (tmp_str[i] == 'i' && tmp_str[i+1] == 'f')) {
				System.out.print(TokenNames.IF);
				i+=1;
			}
			else if( (i < tmp_str.length-4) && (tmp_str[i] == 't' && tmp_str[i+1] == 'h' && tmp_str[i+2] == 'e' && tmp_str[i+3] == 'n')) {
				System.out.print(TokenNames.THEN);
				i+=3;
			}
			else if( (i < tmp_str.length-4) && (tmp_str[i] == 'e' && tmp_str[i+1] == 'l' && tmp_str[i+2] == 's' && tmp_str[i+3] == 'e')) {
				System.out.print(TokenNames.ELSE);
				i+=3;
			}
			else if( (i < tmp_str.length-5) && (tmp_str[i] == 'w' && tmp_str[i+1] == 'h' && tmp_str[i+2] == 'i' && tmp_str[i+3] == 'l' && tmp_str[i+4] == 'e')) {
				System.out.print(TokenNames.WHILE);
				i+=4;
			}
			else if( (i < tmp_str.length-3) && (tmp_str[i] == 'f' && tmp_str[i+1] == 'o' && tmp_str[i+2] == 'r')) {
				System.out.print(TokenNames.FOR);
				i+=2;
			} 
			else if( (i < tmp_str.length-6) && (tmp_str[i] == 'r' && tmp_str[i+1] == 'e' && tmp_str[i+2] == 't' && tmp_str[i+3] == 'u' && tmp_str[i+4] == 'r' && tmp_str[i+5] == 'n')) {
				System.out.print(TokenNames.RETURN);
				i+=5;
			}
			else if( (result = isDelimiter(tmp_str[i], extra_ch, extra_ch2, tmp_str, i)) != TokenConstants.NOT_DELIMITER) {
				i = PrintToken.printDelimiter(result, opt_i);
			}
			else if(result == TokenConstants.NOT_DELIMITER){
				if((result_op = isOperator(tmp_str[i], extra_ch)) != TokenConstants.NOT_OPERATION){
					int return_val = PrintToken.printOperator(result_op);
					if (return_val != 0) 
						i = return_val;
				}  
				else if(result_op == TokenConstants.NOT_OPERATION) {
					PrintToken.printVarOrNum(tmp_str, i);
				}
			}  	
		}
		return;
	}
	
}
