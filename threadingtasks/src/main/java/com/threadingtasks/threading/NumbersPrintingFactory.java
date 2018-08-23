/**.
 * This package contains classes to create connection pool.
 */
package com.threadingtasks.threading;

/**
 * @author Akshaya_Bindugowri
 */
public class NumbersPrintingFactory {

     /**
     * @param choice choice of user.
     * @param threadName Name of Thread.
     * @return  NumbersPrintinginstance.
     */
    NumbersPrinting createInstance(final int choice, final String threadName) {
      NumbersPrinting numbersPrintingInstance = null;
      if (choice == 1) {
        numbersPrintingInstance = new SynchronizedImplementation(threadName);
      } else {
        numbersPrintingInstance = new ReentrantLockImplementation(threadName);
      }
      return numbersPrintingInstance;
    }
}
