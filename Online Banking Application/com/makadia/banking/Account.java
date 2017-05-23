/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012
*   Modified by: Sapana Makadia (1716708)
*******************************************************************************/

package com.makadia.banking;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import com.makadia.banking.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Account
{
	private String Username, Password, Password1, Name;

	public Account(String UN, String PassW, String PassW1, String NM) {
		Username = UN;
		Password = PassW;
		Password1 = PassW1;
		Name = NM;
	}

	public Account(String UN, String PassW) {
		Username = UN;
		Password = PassW;
	}

// Sam
	public String signIn() {
			 boolean done = !Username.equals("") && !Password.equals("");
			    try {
			       if (done) {
			           DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			           Connection DBConn = ToDB.openConn();
			           Statement Stmt = DBConn.createStatement();
			         ResultSet rs=Stmt.executeQuery("select Username,Password from Account where Username='"+Username+"' and Password='"+Password+"'");
			            String username="",password="";
			            while(rs.next()){
			                username=rs.getString("username");
			                password=rs.getString("password");
			            }


			   if(Username.equals(username) && Password.equals(password))
			   {
			   	return username;
			   }
			   else
			   {
			   return "";
			   }

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
			     return "";
		 }
// Sam End
    public boolean signUp() {
		boolean done = !Username.equals("") && !Password.equals("") && !Password1.equals("") && Password.equals(Password1);
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Username FROM Account WHERE Username ='"+Username+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Account(Username, Password, Name) VALUES ('"+Username+ "','"+Password+"','"+Name+"')"; //Save the username, password and Name
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
	public String Lastlogin(String Username) {	//5
		String Login_date="";
		try {
				DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				Connection DBConn = ToDB.openConn();
				Statement Stmt = DBConn.createStatement();
				String SQL_Command = "SELECT LastLogin FROM Account WHERE Username ='"+Username+ "'"; //SQL query command
				String SQL_command1="";
				ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				while(Rslt.next())
				{
					Login_date=Rslt.getString("LastLogin");
				}
				Date date = new Date();
				DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
				String Login_date_new= dateFormat.format(date);
				System.out.println("Last login = "+Login_date_new);
				SQL_Command = "UPDATE Account SET LastLogin='"+Login_date_new+"' WHERE Username ='"+Username+"'";
				Stmt.executeUpdate(SQL_Command);


				Stmt.close();
				ToDB.closeConn();

		  }

				catch(java.sql.SQLException e)		//5
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
				return Login_date;
		}

}