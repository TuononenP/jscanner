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
package constants;

/**
 * Constants for tokens.
 */
public class TokenConstants {

	//boolean constants
	public static final int FALSE = 0;
	public static final int TRUE = 1;

	//keyword constants
	public static final int INT = 3; 
	public static final int CHAR = 4;
	public static final int IF = 5;
	public static final int THEN = 6;
	public static final int ELSE = 7;
	public static final int WHILE = 8;
	public static final int FOR = 9;
	public static final int RETURN = 10;

	//delimiters constants
	public static final int SEMI = 11;
	public static final int O_PA = 12;
	public static final int C_PA = 13;
	public static final int O_SB = 14;
	public static final int C_SB = 15;
	public static final int COMM = 16;
	public static final int S_QUOT = 17;
	public static final int D_QUOT = 18;
	public static final int OB_CMT = 19;
	public static final int CB_CMT = 20;
	public static final int S_CMT = 21;
	public static final int NOT_DELIMITER = 22;
	public static final int CONST_CHAR = 80;
	public static final int CONST_STRING = 81;

	//operation constants
	public static final int ASSIGN = 23;
	public static final int EQ = 24;
	public static final int DIV = 25;
	public static final int MUL = 26;
	public static final int ADD = 27;
	public static final int SUB = 28;
	public static final int DIV_ASSIGN = 29;
	public static final int MUL_ASSIGN = 30;
	public static final int ADD_ASSIGN = 31;
	public static final int SUB_ASSIGN = 32;
	public static final int LT = 33; //<
	public static final int GT = 34; //>
	public static final int EOL = 35; //<=
	public static final int GOL = 36; //>=
	public static final int NOT_EQ = 37; //!=
	public static final int NOT_OPERATION = 38; //!

	//variable and number constants
	public static final int NUMBER = 39;
	public static final int VAR = 40;
	public static final int NOT_V_N = 41;
	
}
