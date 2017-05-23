package Project;

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.makadia.banking.*;
import Project.*;

class TransferBalBO extends JPanel implements ActionListener
{
    private JButton TransButton;
    private JTextField UsernameField, NameField, FromAccountNumberField,ToAccountNumberField, AmountField;
    private JComboBox CheckingOrSavingsBox1,CheckingOrSavingsBox2;
    private String UName, FromAccountNumber, ToAccountNumber, Amount, Name, FromAccountType, ToAccountType,Login_date;
    private Account Acct;

    public TransferBalBO(String UName, String CustomerName,String Login_date)
    {
        TransButton = new JButton("Transfer"); //initializing two button references

        CheckingOrSavingsBox1 = new JComboBox();
        CheckingOrSavingsBox1.addItem("Choose From Account Type");
		CheckingOrSavingsBox1.addItem("Checking");
		CheckingOrSavingsBox1.addItem("Savings");

		CheckingOrSavingsBox2 = new JComboBox();
        CheckingOrSavingsBox2.addItem("Choose TO Account Type");
		CheckingOrSavingsBox2.addItem("Checking");
		CheckingOrSavingsBox2.addItem("Savings");

        UsernameField = new JTextField(15);
        UsernameField.setText(UName);
        NameField = new JTextField(15);
        NameField.setText(CustomerName);
        FromAccountNumberField = new JTextField(15);
        ToAccountNumberField = new JTextField(15);
        AmountField = new JTextField(15);


        //JLabel TypeLabel = new JLabel("Choose Account Type: ");
        JLabel NameLabel = new JLabel("Customer Name:");
        JLabel UsernameLabel = new JLabel("Username: ");
        JLabel DateLabel= new JLabel(Login_date);
        JLabel AccountFromNumber = new JLabel ("From Account: ");
        JLabel AccountToNumber = new JLabel ("To Account: ");
        //JLabel NumberLabel = new JLabel("Account Number:");
        JLabel AmountLabel = new JLabel("Amount:");


        JPanel TypePanel1 = new JPanel();
        JPanel TypePanel2 = new JPanel();

        //JPanel UsernamePanel = new JPanel();
        //JPanel NamePanel = new JPanel();
        //JPanel NumberPanel = new JPanel();
        //JPanel StartDatePanel = new JPanel();
        //JPanel EndDatePanel = new JPanel();


        TypePanel1.add(CheckingOrSavingsBox1);
        TypePanel2.add(CheckingOrSavingsBox2);

        //UsernamePanel.add(UsernameLabel);
        //UsernamePanel.add(UsernameField);
        //NamePanel.add(NameLabel);
        //NamePanel.add(NameField);
        //NumberPanel.add(NumberLabel);
        //NumberPanel.add(AccountNumberField);
        //StartDatePanel.add(StartDateLabel);
        //StartDatePanel.add(StartDateField);
		//EndDatePanel.add(EndDateLabel);
        //EndDatePanel.add(EndDateField);

        //add(TypePanel);
        //add(UsernamePanel);
        //add(NamePanel);
        //add(NumberPanel);
        //add(StartDatePanel);
        //add(EndDatePanel);

        //add(OpenButton);  //add the two buttons on to this panel
        TransButton.addActionListener(this); //event listener registration
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
      		  add(NameLabel, gbc, 0, 2, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
		      gbc.weightx = 100;
		      gbc.weighty = 100;
      		  add(NameField, gbc, 1, 2, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(AccountToNumber, gbc, 0, 4, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(TypePanel1, gbc, 1, 4, 1, 1);

			  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(TypePanel2, gbc, 1, 3, 1, 1);

			  //apply GridBagConstraints to a GUI component and add it to this panel
			  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(AccountFromNumber, gbc, 0,3, 1, 1);

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
			  add(AmountField, gbc, 1, 5, 1, 1);

			  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(AmountLabel, gbc, 0, 5, 1, 1);



      		gbc.fill = GridBagConstraints.NONE;
			gbc.weightx = 100;
			gbc.weighty = 100;
      		add(TransButton, gbc, 1, 6, 1, 1);

    }

   public void actionPerformed(ActionEvent evt)  //event handling
   {
       //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();
        String chkAccNo,savAccNo;
        if (arg.equals("Transfer")) { //determine which button is clicked
        	UName = UsernameField.getText(); //take actions
        	Name = NameField.getText();
        	FromAccountNumber = FromAccountNumberField.getText();
        	ToAccountNumber = ToAccountNumberField.getText();
        	Amount = AmountField.getText();
        	FromAccountType = (String)CheckingOrSavingsBox2.getSelectedItem();
        	ToAccountType = (String)CheckingOrSavingsBox1.getSelectedItem();

        	CheckingAccount ca = new CheckingAccount(UName);
			chkAccNo = ca.getCANumber(UName);
			SavingAccount sa = new SavingAccount(UName);
			savAccNo = sa.getSANumber(UName);

        	if(FromAccountType.equals("Checking"))
        	{
				TransferBalanceControl tbc = new TransferBalanceControl(ToAccountType, savAccNo, FromAccountType, chkAccNo, Name, UName, Amount);

			}
			else if(FromAccountType.equals("Savings"))
        	{
				TransferBalanceControl tbc = new TransferBalanceControl(ToAccountType, chkAccNo, FromAccountType, savAccNo, Name, UName, Amount);

			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please Choose an Account Type!", "Confirmation",JOptionPane.INFORMATION_MESSAGE);
			}
    	 }


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