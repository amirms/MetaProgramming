grammar While;

prog		: statement+ ;
block		: '{' statement* '}' | statement ;
statement	: r_if | r_while | r_assignment ;
r_if		: 'if' exp 'then' block 'else' block ;
r_while		: 'while' exp 'do' block ;
r_assignment	: ID ':=' exp ';' ;

ID		: [a-zA-Z][0-9a-zA-Z]* ;

// Statements
exp		: Int | ID | comparison | arithmetic | booleanExp | Bool ;
Int		: [0-9] | [1-9][0-9]+ ;
booleanExp	: '(' exp ')' | '(' exp Concat exp ')';
Concat		: 'or' | 'and' | '||' | '&&' ;
comparison	: '(' exp BooleanOperator exp ')' ;
arithmetic	: '(' exp IntOperator exp ')' ;
BooleanOperator	: ('<'|'>'|'==') ;
IntOperator	: ('+'|'-'|'*'|'/') ;
Bool		: 'true' | 'false' ;

WS		: [ \t\n\r]* -> skip ;
