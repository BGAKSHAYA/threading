/**.
 * This package contains classes to create connection pool.
 */
package com.threadingtasks.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.util.List;


import java.util.ArrayList;
/**
 * @author Akshaya_Bindugowri
 * version 1
 * This class is a Singleton class
 */
public final class ArrayListImplementation implements ConnectionPool {

  /** A list of available connections. */
  private List<Connection> availableConnections =
      new ArrayList<Connection>();

  /** A list of occupied connections. */
  private List<Boolean> statusOfConnections =
      new ArrayList<Boolean>();

  /** the single instance of class. */
  private static final ArrayListImplementation ONEINSTANCE =
          new  ArrayListImplementation();

  /** It avoids creation of more
   *  than one instance of this class.*/
  private ArrayListImplementation() { }

  /**
  * @return oneInstance Return oneInstance that is created.
  */
  public static synchronized ArrayListImplementation getInstance() {
     return ONEINSTANCE;
  }
  /**
    * @param dbURL The Database URL.
    * @param username User name of Database.
    * @param password Password of Database.
    * @param noOfConnections to set no Of Connections.
    * @throws SQLException .

    */
  public synchronized void connectionPool(final String dbURL,
      final String username,
      final String password, final int noOfConnections) throws SQLException {

    for (int index = 0; index < noOfConnections; index++) {
      availableConnections.add(DriverManager.getConnection(dbURL,
            username, password));
        statusOfConnections.add(true);
      }
  }
    /**
     * @return COnnection object
     */
  public synchronized Connection getConnection() {

   Connection firstAvailableConnection = null;
      int noOfConnections = availableConnections.size();
    for (int index = 0; index < noOfConnections; index++) {
           if (statusOfConnections.get(index)) {
                firstAvailableConnection = availableConnections.get(index);
                statusOfConnections.set(index, false);
                break;
         }
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
    if (connectionName != null) {
        int index = availableConnections.indexOf(connectionName);
        if (statusOfConnections.get(index)) {
          isSuccessfulRemoval = false;
        } else {
          statusOfConnections.set(index, true);
          isSuccessfulRemoval = true;
        }
    }
    return isSuccessfulRemoval;
  }
}
