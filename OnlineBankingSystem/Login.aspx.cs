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
    

   public partial class Login : System.Web.UI.Page
    {
        public String s;
        dbconn conn = new dbconn();
      
        
        protected void Page_Load(object sender, EventArgs e)
        {

            Session.RemoveAll();

        }

        public void Login_Btn_Click(object sender, EventArgs e)
        {
           
            SqlConnection conn = new SqlConnection();

            conn.ConnectionString = @"Data Source=SEPU\SQLEXPRESS;Initial Catalog=Banking;Integrated Security=True;Pooling=False";
            conn.Open();

            SqlCommand cmd = new SqlCommand("select * from Login where Id='" + Id_Txt.Text + "' and Password='" + Password_Txt.Text + "'", conn);
         //   t1 = Id_Txt.ToString();
            SqlDataReader dr;
            dr = cmd.ExecuteReader();
            if (dr.Read())
            {
                Response.Write("Successfully Login");
                Session["ID"] = Id_Txt.Text;
                Response.Redirect("~/Welcome.aspx");
            
                
            }
            else
            {
                Login_Status_Lbl.Visible = true;
                Login_Status_Lbl.Text = "Login Failed";
             //   Response.Write("Login Failed");


            }
        }

        
    }
}