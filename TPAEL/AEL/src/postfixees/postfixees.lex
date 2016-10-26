package postfixees;

%%

%unicode
%line
%column

ENTIER_SIMPLE=[0-9]+
PLUS=[+|plus]
MINUS=[-|minus]
QUO=[/|quo]
MULT=[*|mult]
SEPARATEUR=[\s\n\r\t\f]

%% 

{ENTIER_SIMPLE}
      { return new Valeur(yytext()); }

{PLUS}
      { return new Plus(yytext()); }


{MINUS}
      { return new Minus(yytext()); }

{QUO}
      { return new Quo(yytext()); }

{MULT}
	  { return new Mult(yytext()); }
