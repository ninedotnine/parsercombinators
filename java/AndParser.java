import java.util.*;
import java.text.StringCharacterIterator;
public class AndParser implements Parser {
    Parser p1;
    Parser p2;
    public AndParser(Parser p1, Parser p2) {
        this.p1 = p1;
        this.p2 = p2;
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
        return str1 + str2;
    }
}
