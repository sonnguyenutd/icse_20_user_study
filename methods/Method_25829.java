private static Integer unop(Kind kind,int value){
switch (kind) {
case UNARY_PLUS:
    return +value;
case UNARY_MINUS:
  return -value;
case BITWISE_COMPLEMENT:
return ~value;
default :
return null;
}
}
