package DataStructures.Stacks;

import java.util.Stack;

/**
 * 중첩 괄호 문제는 다음의 순서를 결정하는 문제입니다.
 * 대괄호가 올바르게 중첩되어 있습니다. 일련의 괄호가 올바르게 간주됩니다
 * 다음 조건 중 하나라도 해당되면 중첩됩니다.-s가 비어 있음
 * -s에 형식 (U) 또는 [U] 또는 {U} 여기서 U는 올바르게 중첩 된 문자열입니다. -s 형식
 * V와 W가 올바르게 중첩 된 문자열입니다
 * "() () [()]"은 올바르게 중첩되어 있지만 "[(()]"은 그렇지 않습니다. 
 * is_balanced는 일련의 대괄호 인 문자열 S를 입력으로 사용합니다.
 * S가 중첩되어 있으면 true를, 그렇지 않으면 false를 반환합니다.
 *
 * @author akshay sharma
 * @author <a href="https://github.com/khalil2535">khalil2535<a>
 * @author shellhub
 */
class BalancedBrackets {

    /**
     * {@code leftBracket} 와 {@code rightBracket} 쌍인지 아닌지 검사한다.
     *
     * @param leftBracket   left bracket
     * @param rightBracket right bracket
     * @return {@code true} if {@code leftBracket} and {@code rightBracket} is paired,
     * otherwise {@code false}
     */
    public static boolean isPaired(char leftBracket, char rightBracket) {
        char[][] pairedBrackets = {
                {'(', ')'},
                {'[', ']'},
                {'{', '}'},
                {'<', '>'}
        };
        for (char[] pairedBracket : pairedBrackets) {
            if (pairedBracket[0] == leftBracket && pairedBracket[1] == rightBracket) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if {@code brackets} is balanced
     *
     * @param brackets the brackets
     * @return {@code true} if {@code brackets} is balanced, otherwise {@code false}
     */
    public static boolean isBalanced(String brackets) {
        if (brackets == null) {
            throw new IllegalArgumentException("brackets is null");
        }
        Stack<Character> bracketsStack = new Stack<>();
        for (char bracket : brackets.toCharArray()) {
            switch (bracket) {
                case '(':
                case '[':
                case '{':
                    bracketsStack.push(bracket);
                    break;
                case ')':
                case ']':
                case '}':
                    if (bracketsStack.isEmpty() || !isPaired(bracketsStack.pop(), bracket)) {
                        return false;
                    }
                    break;
                default: /* other character is invalid */
                    return false;
            }
        }
        return bracketsStack.isEmpty();
    }


    public static void main(String[] args) {
        assert isBalanced("[()]{}{[()()]()}");
        assert !isBalanced("[(])");
    }
}
