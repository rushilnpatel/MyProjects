using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;

namespace OnlineBankingSystem
{
    public partial class Deposit : System.Web.UI.Page
    { 
        float bal;
     float amount;
        public string r1 = "";
       
          protected void Page_Load(object sender, EventArgs e)
        {
            Date_Lbl.Text = DateTime.Now.ToString();
            if (Session["ID"] != null)
            {
                
                Welcome_Lbl.Text = Session["ID"].ToString();
                Welcome_Lbl.Visible = true;
            }
            else
            {
                Welcome_Lbl.Text = "Session Expired Login Again...!!";
                Session.RemoveAll();
                Response.Redirect("~/Login.aspx");
            }
            try
            {
                SqlConnection conn = new SqlConnection();

                conn.ConnectionString = @"Data Source=SEPU\SQLEXPRESS;Initial Catalog=Banking;Integrated Security=True;Pooling=False";

                conn.Open();
                SqlCommand cmd = new SqlCommand("select * from Account where Id='" + Welcome_Lbl.Text + "'and Account_Type='"+DropDownList1.SelectedItem.Text+"'",conn);
                SqlDataReader dr;
                dr = cmd.ExecuteReader();
                if (dr.Read())
                {
                    Account_Number_Lbl.Visible = true;
                    Account_Number_Lbl.Text = dr["Account_Number"].ToString();
                    Balance_Lbl.Text = dr["Balance"].ToString();
                    conn.Close();
                }
            }
            catch(Exception)
            {
                Response.Write("Error");
            }
        }

        protected void Deposite_Btn_Click(object sender, EventArgs e)
        {
            bal = float.Parse(Balance_Lbl.Text);
            bal += float.Parse(Amount_Txt.Text);
            Response.Write(bal);
            try
            {
                SqlConnection conn = new SqlConnection();

                conn.ConnectionString = @"Data Source=SEPU\SQLEXPRESS;Initial Catalog=Banking;Integrated Security=True;Pooling=False";

                conn.Open();
                SqlCommand cmd1 = new SqlCommand("update Account set Balance='" + bal + "' where Id='" + Welcome_Lbl.Text + "'and Account_Number='" + Account_Number_Lbl.Text + "'", conn);
                cmd1.ExecuteNonQuery();
                conn.Close();

                Balance_Lbl.Text = bal.ToString();

                amount = float.Parse(Amount_Txt.Text);
             //   Response.Write(r1.ToString() + "<br />");
               // Response.Write(Welcome_Lbl.Text + "<br />");
               // Response.Write(Account_Number_Lbl.Text + "<br />");
                //Response.Write(DropDownList1.SelectedItem.Text + "<br />");
                //Response.Write(amount + "<br />");
                //Response.Write(Date_Lbl.Text + "<br />");
            }
            catch (Exception)
            {
                Response.Write("Error1");
            }
            try
            {
                SqlConnection conn = new SqlConnection();

                conn.ConnectionString = @"Data Source=SEPU\SQLEXPRESS;Initial Catalog=Banking;Integrated Security=True;Pooling=False";
                 SqlCommand t = new SqlCommand("INSERT INTO [Transaction] ([Id], [Account_Number], [Account_Type], [Amount], [Date]) VALUES(@Id, @Account_Number, @Account_Type, @Amount, @Date)", conn);
                string id = Welcome_Lbl.Text;
                string Account_Num = Account_Number_Lbl.Text;
                string Account_Type = DropDownList1.SelectedItem.ToString();
                string date = Date_Lbl.ToString();

                //t.Parameters.AddWithValue("@Transid", r1);
                t.Parameters.AddWithValue("@Id", id);
                t.Parameters.AddWithValue("@Account_Number", Account_Num);
                t.Parameters.AddWithValue("@Account_Type", Account_Type);
                t.Parameters.AddWithValue("@Amount", Amount_Txt.Text);
                t.Parameters.AddWithValue("@Date", DateTime.Today);
                conn.Open();
                t.ExecuteNonQuery();
                conn.Close();
                Response.Write("Done");
                //SqlCommand cmd2 = new SqlCommand("insert into Transaction (Transid , Id , Account_Number , Account_Type , Amount , Date) VALUES ('" + r1.ToString() + "' , '" + Welcome_Lbl.Text + "' , '" + Account_Number_Lbl.Text + "' , '" + DropDownList1.SelectedItem.Text + "' , '" + amount.ToString() + "' , '"+ Date_Lbl.Text +"')", conn);

                //cmd2.ExecuteNonQuery();


            }
            catch (Exception ex)
            {

                Response.Write("Error2");

            }

            Label1.Text = r1.ToString();
           // con.Close();

        }
        
    }
}