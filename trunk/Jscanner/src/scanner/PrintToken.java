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

import constants.TokenConstants;
import constants.TokenNames;

public class PrintToken {

	public static void printDelimiter(int i, int opt_i) {
		switch(i) {
		case TokenConstants.SEMI :
			System.out.print(TokenNames.SEMI);
			break;
		case TokenConstants.O_PA :
			System.out.print(TokenNames.O_PA);
			break;
		case TokenConstants.C_PA :
			System.out.print(TokenNames.C_PA);
			break;
		case TokenConstants.O_SB :
			System.out.print(TokenNames.O_SB);
			break;
		case TokenConstants.C_SB :
			System.out.print(TokenNames.C_SB);
			break;
		case TokenConstants.COMM :
			System.out.print(TokenNames.COMM); 
			break;
		case TokenConstants.S_QUOT :
			System.out.print(TokenNames.S_QUOT); 
			break;
		case TokenConstants.D_QUOT :
			System.out.print(TokenNames.D_QUOT); 
			break;
		case TokenConstants.OB_CMT :
			System.out.print(TokenNames.OB_CMT);
			Scanner.setCell_num(Scanner.getCell_num()+1);
			break;
		case TokenConstants.CB_CMT :
			System.out.print(TokenNames.CB_CMT);
			Scanner.setCell_num(Scanner.getCell_num()+1);
			break;
		case TokenConstants.S_CMT :
			System.out.print(TokenNames.S_CMT);
			Scanner.setCell_num(Scanner.getCell_num()+1);
			break;
		case TokenConstants.CONST_CHAR :
			System.out.print(TokenNames.CONST_CHAR);
			Scanner.setCell_num(Scanner.getCell_num()+Scanner.getOpt_cell());
			break;
		case TokenConstants.CONST_STRING :
			System.out.print(TokenNames.CONST_STRING);
			Scanner.setCell_num(Scanner.getCell_num()+Scanner.getOpt_cell());
			break;
		}
	}
	
	public static void printOperator(int i) {
		switch(i) {
		case TokenConstants.ASSIGN :
			System.out.print(TokenNames.ASSIGN);
			break;
		case TokenConstants.EQ :
			System.out.print(TokenNames.EQ); 
			break;
		case TokenConstants.DIV :
			System.out.print(TokenNames.DIV);
			break;
		case TokenConstants.MUL :
			System.out.print(TokenNames.MUL);
			break;
		case TokenConstants.ADD :
			System.out.print(TokenNames.ADD);
			break;
		case TokenConstants.SUB :
			System.out.print(TokenNames.SUB);
			break;
		case TokenConstants.DIV_ASSIGN :
			System.out.print(TokenNames.DIV_ASSIGN); 
			break;
		case TokenConstants.MUL_ASSIGN :
			System.out.print(TokenNames.MUL_ASSIGN); 
			break;
		case TokenConstants.ADD_ASSIGN :
			System.out.print(TokenNames.ADD_ASSIGN);
			break;
		case TokenConstants.SUB_ASSIGN :
			System.out.print(TokenNames.SUB_ASSIGN);
			break;
		case TokenConstants.LT : 
			System.out.print(TokenNames.LT);
			break;
		case TokenConstants.GT :
			System.out.print(TokenNames.GT);
			break;
		case TokenConstants.EOL :
			System.out.print(TokenNames.EOL);
			break;
		case TokenConstants.GOL :
			System.out.print(TokenNames.GOL);
			break;
		case TokenConstants.NOT_EQ : 
			System.out.print(TokenNames.NOT_EQ);
			break;
		}
	}
	
	public static void printVarOrNum(char[] tmp_str, int i) {
		if (Scanner.isBlank(tmp_str[i])) {
			//do not print white spaces	
		} else if (Scanner.isVar(tmp_str[i])) {
			System.out.print(TokenNames.VAR);
		} else if (Scanner.isNumber(tmp_str[i])) {
			System.out.print(TokenNames.NUMBER);
		} else {
			//do nothing
		}
	}
	
	public static boolean printKeyword(char[] tmp_str, int cell_num) {
		if( (cell_num < tmp_str.length-3) && (tmp_str[cell_num] == 'i' && tmp_str[cell_num+1] == 'n' && tmp_str[cell_num+2] == 't')) {
			System.out.print(TokenNames.INT);
			Scanner.setCell_num(Scanner.getCell_num()+2);
			return true;
		} else if( (cell_num < tmp_str.length-4) && (tmp_str[cell_num] == 'c' && tmp_str[cell_num+1] == 'h' && tmp_str[cell_num+2] == 'a' && tmp_str[cell_num+3] == 'r')) {
			System.out.print(TokenNames.CHAR);
			Scanner.setCell_num(Scanner.getCell_num()+3);
			return true;
		} else if( (cell_num < tmp_str.length-2) && (tmp_str[cell_num] == 'i' && tmp_str[cell_num+1] == 'f')) {
			System.out.print(TokenNames.IF);
			Scanner.setCell_num(Scanner.getCell_num()+1);
			return true;
		} else if( (cell_num < tmp_str.length-4) && (tmp_str[cell_num] == 't' && tmp_str[cell_num+1] == 'h' && tmp_str[cell_num+2] == 'e' && tmp_str[cell_num+3] == 'n')) {
			System.out.print(TokenNames.THEN);
			Scanner.setCell_num(Scanner.getCell_num()+3);
			return true;
		} else if( (cell_num < tmp_str.length-4) && (tmp_str[cell_num] == 'e' && tmp_str[cell_num+1] == 'l' && tmp_str[cell_num+2] == 's' && tmp_str[cell_num+3] == 'e')) {
			System.out.print(TokenNames.ELSE);
			Scanner.setCell_num(Scanner.getCell_num()+3);
			return true;
		} else if( (cell_num < tmp_str.length-5) && (tmp_str[cell_num] == 'w' && tmp_str[cell_num+1] == 'h' && tmp_str[cell_num+2] == 'i' && tmp_str[cell_num+3] == 'l' && tmp_str[cell_num+4] == 'e')) {
			System.out.print(TokenNames.WHILE);
			Scanner.setCell_num(Scanner.getCell_num()+4);
			return true;
		} else if( (cell_num < tmp_str.length-3) && (tmp_str[cell_num] == 'f' && tmp_str[cell_num+1] == 'o' && tmp_str[cell_num+2] == 'r')) {
			System.out.print(TokenNames.FOR);
			Scanner.setCell_num(Scanner.getCell_num()+2);
			return true;
		} else if( (cell_num < tmp_str.length-6) && (tmp_str[cell_num] == 'r' && tmp_str[cell_num+1] == 'e' && tmp_str[cell_num+2] == 't' && tmp_str[cell_num+3] == 'u' && tmp_str[cell_num+4] == 'r' && tmp_str[cell_num+5] == 'n')) {
			System.out.print(TokenNames.RETURN);
			Scanner.setCell_num(Scanner.getCell_num()+5);
			return true;
		} else {
			return false;
		}
	}

}
