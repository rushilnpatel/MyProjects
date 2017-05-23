<%@ Page Title="" Language="C#" MasterPageFile="~/Default_Master.Master" AutoEventWireup="true" CodeBehind="Deposit.aspx.cs" Inherits="OnlineBankingSystem.Deposit" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <p>
        <br />
        <table align="center" style="width: 77%;">
            <tr>
                <td colspan="3" style="text-align: center; height: 53px; font-size: medium;">Deposite&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:Label ID="Welcome_Lbl" runat="server" Text="Welcome_Lbl"></asp:Label>
                </td>
            </tr>
            <tr>
                <td style="text-align: center">Account Type</td>
                <td colspan="2" style="text-align: center">
                    <asp:DropDownList ID="DropDownList1" runat="server" AutoPostBack="True">
                        <asp:ListItem>CHECKING</asp:ListItem>
                        <asp:ListItem>SAVINGS</asp:ListItem>
                    </asp:DropDownList>
                </td>
            </tr>
            <tr>
                <td style="text-align: center">Account Number </td>
                <td colspan="2" style="text-align: center">
                    <asp:Label ID="Account_Number_Lbl" runat="server" Text="Label"></asp:Label>
                </td>
            </tr>
            <tr>
                <td style="text-align: center; height: 30px;">Amount </td>
                <td style="text-align: center; height: 30px;">
                    <asp:TextBox ID="Amount_Txt" runat="server"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="Amount_Txt" ErrorMessage="Enter Amount You Want To Deposite"></asp:RequiredFieldValidator>
                </td>
                <td style="width: 61px; height: 30px;">
                    <asp:Label ID="Balance_Lbl" runat="server" Text="Label"></asp:Label>
                </td>
            </tr>
            <tr>
                <td style="text-align: center">date </td>
                <td colspan="2" style="text-align: center">
                    <asp:Label ID="Date_Lbl" runat="server" Text="Label"></asp:Label>
                </td>
            </tr>
            <tr>
                <td colspan="3" style="text-align: center">
                    <asp:Button ID="Deposite_Btn" runat="server" Text="Deposite" OnClick="Deposite_Btn_Click" />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
                </td>
            </tr>
            <tr>
                <td style="height: 26px">
                    &nbsp;</td>
                <td style="height: 26px">
                    &nbsp;</td>
                <td style="height: 26px; width: 61px;"></td>
            </tr>
        </table>
    </p>
    <p>
    </p>
</asp:Content>
