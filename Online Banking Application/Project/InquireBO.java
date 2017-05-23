package Project;

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.makadia.banking.*;
import Project.*;

class InquireBO extends JPanel implements ActionListener
{
    private JButton InquireButton;
    private JTextField UsernameField, NameField, AccountNumberField, StartDateField, EndDateField;
    private JComboBox CheckingOrSavingsBox;
    private String UName, AccountNumber, StartDate, EndDate, Name, AccountType, Login_date;
    private Account Acct;

    public InquireBO(String UName, String CustomerName, String Login_date)
    {

        InquireButton = new JButton("Inquire"); //initializing two button references

        CheckingOrSavingsBox = new JComboBox();
        CheckingOrSavingsBox.addItem("Choose Account Type");
		CheckingOrSavingsBox.addItem("Checking");
		CheckingOrSavingsBox.addItem("Savings");

        UsernameField = new JTextField(15);
        UsernameField.setText(UName);
        NameField = new JTextField(15);
        NameField.setText(CustomerName);
        //AccountNumberField = new JTextField(15);
        StartDateField = new JTextField(15);
        EndDateField = new JTextField(15);

        JLabel TypeLabel = new JLabel("Choose Account Type: ");
        JLabel NameLabel = new JLabel("Customer Name:");
         JLabel DateLabel=new JLabel(Login_date);
        JLabel UsernameLabel = new JLabel("Username: ");
        //JLabel NumberLabel = new JLabel("Account Number:");
        JLabel StartDateLabel = new JLabel("Start Date:");
        JLabel EndDateLabel = new JLabel("End Date:");



        InquireButton.addActionListener(this); //event listener registration

        GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl); //let the layout manager be GridBagLayout
			        //declare and initialize a GridBagConstraints object
			  GridBagConstraints gbc = new GridBagConstraints();
		     //apply GridBagConstraints to a GUI component and add it to this panel
		   gbc.fill = GridBagConstraints.NONE;
		   gbc.weightx = 100;
 		   gbc.weighty = 100;
		   add(DateLabel, gbc, 0, 0, 1, 1);


		     gbc.fill = GridBagConstraints.NONE;
		      gbc.weightx = 100;
		      gbc.weighty = 100;
      		  add(NameLabel, gbc, 0, 3, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  		      gbc.weightx = 100;
			  		      gbc.weighty = 100;
      		  add(NameField, gbc, 1, 3, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(TypeLabel, gbc, 0, 1, 1, 1);


			  //apply GridBagConstraints to a GUI component and add it to this panel
			  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(CheckingOrSavingsBox, gbc, 1, 1, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(UsernameField, gbc, 1, 2, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(UsernameLabel, gbc, 0, 2, 1, 1);

      		  /*gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
			  add(AccountNumberField, gbc, 1, 3, 1, 1);

       		  gbc.fill = GridBagConstraints.NONE;
 			  gbc.weightx = 100;
 			  gbc.weighty = 100;
      		  add(NumberLabel, gbc, 0, 3, 1, 1);*/

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
			  add(StartDateField, gbc, 1, 4, 1, 1);

			  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(StartDateLabel, gbc, 0, 4, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
			  add(EndDateField, gbc, 1, 5, 1, 1);

			 gbc.fill = GridBagConstraints.NONE;
			 gbc.weightx = 100;
			 gbc.weighty = 100;
      		  add(EndDateLabel, gbc, 0, 5, 1, 1);

      		gbc.fill = GridBagConstraints.NONE;
			gbc.weightx = 100;
			gbc.weighty = 100;
      		add(InquireButton, gbc, 1, 6, 1, 1);


    }

   public void actionPerformed(ActionEvent evt)  //event handling
   {
       //Object source = evt.getSource(); //get who generates this event
		String arg = evt.getActionCommand();
        String ChkAccNO, SavAccNO;

        if (arg.equals("Inquire")) { //determine which button is clicked
        	UName = UsernameField.getText(); //take actions
        	Name = NameField.getText();
        	String stDate = StartDateField.getText();
        	String endDate = EndDateField.getText();
        	//FromAccountNumber = FromAccountNumberField.getText();
        	//ToAccountNumber = ToAccountNumberField.getText();
        	//Amount = AmountField.getText();
        	AccountType = (String)CheckingOrSavingsBox.getSelectedItem();
        	//ToAccountType = (String)CheckingOrSavingsBox2.getSelectedItem();
			if(AccountType.equals("Checking")){

				CheckingAccount ca = new CheckingAccount(UName);
				ChkAccNO = ca.getCANumber(UName);
				System.out.println("Successful"+ChkAccNO);
				System.out.println(UName);
				InquireControl INC_Ctrl = new InquireControl(ChkAccNO, Name, UName, stDate, endDate);
				//OpenBankAccountControl OBAcct_Ctrl = new OpenBankAccountControl(AccountType, AccountNumber, Name, UName, Balance);
    	 	}
    	 	else if(AccountType.equals("Savings")){

				SavingAccount sa = new SavingAccount(UName);
				SavAccNO = sa.getSANumber(UName);
				System.out.println("Successful"+SavAccNO);
				InquireControl INC_Ctrl = new InquireControl(SavAccNO, Name, UName, stDate, endDate);
				//DepositBalanceControl DB_Ctrl = new DepositBalanceControl(FromAccountType, SavAccNO, Name, UName, Amount);
				//OpenBankAccountControl OBAcct_Ctrl = new OpenBankAccountControl(AccountType, AccountNumber, Name, UName, Balance);
    	 	}

			//DepositBalanceControl DB_Ctrl = new DepositBalanceControl(FromAccountType, FromAccountNumber, Name, UName, Amount);
    	 }
       /* String arg = evt.getActionCommand();
        if (arg.equals("Show")) { //determine which button is clicked
        UName = UsernameField.getText(); //take actions
        Name = NameField.getText();
        AccountNumber = AccountNumberField.getText();
        StartDate = StartDateField.getText();
        EndDate = EndDateField.getText();
        AccountType = (String)CheckingOrSavingsBox.getSelectedItem();
        if (AccountType.equals("Choose Account Type"))
            JOptionPane.showMessageDialog(null, "Please Choose an Account Type!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        else if (AccountNumber.length() != 8 )
            JOptionPane.showMessageDialog(null, "Please Enter an Account Number with Exactly 8 Characters!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        else {
			System.out.println("Successful");
			//OpenBankAccountControl OBAcct_Ctrl = new OpenBankAccountControl(AccountType, AccountNumber, Name, UName, Balance);
    	 }

               //Acct = new Account(UName, PsWord, PsWord1, Name);
               //if (Acct.signUp())
                   //JOptionPane.showMessageDialog(null, "Account has been open!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
               //else
                   //JOptionPane.showMessageDialog(null, "Account creation failed due to an invalid email address or unmatched passwords or the email address exists.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
   		}*/
    }


 public void add(Component c, GridBagConstraints gbc,
	                     int x, int y, int w, int h)
	     {
	        gbc.gridx = x;
	        gbc.gridy = y;
	        gbc.gridwidth = w;
	        gbc.gridheight = h;
	        add(c, gbc);
   }


}