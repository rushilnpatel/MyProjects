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
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            
                Random random = new Random();
                string r = "";
                int i;
                for (i = 1; i < 11; i++)
                    {
                        r += random.Next(0, 9).ToString();
                    }
            Response.Write(r);
            Label1.Text = r;
               

         }
    }
}

