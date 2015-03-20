import java.util.*;
import java.text.StringCharacterIterator;
public class BetweenParser implements Parser {
    Parser p1;
    Parser p2;
    Parser p3;

    public BetweenParser(Parser p1, Parser p2, Parser p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public String parse(StringCharacterIterator input) {
        String str1 = p1.parse(input);
        if (str1 == null) {
            return null;
        }
        String str2 = p2.parse(input);
        if (str2 == null) {
            return null;
        }
        String str3 = p3.parse(input);
        if (str3 == null) {
            return null;
        }
        return str2;
    }
}
