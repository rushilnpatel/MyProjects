/****************************************************************************
 * Transaction Entity Class													*
 * Date:Spring 2016											            *
 * Edited by: 											*
 * **************************************************************************/
package com.makadia.banking;
import java.lang.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Transaction
{
    private String TransactionID,transaction_Type, transaction_Date, from_Account,to_Account, CustomerID;
    private double Amount = -1;

    //Constructor One With Five Parameters
    public Transaction( String Trans_Type, String ToAcct, String FromAcct, String Cust_ID, String Amt)
    {
        transaction_Type = Trans_Type;
        transaction_Date = get_Date();
        to_Account = ToAcct;
        from_Account = FromAcct;
        Amount = Double.parseDouble(Amt);
        CustomerID = Cust_ID;
        TransactionID=generateTransID();
    }
	public Transaction(String Customer_ID)
		{
			CustomerID=Customer_ID;
	}
    public boolean save_Transaction(){
			boolean done = false;
				try {
				    if (!done) {
				        DBConnection ToDB = new DBConnection();
				        Connection DBConn = ToDB.openConn();
				        Statement Stmt = DBConn.createStatement();
				        String SQL_Command="insert into Transactions values ('" + TransactionID + "', '" + transaction_Type + "', '" + transaction_Date + "', '" + Amount + "', '" + from_Account + "', '" + to_Account + "', '" + CustomerID + "')";
						//String SQL_Command = "INSERT INTO Transaction values(TransactionID, TransactionType, TransactionDate, Amount, FromAccount, ToAccount, CustomerID)"+
						                  //"(" + TransactionID + "'," + transaction_Type + "'," + transaction_Date + "," + Amount + "," + from_Account + "," + to_Account + ",'" + CustomerID + "')";
						System.out.println("SQL Insert Command :"+SQL_Command);
						System.out.println("Transaction Recoreded Successfully!!");
						Stmt.executeUpdate(SQL_Command);
					    done = true;
					    Stmt.close();
					    ToDB.closeConn();
						}
					}
				    catch(java.sql.SQLException e)
				    {
						done = false;
						System.out.println("SQLException: " + e);
						while (e != null){
							System.out.println("SQLState: " + e.getSQLState());
							System.out.println("Message: " + e.getMessage());
							System.out.println("Vendor: " + e.getErrorCode());
							e = e.getNextException();
							System.out.println("");
							}
					}
					catch (java.lang.Exception e){
						done = false;
						System.out.println("Exception: " + e);
						e.printStackTrace ();
					}
		    return done;

	}
	public String generateTransID()
	 	{
	 		long transid;
	 		transid=System.currentTimeMillis();
	 		String tid = String.valueOf(transid);
			return tid;
	}


public Vector retriveTransaction(String FromDate, String ToDate )
{
	Vector v = new Vector();
	try{
			DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			Connection DBConn = ToDB.openConn();
	        Statement Stmt = DBConn.createStatement();
	        String SQL_Command = "select * from Transactions WHERE CustomerID ='" + CustomerID + "' AND TransactionDate BETWEEN '"+FromDate+"' AND '"+ToDate+"' ";
			ResultSet Rslt = Stmt.executeQuery(SQL_Command);
			ResultSetMetaData Rsmd= Rslt.getMetaData();
	    	System.out.println("Flag 1");
			while(Rslt.next())
			{
				v.addElement(ToDB.getNextRow(Rslt,Rsmd));
								}
								 System.out.println("Flag 2");
								 Stmt.close();
								 ToDB.closeConn();
		}
		catch(java.sql.SQLException e)
				{
					// done = false;
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
				{         //done = false;
						System.out.println("Exception: " + e);
						e.printStackTrace ();
	    		}
		return v;
	}

    public String get_Date()
     {
		 DateFormat date_f = new SimpleDateFormat("yyyyMMdd");
		 Date date = new Date();
	     return date_f.format(date);
	 }
}