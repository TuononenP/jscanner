/**************************************************************************
 *  Copyright (C) 2011  Petri Tuononen, 박영덕                                                                              *
 *                                                                        *
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

import constants.TokenConstants;

/**
 * Scans tokens for numbers, variables, white spaces, delimiters and operators.
 *
 */
public class ScanToken {

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

	public static int isDelimiter(char ch, char extra_ch, char extra_ch2, char[] str, int dq_i) {
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
					Scanner.setOpt_cell(i);
					return TokenConstants.CONST_CHAR;
				}
				tmp_cnt++;
				i++;
			}								
		}
		else if(ch == '\"' && flag == TokenConstants.TRUE) {
			while(str[i] != '\n') {	
				if(str[i] == '\"') {
					Scanner.setOpt_cell(i);
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

	public static int isOperator(char ch, char extra_ch) {
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
	
}
