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
package constants;

/**
 * Constants for tokens.
 */
public class TokenConstants {

	//boolean constants
	public static final int FALSE	 			= 0;
	public static final int TRUE 				= 1;

	//keyword constants
	public static final int INT 				= 2; 
	public static final int CHAR 				= 3;
	public static final int IF 					= 4;
	public static final int THEN 				= 5;
	public static final int ELSE 				= 6;
	public static final int WHILE				= 7;
	public static final int FOR 				= 8;
	public static final int RETURN 				= 9;

	//delimiters constants
	public static final int SEMI 				= 10;
	public static final int O_PA 				= 11;
	public static final int C_PA 				= 12;
	public static final int O_SB 				= 13;
	public static final int C_SB 				= 14;
	public static final int COMM 				= 15;
	public static final int S_QUOT 				= 16;
	public static final int D_QUOT 				= 17;
	public static final int OB_CMT 				= 18;
	public static final int CB_CMT 				= 19;
	public static final int S_CMT 				= 20;
	public static final int NOT_DELIMITER 		= 21;
	public static final int CONST_CHAR 			= 22;
	public static final int CONST_STRING 		= 23;
	public static final int COMMENT_STRING 		= 24;
	
	//operation constants
	public static final int ASSIGN 				= 25;
	public static final int EQ 					= 26;
	public static final int DIV 				= 27;
	public static final int MUL 				= 28;
	public static final int ADD 				= 29;
	public static final int SUB 				= 30;
	public static final int DIV_ASSIGN 			= 31;
	public static final int MUL_ASSIGN 			= 32;
	public static final int ADD_ASSIGN 			= 33;
	public static final int SUB_ASSIGN		 	= 34;
	public static final int LT 					= 35; // <
	public static final int GT 					= 36; // >
	public static final int LOE 				= 37; // <=
	public static final int GOE 				= 38; // >=
	public static final int NOT_EQ 				= 39; // !=
	public static final int NOT_OPERATION 		= 40; // !

	//variable and number constants
	public static final int NUMBER 				= 41;
	public static final int VAR 				= 42;
	
}
