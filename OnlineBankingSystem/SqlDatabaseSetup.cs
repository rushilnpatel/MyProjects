using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.Common;
using System.Data.SqlClient;

namespace OnlineBankingSystem
{
    public class dbconn
    {
        SqlConnection con = new SqlConnection();
        public dbconn()
        {
          //  con.ConnectionString = @"Data Source=RUSHIL-HP\RUSHIL;Initial Catalog=IPMS;Integrated Security=True";
            con.ConnectionString = @"Data Source=SEPU\SQLEXPRESS;Initial Catalog=Banking;Integrated Security=True;Pooling=False";

        }
        public SqlDataReader rd(string str)
        {
            CheckStatus();
            SqlDataReader dr;
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = str;
            dr = cmd.ExecuteReader();
            return dr;

        }

        public void CheckStatus()
        {
            if (con.State == ConnectionState.Open)
            {
                con.Close();
            }
            con.Open();
        }
        public void Insert_update_delete(string strQuery)
        {
            CheckStatus();
            SqlCommand cmdQuery = new SqlCommand();
            cmdQuery.CommandText = strQuery;
            cmdQuery.Connection = con;
            cmdQuery.ExecuteNonQuery();
        }


    }
}
