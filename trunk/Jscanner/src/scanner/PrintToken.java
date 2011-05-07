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

	public static int printDelimiter(int i, int opt_i) {
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
			System.out.print(TokenNames.OB_CMT); i++; 
			break;
		case TokenConstants.CB_CMT :
			System.out.print(TokenNames.CB_CMT);i++; 
			break;
		case TokenConstants.S_CMT :
			System.out.print(TokenNames.S_CMT); i++;
			break;
		case TokenConstants.CONST_CHAR :
			System.out.print(TokenNames.CONST_CHAR);
			i += opt_i;
			opt_i=0;
			break;
		case TokenConstants.CONST_STRING :
			System.out.print(TokenNames.CONST_STRING);
			i += opt_i;
			opt_i=0; 
			break;
		}
		return i;
	}
	
	public static int printOperator(int i) {
		switch(i) {
		case TokenConstants.ASSIGN :
			System.out.print(TokenNames.ASSIGN);
			break;
		case TokenConstants.EQ :
			System.out.print(TokenNames.EQ); 
			return i;
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
			return i;
		case TokenConstants.MUL_ASSIGN :
			System.out.print(TokenNames.MUL_ASSIGN); 
			return i;
		case TokenConstants.ADD_ASSIGN :
			System.out.print(TokenNames.ADD_ASSIGN);
			return i;
		case TokenConstants.SUB_ASSIGN :
			System.out.print(TokenNames.SUB_ASSIGN);
			return i;
		case TokenConstants.LT : 
			System.out.print(TokenNames.LT);
			break;
		case TokenConstants.GT :
			System.out.print(TokenNames.GT);
			return i;
		case TokenConstants.EOL :
			System.out.print(TokenNames.EOL);
			return i;
		case TokenConstants.GOL :
			System.out.print(TokenNames.GOL);
			return i;
		case TokenConstants.NOT_EQ : 
			System.out.print(TokenNames.NOT_EQ);
			return i;
		}
		return 0; 
	}
	
	public static void printVarOrNum(char[] tmp_str, int i) {
		if (Scanner.isVar(tmp_str[i])) {
			System.out.print(TokenNames.VAR);
		} else if (Scanner.isNumber(tmp_str[i])) {
			System.out.print(TokenNames.NUMBER);
		} else if (Scanner.isBlank(tmp_str[i])) {
			//do not print white spaces					
		} else {
			//do nothing
		}
	}
	
}
