/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fil.coo.dungeon.menu;

import java.util.Scanner;

/**
 *
 * @author boin
 */
public class Menu {

    private int choice;

    public void show() {
        System.out.println("1 - Play");
        System.out.println("2 - About");

        this.addChoice(new Scanner(System.in));
    }

    /**
     * Check range of choice.
     *
     * @param choice to be checked
     * @return true if is valid choice
     */
    private boolean isValidChoice(int choice) {
        return (choice == 1) || (choice == 2);
    }

    /**
     * Check user input about choice.
     *
     * @param scanner - user input
     */
    private void addChoice(Scanner scanner) {
        boolean badChoice = false;
        do {
            if (badChoice) {
                System.err.println("Choice out of range");
            }
            System.out.print("So: ");
            this.choice = Integer.parseInt(scanner.next());
        } while ((badChoice = !isValidChoice(choice)));
    }

    /**
     * Return user choice.
     *
     * @return choice
     */
    public int getChoice() {
        return this.choice;
    }

}
