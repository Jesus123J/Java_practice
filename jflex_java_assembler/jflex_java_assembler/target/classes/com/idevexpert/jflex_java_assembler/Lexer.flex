
/* Lexical specification for a simple assembler lexer */
%class Lexer
%unicode
%public
%eof{ return null; %}
%{
// Java code to include in the lexer class
%}

/* Regular expressions and their corresponding actions */
%% // Lexical rules section
%%

/* Define tokens here */
[ \t\n\r]+      { /* Skip whitespace */ }
"MOV"           { return Token.MOV; }
"ADD"           { return Token.ADD; }
"SUB"           { return Token.SUB; }
"MUL"           { return Token.MUL; }
"DIV"           { return Token.DIV; }
[0-9]+          { return Token.NUMBER; }
[a-zA-Z_][a-zA-Z0-9_]* { return Token.IDENTIFIER; }
.               { throw new Error("Unrecognized character: " + yytext()); }
