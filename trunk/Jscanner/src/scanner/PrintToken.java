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
			Scanner.getSb().append(TokenNames.SEMI);
			break;
		case TokenConstants.O_PA :
			Scanner.getSb().append(TokenNames.O_PA);
			break;
		case TokenConstants.C_PA :
			Scanner.getSb().append(TokenNames.C_PA);
			break;
		case TokenConstants.O_SB :
			Scanner.getSb().append(TokenNames.O_SB);
			break;
		case TokenConstants.C_SB :
			Scanner.getSb().append(TokenNames.C_SB);
			break;
		case TokenConstants.COMM :
			Scanner.getSb().append(TokenNames.COMM); 
			break;
		case TokenConstants.S_QUOT :
			Scanner.getSb().append(TokenNames.S_QUOT); 
			break;
		case TokenConstants.D_QUOT :
			Scanner.getSb().append(TokenNames.D_QUOT); 
			break;
		case TokenConstants.OB_CMT :
			Scanner.getSb().append(TokenNames.OB_CMT);
			Scanner.setCell_num(Scanner.getCell_num()+1);
			break;
		case TokenConstants.CB_CMT :
			Scanner.getSb().append(TokenNames.CB_CMT);
			Scanner.setCell_num(Scanner.getCell_num()+1);
			break;
		case TokenConstants.S_CMT :
			Scanner.getSb().append(TokenNames.S_CMT);
			Scanner.setCell_num(Scanner.getCell_num()+1);
			break;
		case TokenConstants.CONST_CHAR :
			Scanner.getSb().append(TokenNames.CONST_CHAR);
			Scanner.setCell_num(Scanner.getCell_num()+Scanner.getOpt_cell());
			break;
		case TokenConstants.CONST_STRING :
			Scanner.getSb().append(TokenNames.CONST_STRING);
			Scanner.setCell_num(Scanner.getCell_num()+Scanner.getOpt_cell());
			break;
		}
	}
	
	public static void printOperator(int i) {
		switch(i) {
		case TokenConstants.ASSIGN :
			Scanner.getSb().append(TokenNames.ASSIGN);
			break;
		case TokenConstants.EQ :
			Scanner.getSb().append(TokenNames.EQ); 
			break;
		case TokenConstants.DIV :
			Scanner.getSb().append(TokenNames.DIV);
			break;
		case TokenConstants.MUL :
			Scanner.getSb().append(TokenNames.MUL);
			break;
		case TokenConstants.ADD :
			Scanner.getSb().append(TokenNames.ADD);
			break;
		case TokenConstants.SUB :
			Scanner.getSb().append(TokenNames.SUB);
			break;
		case TokenConstants.DIV_ASSIGN :
			Scanner.getSb().append(TokenNames.DIV_ASSIGN); 
			break;
		case TokenConstants.MUL_ASSIGN :
			Scanner.getSb().append(TokenNames.MUL_ASSIGN); 
			break;
		case TokenConstants.ADD_ASSIGN :
			Scanner.getSb().append(TokenNames.ADD_ASSIGN);
			break;
		case TokenConstants.SUB_ASSIGN :
			Scanner.getSb().append(TokenNames.SUB_ASSIGN);
			break;
		case TokenConstants.LT : 
			Scanner.getSb().append(TokenNames.LT);
			break;
		case TokenConstants.GT :
			Scanner.getSb().append(TokenNames.GT);
			break;
		case TokenConstants.EOL :
			Scanner.getSb().append(TokenNames.EOL);
			break;
		case TokenConstants.GOL :
			Scanner.getSb().append(TokenNames.GOL);
			break;
		case TokenConstants.NOT_EQ : 
			Scanner.getSb().append(TokenNames.NOT_EQ);
			break;
		}
	}
	
	public static void printVarOrNum(char[] tmp_str, int i) {
		if (ScanToken.isBlank(tmp_str[i])) {
			//do not print white spaces	
		} else if (ScanToken.isVar(tmp_str[i])) {
			Scanner.getSb().append(TokenNames.VAR);
		} else if (ScanToken.isNumber(tmp_str[i])) {
			Scanner.getSb().append(TokenNames.NUMBER);
		} else {
			//do nothing
		}
	}
	
	public static boolean printKeyword(char[] tmp_str, int cell_num) {
		if( (cell_num < tmp_str.length-3) && (tmp_str[cell_num] == 'i' && tmp_str[cell_num+1] == 'n' && tmp_str[cell_num+2] == 't')) {
			Scanner.getSb().append(TokenNames.INT);
			Scanner.setCell_num(Scanner.getCell_num()+2);
			return true;
		} else if( (cell_num < tmp_str.length-4) && (tmp_str[cell_num] == 'c' && tmp_str[cell_num+1] == 'h' && tmp_str[cell_num+2] == 'a' && tmp_str[cell_num+3] == 'r')) {
			Scanner.getSb().append(TokenNames.CHAR);
			Scanner.setCell_num(Scanner.getCell_num()+3);
			return true;
		} else if( (cell_num < tmp_str.length-2) && (tmp_str[cell_num] == 'i' && tmp_str[cell_num+1] == 'f')) {
			Scanner.getSb().append(TokenNames.IF);
			Scanner.setCell_num(Scanner.getCell_num()+1);
			return true;
		} else if( (cell_num < tmp_str.length-4) && (tmp_str[cell_num] == 't' && tmp_str[cell_num+1] == 'h' && tmp_str[cell_num+2] == 'e' && tmp_str[cell_num+3] == 'n')) {
			Scanner.getSb().append(TokenNames.THEN);
			Scanner.setCell_num(Scanner.getCell_num()+3);
			return true;
		} else if( (cell_num < tmp_str.length-4) && (tmp_str[cell_num] == 'e' && tmp_str[cell_num+1] == 'l' && tmp_str[cell_num+2] == 's' && tmp_str[cell_num+3] == 'e')) {
			Scanner.getSb().append(TokenNames.ELSE);
			Scanner.setCell_num(Scanner.getCell_num()+3);
			return true;
		} else if( (cell_num < tmp_str.length-5) && (tmp_str[cell_num] == 'w' && tmp_str[cell_num+1] == 'h' && tmp_str[cell_num+2] == 'i' && tmp_str[cell_num+3] == 'l' && tmp_str[cell_num+4] == 'e')) {
			Scanner.getSb().append(TokenNames.WHILE);
			Scanner.setCell_num(Scanner.getCell_num()+4);
			return true;
		} else if( (cell_num < tmp_str.length-3) && (tmp_str[cell_num] == 'f' && tmp_str[cell_num+1] == 'o' && tmp_str[cell_num+2] == 'r')) {
			Scanner.getSb().append(TokenNames.FOR);
			Scanner.setCell_num(Scanner.getCell_num()+2);
			return true;
		} else if( (cell_num < tmp_str.length-6) && (tmp_str[cell_num] == 'r' && tmp_str[cell_num+1] == 'e' && tmp_str[cell_num+2] == 't' && tmp_str[cell_num+3] == 'u' && tmp_str[cell_num+4] == 'r' && tmp_str[cell_num+5] == 'n')) {
			Scanner.getSb().append(TokenNames.RETURN);
			Scanner.setCell_num(Scanner.getCell_num()+5);
			return true;
		} else {
			return false;
		}
	}

}
