package Project;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import javax.swing.*;
import java.util.*;
import com.makadia.banking.*;
import Project.*;

public class DepositBalanceControl
{

    public DepositBalanceControl(String AccountType, String  AccountNumber, String  Name, String  UName, String  Balance) {
		//Use CheckingAccount object to invoke method openAcct()
		//java.util.Date currentDate = new java.util.Date();
		//String date= new String();
		//date=currentDate;
		System.out.println(AccountType);
		Double Bal = -1.0;
		Double Bal1= -1.0;
		if (AccountType.equals("Checking")) {
			System.out.println(AccountType);
			CheckingAccount CA = new CheckingAccount(UName);
			AccountNumber=CA.getCANumber(UName);
			System.out.println(AccountNumber);
			Bal1=Double.parseDouble(Balance);
			Bal=CA.depositAmount(Bal1);
			System.out.println(Bal);
			if(Bal!=-1){
				Transaction TC= new Transaction("Deposit",AccountNumber,"0",UName,Balance);
            	TC.save_Transaction();
				JOptionPane.showMessageDialog(null, "Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            	//if (CA.openAcct()) {
            	//   	Transaction TC= new Transaction("Deposit",AccountNumber,"0",UName,Balance);
            	//	TC.SaveTransaction();
            	//    JOptionPane.showMessageDialog(null, "Opening a Checking Account is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            	//System.out.println("fail!");
            	JOptionPane.showMessageDialog(null, "Depositing from a Checking Account failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (AccountType.equals("Savings")) {
			SavingAccount SA = new SavingAccount(UName);
			AccountNumber=SA.getSANumber(UName);
			Bal=Double.parseDouble(Balance);
			Bal=SA.depositAmount(Bal);
			System.out.println(Bal);
			if(Bal!=-1){
            	//if (SA.openAcct()) {
				//	Transaction TS= new Transaction("Deposit",AccountNumber,"0",UName,Balance);
				//	TS.SaveTransaction();
            	//System.out.println("successful!");
            	Transaction TS= new Transaction("Deposit",AccountNumber,"0",UName,Balance);
            	TS.save_Transaction();
                JOptionPane.showMessageDialog(null, "Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            	//System.out.println("fail!");
            	JOptionPane.showMessageDialog(null, "Depositing from a Savings Account failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}