<%@ Page Title="" Language="C#" MasterPageFile="~/Default_Master.Master" AutoEventWireup="true" CodeBehind="OpenAccount.aspx.cs" Inherits="OnlineBankingSystem.OpenAccount" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <p>
        <br />
        <table align="center" style="width: 75%;">
            <tr>
                <td colspan="3" style="text-align: center">Open Account&nbsp;
                    <asp:Label ID="Welcome_Lbl" runat="server"></asp:Label>
                </td>
            </tr>
            <tr>
                <td colspan="3" style="text-align: center">This Is Your Info....!</td>
            </tr>
            <tr>
                <td colspan="3">
                    <asp:FormView ID="FormView1" runat="server" DataSourceID="SqlDataSource_CustomerDetails">
                        <EditItemTemplate>
                            Id:
                            <asp:TextBox ID="IdTextBox" runat="server" Text='<%# Bind("Id") %>' />
                            <br />
                            Fname:
                            <asp:TextBox ID="FnameTextBox" runat="server" Text='<%# Bind("Fname") %>' />
                            <br />
                            Lname:
                            <asp:TextBox ID="LnameTextBox" runat="server" Text='<%# Bind("Lname") %>' />
                            <br />
                            Dob:
                            <asp:TextBox ID="DobTextBox" runat="server" Text='<%# Bind("Dob") %>' />
                            <br />
                            Address:
                            <asp:TextBox ID="AddressTextBox" runat="server" Text='<%# Bind("Address") %>' />
                            <br />
                            City:
                            <asp:TextBox ID="CityTextBox" runat="server" Text='<%# Bind("City") %>' />
                            <br />
                            State:
                            <asp:TextBox ID="StateTextBox" runat="server" Text='<%# Bind("State") %>' />
                            <br />
                            Zipcode:
                            <asp:TextBox ID="ZipcodeTextBox" runat="server" Text='<%# Bind("Zipcode") %>' />
                            <br />
                            Email:
                            <asp:TextBox ID="EmailTextBox" runat="server" Text='<%# Bind("Email") %>' />
                            <br />
                            <asp:LinkButton ID="UpdateButton" runat="server" CausesValidation="True" CommandName="Update" Text="Update" />
                            &nbsp;<asp:LinkButton ID="UpdateCancelButton" runat="server" CausesValidation="False" CommandName="Cancel" Text="Cancel" />
                        </EditItemTemplate>
                        <InsertItemTemplate>
                            Id:
                            <asp:TextBox ID="IdTextBox" runat="server" Text='<%# Bind("Id") %>' />
                            <br />
                            Fname:
                            <asp:TextBox ID="FnameTextBox" runat="server" Text='<%# Bind("Fname") %>' />
                            <br />
                            Lname:
                            <asp:TextBox ID="LnameTextBox" runat="server" Text='<%# Bind("Lname") %>' />
                            <br />
                            Dob:
                            <asp:TextBox ID="DobTextBox" runat="server" Text='<%# Bind("Dob") %>' />
                            <br />
                            Address:
                            <asp:TextBox ID="AddressTextBox" runat="server" Text='<%# Bind("Address") %>' />
                            <br />
                            City:
                            <asp:TextBox ID="CityTextBox" runat="server" Text='<%# Bind("City") %>' />
                            <br />
                            State:
                            <asp:TextBox ID="StateTextBox" runat="server" Text='<%# Bind("State") %>' />
                            <br />
                            Zipcode:
                            <asp:TextBox ID="ZipcodeTextBox" runat="server" Text='<%# Bind("Zipcode") %>' />
                            <br />
                            Email:
                            <asp:TextBox ID="EmailTextBox" runat="server" Text='<%# Bind("Email") %>' />
                            <br />
                            <asp:LinkButton ID="InsertButton" runat="server" CausesValidation="True" CommandName="Insert" Text="Insert" />
                            &nbsp;<asp:LinkButton ID="InsertCancelButton" runat="server" CausesValidation="False" CommandName="Cancel" Text="Cancel" />
                        </InsertItemTemplate>
                        <ItemTemplate>
                            Id:
                            <asp:Label ID="IdLabel" runat="server" Text='<%# Bind("Id") %>' />
                            <br />
                            Fname:
                            <asp:Label ID="FnameLabel" runat="server" Text='<%# Bind("Fname") %>' />
                            <br />
                            Lname:
                            <asp:Label ID="LnameLabel" runat="server" Text='<%# Bind("Lname") %>' />
                            <br />
                            Dob:
                            <asp:Label ID="DobLabel" runat="server" Text='<%# Bind("Dob") %>' />
                            <br />
                            Address:
                            <asp:Label ID="AddressLabel" runat="server" Text='<%# Bind("Address") %>' />
                            <br />
                            City:
                            <asp:Label ID="CityLabel" runat="server" Text='<%# Bind("City") %>' />
                            <br />
                            State:
                            <asp:Label ID="StateLabel" runat="server" Text='<%# Bind("State") %>' />
                            <br />
                            Zipcode:
                            <asp:Label ID="ZipcodeLabel" runat="server" Text='<%# Bind("Zipcode") %>' />
                            <br />
                            Email:
                            <asp:Label ID="EmailLabel" runat="server" Text='<%# Bind("Email") %>' />
                            <br />

                        </ItemTemplate>
                    </asp:FormView>
                    <asp:SqlDataSource ID="SqlDataSource_CustomerDetails" runat="server" ConnectionString="<%$ ConnectionStrings:BankingConnectionString %>" SelectCommand="SELECT [Id], [Fname], [Lname], [Dob], [Address], [City], [State], [Zipcode], [Email] FROM [Customer] WHERE ([Id] = @Id)">
                        <SelectParameters>
                            <asp:ControlParameter ControlID="Welcome_Lbl" Name="Id" PropertyName="Text" Type="String" />
                        </SelectParameters>
                    </asp:SqlDataSource>
                </td>
            </tr>
            <tr>
                <td style="width: 317px">Account Type </td>
                <td>
                    <asp:DropDownList ID="DropDownList1" runat="server">
                        <asp:ListItem>-- Select an Item --</asp:ListItem>
                        <asp:ListItem>CHECKING</asp:ListItem>
                        <asp:ListItem>SAVINGS</asp:ListItem>
                    </asp:DropDownList>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td style="width: 317px">Deposite </td>
                <td>
                    <asp:TextBox ID="Deposite_Txt" runat="server"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="Deposite_Txt" ErrorMessage="Please Enter Amount More Than $1"></asp:RequiredFieldValidator>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td style="width: 317px">Date </td>
                <td>
                    <asp:Label ID="Date_Lbl" runat="server" Text="Label"></asp:Label>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colspan="3" style="text-align: center">
                    <asp:Button ID="Open_Account" runat="server" OnClick="Open_Account_Click" Text="Open Account" />
                </td>
            </tr>
            <tr>
                <td style="width: 317px">&nbsp;</td>
                <td>
                    <asp:Label ID="Account_Number" runat="server" Text="Label"></asp:Label>
                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </p>
    <p>
        &nbsp;</p>
</asp:Content>
