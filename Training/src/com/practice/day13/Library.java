package com.practice.day13;

public class Library {
	
	private String searchBook, rentBook,name;

	private int returnDate, penalty, lendDate;
	
	Library(){
		searchBook=null;
		rentBook=null;
		returnDate=0;
		lendDate=1;
		penalty=0;
	}
	
	//Getter Setter for private dataMembers
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getLendDate() {
		return lendDate;
	}
	public void setLendDate(int lendDate) {
		this.lendDate = lendDate;
	}
	public String getSearchBook() {
		return searchBook;
	}
	public void setSearchBook(String searchBook) {
		this.searchBook = searchBook;
	}
	public String getRentBook() {
		return rentBook;
	}
	public void setRentBook(String rentBook) {
		this.rentBook = rentBook;
	}
	public int getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(int returnDate) {
		this.returnDate = returnDate;
	}
	public int getPenalty() {
		return penalty;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	
	public   int date(int returnDate) throws Exception {
		if(returnDate>0) {
			
			if(returnDate>7) {
				int dueDate=returnDate-7;
				//int duePenalty=dueDate*10;
				
				return dueDate;
			}
			else 
				return returnDate;
		}
		else
			throw new Exception("Enter valid date!");
		
		
	}
	
	public  int fain(int penalty) throws Exception {
		
		date(penalty);
		penalty=date(penalty)*10;
		return penalty;
		
		
	}
	
	public boolean validation() {
		String name=getName();
		boolean valid=name.matches("[a-z A-Z]+");
		return valid;
	}
	
	
	
	
	
}
