/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lich.im;
import java.sql.*;
/**
 *
 * @author liyi
 */
public class dml 
{   String number,number2;//雇员号
    int id,sd;
    boolean sort=false;
    float salaryMax,salaryMin,salaryMax2,salaryMin2;       //薪水范围
    StringBuffer queryResultByNumber,
                 queryResultBySalary,
                 queryResultByMohu,
                 queryResultByGroup,
                 queryResultByNumberSort,
                 queryResultBySalarySort,
                 queryResultByMohuSort,
                 queryResultByGroupSort,
                 queryResult;
    String ziduan="",ziduan2="";       //字段 
    String keyWord="",keyWord2="";       //关键
    
    public dml()
    {  queryResultByNumber=new StringBuffer();
       queryResultBySalary=new StringBuffer();
       queryResultByMohu=new StringBuffer();
       queryResultByGroup=new StringBuffer();
       queryResultByNumberSort=new StringBuffer();
       queryResultBySalarySort=new StringBuffer();
       queryResultByMohuSort=new StringBuffer();
       queryResultByGroupSort=new StringBuffer();
       queryResult=new StringBuffer();
       try{  Class.forName("net.sourceforge.jtds.jdbc.Driver");
          }
       catch(Exception e){ } 
    }
    public void setNumber(String s)
    {  number=s.trim();
       queryResultByNumber=new StringBuffer();
       queryResultBySalary=new StringBuffer();
       queryResultByMohu=new StringBuffer();
       queryResultByGroup=new StringBuffer();
       queryResultByNumberSort=new StringBuffer();
       queryResultBySalarySort=new StringBuffer();
       queryResultByMohuSort=new StringBuffer();
       queryResultByGroupSort=new StringBuffer();
       queryResult=new StringBuffer();
    }
    public String getNumber()
    {  return number;
    }
    public void setNumber2(String s)
    {  number2=s.trim();
       queryResultByNumber=new StringBuffer();
       queryResultBySalary=new StringBuffer();
       queryResultByMohu=new StringBuffer();
       queryResultByGroup=new StringBuffer();
       queryResultByNumberSort=new StringBuffer();
       queryResultBySalarySort=new StringBuffer();
       queryResultByMohuSort=new StringBuffer();
       queryResultByGroupSort=new StringBuffer();
       queryResult=new StringBuffer();
    }
    public String getNumber2()
    {  return number2;
    }
    public void setSalaryMax(float n)
    {  salaryMax=n;
       queryResultByNumber=new StringBuffer();
       queryResultBySalary=new StringBuffer();
       queryResultByMohu=new StringBuffer();
       queryResultByGroup=new StringBuffer();
       queryResultByNumberSort=new StringBuffer();
       queryResultBySalarySort=new StringBuffer();
       queryResultByMohuSort=new StringBuffer();
       queryResultByGroupSort=new StringBuffer();
       queryResult=new StringBuffer();
    }
    public float getSalaryMax()
    {  return salaryMax;
    }
    public void setSalaryMin(float n)
    {  salaryMin=n;
       queryResultByNumber=new StringBuffer();
       queryResultBySalary=new StringBuffer();
       queryResultByMohu=new StringBuffer();
       queryResultByGroup=new StringBuffer();
       queryResultByNumberSort=new StringBuffer();
       queryResultBySalarySort=new StringBuffer();
       queryResultByMohuSort=new StringBuffer();
       queryResultByGroupSort=new StringBuffer();
       queryResult=new StringBuffer();
    }
    public float getSalaryMin()
    {  return salaryMin;
    }
    public void setSalaryMax2(float n)
    {  salaryMax2=n;
       queryResultByNumber=new StringBuffer();
       queryResultBySalary=new StringBuffer();
       queryResultByMohu=new StringBuffer();
       queryResultByGroup=new StringBuffer();
       queryResultByNumberSort=new StringBuffer();
       queryResultBySalarySort=new StringBuffer();
       queryResultByMohuSort=new StringBuffer();
       queryResultByGroupSort=new StringBuffer();
       queryResult=new StringBuffer();
    }
    public float getSalaryMax2()
    {  return salaryMax2;
    }
    public void setSalaryMin2(float n)
    {  salaryMin2=n;
       queryResultByNumber=new StringBuffer();
       queryResultBySalary=new StringBuffer();
       queryResultByMohu=new StringBuffer();
       queryResultByGroup=new StringBuffer();
       queryResultByNumberSort=new StringBuffer();
       queryResultBySalarySort=new StringBuffer();
       queryResultByMohuSort=new StringBuffer();
       queryResultByGroupSort=new StringBuffer();
       queryResult=new StringBuffer();
    }
    public float getSalaryMin2()
    {  return salaryMin2;
    }
   public void setId(int n)
   {
       id=n;
       queryResultByNumber=new StringBuffer();
       queryResultBySalary=new StringBuffer();
       queryResultByMohu=new StringBuffer();
       queryResultByGroup=new StringBuffer();
       queryResultByNumberSort=new StringBuffer();
       queryResultBySalarySort=new StringBuffer();
       queryResultByMohuSort=new StringBuffer();
       queryResultByGroupSort=new StringBuffer();
       queryResult=new StringBuffer();
   }
   public int getId()
   {
       return id;
   }
    public void setSd(int n)
   {
       sd=n;
       queryResultByNumber=new StringBuffer();
       queryResultBySalary=new StringBuffer();
       queryResultByMohu=new StringBuffer();
       queryResultByGroup=new StringBuffer();
       queryResultByNumberSort=new StringBuffer();
       queryResultBySalarySort=new StringBuffer();
       queryResultByMohuSort=new StringBuffer();
       queryResultByGroupSort=new StringBuffer();
       queryResult=new StringBuffer();
   }
    public int getSd()
    {
        return sd;
    }
    public void setKeyWord(String s)
    {  keyWord=s.trim();
       try{ byte bb[]=keyWord.getBytes("ISO-8859-1");
            keyWord=new String(bb,"gb2312"); 
          }
       catch(Exception e){}
    }
   public String getKeyWord()
    {  return keyWord;
    }
   public void setKeyWord2(String s)
    {  keyWord2=s.trim();
       try{ byte bb[]=keyWord2.getBytes("ISO-8859-1");
            keyWord2=new String(bb,"gb2312"); 
          }
       catch(Exception e){}
    }
   public String getKeyWord2()
    {  return keyWord2;
    }
   public void setZiduan(String s)
    {  ziduan=s.trim();
       try{ byte bb[]=ziduan.getBytes("ISO-8859-1");
            ziduan=new String(bb,"gb2312"); 
          }
       catch(Exception e){}
    }
   public String getZiduan()
    {  return ziduan;
    }
   public void setZiduan2(String s)
    {  ziduan2=s.trim();
       try{ byte bb[]=ziduan2.getBytes("ISO-8859-1");
            ziduan2=new String(bb,"gb2312"); 
          }
       catch(Exception e){}
    }
   public String getZiduan2()
    {  return ziduan2;
    }
      public StringBuffer getQueryResultByMohu()
    {  String condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where "+ziduan+" Like '%"+keyWord+"%'";
       StringBuffer str=f(condition);  
       return str;
    }
      public StringBuffer getQueryResultByMohuSort()
      {
          String condition="";
          if(sort==false)
          {
          if(sd==1) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where "+ziduan+" Like '%"+keyWord+"%' Order by ID DESC";
          else if(sd==2) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where "+ziduan+" Like '%"+keyWord+"%' Order by Name DESC";
          else if(sd==3) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where "+ziduan+" Like '%"+keyWord+"%' Order by Sex DESC";
          else if(sd==4) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where "+ziduan+" Like '%"+keyWord+"%' Order by Phone DESC";
          else condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where "+ziduan+" Like '%"+keyWord+"%' Order by Income DESC";
          sort=true;
          }
          else
          {
          if(sd==1) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where "+ziduan+" Like '%"+keyWord+"%' Order by ID ASC";
          else if(sd==2) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where "+ziduan+" Like '%"+keyWord+"%' Order by Name ASC";
          else if(sd==3) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where "+ziduan+" Like '%"+keyWord+"%' Order by Sex ASC";
          else if(sd==4) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where "+ziduan+" Like '%"+keyWord+"%' Order by Phone ASC";
          else condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where "+ziduan+" Like '%"+keyWord+"%' Order by Income ASC";
          sort=false;
          }
          StringBuffer str=f(condition);
          sd=0;
          return str;
      }

    public StringBuffer getQueryResultByNumber()
    {    String condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id = '"+number+"'";
         queryResultByNumber=f(condition);
         return queryResultByNumber;
    } 
    
     public StringBuffer getQueryResultByNumberSort()
      {
          String condition="";
          if(sort==false)
          {
          if(sd==1) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id = '"+number+"' Order by ID DESC";
          else if(sd==2) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id = '"+number+"' Order by Name DESC";
          else if(sd==3) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id = '"+number+"' Order by Sex DESC";
          else if(sd==4) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id = '"+number+"' Order by Phone DESC";
          else condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id = '"+number+"' Order by Income DESC";
          sort=true;
          }
          else
          {
          if(sd==1) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id = '"+number+"' Order by ID ASC";
          else if(sd==2) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id = '"+number+"' Order by Name ASC";
          else if(sd==3) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id = '"+number+"' Order by Sex ASC";
          else if(sd==4) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id = '"+number+"' Order by Phone ASC";
          else condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id = '"+number+"' Order by Income ASC";
          sort=false;
          }
          StringBuffer str=f(condition);
          sd=0;
          return str;
      }
     
    public StringBuffer getQueryResultBySalary()
    {  String condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Income <= "+salaryMax
                         +" AND "+"Income >= "+salaryMin;
       queryResultBySalary=f(condition);
       return queryResultBySalary;
    }
    
    public StringBuffer getQueryResultBySalarySort()
      {
          String condition="";
          if(sort==false)
          {
          if(sd==1) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Income <= "+salaryMax
                         +" AND "+"Income >= "+salaryMin+" Order by ID DESC";
          else if(sd==2) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Income <= "+salaryMax
                         +" AND "+"Income >= "+salaryMin+" Order by Name DESC";
          else if(sd==3) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Income <= "+salaryMax
                         +" AND "+"Income >= "+salaryMin+" Order by Sex DESC";
          else if(sd==4) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Income <= "+salaryMax
                         +" AND "+"Income >= "+salaryMin+" Order by Phone DESC";
          else condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Income <= "+salaryMax
                         +" AND "+"Income >= "+salaryMin+" Order by Income DESC";
          sort=true;
          }
          else
          {
          if(sd==1) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Income <= "+salaryMax
                         +" AND "+"Income >= "+salaryMin+" Order by ID ASC";
          else if(sd==2) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Income <= "+salaryMax
                         +" AND "+"Income >= "+salaryMin+" Order by Name ASC";
          else if(sd==3) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Income <= "+salaryMax
                         +" AND "+"Income >= "+salaryMin+" Order by Sex ASC";
          else if(sd==4) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Income <= "+salaryMax
                         +" AND "+"Income >= "+salaryMin+" Order by Phone ASC";
          else condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Income <= "+salaryMax
                         +" AND "+"Income >= "+salaryMin+" Order by Income ASC";
          sort=false;
          }
          StringBuffer str=f(condition);
          sd=0;
          return str;
      }
    public StringBuffer getQueryResultByGroup()
    {
        String condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id='"+number2+"'"
                +" AND "+"Income <= "+salaryMax2+" AND "+"Income >= "+salaryMin2
                +" AND "+ ziduan2+" Like '%"+keyWord2+"%'";
        queryResultByGroup=f(condition);
        return queryResultByGroup;
    }
    public StringBuffer getQueryResultByGroupSort()
      {
          String condition="";
          if(sort==false)
          {
          if(sd==1) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id='"+number2+"'"
                +" AND "+"Income <= "+salaryMax2+" AND "+"Income >= "+salaryMin2
                +" AND "+ ziduan2+" Like '%"+keyWord2+"%' Order by ID DESC";
          else if(sd==2) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id='"+number2+"'"
                +" AND "+"Income <= "+salaryMax2+" AND "+"Income >= "+salaryMin2
                +" AND "+ ziduan2+" Like '%"+keyWord2+"%' Order by Name DESC";
          else if(sd==3) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id='"+number2+"'"
                +" AND "+"Income <= "+salaryMax2+" AND "+"Income >= "+salaryMin2
                +" AND "+ ziduan2+" Like '%"+keyWord2+"%' Order by Sex DESC";
          else if(sd==4) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id='"+number2+"'"
                +" AND "+"Income <= "+salaryMax2+" AND "+"Income >= "+salaryMin2
                +" AND "+ ziduan2+" Like '%"+keyWord2+"%' Order by Phone DESC";
          else condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id='"+number2+"'"
                +" AND "+"Income <= "+salaryMax2+" AND "+"Income >= "+salaryMin2
                +" AND "+ ziduan2+" Like '%"+keyWord2+"%' Order by Income DESC";
          sort=true;
          }
          else
          {
          if(sd==1) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id='"+number2+"'"
                +" AND "+"Income <= "+salaryMax2+" AND "+"Income >= "+salaryMin2
                +" AND "+ ziduan2+" Like '%"+keyWord2+"%' Order by ID ASC";
          else if(sd==2) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id='"+number2+"'"
                +" AND "+"Income <= "+salaryMax2+" AND "+"Income >= "+salaryMin2
                +" AND "+ ziduan2+" Like '%"+keyWord2+"%' Order by Name ASC";
          else if(sd==3) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id='"+number2+"'"
                +" AND "+"Income <= "+salaryMax2+" AND "+"Income >= "+salaryMin2
                +" AND "+ ziduan2+" Like '%"+keyWord2+"%' Order by Sex ASC";
          else if(sd==4) condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id='"+number2+"'"
                +" AND "+"Income <= "+salaryMax2+" AND "+"Income >= "+salaryMin2
                +" AND "+ ziduan2+" Like '%"+keyWord2+"%' Order by Phone ASC";
          else condition="SELECT Id,Name,Sex,Phone,Income FROM Customers Where Id='"+number2+"'"
                +" AND "+"Income <= "+salaryMax2+" AND "+"Income >= "+salaryMin2
                +" AND "+ ziduan2+" Like '%"+keyWord2+"%' Order by Income ASC";
          sort=false;
          }
          StringBuffer str=f(condition);
          sd=0;
          return str;
      }
    private StringBuffer f(String condition)
    {  StringBuffer str=new StringBuffer();
       Connection con;
       Statement sql; 
       ResultSet rs;
       try { String uri="jdbc:jtds:sqlserver://127.0.0.1:1122/happyolder.mdf";
             con=DriverManager.getConnection(uri,"sa","as798360687");
             sql=con.createStatement();
             rs=sql.executeQuery(condition);
             str.append("<table border=1>");
             str.append("<th width=100>"+"<form method=post action=\""+"\" name=formlink1> "
                     + "<a href=javascript:formlink1.submit();>ID</a> <Input type=hidden value=\"1\" name=\"sd\"></form>");
             str.append("<th width=100>"+"<form method=post action=\""+"\" name=formlink2> "
                     + "<a href=javascript:formlink2.submit();>Name</a><Input type=hidden value=\"2\" name=\"sd\"> </form>");
             str.append("<th width=100>"+"<form method=post action=\""+"\" name=formlink3> "
                     + "<a href=javascript:formlink3.submit();>Sex</a> <Input type=hidden value=\"3\" name=\"sd\"></form>");
             str.append("<th width=100>"+"<form method=post action=\""+"\" name=formlink4> "
                     + "<a href=javascript:formlink4.submit();>Phone</a><Input type=hidden value=\"4\" name=\"sd\"> </form>");
             str.append("<th width=100>"+"<form method=post action=\""+"\" name=formlink5> "
                     + "<a href=javascript:formlink5.submit();>Income</a> <Input type=hidden value=\"5\" name=\"sd\"></form>");
            while(rs.next())
             {  str.append("<tr>");
                   str.append("<td>"+rs.getInt(1)+"</td>");
                   str.append("<td>"+rs.getString(2)+"</td>");
                   str.append("<td>"+rs.getString(3)+"</td>");
                   str.append("<td>"+rs.getString(4)+"</td>");
                   str.append("<td>"+rs.getInt(5)+"</td>");
               str.append("</tr>");
             }
            str.append("</table>");
            con.close();
           }
       catch(SQLException e)
          { System.out.println(e);
          }
       return str;
   }   
    public StringBuffer getQueryResult()
    {
        if(id==1) 
        {
            queryResult=getQueryResultByNumber();
            if(sd!=0) queryResult=getQueryResultByNumberSort();
        }
        else if(id==2)
        {
            queryResult=getQueryResultBySalary();
            if(sd!=0) queryResult=getQueryResultBySalarySort();
        }
        else if(id==3) 
        {
            queryResult=getQueryResultByMohu();
            if(sd!=0) queryResult=getQueryResultByMohuSort();
        }
        else if(id==4) 
        {
            queryResult=getQueryResultByGroup();
            if(sd!=0) queryResult=getQueryResultByGroupSort();
        }
        else queryResult.append("请输入查询条件");
        return queryResult;
    }
}  
