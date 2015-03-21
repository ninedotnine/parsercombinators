import java.text.StringCharacterIterator;
public class StringParser implements Parser {
    private String str;

    public StringParser(String str) {
        this.str = str;
    }

    public String parse(StringCharacterIterator input) {
        int index = input.getIndex(); // save current position in input stream
        for (int i = 0; i < str.length(); i++) {
            Parser p = new LitParser(str.charAt(i));
            if (p.parse(input) == null) {
                input.setIndex(index); // go back
                return null;
            }
        }
        return str;
    }
}
