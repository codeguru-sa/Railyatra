package test;
import java.io.*;
public class BookBean implements Serializable {
		private String name,birth,gender,cname,cgender;
		private Long page,cage,accno;
		
		public void setpAge(Long page){
			this.page=page;
		}
		public Long getpAge(){
			return page;
		}
		public void setcAge(Long cage){
			this.cage=cage;
		}
		public Long getcAge(){
			return cage;
		}
		public void setAccno(Long accno){
			this.accno=accno;
		}
		public Long getAccno(){
			return accno;
		}
		
		public void setName(String name){
			this.name=name;
		}
		public String getName(){
			return name;
		}

		public void setBirth(String birth){
			this.birth=birth;
		}
		public String getBirth(){
			return birth;
		}
		public void setGender(String gender){
			this.gender=gender;
		}
		public String getGender(){
			return gender;
		}
		public void setcGender(String cgender){
			this.cgender=cgender;
		}
		public String getcGender(){
			return cgender;
		}
		public void setcName(String cname){
			this.cname=cname;
		}
		public String getcName(){
			return cname;
		}
 }

