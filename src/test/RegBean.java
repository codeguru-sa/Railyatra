package test;
import java.io.*;
public class RegBean implements Serializable {
		private long phno;
		private String uname,pword,fname,lname,mailid;

		public void setPhNo(Long phno){
			this.phno=phno;
		}
		public Long getPhNo(){
			return phno;
		}
		public void setUName(String uname){
			this.uname=uname;
		}
		public String getUName(){
			return uname;
		}
		public void setPWord(String pword){
			this.pword=pword;
		}
		public String getPWord(){
			return pword;
		}
		
		public void setFName(String fname){
			this.fname=fname;
		}
		public String getFName(){
			return fname;
		}

		public void setLName(String lname){
			this.lname=lname;
		}
		public String getLName(){
			return lname;
		}

		public void setMail(String mailid){
			this.mailid=mailid;
		}
		public String getMail(){
			return mailid;
		}

}
