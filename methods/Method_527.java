public int scanFieldInt(char[] fieldName){
  matchStat=UNKNOWN;
  if (!charArrayCompare(fieldName)) {
    matchStat=NOT_MATCH_NAME;
    return 0;
  }
  int offset=fieldName.length;
  char chLocal=charAt(bp + (offset++));
  final boolean negative=chLocal == '-';
  if (negative) {
    chLocal=charAt(bp + (offset++));
  }
  int value;
  if (chLocal >= '0' && chLocal <= '9') {
    value=chLocal - '0';
    for (; ; ) {
      chLocal=charAt(bp + (offset++));
      if (chLocal >= '0' && chLocal <= '9') {
        value=value * 10 + (chLocal - '0');
      }
 else       if (chLocal == '.') {
        matchStat=NOT_MATCH;
        return 0;
      }
 else {
        break;
      }
    }
    if (value < 0 || offset > 11 + 3 + fieldName.length) {
      if (value != Integer.MIN_VALUE || offset != 17 || !negative) {
        matchStat=NOT_MATCH;
        return 0;
      }
    }
  }
 else {
    matchStat=NOT_MATCH;
    return 0;
  }
  if (chLocal == ',') {
    bp+=offset;
    this.ch=this.charAt(bp);
    matchStat=VALUE;
    token=JSONToken.COMMA;
    return negative ? -value : value;
  }
  if (chLocal == '}') {
    chLocal=charAt(bp + (offset++));
    if (chLocal == ',') {
      token=JSONToken.COMMA;
      bp+=offset;
      this.ch=this.charAt(bp);
    }
 else     if (chLocal == ']') {
      token=JSONToken.RBRACKET;
      bp+=offset;
      this.ch=this.charAt(bp);
    }
 else     if (chLocal == '}') {
      token=JSONToken.RBRACE;
      bp+=offset;
      this.ch=this.charAt(bp);
    }
 else     if (chLocal == EOI) {
      token=JSONToken.EOF;
      bp+=(offset - 1);
      ch=EOI;
    }
 else {
      matchStat=NOT_MATCH;
      return 0;
    }
    matchStat=END;
  }
 else {
    matchStat=NOT_MATCH;
    return 0;
  }
  return negative ? -value : value;
}
