Simple scanner & lexical analyzer combination done during the Compiler course in Sungkyunkwan University, South Korea.

The scanner's job is to read the source file one character at a time. For each character, it keeps track of the line and character position where the character was found. Each time the scanner is called, it reads the next character from the file and returns it.

The lexer's job is to group the characters of the source file into chunks called tokens (meaningful groups of characters). Each time the lexer is called, it calls the scanner (perhaps several times) to get as many characters as it needs in order to assemble the characters into a token. It determines the type of token that it has found (a string, a number, an identifier, a comment, etc.) and returns the token.

The lexer is not aimed to any specific language. Rather it is defined for basic imperative language keywords, operator symbols, delimiters, constants and white spaces. Programming languages such as C and Java share these grammar definitions.