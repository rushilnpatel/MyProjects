package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class SignInBO extends JFrame
{  private int Index;
   private JTabbedPane tabbedPane;
   private JPanel tabPanel_1, tabPanel_2,tabPanel_3,tabPanel_4,tabPanel_5, tabPanel_6, tabPanel_7;
   public SignInBO(String UName, String CustomerName, int Index, String date)
   {
	   Index--;
      setTitle("Account");
      setSize(900, 550);
      //get screen size and set the location of the frame
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension d = tk.getScreenSize();
      int screenHeight = d.height;
      int screenWidth = d.width;
      setLocation( screenWidth / 3 - 180, screenHeight / 6);

      addWindowListener (new WindowAdapter()  //handle window closing event
         {  public void windowClosing (WindowEvent e)
            { System.exit(0);
            }
         });
System.out.println(Index);
         tabbedPane = new JTabbedPane(); //initialize a JTabbedPane object
		 tabPanel_1 = new TransferBalBO(UName,CustomerName,date);
		 tabPanel_2 = new ViewBalanceBO(UName,CustomerName,date);
		 tabPanel_3 = new WithdrawalBalanceBO(UName,CustomerName,date);
		 tabPanel_4 = new DepositBalanceBO(UName,CustomerName,date);
		 tabPanel_5 = new OpenBankAccountPanel(UName,CustomerName);
		 tabPanel_6 = new InquireBO(UName,CustomerName,date);


		 tabbedPane.addTab("Transfer", tabPanel_1);
		 tabbedPane.addTab("View Balance", tabPanel_2);
		 tabbedPane.addTab("Withdraw", tabPanel_3);
		 tabbedPane.addTab("Deposit", tabPanel_4);
		 tabbedPane.addTab("Open Account", tabPanel_5);
		 tabbedPane.addTab("Inquire", tabPanel_6);
		 /*
		 //tabbedPane.setComponentAt(0,tabPanel_1);
		 tabbedPane.addTab("View Balance", tabPanel_2); //add GUI components to Tabbed Pane
		 //tabbedPane.setComponentAt(1,tabPanel_2);
		 tabbedPane.addTab("Withdraw", tabPanel_3);
		 //tabbedPane.setComponentAt(2,tabPanel_3);
		 tabbedPane.addTab("Deposit", tabPanel_4);
		 //tabbedPane.setComponentAt(3,tabPanel_4);
		 tabbedPane.addTab("Transfer", tabPanel_5);
		 //tabbedPane.setComponentAt(4,tabPanel_4);
		 tabbedPane.addTab("Inquire", tabPanel_6);
		 //tabbedPane.setComponentAt(5,tabPanel_6);
		 tabbedPane.addTab("InquireTCP/IP", tabPanel_7);
		 */
		 tabbedPane.setSelectedIndex(Index);
		 add(tabbedPane);
		       //tabbedPane.addTab("List 2", tabPanel_3);
		//show();
		setVisible(true);


}
}