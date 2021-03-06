
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	//ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}

	//ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}
	

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}


%%

" "		{ }
"\b"	{ }
"\t"	{ }
"\r\n"	{ }
"\f"	{ }

"program"	{ return new_symbol(sym.PROG, yytext());}
"break"		{ return new_symbol(sym.BREAK, yytext());}
"else"		{ return new_symbol(sym.ELSE, yytext());}
"const"		{ return new_symbol(sym.CONST, yytext());}
"if"		{ return new_symbol(sym.IF, yytext());}
"do"		{ return new_symbol(sym.DO, yytext());}
"while"		{ return new_symbol(sym.WHILE, yytext());}
"new"		{ return new_symbol(sym.NEW, yytext());}
"print"		{ return new_symbol(sym.PRINT, yytext());}	
"read"		{ return new_symbol(sym.READ, yytext());}
"return"	{ return new_symbol(sym.RETURN, yytext());}
"void"		{ return new_symbol(sym.VOID, yytext());}
"continue"	{ return new_symbol(sym.CONTINUE, yytext());}
"goto"		{ return new_symbol(sym.GOTO, yytext());}
"record"	{ return new_symbol(sym.RECORD, yytext());}

"+"			{ return new_symbol(sym.PLUS, yytext());}
"-"			{ return new_symbol(sym.MINUS, yytext());}
"*"			{ return new_symbol(sym.TIMES, yytext());}
"/"			{ return new_symbol(sym.DIVIDE, yytext());}
"%"			{ return new_symbol(sym.PERCENT, yytext());}

"=="		{ return new_symbol(sym.EQ, yytext());}
"!="		{ return new_symbol(sym.NOT_EQ, yytext());}
">"			{ return new_symbol(sym.GR, yytext());}
">="		{ return new_symbol(sym.GR_EQ, yytext());}
"<"			{ return new_symbol(sym.LS, yytext());}
"<="		{ return new_symbol(sym.LS_EQ, yytext());}

"&&"		{ return new_symbol(sym.AND, yytext());}
"||"		{ return new_symbol(sym.OR, yytext());}
"="			{ return new_symbol(sym.EQUAL, yytext());}
"++"		{ return new_symbol(sym.INC, yytext());}
"--"		{ return new_symbol(sym.DEC, yytext());}

";"			{ return new_symbol(sym.SEMI, yytext());}
","			{ return new_symbol(sym.COMMA, yytext());}
"."			{ return new_symbol(sym.DOT, yytext());}

"("			{ return new_symbol(sym.LPAREN, yytext());}
")"			{ return new_symbol(sym.RPAREN, yytext());}
"["			{ return new_symbol(sym.LBRACK, yytext());}
"]"			{ return new_symbol(sym.RBRACK, yytext());}
"{"			{ return new_symbol(sym.LCURL, yytext());}
"}"			{ return new_symbol(sym.RCURL, yytext());}

"?"			{ return new_symbol(sym.QUEST, yytext());}
":"			{ return new_symbol(sym.COLON, yytext());}

"//"		{ yybegin(COMMENT);}
<COMMENT> . { yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL);}



([0] | [1-9][0-9]*)	{ return new_symbol(sym.NUM_CONST, new Integer(yytext()));}
"true" | "false" { return new_symbol(sym.BOOL_CONST, yytext().equals("true") ? 1 : 0);}
"'"."'" { return new_symbol(sym.CHAR_CONST, new Character(yytext().charAt(1)));}
([a-z]|[A-Z])[a-z|A-Z|0-9|_]*	{ return new_symbol(sym.IDENT, yytext());}

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1));}



