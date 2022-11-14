package LinearDataStructuresExercises;


import java.util.ArrayDeque;

public class BalancedParentheses {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }


    public Boolean solve() {
        char[] toSolve = parentheses.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();


        if (toSolve.length % 2 != 0) {
            return false;
        }

        for (int i = 0; i < toSolve.length; i++) {
            if (toSolve[i] == '(' || toSolve[i] == '{' || toSolve[i] == '[') {
                stack.push(toSolve[i]);
            } else {
                char closed = toSolve[i];
                if (closed == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (closed == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (closed == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}