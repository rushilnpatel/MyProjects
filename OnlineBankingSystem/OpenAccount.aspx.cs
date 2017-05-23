using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;

namespace OnlineBankingSystem
{
    public partial class OpenAccount : System.Web.UI.Page
    {
        public string r="";
        public string GenerateNumber()
        {
            Random random = new Random();
          // string r = "";
            int i;
            for (i = 1; i < 11; i++)
            {
                r += random.Next(1, 9).ToString();
            }
            return r;
            
        }

        protected void Page_Load(object sender, EventArgs e)
        {
           // GenerateNumber();
           // Account_Number.Text = r;
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

           

        }

        protected void Open_Account_Click(object sender, EventArgs e)
        {

           GenerateNumber();
           

            try
            {
                SqlConnection conn = new SqlConnection();

                conn.ConnectionString = @"Data Source=SEPU\SQLEXPRESS;Initial Catalog=Banking;Integrated Security=True;Pooling=False";

                conn.Open();
               SqlCommand cmd2 = new SqlCommand("select * from Account where Id='"+Welcome_Lbl.Text+"'and Account_Type='"+DropDownList1.SelectedItem.ToString()+"'",conn);
                SqlDataReader dr;
                dr = cmd2.ExecuteReader();
                if(dr.Read())
                {
                    Account_Number.Text = "Already Exist Account";
                    conn.Close();
                }

                else
                {

                    conn.Close();
                    conn.Open();
                    SqlCommand cmd = new SqlCommand("insert into Account VALUES ('" + Welcome_Lbl.Text + "','" + r.ToString() + "','" + DropDownList1.SelectedItem.ToString() + "','" + Deposite_Txt.Text + "','" + Date_Lbl.Text + "')", conn);


                    cmd.ExecuteNonQuery();
                    Account_Number.Text = r;
                    conn.Close();


                }



            }
            catch (Exception)
            {
                Response.Write("Error");
            }
        }
    }
}