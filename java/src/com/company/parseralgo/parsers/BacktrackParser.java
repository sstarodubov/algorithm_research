
public class BacktrackParser {


    public boolean parse(final String s) {
        source = s;
        cursor = 0;
        savedCursor = 0;
        return E() && cursor == s.length();
    }

    private int cursor;
    private int savedCursor;
    private String source;

    private boolean term(char expected) {
        if (cursor == source.length()) return false;
        return source.charAt(cursor++) == expected;
    }

    private void saveCursor() {
        savedCursor = cursor;
    }

    private void backtrack() {
        cursor = savedCursor;
    }

    public boolean F() {
        return term('a');
    }

    public boolean T() {
        saveCursor();
        boolean t1 = T1();
        if (t1) {
            return true;
        }

        backtrack();
        saveCursor();
        return T2();
    }

    public boolean T1() {
        return F() && term('*') && T();
    }

    public boolean T2() {
        return F();
    }

    public boolean E1() {
        return T() && term('+') && E();
    }

    public boolean E2() {
        return T();
    }

    public boolean E() {
        saveCursor();
        boolean val = E1();
        if (val) {
            return val;
        }

        backtrack();
        saveCursor();

        return E2();
    }
}
