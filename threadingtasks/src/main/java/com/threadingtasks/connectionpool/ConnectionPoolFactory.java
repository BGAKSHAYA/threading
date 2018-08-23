/**.
 * This package contains classes to create connection pool.
 */
package com.threadingtasks.connectionpool;

/**
 * @author Akshaya_Bindugowri
 */
public class ConnectionPoolFactory {

     /**
     * @param choice choice of user.
     * @return ConnectionPool instance
     */
    ConnectionPool createInstanceOfPool(final int choice) {
      ConnectionPool connectionPoolInstance = null;
      if (choice == 1) {
        connectionPoolInstance = LinkedListImplementation.getInstance();
      } else {
        connectionPoolInstance = ArrayListImplementation.getInstance();
      }
        return connectionPoolInstance;
    }
}
