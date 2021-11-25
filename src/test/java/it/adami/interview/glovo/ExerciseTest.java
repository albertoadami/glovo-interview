package it.adami.interview.glovo;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


public class ExerciseTest {





    @Test
    public void findFirstNotRepeatableCharNotFound() {
        String test = "BCABAC";
        Character result = Exercise.findFirstNotRepeatableChar(test);

        assertNull(result);
    }

    @Test
    public void findFirstNotRepeatableChaFind() {
        String test1 = "ABCA";
        String test2 = "BAC";
        String test3 = "GlovoOnGlovo";
        String test4 = "What is the first non-repeated character?";

        Character result1 = Exercise.findFirstNotRepeatableChar(test1);
        Character result2 = Exercise.findFirstNotRepeatableChar(test2);
        Character result3 = Exercise.findFirstNotRepeatableChar(test3);
        Character result4 = Exercise.findFirstNotRepeatableChar(test4);


        assertEquals(result1, new Character('B'));
        assertEquals(result2, new Character('B'));
        assertEquals(result3, new Character('O'));
        assertEquals(result4, new Character('W'));

    }

    @Test
    public void checkIfStingIsBalancedTest() {
        String string1 = "([)]";
        String string2 = "([]";
        String string3 = "(((((((((())))))))))";


        assertEquals(Exercise.checkIfStingIsBalanced(string1), false);
        assertEquals(Exercise.checkIfStingIsBalanced(string2), false);
        assertEquals(Exercise.checkIfStingIsBalanced(string3), true);

    }

    @Test
    public void reverseTreeTest() {

        Node tree1 = new Node(1, new Node(2, new Node(3, null, null), null), null);
        Node tree2 = new Node(1, new Node(2, new Node(4, null, null), new Node(5, null, null)), new Node(3, new Node(6, null, null), null));

        Node mirrorTree1 = new Node(1, null, new Node(2, null, new Node(3, null, null)));
        Node mirrorTree2 = new Node(1, new Node(3, null, new Node(6, null, null)), new Node(2, new Node(5, null, null), new Node(4, null, null)));

        assertEquals(Exercise.reverseTree(tree1), mirrorTree1);
        assertEquals(Exercise.reverseTree(tree2), mirrorTree2);



    }

}