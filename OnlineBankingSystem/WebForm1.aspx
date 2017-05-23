<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="OnlineBankingSystem.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:FormView ID="FormView1" runat="server" DataKeyNames="Account_Number" DataSourceID="SqlDataSource1">
            <EditItemTemplate>
                Id:
                <asp:TextBox ID="IdTextBox" runat="server" Text='<%# Bind("Id") %>' />
                <br />
                Account_Number:
                <asp:Label ID="Account_NumberLabel1" runat="server" Text='<%# Eval("Account_Number") %>' />
                <br />
                Account_Type:
                <asp:TextBox ID="Account_TypeTextBox" runat="server" Text='<%# Bind("Account_Type") %>' />
                <br />
                Balance:
                <asp:TextBox ID="BalanceTextBox" runat="server" Text='<%# Bind("Balance") %>' />
                <br />
                date:
                <asp:TextBox ID="dateTextBox" runat="server" Text='<%# Bind("date") %>' />
                <br />
                <asp:LinkButton ID="UpdateButton" runat="server" CausesValidation="True" CommandName="Update" Text="Update" />
                &nbsp;<asp:LinkButton ID="UpdateCancelButton" runat="server" CausesValidation="False" CommandName="Cancel" Text="Cancel" />
            </EditItemTemplate>
            <InsertItemTemplate>
                Id:
                <asp:TextBox ID="IdTextBox" runat="server" Text='<%# Bind("Id") %>' />
                <br />
                Account_Number:
                <asp:TextBox ID="Account_NumberTextBox" runat="server" Text='<%# Bind("Account_Number") %>' />
                <br />
                Account_Type:
                <asp:TextBox ID="Account_TypeTextBox" runat="server" Text='<%# Bind("Account_Type") %>' />
                <br />
                Balance:
                <asp:TextBox ID="BalanceTextBox" runat="server" Text='<%# Bind("Balance") %>' />
                <br />
                date:
                <asp:TextBox ID="dateTextBox" runat="server" Text='<%# Bind("date") %>' />
                <br />
                <asp:LinkButton ID="InsertButton" runat="server" CausesValidation="True" CommandName="Insert" Text="Insert" />
                &nbsp;<asp:LinkButton ID="InsertCancelButton" runat="server" CausesValidation="False" CommandName="Cancel" Text="Cancel" />
            </InsertItemTemplate>
            <ItemTemplate>
                Id:
                <asp:Label ID="IdLabel" runat="server" Text='<%# Bind("Id") %>' />
                <br />
                Account_Number:
                <asp:Label ID="Account_NumberLabel" runat="server" Text='<%# Eval("Account_Number") %>' />
                <br />
                Account_Type:
                <asp:Label ID="Account_TypeLabel" runat="server" Text='<%# Bind("Account_Type") %>' />
                <br />
                Balance:
                <asp:Label ID="BalanceLabel" runat="server" Text='<%# Bind("Balance") %>' />
                <br />
                date:
                <asp:Label ID="dateLabel" runat="server" Text='<%# Bind("date") %>' />
                <br />

            </ItemTemplate>
        </asp:FormView>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:BankingConnectionString %>" SelectCommand="SELECT * FROM [Account]"></asp:SqlDataSource>
    
        <br />
        <br />
        <br />
        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
    
    </div>
    </form>
</body>
</html>
