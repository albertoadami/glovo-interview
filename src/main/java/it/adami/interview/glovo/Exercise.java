package it.adami.interview.glovo;

import java.util.*;

class Node {
    private int value;
    private Node left;
    private Node right;

    Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }
}

public class Exercise {

    static Character findFirstNotRepeatableChar(String s) {

        if(s == null) {
            return null;
        }

        Character result = null;
        Map<Character, Integer> characterCounts = new HashMap<>();
        for(int i=0; i<s.length();i++) {
            Character element = s.charAt(i);
            Integer findResult = characterCounts.get(element);
            if(findResult == null) {//first occurency
                characterCounts.put(element, 1);
            } else {
                characterCounts.put(element, findResult + 1);
            }
        }

        boolean findUnique = false;
        for(int j=0; j<s.length() && !findUnique;j++)  {
            Character element = s.charAt(j);

            Integer characterCount = characterCounts.get(element);

            if(characterCount == 1) {
                result = element;
                findUnique = true;
            }

        }

        //uniques here is containing all the unique characters

        return result;

    }


    public static boolean checkIfStingIsBalanced(String s) {

        if(s == null) {
            return true;
        }

        Stack<Character> latestParentherisation = new Stack<>();
        boolean isValid = true;

        for(int i=0; i<s.length() && isValid;i++) {
            Character c = s.charAt(i);

            if(c == '(' || c == '[' || c == '{') {
                latestParentherisation.push(c);
            } else {
                if(latestParentherisation.isEmpty()) {
                    isValid = false;
                } else {
                    Character latestCharacter = latestParentherisation.pop();
                    if(latestCharacter == '(' && c != ')') {
                        isValid = false;
                    } else if(latestCharacter == '[' && c != ']') {
                        isValid = false;
                    } else if(latestCharacter == '{' && c != '}') {
                        isValid = false;
                    }
                }
            }

        }

        if(!latestParentherisation.isEmpty()) {
            return false;
        }

        return isValid;

    }


    public static Node reverseTree(Node node) {
        if(node == null) {
            return null;
        } else {
            return new Node(node.getValue(), reverseTree(node.getRight()), reverseTree(node.getLeft()));
        }
    }



}
