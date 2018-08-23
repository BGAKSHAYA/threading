
package com.threadingtasks.connectionpool;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

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
      String dbURL = "jdbc:mysql://localhost:3306/parking";
      Scanner consoleScanner = new Scanner(System.in);
      final int three = 3;

      System.out.println(" ** MENU ** "
            + "\n 1. Connection pool creation using linked list"
            + "\n 2. Connection pool creation using Array list"
            + "\n Enter your choice");

          ConnectionPool  connectionPoolInstance =
               new ConnectionPoolFactory()
              .createInstanceOfPool(consoleScanner.nextInt());

          System.out.println("Enter pool size");
          try {
           connectionPoolInstance.connectionPool(dbURL, "root", "oracle",
                  consoleScanner.nextInt());
           } catch (SQLException e) {
           e.printStackTrace();
          }
          Connection newConnection = null;

      do {

           System.out.println(" ** MENU ** "
                + "\n 1. Get Connection"
                + "\n 2. Release Connection"
                + "\n 3. Exit"
                + "\n Enter your choice");
           switch (consoleScanner.nextInt()) {
               case 1: newConnection = connectionPoolInstance.getConnection();
                   if (newConnection != null) {
                      System.out.println("Got the connection " + newConnection);
                   } else {
                       System.out.println("No free connections available");
                   }
                       break;
               case 2: if (connectionPoolInstance.releaseConnection(
                           newConnection)) {
                        System.out.println("The connection is "
                            + "released successfully");
                       } else {
                       System.out.println("The connection is already released");
                       }
                       break;
               case three: System.out.println("Program Exited");
                       consoleScanner.close();
                       return;
               default: System.out.println("Wrong choice");
           }
       } while (true);
    }
}
