// Bellard's formula
// good for over 500 decimal places in 75ms



public static BigDecimal bigPi(int max,int digits) {
    BigDecimal num2power6 = new BigDecimal(64);
    BigDecimal sum = new BigDecimal(0);
    for(int i = 0; i < max; i++ ) {
        BigDecimal tmp;
        BigDecimal term ; 
        BigDecimal divisor;
        term = new BigDecimal(-32); 
        divisor = new BigDecimal(4*i+1); 
        tmp =  term.divide(divisor, digits, BigDecimal.ROUND_FLOOR);
        term = new BigDecimal(-1); 
        divisor = new BigDecimal(4*i+3); 
        tmp = tmp.add(term.divide(divisor, digits, BigDecimal.ROUND_FLOOR));
        term = new BigDecimal(256); 
        divisor = new BigDecimal(10*i+1); 
        tmp = tmp.add(term.divide(divisor, digits, BigDecimal.ROUND_FLOOR));
        term = new BigDecimal(-64); 
        divisor = new BigDecimal(10*i+3); 
        tmp = tmp.add(term.divide(divisor, digits, BigDecimal.ROUND_FLOOR));
        term = new BigDecimal(-4); 
        divisor = new BigDecimal(10*i+5); 
        tmp = tmp.add(term.divide(divisor, digits, BigDecimal.ROUND_FLOOR));
        term = new BigDecimal(-4); 
        divisor = new BigDecimal(10*i+7); 
        tmp = tmp.add(term.divide(divisor, digits, BigDecimal.ROUND_FLOOR));
        term = new BigDecimal(1); 
        divisor = new BigDecimal(10*i+9); 
        tmp = tmp.add(term.divide(divisor, digits, BigDecimal.ROUND_FLOOR));
        int s = ((1-((i&1)<<1)));
        divisor = new BigDecimal(2); 
        divisor = divisor.pow(10*i).multiply(new BigDecimal(s));
        sum = sum.add(tmp.divide(divisor, digits, BigDecimal.ROUND_FLOOR));
    }
    sum = sum.divide(num2power6,digits, BigDecimal.ROUND_FLOOR);
    return sum;
}
