/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014
*   Modified by Smitkumar Choksi(1693805)
*******************************************************************************/
package Project;

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.makadia.banking.*;

public class OpenBankAccountControl
{

    public OpenBankAccountControl(String AcountType, String  AcountNumber, String  Name, String  UName, String  Balance) {
		//Use CheckingAccount object to invoke method openAcct()
		System.out.println("Account type is :"+AcountType);
		if (AcountType.equals("Checking")) {
			CheckingAccount CA = new CheckingAccount(AcountNumber, Name, UName, Balance);
            if (CA.openAcct()) {
            //System.out.println("successful!");

				String Trans_type="Account Open Deposit";
                Transaction TA=new Transaction(Trans_type,AcountType,"",UName,Balance);
				TA.save_Transaction();

				JOptionPane.showMessageDialog(null, "Opening a Checking Account is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            } else
            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Opening a Checking Account failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}
		if (AcountType.equals("Savings")) {
					SavingAccount SA = new SavingAccount(AcountNumber, Name, UName, Balance);
		            if (SA.openAcct()) {
		            //System.out.println("successful!");

						String Trans_type="Account Open Deposit";
		                Transaction TA=new Transaction(Trans_type,AcountType,"",UName,Balance);
						TA.save_Transaction();

						JOptionPane.showMessageDialog(null, "Opening a Saving Account is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		            } else
		            //System.out.println("fail!");
		            JOptionPane.showMessageDialog(null, "Opening a Saving Account failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}