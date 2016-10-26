package exemple1;

%%

%unicode

USUEL=[:letter:]+
ENTIER_SIMPLE=[0-9]+
IDENTIFICATEUR= [A-Za-z][A-Za-z0-9]*
OPERATEUR=[-+*/]
%% 

{IDENTIFICATEUR}|{ENTIER_SIMPLE}|{OPERATEUR}
      {return new Yytoken(yytext());}

[^\-*/+A-Za-z0-9]
      {}  
