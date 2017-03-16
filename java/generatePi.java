// Bellard's formula
// https://en.wikipedia.org/wiki/Bellard's_formula
// good for over 500 decimal places

// for bigPi(200,2000)
// 3.
// 14159265358979323846264338327950288419716939937510582097494459230781640628620899
// 86280348253421170679821480865132823066470938446095505822317253594081284811174502
// 84102701938521105559644622948954930381964428810975665933446128475648233786783165
// 27120190914564856692346034861045432664821339360726024914127372458700660631558817
// 48815209209628292540917153643678925903600113305305488204665213841469519415116094
// 33057270365759591953092186117381932611793105118548074462379962749567351885752724
// 89122793818301194912983367336244065664308602139494639522473719070217986094370277
// 05392171762931767523846748184676694051320005611526979981607242018469874601593584
// 39998763999279510982117526898249607898062008719876955750421058806690313363126091
// 89293843149321452372234246488529443180269339081089454507344282243991032459463954
// 25483687692928265078318566236890755062649021968696723911330541353320333273179327
// 06413376119054342568657919351687936047840448509272687930514143792357444791950636
// 73349779280349895273445767597457315498972700872375877892313339439509782258365084
// 85753952511413271036464793144689453682032634934688565059396678739112894995026248
// 40244244066208222979331975284868906493957094246499339684179346779123785544059047
// 35109397989700756248527876210713363864252156556885042950773468636774062711999455
// 54309500364867248885679690810714192258759388055260862012654787191729500674656733
// 08006243060602928853455906229757573522448525128842889090359496584564489156895738
// 61377537643546019234228538157677744932092130841263804870478145550609574873461993
// 56263905009611357805357128000991843260409241794958936018690494508858496827801448
// 84989656885520700245550172279631522803014197626881233990952253506846320586302173
// 03242301348386009477054101847434835020432786613024340517744524017740414240604356
// 95648299242408400289669608633626460194280733103370666803190066367921950543007162
// 53596022585682972145719084055685670171540437779799071120064372508050883526155838
// 72567317094675254691832004603921881441631556960451032359848193384651876257146112



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
