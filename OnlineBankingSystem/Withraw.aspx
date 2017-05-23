<%@ Page Title="" Language="C#" MasterPageFile="~/Default_Master.Master" AutoEventWireup="true" CodeBehind="Withraw.aspx.cs" Inherits="OnlineBankingSystem.Withraw" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <p>
    <br />
        <table align="center" style="width: 77%;">
            <tr>
                <td colspan="3" style="text-align: center; height: 53px; font-size: medium;">Withraw&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:Label ID="Welcome_Lbl" runat="server" Text="Welcome_Lbl"></asp:Label>
                </td>
            </tr>
            <tr>
                <td style="text-align: center; height: 26px;">Account Type</td>
                <td colspan="2" style="text-align: center; height: 26px;">
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
                <td style="text-align: center">Amount </td>
                <td style="text-align: center">
                    <asp:TextBox ID="Amount_Txt" runat="server"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="Amount_Txt" ErrorMessage="Enter Amount You Want To Withdraw"></asp:RequiredFieldValidator>
                </td>
                <td style="width: 61px">
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
                    <asp:Button ID="Withraw_Btn" runat="server" Text="Withdraw" OnClick="Deposite_Btn_Click" />
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
    <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:BankingConnectionString %>" SelectCommand="SELECT * FROM [Transaction] WHERE (([Account_Number] = @Account_Number) AND ([Account_Type] = @Account_Type) AND ([Amount] = @Amount) AND ([Date] = @Date) AND ([Id] = @Id) AND ([Transid] = @Transid))">
        <SelectParameters>
            <asp:ControlParameter ControlID="Account_Number_Lbl" Name="Account_Number" PropertyName="Text" Type="String" />
            <asp:ControlParameter ControlID="DropDownList1" Name="Account_Type" PropertyName="SelectedValue" Type="String" />
            <asp:ControlParameter ControlID="Amount_Txt" Name="Amount" PropertyName="Text" Type="String" />
            <asp:ControlParameter ControlID="Date_Lbl" DbType="Date" Name="Date" PropertyName="Text" />
            <asp:ControlParameter ControlID="Welcome_Lbl" Name="Id" PropertyName="Text" Type="String" />
            <asp:ControlParameter ControlID="Label1" Name="Transid" PropertyName="Text" Type="String" />
        </SelectParameters>
    </asp:SqlDataSource>
</p>
<p>
</p>
</asp:Content>
