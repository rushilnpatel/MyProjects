package Project;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import javax.swing.*;
import java.util.*;
import com.makadia.banking.*;
import Project.*;

public class InquireControl
{

	public InquireControl(String  AccountNumber, String  Name, String  UName, String sDate, String eDate)
	{
		Vector ve = new Vector();
		Transaction ts = new Transaction(UName);
		ve = ts.retriveTransaction(sDate,eDate);
		Vector<String> value = new Vector<String>(7);
       	value.add(0,"TransactionID");
       	value.add(1,"TransactionType");
       //	value.add(2,"TransactionDate");
       	value.add(2,"Amount");
       	value.add(3,"FromAccount");
       	value.add(4,"ToAccount");
       	value.add(5,"CustomerID");

       	ShowTransactionBO st = new ShowTransactionBO(ve,value);
       	show();

	}
}