import java.text.StringCharacterIterator;
import java.util.*;
public class Main {
    public static final String input = "public   class Main public static void main";
    /*
    public static final String input = "hello Delllllonononon yeh k [308] k";
    public static void main(String [] args) {
        System.out.println(input);
        StringCharacterIterator itr8r = new StringCharacterIterator(input);
        Parser hp = new LitParser('h');
        Parser ep = new LitParser('e');
        String parsed1 = hp.parse(itr8r);
        String parsed2 = ep.parse(itr8r);
        System.out.println(parsed1);
        System.out.println(parsed2);

        Parser lp = new LitParser('l');
        Parser llp = new AndParser(lp, lp);
        String parsed3 = llp.parse(itr8r);
        System.out.println(parsed3);

        Parser o_p = new AndParser(new LitParser('o'), new LitParser(' '));
        System.out.println(o_p.parse(itr8r));

        Parser dp = new LitParser('d');
        Parser Dp = new LitParser('D');
        Parser dDp = new OrParser(dp, Dp);
        String parsed4 = dDp.parse(itr8r);
        System.out.println(parsed4);

        String parsed5 = ep.parse(itr8r);
        System.out.println(parsed5);

        Parser llllp = new ManyParser(lp);
        String parsed6 = llllp.parse(itr8r);
        System.out.println(parsed6);

        Parser ononp = new ManyParser(new AndParser(new LitParser('o'), 
                                                    new LitParser('n')));
        String parsed7 = ononp.parse(itr8r);
        System.out.println(parsed7);

        Parser spacep = new LitParser(' ');
        Parser yehp = new AndParser(new AndParser(new LitParser('y'), ep), hp);
        Parser _yehp_ = new BetweenParser(spacep, yehp, spacep);
        String parsed8 = _yehp_.parse(itr8r);
        System.out.println(parsed8);

        String parsed9 = new AlphaParser().parse(itr8r);
        System.out.println(parsed9);
        spacep.parse(itr8r);

        Parser bracketp = new OrParser(new LitParser('['), new LitParser(']'));
        Parser indexp = new BetweenParser(bracketp, 
                                          new NumberParser(),
                                          bracketp);
        String parsed10 = indexp.parse(itr8r);
        System.out.println(parsed10);
        spacep.parse(itr8r);

        String parsed11 = new AlphaNumericParser().parse(itr8r);
        System.out.println(parsed11);
    }
    */
    public static void main(String [] args) {
        StringCharacterIterator itr8r = new StringCharacterIterator(input);
        Parser wordp = new ManyParser(new AlphaParser());
        String str = wordp.parse(itr8r);
        System.out.println(str);

        Parser spacep = new ManyParser(new LitParser(' '));
        spacep.parse(itr8r);

        str = wordp.parse(itr8r);
        System.out.println(str);

    }
}
