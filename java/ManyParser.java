import java.util.*;
import java.text.StringCharacterIterator;
public class ManyParser implements Parser {
    Parser p;
    public ManyParser(Parser p) {
        this.p = p;
    }

    public String parse(StringCharacterIterator input) {
        String str = p.parse(input);
        if (str == null) {
            return null;
        }
        String str2 = str;
        while ((str2 = p.parse(input)) != null) {
            str = str + str2;
        }
        return str;
    }
}
