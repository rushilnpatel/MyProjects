package Project;

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.makadia.banking.*;
import Project.*;

class DepositBalanceBO extends JPanel implements ActionListener
{
	private JButton DepositButton;
	private JTextField UsernameField, NameField, FromAccountNumberField,ToAccountNumberField, AmountField;
	private JComboBox CheckingOrSavingsBox1,CheckingOrSavingsBox2;
	private String UName, FromAccountNumber, ToAccountNumber, Amount, Name, FromAccountType, ToAccountType, LoginDate;
	private Account Acct;

	public DepositBalanceBO(String UName, String CustomerName, String LoginDate)
    {
			DepositButton = new JButton("Deposit"); //initializing two button references

        	CheckingOrSavingsBox1 = new JComboBox();
        	CheckingOrSavingsBox1.addItem("Choose Account Type");
			CheckingOrSavingsBox1.addItem("Checking");
			CheckingOrSavingsBox1.addItem("Savings");


        	UsernameField = new JTextField(15);
        	UsernameField.setText(UName);
        	NameField = new JTextField(15);
        	NameField.setText(CustomerName);
        	//FromAccountNumberField = new JTextField(15);
        	//ToAccountNumberField = new JTextField(15);
        	AmountField = new JTextField(15);


        	//JLabel TypeLabel = new JLabel("Choose Account Type: ");
        	JLabel DateLabel=new JLabel(LoginDate);
        	JLabel NameLabel = new JLabel("Customer Name:");
        	JLabel UsernameLabel = new JLabel("Username: ");
        	JLabel AccountTypeLabel = new JLabel("Account Type:");
        	JLabel AmountLabel = new JLabel("Amount:");


        	//JPanel TypePanel1 = new JPanel();


        	//TypePanel1.add(CheckingOrSavingsBox1);

        	DepositButton.addActionListener(this); //event listener registration
        	//declare and initialize a GridBagLayout object
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
		   add(UsernameField, gbc, 1, 1, 1, 1);

		   gbc.fill = GridBagConstraints.NONE;
		   gbc.weightx = 100;
		   gbc.weighty = 100;
      	   add(UsernameLabel, gbc, 0, 1, 1, 1);

		   gbc.fill = GridBagConstraints.NONE;
		   	gbc.weightx = 100;
		   	gbc.weighty = 100;
      	  	add(NameLabel, gbc, 0, 2, 1, 1);

			gbc.fill = GridBagConstraints.NONE;
  	      	gbc.weightx = 100;
  	      	gbc.weighty = 100;
    	  	add(NameField, gbc, 1, 2, 1, 1);

    	  	//gbc.fill = GridBagConstraints.NONE;
		  	//gbc.weightx = 100;
		  	//gbc.weighty = 100;
    	  	//add(TypePanel2, gbc, 0, 3, 1, 1);

      		//gbc.fill = GridBagConstraints.NONE;
			//gbc.weightx = 100;
			//gbc.weighty = 100;
      		//add(TypePanel1, gbc, 1, 2, 1, 1);

			//gbc.fill = GridBagConstraints.NONE;
			//gbc.weightx = 100;
			//gbc.weighty = 100;
      		//add(ToAccountNumberField, gbc, 1, 3, 1, 1);
			//apply GridBagConstraints to a GUI component and add it to this panel
			gbc.fill = GridBagConstraints.NONE;
			gbc.weightx = 100;
			gbc.weighty = 100;
      		add(AccountTypeLabel, gbc, 0,3, 1, 1);

      		gbc.fill = GridBagConstraints.NONE;
			gbc.weightx = 100;
			gbc.weighty = 100;
      		add(CheckingOrSavingsBox1, gbc, 1, 3, 1, 1);

      		gbc.fill = GridBagConstraints.NONE;
			gbc.weightx = 100;
			gbc.weighty = 100;
			add(AmountField, gbc, 1, 4, 1, 1);

			gbc.fill = GridBagConstraints.NONE;
			gbc.weightx = 100;
			gbc.weighty = 100;
			add(AmountLabel, gbc, 0, 4, 1, 1);

			gbc.fill = GridBagConstraints.NONE;
			gbc.weightx = 100;
			gbc.weighty = 100;
      		add(DepositButton, gbc, 1, 5, 1, 1);

    }

   public void actionPerformed(ActionEvent evt)  //event handling
   {
       	//Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();
        String ChkAccNO, SavAccNO;

        if (arg.equals("Deposit")) { //determine which button is clicked
        	UName = UsernameField.getText(); //take actions
        	Name = NameField.getText();
        	//FromAccountNumber = FromAccountNumberField.getText();
        	//ToAccountNumber = ToAccountNumberField.getText();
        	Amount = AmountField.getText();
        	FromAccountType = (String)CheckingOrSavingsBox1.getSelectedItem();
        	//ToAccountType = (String)CheckingOrSavingsBox2.getSelectedItem();
			if(FromAccountType.equals("Checking")){

				CheckingAccount ca = new CheckingAccount(UName);
				ChkAccNO = ca.getCANumber(UName);
				System.out.println("Successful"+ChkAccNO);
				DepositBalanceControl DB_Ctrl = new DepositBalanceControl(FromAccountType, ChkAccNO, Name, UName, Amount);
				//OpenBankAccountControl OBAcct_Ctrl = new OpenBankAccountControl(AccountType, AccountNumber, Name, UName, Balance);
    	 	}
    	 	else if(FromAccountType.equals("Savings")){
				SavingAccount sa = new SavingAccount(UName);
				SavAccNO = sa.getSANumber(UName);
				System.out.println("Successful"+SavAccNO);
				DepositBalanceControl DB_Ctrl = new DepositBalanceControl(FromAccountType, SavAccNO, Name, UName, Amount);
				//OpenBankAccountControl OBAcct_Ctrl = new OpenBankAccountControl(AccountType, AccountNumber, Name, UName, Balance);
    	 	}

    	 }

    }

 public void add(Component c, GridBagConstraints gbc, int x, int y, int w, int h)
	     {
	        gbc.gridx = x;
	        gbc.gridy = y;
	        gbc.gridwidth = w;
	        gbc.gridheight = h;
	        add(c, gbc);
   }
}