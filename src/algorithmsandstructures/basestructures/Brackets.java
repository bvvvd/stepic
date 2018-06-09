package algorithmsandstructures.basestructures;

import java.util.*;
import java.util.stream.Collectors;

class Brackets {
    public static void main(String[] args) {
        List<Element> list = convertToElements(getLine());
        check(list);
    }

    private static List convertToElements(String line) {
        List<Element> elements = new ArrayList<>();
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Element element = new Element(chars[i], i + 1);
            elements.add(element);
        }

        return elements
                .stream()
                .filter(element -> {
                    char value = element.value;
                    return value == '{' ||
                            value == '[' ||
                            value == '(' ||
                            value == ')' ||
                            value == ']' ||
                            value == '}';
                })
                .collect(Collectors.toList());
    }

    private static String getLine() {
        return new Scanner(System.in).nextLine();
    }

    private static void check(List<Element> elements) {
        Stack<Element> stack = new Stack<>();

        for (Element element : elements) {
            if (isOpeningBracket(element)) {
                stack.push(element);
            }

            if (isClosingBracket(element)) {
                if (pair(stack, element)) {
                    stack.pop();
                } else {
                    System.out.println(element.position);
                    System.exit(0);
                }
            }
        }

        System.out.println(
                stack.isEmpty()
                ? "Success"
                : stack.pop().position);
    }

    private static boolean pair(Stack<Element> stack, Element element) {
        if (stack.isEmpty()) {
            System.out.println(element.position);
            System.exit(0);
        }

        char value = stack.peek().value;

        return match(value, element);
    }

    private static boolean match(char stackValue, Element element) {
        char otherValue = element.value;

        return stackValue == '[' && otherValue == ']' ||
                stackValue == '(' && otherValue == ')' ||
                stackValue == '{' && otherValue == '}';

    }

    private static boolean isClosingBracket(Element element) {
        char value = element.value;

        return value == '}' ||
                value == ')' ||
                value == ']';
    }

    private static boolean isOpeningBracket(Element element) {
        char value = element.value;

        return value == '{' ||
                value == '(' ||
                value == '[';
    }

    private static class Element {
        private char value;
        private int position;

        public Element(char value, int position) {
            this.value = value;
            this.position = position;
        }

    }
}