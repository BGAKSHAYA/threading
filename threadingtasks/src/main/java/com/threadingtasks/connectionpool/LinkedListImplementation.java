/**.
 * This package contains classes to create connection pool.
 */
package com.threadingtasks.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.util.List;
import java.util.LinkedList;
/**
 * @author Akshaya_Bindugowri
 */
public final class LinkedListImplementation implements ConnectionPool {

  /** A list of available connections. */
  private List<Connection> availableConnections =
      new LinkedList<Connection>();

  /** A list of occupied connections. */
  private List<Connection> occupiedConnections =
      new LinkedList<Connection>();

  /** the single instance of class. */
  private static final LinkedListImplementation ONEINSTANCE =
          new  LinkedListImplementation();

  /** It avoids creation of more
   *  than one instance of this class.*/
  private LinkedListImplementation() { }

  /**
  * @return oneInstance Return oneInstance that is created.
  */
  public static synchronized LinkedListImplementation getInstance() {
     return ONEINSTANCE;
  }

  /**
    * @param dbURL The Database URL.
    * @param username Username of Database.
    * @param password Password of Database.
    * @param noOfConnections to set no Of Connections.
    * @throws SQLException .

    */
  public synchronized void connectionPool(final String dbURL,
      final String username,
      final String password, final int noOfConnections) throws SQLException {
      for (int i = 0; i < noOfConnections; i++) {
         availableConnections.add(DriverManager.getConnection(dbURL,
            username, password));
      }
  }
    /**
     * @return COnnection object
     */
  public synchronized Connection getConnection() {

   Connection firstAvailableConnection = null;
     if (!availableConnections.isEmpty()) {
       firstAvailableConnection = availableConnections.remove(0);
       occupiedConnections.add(firstAvailableConnection);

     }
    return firstAvailableConnection;
  }

    /**
     * @param connectionName The connection to be removed
     * @return is successfully removed or not.
     */
  public synchronized boolean releaseConnection(
      final Connection connectionName) {
    boolean isSuccessfulRemoval = false;


    if (connectionName != null && occupiedConnections.contains(
         connectionName)) {
       occupiedConnections.remove(connectionName);
       availableConnections.add(connectionName);
       isSuccessfulRemoval = true;
    }
    return isSuccessfulRemoval;
  }
}
