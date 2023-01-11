/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semestralproject;

import java.io.InputStream;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author smutn
 */
public class UserInputManager {

    private Scanner _sc;

    public UserInputManager(InputStream source) {
        _sc = new Scanner(source);
    }

    /**
     * Will repeatedly ask user to enter integer until user enters valid input which meets given condition
     * @param promptMessage message to show when asking for input
     * @param failMessage message to show when user enters invalid input
     * @param condition condition which must be met in order to get valid input
     * @return valid user input
     */
    public int userNumberInput(String promptMessage, String failMessage, Predicate<Integer> condition) {
        System.out.print(promptMessage);
        int numberUserInput;
        while (true) {
            try {
                numberUserInput = Integer.parseInt(_sc.nextLine());
                if (condition != null && !condition.test((numberUserInput))) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println(failMessage);
                System.out.print(promptMessage);
            }
        }
        return numberUserInput;
    }

    public char userCharInput(String promptMessage) {
        System.out.print(promptMessage);
        return _sc.next().charAt(0);
    }
}
