package com.threadingtasks;
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
      long i = 0;
      while (true) {
          new Thread().start();
          System.out.println("Thread number " + i);
          i += 1;

      }
    }
}
