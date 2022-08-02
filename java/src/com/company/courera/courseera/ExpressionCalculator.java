import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ExpressionCalculator {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var exp = sc.nextLine();
        var ec = new ExpressionCalculator(exp);
        System.out.println(ec.calculate());
    }

    private final Deque<Integer> valStack = new ArrayDeque<>();
    private final Deque<Character> operatorStack = new ArrayDeque<>();
    private final String exp;

    public ExpressionCalculator(final String exp) {
        this.exp = exp;
    }

    public int calculate() {
        for (int i = 0; i < exp.length(); i++) {
            char el = exp.charAt(i);

            if ((el == '*') || (el == '+') || (el == '-') || (el == '/')) {
                operatorStack.push(el);
            } else if (Character.isDigit(el)) {
                valStack.push(Character.getNumericValue(el));
            } else if (el == ')') {
                calculateLastElementInStack();
            }
        }

        while (!operatorStack.isEmpty()) {
            calculateLastElementInStack();
        }

        return valStack.pop();
    }

    private void calculateLastElementInStack() {
        int p = valStack.pop();
        int pp = valStack.pop();
        char oper = operatorStack.pop();

        switch (oper) {
            case '+' -> valStack.push(pp + p);
            case '-' -> valStack.push(pp - p);
            case '*' -> valStack.push(pp * p);
            case '/' -> valStack.push(pp / p);
        }
    }
}
