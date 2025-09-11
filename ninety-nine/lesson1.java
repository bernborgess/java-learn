/*
 * 1: How to Answer These Questions
 * Write methods to solve all of the questions. Here are two example questions
 * and their solutions. Notice that the first method prints a value, the second
 * method returns a value.
 */
void main() {
    System.out.println("https://tech.tonyballantyne.com/2014/02/28/1-how-to-answer-these-questions/");
}

/*
 * 1.1 Hello <Name>
 * Write a method that accepts a name as a parameter and prints out “Hello ”
 * <name>
 * 1.1.1 Example
 * 
 * 1: hello("Kim")
 * 2: *** Output ***
 * 3: Hello Kim
 */
void hello(String name) {
    System.out.println("Hello " + name);
}

/*
 * 1.2 Average of two numbers
 * Write a method that accepts two numbers and returns the average of the two
 * numbers.
 * 1.2.1 Example
 * 
 * 1: System.out.println(average(3,4));
 * 2: *** Output ***
 * 3: 3.5
 */
double average(double a, double b) {
    return (a + b) / 2.0;
}
