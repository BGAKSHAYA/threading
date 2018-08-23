
package com.threadingtasks.threading;

import java.util.Scanner;


/**
 * @author Akshaya_Bindugowri
 */
public final class App {
  /** This private constructor overloads default constructor.
       * and won't be called
  */
  private App() {
  }
  /**.
   * @param args Command Line Arguments
   */
    public static void main(final String[] args) {
      Scanner consoleScanner = new Scanner(System.in);


      System.out.println(" ** Make threads to print natural numbers using ** "
            + "\n 1.Synchronised blocks"
            + "\n 2.Re entrant locks"
            + "\n Enter your choice");
      int choice = consoleScanner.nextInt();

      Thread thread1 = new Thread((Runnable) new NumbersPrintingFactory()
              .createInstance(choice, "Thread 1"));
      Thread thread2 = new Thread((Runnable) new NumbersPrintingFactory()
              .createInstance(choice, "Thread 2"));

      thread1.start();
      thread2.start();

      consoleScanner.close();
    }
}
