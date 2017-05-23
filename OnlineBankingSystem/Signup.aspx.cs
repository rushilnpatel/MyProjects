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
    public partial class Signup : System.Web.UI.Page
    {
        SqlConnection con = new SqlConnection();
        protected void Page_Load(object sender, EventArgs e)
        {
            
            con.ConnectionString = @"Data Source=SEPU\SQLEXPRESS;Initial Catalog=Banking;Integrated Security=True;Pooling=False";
        }

        protected void Signup_btn_Click(object sender, EventArgs e)
        {
            try
            {
                con.Open();
                SqlCommand cmd1 = new SqlCommand("insert into Login VALUES ('" + CustomerId_Txt.Text + "','" + Pass2_Txt.Text + "')", con);
                //SqlCommand cmd = new SqlCommand("select * from Department_master where dep_id='" + Txt_Dept_Insert.Text + "' and depertment_name='" + Txt_Dept_Name.Text + "'", con);
               
                cmd1.ExecuteNonQuery();
                Response.Write("1st Done ...!");
                
                SqlCommand cmd2 = new SqlCommand("insert into Customer VALUES ('" + Fname_Txt.Text + "','" + Lname_Txt.Text + "','" + Dob_Txt.Text + "','" + Ssn_Txt.Text + "','" + Address_Txt.Text + "','" + City_Txt.Text + "','" + State_Dropdown.Text + "','" + Zip_Txt.Text + "','" + Email_Txt.Text + "','" + CustomerId_Txt.Text + "')", con);

                cmd2.ExecuteNonQuery();
               

                Signup_Lbl.Visible = true;
                Signup_Lbl.Text = "Successfully Signedup";

                con.Close();
                Response.Redirect("~/Login.aspx");

            }
            catch
            {
                Response.Write("Error");
                con.Close();

            }
        }
    }
}