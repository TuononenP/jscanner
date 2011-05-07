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

public class TokenNames {

	//keyword
	public static final String INT = " INT "; 
	public static final String CHAR = " CHAR ";
	public static final String IF = " IF ";
	public static final String THEN = " THEN ";
	public static final String ELSE = " ELSE ";
	public static final String WHILE = " WHILE ";
	public static final String FOR = " FOR ";
	public static final String RETURN = " RETURN ";
	
	//delimiters
	public static final String SEMI = " SEMI ";
	public static final String O_PA = " O_PA ";
	public static final String C_PA = " C_PA ";
	public static final String O_SB = " O_SB ";
	public static final String C_SB = " C_SB ";
	public static final String COMM = " COMM ";
	public static final String S_QUOT = " S_QUOT ";
	public static final String D_QUOT = " D_QUOT ";
	public static final String OB_CMT = " OB_CMT ";
	public static final String CB_CMT = " CB_CMT ";
	public static final String S_CMT = " S_CMT ";
	public static final String NOT_DELIMITER = " NOT_DELIMITER ";
	public static final String CONST_CHAR = " CONST_CHAR ";
	public static final String CONST_STRING = " CONST_STRING ";
	
	//operations
	public static final String ASSIGN = " ASSIGN ";
	public static final String EQ = " EQ ";
	public static final String DIV = " DIV ";
	public static final String MUL = " MUL ";
	public static final String ADD = " ADD ";
	public static final String SUB = " SUB ";
	public static final String DIV_ASSIGN = " DIV_ASSIGN ";
	public static final String MUL_ASSIGN = " MUL_ASSIGN ";
	public static final String ADD_ASSIGN = " ADD_ASSIGN ";
	public static final String SUB_ASSIGN = " SUB_ASSIGN ";
	public static final String LT = " LT "; //<
	public static final String GT = " GT "; //>
	public static final String EOL = " EOL "; //<=
	public static final String GOL = " GOL "; //>=
	public static final String NOT_EQ = " NOT_EQ "; //!=
	public static final String NOT_OPERATION = " NOT_OPERATION "; //!
	
	//variables and numbers
	public static final String NUMBER = " NUMBER ";
	public static final String VAR = " VAR ";
	public static final String NOT_V_N = " NOT_V_N ";
	
}
