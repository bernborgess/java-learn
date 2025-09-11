/*
 * 2: Loops
 */

import java.util.Scanner;

void main() {
    System.out.println("https://tech.tonyballantyne.com/2014/02/28/2-loops/");
    areWeThereYet();
}

/*
 * 2.1 1 to 10
 * Write a method that prints the numbers 1 to 10
 * 2.1.1 Example
 * 
 * 1: oneToTen()
 * 2: *** Output ***
 * 3: 1
 * 4: 2
 * 5: 3
 * 6: 4
 * 7: 5
 * 8: 6
 * 9: 7
 * 10: 8
 * 11: 9
 * 12: 10
 */
void oneToTen() {
    for (int i = 1; i <= 10; i++) {
        System.out.println(i);
    }
}

/*
 * 2.2 Odd Numbers
 * Write a method that prints the positive odd numbers less than 20
 * 2.2.1 Example
 * 
 * 1: oddNumbers()
 * 2: *** Output ***
 * 3: 1
 * 4: 3
 * 5: 5
 * 6: 7
 * 7: 9
 * 8: 11
 * 9: 13
 * 10: 15
 * 11: 17
 * 12: 19
 */
void oddNumbers() {
    for (int i = 1; i <= 19; i += 2) {
        System.out.println(i);
    }
}

/*
 * 2.3 Square Numbers
 * Write a method that prints the square numbers up to 100
 * 2.3.1 Example
 * 
 * 1: squares()
 * 2: *** Output ***
 * 3: 1
 * 4: 4
 * 5: 9
 * 6: 16
 * 7: 25
 * 8: 36
 * 9: 49
 * 10: 64
 * 11: 81
 * 12: 100
 */
void squares() {
    for (int i = 1; i <= 10; i++) {
        System.out.println(i * i);
    }
}

/*
 * 2.4 Random Numbers
 * Write a for loop to print out four random integers between 1 and 10
 * 2.4.1 Example
 * 
 * 1: random4()
 * 2: *** Output ***
 * 3: 3
 * 4: 5
 * 5: 2
 * 6: 8
 */
void random4() {
    Random r = new Random();
    for (int i = 1; i <= 4; i++) {
        // Generate random integers in range 1 to 10
        int x = r.nextInt(1, 11);
        System.out.println(x);
    }
}

/*
 * 2.5 Even Numbers < n
 * Write a method to print out the positive even numbers less than n
 * 2.5.1 Example
 * 
 * 1: even(20)
 * 2: *** Output ***
 * 3: 2
 * 4: 4
 * 5: 6
 * 6: 8
 * 7: 10
 * 8: 12
 * 9: 14
 * 10: 16
 * 11: 18
 */
void even(int n) {
    for (int i = 2; i < n; i += 2) {
        System.out.println(i);
    }
}

/*
 * 2.6 Powers of 2
 * Write a method to print out the powers of 2 from 2^1 up to 2^n
 * 2.6.1 Example
 * 
 * 1: powers(8)
 * 2: *** Output ***
 * 3: 2
 * 4: 4
 * 5: 8
 * 6: 16
 * 7: 32
 * 8: 64
 * 9: 128
 * 10: 256
 */
void powers(int n) {
    for (int i = 1; i <= n; i++) {
        System.out.println(1L << i);
    }
}

/*
 * 2.7 Are we there yet?
 * Write a program that outputs “Are we there yet?” and then waits for input. If
 * the input is “Yes” the program outputs “Good!” and exits, otherwise the
 * program loops.
 * 2.7.1 Example
 * 
 * 1: "Are we there yet?"
 * 2: No
 * 3: "Are we there yet?"
 * 4: Spoons
 * 5: "Are we there yet?"
 * 6: Yes
 * 7: Good!
 */
void areWeThereYet() {
    var scanner = new Scanner(System.in);
    System.out.println("Are we there yet?");
    var areWe = scanner.nextLine();

    // while (!"Yes".equals(areWe)) {
    // System.out.println("Are we there yet?");
    // areWe = scanner.nextLine();
    // }

    if (!"Yes".equals(areWe)) {
        // scanner.close(); // Kaboom
        areWeThereYet();
        // For some reason, if I close the
        // scanner BEFORE the recursive call
        // Scanner.nextLine won't work the next time...
    } else {
        System.out.println("Good!");
    }

    scanner.close();
}

/*
 * 2.8 Triangle
 * Write a method that uses nested loops to produce the following pattern
 * 
 * 1: triangle()
 * 2: *** Output ***
 * 3: *
 * 4: **
 * 5: ***
 * 6: ****
 * 7: *****
 */
void triangle() {
    int n = 5; // Could be a parameter...
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}

/*
 * 2.9 Table Square
 * Write a method that prints out a 4 x 4 table square
 * 2.9.1 Example
 * 
 * 1: tableSquare()
 * 2: *** Output ***
 * 3: A 4 x 4 table square
 * 4: | 1 | 2 | 3 | 4 |
 * 5: | 1 | 2 | 3 | 4 |
 * 6: | 2 | 4 | 6 | 8 |
 * 7: | 3 | 6 | 9 | 12 |
 * 8: | 4 | 8 | 12 | 16 |
 */
void tableSquare() {
    int n = 4;
    int m = 4;
    Random r = new Random();

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (j == 0)
                System.out.print("|");
            int x = r.nextInt(1, 21);
            System.out.print(" " + x + " |");
        }
        System.out.println();
    }
}

/*
 * 2.10 Table Squares
 * Extend your answer to the last question produce a method that will print out
 * a n x n table square
 * 2.10.1 Example
 * 
 * 1: tableSquares(6)
 * 2: *** Output ***
 * 3: A 6 x 6 table square
 * 4: | 1 | 2 | 3 | 4 | 5 | 6 |
 * 5: | 2 | 4 | 6 | 8 | 10 | 12 |
 * 6: | 3 | 6 | 9 | 12 | 15 | 18 |
 * 7: | 4 | 8 | 12 | 16 | 20 | 24 |
 * 8: | 5 | 10 | 15 | 20 | 25 | 30 |
 * 9: | 6 | 12 | 18 | 24 | 30 | 36 |
 */
void tableSquares(int n) {
    Random r = new Random();

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (j == 0)
                System.out.print("|");
            int x = r.nextInt(1, 21);
            System.out.print(" " + x + " |");
        }
        System.out.println();
    }
}