package jadelex ;

%%

%class TokenizerV1
%implements Tokenizer
%public
%unicode
%line
%column

BAISSER=[BAISSER|baisser]
LEVER=[LEVER|lever]
SEPARATEUR=[\s|\n|\t|\r|\f]
COMMENTAIRE=[(\/\/.*\n)|(\/\/*.*\/\/)]
UNKNOWN=[[:alnum:]]
%%
{BAISSER}
    {return new PenMode(true);}

{LEVER}
    {return new PenMode(false);}


{SEPARATEUR}
    {}
 
{COMMENTAIRE}
    {}

{UNKNOWN}
    { return new Unknown(Yytext());}

