/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/
package Project;

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.makadia.banking.*;

class SignUpPanel extends JPanel implements ActionListener
{
    private JButton RegisterButton;
    private JTextField UsernameField, NameField;
    private JPasswordField PasswordField, PasswordField1;
    private String UName, PsWord, PsWord1, Name;
    private Account Acct;

    public SignUpPanel()
    {
        RegisterButton = new JButton("Register"); //initializing two button references

        UsernameField = new JTextField(15);
        PasswordField = new JPasswordField(15);
        PasswordField1 = new JPasswordField(15);
        NameField = new JTextField(15);

        JLabel UsernameLabel = new JLabel("Username: ");
        JLabel PasswordLabel = new JLabel("Password: ");
        JLabel PasswordLabel1 = new JLabel("Re-enter Password");
        JLabel NameLabel = new JLabel("Name");

        JPanel UsernamePanel = new JPanel();
        JPanel PasswordPanel = new JPanel();
        JPanel PasswordPanel1 = new JPanel();
        JPanel NamePanel = new JPanel();

        UsernamePanel.add(UsernameLabel);
        UsernamePanel.add(UsernameField);
        PasswordPanel.add(PasswordLabel);
        PasswordPanel.add(PasswordField);
        PasswordPanel1.add(PasswordLabel1);
        PasswordPanel1.add(PasswordField1);
        NamePanel.add(NameLabel);
        NamePanel.add(NameField);

        add(UsernamePanel);
        add(PasswordPanel);
        add(PasswordPanel1);
        add(NamePanel);

        add(RegisterButton);  //add the two buttons on to this panel
        RegisterButton.addActionListener(this); //event listener registration
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();
        if (arg.equals("Register")) { //determine which button is clicked
            UName = UsernameField.getText(); //take actions
            PsWord =PasswordField.getText();
            PsWord1 = PasswordField1.getText();
            Name = NameField.getText();
			//Quality checking
			if(isValidEmailAddress(UName) && PsWord.length()>=8){
				Acct = new Account(UName, PsWord, PsWord1, Name);
            	if (Acct.signUp())
            	    JOptionPane.showMessageDialog(null, "Account has been created!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            	else
            	    JOptionPane.showMessageDialog(null, "Account creation failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null, "Please enter valid email address and passwords.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			/*

              */
		}
    }
    public boolean isValidEmailAddress(String email) {
		    boolean stricterFilter = true;
		    String stricterFilterString = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
		    String laxString = ".+@.+\\.[A-Za-z]{2}[A-Za-z]*";
		    String emailRegex = stricterFilter ? stricterFilterString : laxString;
		    java.util.regex.Pattern p = java.util.regex.Pattern.compile(emailRegex);
		    java.util.regex.Matcher m = p.matcher(email);
		    return m.matches();
	}
/*
    public String getUsername() {
		return UName;
	};

	public String getPassword() {
	    return PsWord;
	}

	public String getPassword1() {
	    return PsWord1;
	}*/
}

public class SignUpBO extends JFrame
{
    private SignUpPanel SU_Panel;

    public SignUpBO()
    {
        setTitle("Sign Up");
        setSize(340, 210);

         //get screen size and set the location of the frame
         Toolkit tk = Toolkit.getDefaultToolkit();
         Dimension d = tk.getScreenSize();
         int screenHeight = d.height;
         int screenWidth = d.width;
         setLocation( screenWidth / 3, screenHeight / 4);

         addWindowListener (new WindowAdapter()  //handle window event
            {
		       public void windowClosing (WindowEvent e)
			                  { System.exit(0);
               }
            });

         Container contentPane = getContentPane(); //add a panel to a frame
         SU_Panel = new SignUpPanel();
         contentPane.add(SU_Panel);
         show();
    }

    /*public static void main(String [] args)
    { JFrame frame = new SignUpBO(); //initialize a JFrame object
      frame.show(); //display the frame
    }*/
}

