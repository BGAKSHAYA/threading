/**.
 * This package contains classes to create connection pool.
 */
package com.threadingtasks.threading;


/**
 * @author Akshaya_Bindugowri
 */
public final class SynchronizedImplementation implements NumbersPrinting,
                              Runnable {
  /** Name of Thread. */
  private String threadName;
  /** Ten.*/
  private static final int TEN = 10;
  /** Counter. */
  private static int counter = 1;
  /** Object. */
  private static Object object = new Object();

  /** constructor to set the Name of Thread.
   * @param threadname Name of Thread.
   */
  SynchronizedImplementation(final String threadname) {
    this.threadName  = threadname;
  }
    /**
     * run method of Runnable interface.
     */
  public void run() {
       while (counter < TEN) {
           synchronized (object) {
               System.out.println(threadName + "---" + counter);
               counter += 1;
               object.notify();
               try {
                  object.wait();
               } catch (InterruptedException x) {
                   System.out.println("Interrupted!");
               }

           }
       }
  }

}

