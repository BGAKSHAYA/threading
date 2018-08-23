/**.
 * This package contains classes to create connection pool.
 */
package com.threadingtasks.connectionpool;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Akshaya_Bindugowri
 */
public interface ConnectionPool {

     /**
     * @param dbURL The Database URL.
     * @param username Username of Database.
     * @param password Password of Database.
     * @param noOfConnections to set no Of Connections.
     * @throws SQLException .
     */
    void connectionPool(String dbURL, String username, String password,
            int noOfConnections) throws SQLException;
    /**
     * @return COnnection object
     */
    Connection getConnection();
    /**
     * @param connectionName The connection to be removed
     * @return is successfully removed or not.
     */
   boolean releaseConnection(Connection connectionName);

}
