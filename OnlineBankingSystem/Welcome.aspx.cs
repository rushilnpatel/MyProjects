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
    public partial class Welcome : System.Web.UI.Page
    {
        
        protected void Page_Load(object sender, EventArgs e)
        {
            if(Session["ID"] != null)
            {
                Welcome_Lbl.Text = Session["ID"].ToString();
                Welcome_Lbl.Visible = false;
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
                SqlCommand cmd = new SqlCommand("select Fname from Customer where Id='" + Welcome_Lbl.Text + "'", conn);
                SqlDataReader dr;
                dr = cmd.ExecuteReader();
                if (dr.Read())
                {

                    Name_Lbl.Text = dr["Fname"].ToString() +"("+Welcome_Lbl.Text+")";
                //    conn.Close();
                }

                else
                {
                    conn.Close();
                }
            }
            catch(Exception )
            {
                Response.Write("Error");
            }
           

        }

        
    }
}