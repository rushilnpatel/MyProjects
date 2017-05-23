<%@ Page Title="" Language="C#" EnableSessionState="ReadOnly" MasterPageFile="~/Default_Master.Master" AutoEventWireup="true" CodeBehind="Welcome.aspx.cs" Inherits="OnlineBankingSystem.Welcome" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
   
    <br />
    <br />
    <br />
    
    
     <div>
        <br /><p>
        Welcome .......<asp:Label ID="Welcome_Lbl" runat="server" OnDataBinding="Page_Load" OnLoad="Page_Load"></asp:Label>
        ...<asp:Label ID="Name_Lbl" runat="server" Text="Label"></asp:Label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </p>
    </div>
    <div><p>
        &nbsp;</p></div>
    <div> <p>
        &nbsp; </p></div>
    <div>
        <p>
    &nbsp;&nbsp;&nbsp;&nbsp;
    </p>
        <p>
            <table style="width:79%;" align="center" border="1">
                <tr>
                    <td style="height: 19px; width: 229px;">
        <asp:FormView ID="FormView1" runat="server" DataSourceID="SqlDataSource_Customer" Width="222px" Height="190px" CellPadding="4" Font-Italic="True" Font-Size="Medium" ForeColor="#333333" HeaderText="Your Info">
            <EditItemTemplate>
                Fname:
                <asp:TextBox ID="FnameTextBox" runat="server" Text='<%# Bind("Fname") %>' />
                <br />
                Lname:
                <asp:TextBox ID="LnameTextBox" runat="server" Text='<%# Bind("Lname") %>' />
                <br />
                Dob:
                <asp:TextBox ID="DobTextBox" runat="server" Text='<%# Bind("Dob") %>' />
                <br />
                City:
                <asp:TextBox ID="CityTextBox" runat="server" Text='<%# Bind("City") %>' />
                <br />
                State:
                <asp:TextBox ID="StateTextBox" runat="server" Text='<%# Bind("State") %>' />
                <br />
                Address:
                <asp:TextBox ID="AddressTextBox" runat="server" Text='<%# Bind("Address") %>' />
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
            <EditRowStyle BackColor="#999999" />
            <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <InsertItemTemplate>
                Fname:
                <asp:TextBox ID="FnameTextBox" runat="server" Text='<%# Bind("Fname") %>' />
                <br />
                Lname:
                <asp:TextBox ID="LnameTextBox" runat="server" Text='<%# Bind("Lname") %>' />
                <br />
                Dob:
                <asp:TextBox ID="DobTextBox" runat="server" Text='<%# Bind("Dob") %>' />
                <br />
                City:
                <asp:TextBox ID="CityTextBox" runat="server" Text='<%# Bind("City") %>' />
                <br />
                State:
                <asp:TextBox ID="StateTextBox" runat="server" Text='<%# Bind("State") %>' />
                <br />
                Address:
                <asp:TextBox ID="AddressTextBox" runat="server" Text='<%# Bind("Address") %>' />
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
                Fname:
                <asp:Label ID="FnameLabel" runat="server" Text='<%# Bind("Fname") %>' />
                <br />
                Lname:
                <asp:Label ID="LnameLabel" runat="server" Text='<%# Bind("Lname") %>' />
                <br />
                Dob:
                <asp:Label ID="DobLabel" runat="server" Text='<%# Bind("Dob") %>' />
                <br />
                City:
                <asp:Label ID="CityLabel" runat="server" Text='<%# Bind("City") %>' />
                <br />
                State:
                <asp:Label ID="StateLabel" runat="server" Text='<%# Bind("State") %>' />
                <br />
                Address:
                <asp:Label ID="AddressLabel" runat="server" Text='<%# Bind("Address") %>' />
                <br />
                Zipcode:
                <asp:Label ID="ZipcodeLabel" runat="server" Text='<%# Bind("Zipcode") %>' />
                <br />
                Email:
                <asp:Label ID="EmailLabel" runat="server" Text='<%# Bind("Email") %>' />
                <br />

            </ItemTemplate>
            <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
            <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
        </asp:FormView>
                    </td>
                    <td style="height: 19px; width: 130px;">&nbsp;</td>
                    <td style="height: 19px">
                        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" CellPadding="4" DataKeyNames="Account_Number" DataSourceID="SqlDataSource_Account_Details" ForeColor="#333333" GridLines="None" Height="220px" style="margin-left: 0px">
                            <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
                            <Columns>
                                <asp:CommandField ShowSelectButton="True" />
                                <asp:BoundField DataField="Id" HeaderText="Id" SortExpression="Id" />
                                <asp:BoundField DataField="Account_Number" HeaderText="Account_Number" ReadOnly="True" SortExpression="Account_Number" />
                                <asp:BoundField DataField="Account_Type" HeaderText="Account_Type" SortExpression="Account_Type" />
                                <asp:BoundField DataField="Balance" HeaderText="Balance" SortExpression="Balance" />
                            </Columns>
                            <EditRowStyle BackColor="#999999" />
                            <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                            <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                            <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
                            <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
                            <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
                            <SortedAscendingCellStyle BackColor="#E9E7E2" />
                            <SortedAscendingHeaderStyle BackColor="#506C8C" />
                            <SortedDescendingCellStyle BackColor="#FFFDF8" />
                            <SortedDescendingHeaderStyle BackColor="#6F8DAE" />
                        </asp:GridView>
                        <asp:SqlDataSource ID="SqlDataSource_Account_Details" runat="server" ConnectionString="<%$ ConnectionStrings:BankingConnectionString %>" SelectCommand="SELECT [Id], [Account_Number], [Account_Type], [Balance] FROM [Account] WHERE ([Id] = @Id)">
                            <SelectParameters>
                                <asp:ControlParameter ControlID="Welcome_Lbl" Name="Id" PropertyName="Text" Type="String" />
                            </SelectParameters>
                        </asp:SqlDataSource>
                    </td>
                </tr>
                
                <tr>
                    <td style="height: 46px; width: 229px;"></td>
                    <td style="height: 46px; width: 130px;"></td>
                    <td style="height: 46px">
                        <asp:GridView ID="GridView2" runat="server" AutoGenerateColumns="False" CellPadding="4" DataKeyNames="Transid" DataSourceID="SqlDataSource_Detail" ForeColor="#333333" GridLines="None">
                            <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
                            <Columns>
                                <asp:BoundField DataField="Transid" HeaderText="Transid" InsertVisible="False" ReadOnly="True" SortExpression="Transid" />
                                <asp:BoundField DataField="Id" HeaderText="Id" SortExpression="Id" />
                                <asp:BoundField DataField="Account_Number" HeaderText="Account_Number" SortExpression="Account_Number" />
                                <asp:BoundField DataField="Account_Type" HeaderText="Account_Type" SortExpression="Account_Type" />
                                <asp:BoundField DataField="Amount" HeaderText="Amount" SortExpression="Amount" />
                                <asp:BoundField DataField="Date" HeaderText="Date" SortExpression="Date" />
                            </Columns>
                            <EditRowStyle BackColor="#999999" />
                            <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                            <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                            <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
                            <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
                            <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
                            <SortedAscendingCellStyle BackColor="#E9E7E2" />
                            <SortedAscendingHeaderStyle BackColor="#506C8C" />
                            <SortedDescendingCellStyle BackColor="#FFFDF8" />
                            <SortedDescendingHeaderStyle BackColor="#6F8DAE" />
                        </asp:GridView>
                    </td>
                </tr>
                
                <tr>
                    <td style="height: 19px; width: 229px;">&nbsp;</td>
                    <td style="height: 19px" colspan="2">
                        <asp:SqlDataSource ID="SqlDataSource_Detail" runat="server" ConnectionString="<%$ ConnectionStrings:BankingConnectionString %>" SelectCommand="SELECT * FROM [Transaction] WHERE ([Account_Number] = @Account_Number)">
                            <SelectParameters>
                                <asp:ControlParameter ControlID="GridView1" Name="Account_Number" PropertyName="SelectedValue" Type="String" />
                            </SelectParameters>
                        </asp:SqlDataSource>
                    </td>
                </tr>
                
            </table>
        </p>
        <p>
            &nbsp;</p>
        <p>
        <asp:SqlDataSource ID="SqlDataSource_Customer" runat="server" ConnectionString="<%$ ConnectionStrings:BankingConnectionString %>" OnDataBinding="Page_Load" SelectCommand="SELECT [Fname], [Lname], [Dob], [City], [State], [Address], [Zipcode], [Email] FROM [Customer] WHERE ([Id] = @Id)">
            <SelectParameters>
                <asp:ControlParameter ControlID="Welcome_Lbl" Name="Id" PropertyName="Text" Type="String" />
            </SelectParameters>
            </asp:SqlDataSource>
    </p>
        <p>
            &nbsp;</p>
        <p>
            &nbsp;</p>
        <p>
            &nbsp;</p>
        <p>
            &nbsp;</p>
        <p style="text-align: center">
            &nbsp;</p>
    </div><br />
     <div>   &nbsp; </div> <br />
   
</asp:Content>
