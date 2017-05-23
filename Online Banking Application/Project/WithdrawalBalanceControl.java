package Project;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import javax.swing.*;
import java.util.*;
import com.makadia.banking.*;
import Project.*;

public class WithdrawalBalanceControl
{

    public WithdrawalBalanceControl(String AccountType, String  AccountNumber, String  Name, String  UName, String  Balance) {
		//Use CheckingAccount object to invoke method openAcct()
		//java.util.Date currentDate = new java.util.Date();
		//String date= new String();
		//date=currentDate;
		System.out.println("In WBC" +AccountType);
		Double Bal = -1.0;
		Double Bal1= -1.0;
		if (AccountType.equals("Checking")) {
			System.out.println("In WBC" +Balance);
			CheckingAccount CA = new CheckingAccount(UName);
			//AccountNumber=CA.getCANumber(UName);
			//System.out.println(AccountNumber);
			Bal1=Double.parseDouble(Balance);
			System.out.println(Bal1);
			Bal=CA.widthrowalAmount(Bal1);
			System.out.println(Bal);
			if(Bal!=-1){
			JOptionPane.showMessageDialog(null, "Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

              	Transaction TC= new Transaction("Withdrawal","0",AccountNumber,UName,Balance);
            	TC.save_Transaction();
            //    JOptionPane.showMessageDialog(null, "Opening a Checking Account is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (AccountType.equals("Savings")) {
			SavingAccount SA = new SavingAccount(UName);
			AccountNumber=SA.getSANumber(UName);
			Bal1=Double.parseDouble(Balance);
			Bal=SA.widthrowalAmount(Bal1);
			System.out.println(Bal);
			if(Bal!=-1)
             {
				Transaction TS= new Transaction("Withdrawal","0",AccountNumber,UName,Balance);
				TS.save_Transaction();
            //System.out.println("successful!");
                JOptionPane.showMessageDialog(null, "Successful Withdrawal!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Withdrawal from a Savings Account failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}