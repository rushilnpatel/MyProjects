/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/
package Project;

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.makadia.banking.*;

public class LoginControl
{
    private Account Acct;
    private SignInBO sbo;

    public LoginControl(String UName, String PWord) {
		Acct = new Account(UName, PWord);
		String CustomerName = Acct.signIn();
		int i = 0;
        if (!CustomerName.equals("")) {
			//OpenBankAccountBO OpenAcctBO = new OpenBankAccountBO(UName, CustomerName);

            String lastLogin = Acct.Lastlogin(UName);
            System.out.println("lastLogin : "+lastLogin);
			if( lastLogin==null)
			{
				lastLogin="First Time Login";
			}
			else
			{
				lastLogin="Last Login Date:"+lastLogin;
			}
         	sbo= new SignInBO(UName,CustomerName, i , lastLogin);


        } else
            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Login failed because of invalid username or password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	}
}