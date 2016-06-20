package database.operation;
import java.sql.*;
public class ConditionQuery
{   String number ;                  //雇员号
    float salaryMax,salaryMin;       //薪水范围
    StringBuffer queryResultByNumber,
                 queryResultBySalary;
    public ConditionQuery()
    {  queryResultByNumber=new StringBuffer();
       queryResultBySalary=new StringBuffer();
       try{  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          }
       catch(Exception e){ } 
    }
    public void setNumber(String s)
    {  number=s.trim();
       queryResultByNumber=new StringBuffer();
       queryResultBySalary=new StringBuffer();
    }
    public String getNumber()
    {  return number;
    }
    public void setSalaryMax(float n)
    {  salaryMax=n;
       queryResultByNumber=new StringBuffer();
       queryResultBySalary=new StringBuffer();
    }
    public float getSalaryMax()
    {  return salaryMax;
    }
    public void setSalaryMin(float n)
    {  salaryMin=n;
       queryResultByNumber=new StringBuffer();
       queryResultBySalary=new StringBuffer();
    }
    public float getSalaryMin()
    {  return salaryMin;
    }
    public StringBuffer getQueryResultByNumber()
    {    String condition="SELECT * FROM employee Where number = '"+number+"'";
         queryResultByNumber=f(condition);
         return queryResultByNumber;
    } 
    public StringBuffer getQueryResultBySalary()
    {  String condition="SELECT * FROM employee Where salary <= "+salaryMax
                         +" AND "+"salary >= "+salaryMin;
       queryResultBySalary=f(condition);
       return queryResultBySalary;
    }   
    private StringBuffer f(String condition)
    {  StringBuffer str=new StringBuffer();
       Connection con;
       Statement sql; 
       ResultSet rs;
       try { String uri="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=factory";
             con=DriverManager.getConnection(uri,"sa","sa");
             sql=con.createStatement();
             rs=sql.executeQuery(condition);
             str.append("<table border=1>");
             str.append("<th width=100>"+"number");
             str.append("<th width=100>"+"name");
             str.append("<th width=100>"+"birthday");
             str.append("<th width=100>"+"salary");
            while(rs.next())
             {  str.append("<tr>");
                   str.append("<td>"+rs.getString(1)+"</td>");
                   str.append("<td>"+rs.getString(2)+"</td>");
                   str.append("<td>"+rs.getDate(3)+"</td>");
                   str.append("<td>"+rs.getFloat(4)+"</td>");
               str.append("</tr>");
             }
            str.append("<table border=1>");
            con.close();
           }
       catch(SQLException e)
          { System.out.println(e);
          }
       return str;
   }   
}  