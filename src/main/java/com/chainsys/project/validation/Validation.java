package com.chainsys.project.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validation {
	


		//check name contain only character both lower and upper cases
		public Boolean name(String responce) {
			String regex = "[a-z .A-Z]+";
			Pattern p = Pattern.compile(regex);
			Matcher valid=p.matcher(responce);
			Boolean ans=valid.matches();
			//System.out.println(ans);
			return ans;

		}
		
		//check mail id contains minimum 3 character front of '@' and after minimum 5 character must contain '.'
		public Boolean email(String responce) {
			String regex ="^(.+)\\w{3,8}@\\w{5,10}(.+)$?";
	        Pattern p=Pattern.compile(regex);
			Matcher valid=p.matcher(responce);
			Boolean ans=valid.matches();
			//System.out.println(ans);
			return ans;
			
		}
		
		public Boolean phoneNo(String responce) {
			String regex="^\\d{10}$";
			Pattern p=Pattern.compile(regex);
			Matcher valid=p.matcher(responce);
			Boolean answer=valid.matches();
			
			return answer;
			
		}
		
		
		//check address whether length 100 or not
		public Boolean addressLength(String responce) {
			String address=responce;
			if(address.length()<100) {
				return true;
			}
			return false;
			
		}
		
		//check donor id whether length 4 or not
		public Boolean donorIdCheck(String responce) {
			String address=responce;
			if(address.length()<100) {
				return true;
			}
			return false;
			
		}
		
		//check phone number length not exceed 10 digit and also not null and continue sequence digits 
		public Boolean phoneNoLength(String responce) {
			String num=responce;
			if(num.length()>10||num.length()<10||num.equals("0000000000")||num.equals("1111111111")||num.equals("2222222222")
					||num.equals("3333333333")||num.equals("4444444444")||num.equals("5555555555")||num.equals("6666666666")
					||num.equals("7777777777")||num.equals("8888888888")||num.equals("9999999999")) {
				return true;
			}
			return false;
		}
		
		//check aadhar number length not exceed 12 digit as well as not null
		public Boolean aadharNo(String responce) {
			String num=responce;
			if(num.length()>12||num.length()<12||num.equals("000000000000")||num.equals("111111111111")||num.equals("222222222222")
					||num.equals("333333333333")||num.equals("444444444444")||num.equals("555555555555")||num.equals("666666666666{")
					||num.equals("777777777777")||num.equals("888888888888")||num.equals("999999999999")) {
				
				return true;
			}
			return false;
		}
		
		
		//check account number length not exceed 20 digit as well as not null
		public Boolean accountNo(String responce) {
			String num=responce;
			if(num.length()>20||num.length()<20||num.equals("000000000000")||num.equals("111111111111")||num.equals("222222222222")
					||num.equals("333333333333")||num.equals("444444444444")||num.equals("555555555555")||num.equals("666666666666{")
					||num.equals("777777777777")||num.equals("888888888888")||num.equals("999999999999")) {
				
				return true;
			}
			return false;
		}
		
		
		
		
		
		
	

}
