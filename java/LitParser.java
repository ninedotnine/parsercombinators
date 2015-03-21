/* generic parser, can currently handle char and String */
import java.text.StringCharacterIterator;
public class LitParser implements Parser {
    private Parser p;

    /* constructor for a char */
    public LitParser(char ch) {
        this.p = new CharParser(ch);
    }

    /* constructor for a String */
    public LitParser(String str) {
        this.p = new StringParser(str);
    }

    public String parse(StringCharacterIterator input) {
        return p.parse(input);
    }
}
