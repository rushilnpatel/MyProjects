<%@ Page Title="" Language="C#" MasterPageFile="~/Default_Master.Master" AutoEventWireup="true" CodeBehind="Signup.aspx.cs" Inherits="OnlineBankingSystem.Signup" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <p>
        <br />
        <br />
        <br />
        <br />
        <table align="center" style="width: 70%; color: #000000; font-size: medium;">
            <tr>
                <td colspan="4" style="text-align: center; height: 58px"><strong>Sign Up with My Bank</td>
            </tr>
            <tr>
                <td style="text-align: center; height: 43px">Name</td>
                <td colspan="2" style="height: 43px">
                    <asp:TextBox ID="Fname_Txt" runat="server">First Name</asp:TextBox>
&nbsp; 
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="Fname_Txt" ErrorMessage="Enter First Name"></asp:RequiredFieldValidator>
                </td>
                <td style="height: 43px">
                    <asp:TextBox ID="Lname_Txt" runat="server">Last Name</asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="Lname_Txt" ErrorMessage="Enter Last Name"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td style="text-align: center">Date Of Birth</td>
                <td colspan="3">
                    <asp:TextBox ID="Dob_Txt" runat="server">Birthday</asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ControlToValidate="Dob_Txt" ErrorMessage="Enter Date Of Birth"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td style="text-align: center">Social </td>
                <td colspan="3">
                    <asp:TextBox ID="Ssn_Txt" runat="server">Social</asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="text-align: center">Address</td>
                <td colspan="3">
                    <asp:TextBox ID="Address_Txt" runat="server" Height="45px" TextMode="MultiLine" Width="188px">Address</asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ControlToValidate="Address_Txt" ErrorMessage="Enter Your Address"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td style="text-align: center">&nbsp;</td>
                <td>
                    <asp:TextBox ID="City_Txt" runat="server">City</asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator6" runat="server" ControlToValidate="City_Txt" ErrorMessage="Enter Your City"></asp:RequiredFieldValidator>
                </td>
                <td colspan="2">State
                    <asp:DropDownList ID="State_Dropdown" runat="server">
                        <asp:ListItem>NJ</asp:ListItem>
                        <asp:ListItem>NY</asp:ListItem>
                    </asp:DropDownList>
                </td>
            </tr>
            <tr>
                <td style="text-align: center">&nbsp;</td>
                <td colspan="3">
                    <asp:TextBox ID="Zip_Txt" runat="server">Zip Code</asp:TextBox>
                    <asp:RegularExpressionValidator ID="RegularExpressionValidator3" runat="server" ControlToValidate="Zip_Txt" ErrorMessage="Invalid ZIP Code" ValidationExpression="\d{5}(-\d{4})?"></asp:RegularExpressionValidator>
                </td>
            </tr>
            <tr>
                <td style="text-align: center">Email </td>
                <td colspan="3">
                    <asp:TextBox ID="Email_Txt" runat="server">Email</asp:TextBox>
                    <asp:RegularExpressionValidator ID="RegularExpressionValidator2" runat="server" ControlToValidate="Email_Txt" ErrorMessage="Enter Valid Email" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RegularExpressionValidator>
                </td>
            </tr>
            <tr>
                <td style="text-align: center; height: 30px;">Customer Id </td>
                <td colspan="3" style="height: 30px">
                    <asp:TextBox ID="CustomerId_Txt" runat="server">Select Id</asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" ControlToValidate="CustomerId_Txt" ErrorMessage="Enter Customer ID"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td style="height: 26px; text-align: center">Create Password</td>
                <td colspan="3" style="height: 26px">
                    <asp:TextBox ID="Pass1_Txt" runat="server">Choose Password</asp:TextBox>
                    <asp:CompareValidator ID="CompareValidator1" runat="server" ControlToCompare="Pass1_Txt" ControlToValidate="Pass2_Txt" ErrorMessage="Password Doesnt Match"></asp:CompareValidator>
                </td>
            </tr>
            <tr>
                <td style="text-align: center">Confirm Password </td>
                <td colspan="3">
                    <asp:TextBox ID="Pass2_Txt" runat="server">Confirm Password</asp:TextBox>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td colspan="3">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="4" style="text-align: center">
                    <asp:Button ID="Signup_btn" runat="server" OnClick="Signup_btn_Click" Text="Signup" />
                </td>
            </tr>
            <tr>
                <td colspan="4" style="text-align: center">
                    <asp:Label ID="Signup_Lbl" runat="server" Text="Label" Visible="False"></asp:Label>
                </td>
            </tr>
            <tr>
                <td colspan="4" style="text-align: center">
                    <asp:Label ID="Signup_Lbl2" runat="server" Visible="False"></asp:Label>
                    </strong></td>
            </tr>
        </table>
    </p>
    <p>
        &nbsp;</p>
</asp:Content>
