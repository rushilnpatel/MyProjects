package Project;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import javax.swing.*;
import java.util.*;
import com.makadia.banking.*;
import Project.*;

public class TransferBalanceControl
{

    public TransferBalanceControl(String TAccountType, String  TAccountNumber, String FAccountType, String  FAccountNumber, String  Name, String  UName, String  Balance) {
		//Use CheckingAccount object to invoke method openAcct()
		//java.util.Date currentDate = new java.util.Date();
		//String date= new String();
		//date=currentDate;
		System.out.println(TAccountType);
		double Bal = -1;
		double Bal1= -1;
		if (FAccountType.equals("Checking")) {
			System.out.println(FAccountType);
			CheckingAccount CA = new CheckingAccount(UName);
			FAccountNumber= CA.getCANumber(UName);

			Bal1=Double.parseDouble(Balance);
			double current_Balance = CA.getBalance();
			if(current_Balance < Bal1){
				JOptionPane.showMessageDialog(null, "Transfer Failed. Not enough Balance", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				Bal=CA.widthrowalAmount(Bal1);
				SavingAccount SA = new SavingAccount(UName);
				TAccountNumber=SA.getSANumber(UName);
				Bal1=Double.parseDouble(Balance);
				Bal=SA.depositAmount(Bal1);

				if(Bal!=-1){
					JOptionPane.showMessageDialog(null, "Transfer Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

				    Transaction TC= new Transaction("Transfer",TAccountNumber,FAccountNumber,UName,Balance);
				    TC.save_Transaction();
				            //    JOptionPane.showMessageDialog(null, "Opening a Checking Account is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				     //System.out.println("fail!");
            		JOptionPane.showMessageDialog(null, "Transfer Failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}

		}
		else if (FAccountType.equals("Savings")) {
			SavingAccount SA = new SavingAccount(UName);
			FAccountNumber=SA.getSANumber(UName);
			Bal1=Double.parseDouble(Balance);

			double current_Balance = SA.getBalance();
			if(current_Balance < Bal1){
				JOptionPane.showMessageDialog(null, "Transfer Failed. Not enough Balance", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				Bal=SA.widthrowalAmount(Bal1);

							CheckingAccount CA = new CheckingAccount(UName);
							TAccountNumber=CA.getCANumber(UName);
							Bal1=Double.parseDouble(Balance);
							Bal=CA.depositAmount(Bal1);
							if(Bal!=-1)
				            {
								Transaction TS= new Transaction("Transfer",TAccountNumber,FAccountNumber,UName,Balance);
								TS.save_Transaction();
				            //System.out.println("successful!");
				                JOptionPane.showMessageDialog(null, "Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				            }
				            else
				            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Opening a Savings Account failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}
}