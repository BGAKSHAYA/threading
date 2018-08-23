/**.
 * This package contains classes to create connection pool.
 */
package com.threadingtasks.threading;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Akshaya_Bindugowri
 */
public final class ReentrantLockImplementation implements NumbersPrinting,
                              Runnable {
  /** Name of Thread. */
  private String threadName;
  /** Lock Object. */
  private static final ReentrantLock NEWLOCK = new ReentrantLock();
  /** Ten.*/
  private static final int TEN = 10;
  /** Counter. */
  private static int counter = 1;

  /** constructor to set the Name of Thread.
   * @param threadname Name of Thread.
   */
  ReentrantLockImplementation(final String threadname) {
    this.threadName  = threadname;
  }
    /**
     * run method of Runnable interface.
     */
  public void run() {
  if (NEWLOCK.tryLock()) {
      NEWLOCK.lock();
      while (counter <= TEN) {
          try {
            System.out.println(this.threadName + "---" + counter);
            counter += 1;
            Thread.sleep(1);
        } catch (InterruptedException x) {
              System.out.println("Interrupted!");
        } finally {
          NEWLOCK.unlock();
        }

        }
    }
  }
}

