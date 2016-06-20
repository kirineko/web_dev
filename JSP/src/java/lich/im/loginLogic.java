package lich.im;

public class loginLogic {
	String username,password;
    String logintime;
    boolean result=false;
    public void setUsername(String newUsername)
    {
    	username=newUsername;
    }
    public void setPassword(String newPassword)
    {
    	password=newPassword;
    }
    public void setLogintime(String newLogintime)
    {
    	logintime=newLogintime;
    }
    public String getUsername()
    {
    	return username;
    }
    public String getPassword()
    {
    	return password;
    }
    public String getLogintime()
    {
    	return logintime;
    }
    public boolean getResult()
    {
    	if(username==null)
 	   {
 	       username="";
 	   }
 	    if(password==null)
 	   {
 	       password="";
 	   }
    	if(username.length()>0&&password.length()>0)
    	 {
    	    result=true;
    	  } 
    	else
    	 {	
    		result=false;		
    	 }
    	return result;
    }
}
