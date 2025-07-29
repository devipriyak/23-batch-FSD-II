import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class SubmitForm extends Frame implements ActionListener
{
    TextField uid,un,pw,rol;
    Button bs,bc;
    Label i,n,p,r,msg;
    SubmitForm()
    {
        setLayout(new GridLayout(6,2));
	i=new Label("UID:");
        n=new Label("Name:");
        p=new Label("Password:");
	r=new Label("Role");
	msg=new Label("");
	uid=new TextField(20);
	un=new TextField(20);
        pw=new TextField(20);
	rol=new TextField(20);
        pw.setEchoChar('*');
        bs=new Button("Submit");
        bc=new Button("cancel");
	this.add(i);
	this.add(uid);
        this.add(n);
        this.add(un);
        this.add(p);
        this.add(pw);
	this.add(r);
	this.add(rol);
        this.add(bs);
        this.add(bc);
	this.add(msg);
       	bs.addActionListener(this);
	bc.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
	if(ae.getSource()==bs)
	{
         try{
Class.forName("oracle.jdbc.driver.OracleDriver");  //step1 load the driver class  

//step2 create  the connection object  
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager"); 
String ui=uid.getText();
String unm=un.getText();
String pwd=pw.getText();
String role=rol.getText();
String query="insert into MsUsers values('"+ui+"','"+unm+"','"+pwd+"','"+role+"')";
Statement stmt=con.createStatement();
stmt.executeUpdate( query);
con.close();

msg.setText("Data Inserted Successfully");
            System.out.println("Command successful"); 


}
catch(Exception e)
{
System.out.println(e);
}  
  
          
}
      	if(ae.getSource()==bc)
	{
          uid.setText(" ");
	  un.setText(" ");
	  pw.setText(" ");
	  rol.setText(" ");
	  msg.setText("Data Empty");
        }
	
    }
    public static void main(String args[])
    {
       SubmitForm s=new SubmitForm();
        s.setVisible(true);
        s.setSize(400,400);
        s.setTitle("User Registration");

    }
}