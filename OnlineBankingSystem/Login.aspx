<%@ Page Title="" Language="C#" EnableSessionState="True" MasterPageFile="~/Default_Master.Master" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="OnlineBankingSystem.Login" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <p>
        <br />
        <table align="center" style="width: 70%;">
            <tr>
                <td colspan="2" style="text-align: center; font-size: xx-large; height: 55px">Login </td>
            </tr>
            <tr>
                <td style="text-align: center; font-size: x-large; width: 270px">Id </td>
                <td>
                    <asp:TextBox ID="Id_Txt" runat="server" Width="230px"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="Please Enter Your ID" ControlToValidate="Id_Txt"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td style="text-align: center; font-size: x-large; width: 270px; height: 32px;">Password</td>
                <td style="height: 32px">
                    <asp:TextBox ID="Password_Txt" runat="server" Width="230px" TextMode="Password"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="Password_Txt" ErrorMessage="Please Enter Your Password"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="font-size: x-large; text-align: center">
                    <asp:Button ID="Login_Btn" runat="server" Height="36px" OnClick="Login_Btn_Click" Text="Login" Width="63px" />
                </td>
            </tr>
            <tr>
                <td colspan="2" style="font-size: x-large; text-align: center">
                    <asp:Label ID="Login_Status_Lbl" runat="server" Visible="False"></asp:Label>
                    <br />
                    <span style="font-size: medium">Don&#39;t Have Account ? </span>
                    <asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="~/Signup.aspx">SignUp Here</asp:HyperLink>
                    <br />
                </td>
            </tr>
        </table>
 
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
</asp:Content>
