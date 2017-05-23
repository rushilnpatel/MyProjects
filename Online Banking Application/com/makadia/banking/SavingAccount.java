package com.makadia.banking;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import com.makadia.banking.*;

public class SavingAccount
{   //Instance Variables
	private String SavingAccountNumber, CustomerName, CustomerID;
	private float Balance = -1;

	public SavingAccount(String CA_Num, String Cust_Name, String Cust_ID, String Bal) { //Constructor One with three parameters
		SavingAccountNumber = CA_Num;
		CustomerName = Cust_Name;
		CustomerID = Cust_ID;
		Balance = Float.parseFloat(Bal);
	}

	public SavingAccount(String SA_Name) { //Constructor Two with one parameter
		SavingAccountNumber = getSANumber(SA_Name);
	}

    public boolean openAcct() {
	     boolean done = false;
				try {
				    if (!done) {
				        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				        Connection DBConn = ToDB.openConn();
				        Statement Stmt = DBConn.createStatement();
				        String SQL_Command = "SELECT SavingsAccountNumber FROM SavingsAccount WHERE SavingsAccountNumber ='"+SavingAccountNumber+"'"; //SQL query command
				        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				        done = !Rslt.next();
				        if (done) {
						    SQL_Command = "INSERT INTO SavingsAccount(SavingsAccountNumber, CustomerName, Balance, CustomerID)"+
						                  " VALUES ('"+SavingAccountNumber+"','"+CustomerName+"',"+Balance+", '"+CustomerID+"')"; //Save the username, password and Name
						    Stmt.executeUpdate(SQL_Command);
					    }
					    Stmt.close();
					    ToDB.closeConn();
					}
				}
			    catch(java.sql.SQLException e)
			    {         done = false;
						 System.out.println("SQLException: " + e);
						 while (e != null)
						 {   System.out.println("SQLState: " + e.getSQLState());
							 System.out.println("Message: " + e.getMessage());
							 System.out.println("Vendor: " + e.getErrorCode());
							 e = e.getNextException();
							 System.out.println("");
						 }
			    }
			    catch (java.lang.Exception e)
			    {         done = false;
						 System.out.println("Exception: " + e);
						 e.printStackTrace ();
			    }
	    return done;
	}
	//
			public double depositAmount(double dep_Amount){
				double cur_Balance =  getBalance();
				double next_Balance = cur_Balance + dep_Amount;
				updateBalance(next_Balance);
				return next_Balance;
			}
			public double widthrowalAmount(double wid_Amount){
				double cur_Balance =  getBalance();
				double next_Balance = cur_Balance - wid_Amount;
				updateBalance(next_Balance);
				return next_Balance;
			}
			public void updateBalance(double next_Balance){
				try {
						        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
						        Connection DBConn = ToDB.openConn();
						        Statement Stmt = DBConn.createStatement();
						        String SQL_Command = "UPDATE SavingsAccount SET Balance = '"+next_Balance+"' WHERE SavingsAccountNumber ='"+SavingAccountNumber+"'"; //SQL query command for Balance
						        Stmt.executeQuery(SQL_Command);

							    Stmt.close();
							    ToDB.closeConn();
						}
					    catch(java.sql.SQLException e)
					    {
								 System.out.println("SQLException: " + e);
								 while (e != null)
								 {   System.out.println("SQLState: " + e.getSQLState());
									 System.out.println("Message: " + e.getMessage());
									 System.out.println("Vendor: " + e.getErrorCode());
									 e = e.getNextException();
									 System.out.println("");
								 }
					    }
					    catch (java.lang.Exception e)
					    {
								 System.out.println("Exception: " + e);
								 e.printStackTrace ();
			    }
			}
	//
    public double getBalance() {  //Method to return a SavingAccount balance
		try {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber ='"+SavingAccountNumber+"'"; //SQL query command for Balance
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command);

		        while (Rslt.next()) {
					Balance = Rslt.getFloat(1);
			    }
			    Stmt.close();
			    ToDB.closeConn();
		}
	    catch(java.sql.SQLException e)
	    {
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return Balance;
	}

    public double getBalance(String ChkAcctNumber) {  //Method to return a SavingAccount balance
		try {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber ='"+SavingAccountNumber+"'"; //SQL query command for Balance
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command);

		        while (Rslt.next()) {
					Balance = Rslt.getFloat(1);
			    }
			    Stmt.close();
			    ToDB.closeConn();
		}
	    catch(java.sql.SQLException e)
	    {
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return Balance;
	}
	public String getSANumber(String CustomerID) {  //Method to return a SavingAccount balance
			try {
			        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			        Connection DBConn = ToDB.openConn();
			        Statement Stmt = DBConn.createStatement();
			        String SQL_Command = "SELECT SavingsAccountNumber FROM SavingsAccount WHERE CustomerID ='"+CustomerID+"'"; //SQL query command for Balance
			        ResultSet Rslt = Stmt.executeQuery(SQL_Command);

			        while (Rslt.next()) {
						SavingAccountNumber = Rslt.getString(1);
				    }
				    Stmt.close();
				    ToDB.closeConn();
			}
		    catch(java.sql.SQLException e)
		    {
					 System.out.println("SQLException: " + e);
					 while (e != null)
					 {   System.out.println("SQLState: " + e.getSQLState());
						 System.out.println("Message: " + e.getMessage());
						 System.out.println("Vendor: " + e.getErrorCode());
						 e = e.getNextException();
						 System.out.println("");
					 }
		    }
		    catch (java.lang.Exception e)
		    {
					 System.out.println("Exception: " + e);
					 e.printStackTrace ();
		    }
		    return SavingAccountNumber;
	}
}