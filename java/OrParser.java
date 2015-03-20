import java.util.*;
import java.text.StringCharacterIterator;
public class OrParser implements Parser {
    Parser p1;
    Parser p2;

    public OrParser(Parser p1, Parser p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String parse(StringCharacterIterator input) {
        String str1 = p1.parse(input);
        if (str1 != null) {
            return str1;
        }
        String str2 = p2.parse(input);
        if (str2 != null) {
            return str2;
        }
        return null;
    }
}


