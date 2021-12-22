package com.library.main;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.library.dao.*;
import com.library.pojo.*;

public class LibraryApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean flagChoice = true;
		do {
			System.out.println("Enter your wish 1.register 2.login");
			String choice = sc.nextLine();
			UsersDao user = null;
			BooksDao book = new BooksDao();
			FineHistoryDao fineHistory = new FineHistoryDao();

			switch (choice) {

			/* Register */

			case "register":
			case "1":
				user = new UsersDao();
				System.out.println("Enter your user_name,city,date_register,password,mobile_no,email_id");

				/* User name */

				boolean flag = false;
				String user_name = null;
				do {
					System.out.println("Enter User_Name");
					user_name = sc.nextLine();
					if (user_name.matches("[A-Za-z]{2,}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid user name");

					/* City */
				} while (flag == false);
				String city = null;
				flag = false;
				do {
					System.out.println("Enter city");
					city = sc.nextLine();
					if (city.matches("[A-Za-z]{2,}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid city");

					/* Password */
				} while (flag == false);
				String password = null;
				flag = false;
				do {
					System.out.println("Enter password");
					password = sc.nextLine();
					if (password.matches("(?=.*[0-9])(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid password");

					/* Phone number */
				} while (flag == false);
				Long mobile_no = null;
				flag = false;
				String phno = null;
				do {
					System.out.println("Enter Phone Number");
					phno = sc.nextLine();
					if (phno.matches("[6-9][0-9]{9}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid Phone number");

				} while (flag == false);
				mobile_no = Long.parseLong(phno);

				/* Email Id */
				String email_id = null;
				flag = false;
				do {
					System.out.println("Enter email_id");
					email_id = sc.nextLine();
					if (email_id.matches("([a-zA-Z0-9]+[@][a-zA-Z]+[.][a-z]+{15,40})")) {
						flag = true;
					} else
						System.out.println("Please enter Valid email");

				} while (flag == false);
				System.out.println("For registration you have to pay 1000 rupees to recharge your wallet");
				System.out.println("Do you want to continue pay now yes/no");
				String choiceReg=sc.nextLine();
				if(choiceReg.equals("yes")) {
				Users p1 = new Users(user_name, city, password, mobile_no, email_id);
				boolean a = user.insert(p1);
				if (a) {
					System.out.println("Registration successful");
					System.out.println();
				} else {
					System.out.println("Not registered");
					break;
				}}
				else {
					System.exit(0);
				}

				/* Login */

			case "login":
			case "2":
				System.out.println("Enter your username and password");
				flag = false;
				user_name = null;
				do {
					System.out.println("Enter User_Name");
					user_name = sc.nextLine();
					if (user_name.matches("[A-Za-z]{2,}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid user name");

				} while (flag == false);
				password = null;
				flag = false;
				do {
					System.out.println("Enter password");
					password = sc.nextLine();
					if (password.matches("(?=.*[0-9])(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid password");
					flag = true;
				} while (flag == false);

				user = new UsersDao();
				Users u1 = new Users(user_name, password);
				String val = user.fetch(u1);
				System.out.println(val);
				int fineOf = 0;
				if (val.equals("user")) {
					Users u3 = new Users(fineOf,user_name);
					try {
						fineOf = user.getFine(u3);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (fineOf > 0) {
						System.out.println("Welcome " + user_name + " you have fine of rs " + fineOf);
						System.out.println("You have to repay now to borrow book");
						System.out.println("Are you ready to pay yes/no");
						String borrowChoice = sc.nextLine();
						u3=new Users(fineOf,user_name);
						if (borrowChoice.equals("yes")) {
							try {
								user.setFine(u3);
								FineHistory fh1 = new FineHistory(user_name, fineOf);
								fineHistory.insert(fh1);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							libUser(user_name);
						} else
							System.exit(0);

					} else {
						System.out.println("Welcome " + user_name);
						libUser(user_name);
					}
				} else if (val.equals("admin")) {

					System.out.println("welcome admin " + user_name);
					LibraryAdmin();
				} else if (val.equals("supplier")) {
					System.out.println("Welcome supplier " + user_name);
					libSupplier(user_name);
				}
				break;

			default:
				System.out.println("Please select valid choice");

			}
		} while (flagChoice);

	}

	private static void libSupplier(String user_name) throws SQLException {
		// TODO Auto-generated method stub
		OrderBookDao obDao = new OrderBookDao();
		ResultSet rs = null;
		try {
			rs = obDao.view(user_name);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (rs.next()) {
			System.out.print(rs.getString(2));
			System.out.println("\t\t" + rs.getString(3));
		}
	}

	private static void LibraryAdmin() {
		// TODO Auto-generated method stub
		BooksDao book = new BooksDao();
		SuppliersDao supply = new SuppliersDao();
		BookIssueDao bookIssue = new BookIssueDao();
		FinesDao fine = new FinesDao();
		boolean adminFlag = true;
		do {
			System.out.println(
					"1.Show Books 2.Add Books 3.Add supplier Details 4.Add Book Issue Details 5.Add Fine Details 6.Add User 7.View Fine History 8.Home 9.Exit");
			Scanner sc = new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
//			ResultSet rs=book.showBooks();
				List Products = book.showBooks();
				for (int i = 0; i < Products.size(); i++) {
					System.out.println(Products.get(i));

				}
				LibraryAdmin();
				break;
//			try {
//				while(rs.next()) {
//					System.out.println("Book Name");
//					System.out.println(rs.getString(1));
//					System.out.println("Author");
//					System.out.println(rs.getString(2));
//					System.out.println("Category");
//					System.out.println(rs.getString(3));
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
			case 2:
				System.out.println("Enter Book_code");
				Boolean flag = false;
				String book_code = null;
				do {
					book_code = sc.nextLine();
					if (book_code.matches("[A-Za-z0-9]{2,}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid book code");

				} while (flag == false);

				flag = false;
				System.out.println("Enter Book Title");
				String book_title = null;
				do {
					book_title = sc.nextLine();
					if (book_title.matches("[A-Za-z\\s]{2,}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid book_title");

				} while (flag == false);

				flag = false;
				System.out.println("Enter Category");
				String category = null;
				do {
					category = sc.nextLine();
					if (category.matches("[A-Za-z]{2,}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid category");

				} while (flag == false);

				flag = false;
				System.out.println("Enter Author");
				String author = null;
				do {
					author = sc.nextLine();
					if (author.matches("[A-Za-z]{2,}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid author");

				} while (flag == false);

				flag = false;
				System.out.println("Enter Price");
				String price1 = null;
				do {
					price1 = sc.nextLine();
					if (price1.matches("[0-9]{1,}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid price");

				} while (flag == false);

				int price = Integer.parseInt(price1);
				flag = false;
				System.out.println("Enter Rack Number");
				String rack_number = null;
				do {
					rack_number = sc.nextLine();
					if (rack_number.matches("[0-9]{1,}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid rack_number");

				} while (flag == false);

				flag = false;

				Books p1 = new Books(book_code, book_title, category, author, price, rack_number);
				try {
					book.insert(p1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LibraryAdmin();
				break;
			case 3:
				System.out.println("Enter Supplier Id");
				String supplier_id = sc.nextLine();
				System.out.println("Enter Supplier Name");
				String supplier_name = sc.nextLine();
				System.out.println("Enter Address");
				String address = sc.nextLine();
				System.out.println("Enter Contact");
				long contact = Long.parseLong(sc.nextLine());
				Suppliers s1 = new Suppliers(supplier_name, address, contact);
				try {
					supply.insert(s1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LibraryAdmin();
				break;

			case 4:
				System.out.println("Enter Book Issue Details");
				String pDetail = sc.nextLine();
				System.out.println("Enter Book Issue no");
				int book_issue_no = Integer.parseInt(sc.nextLine());
				System.out.println("Enter User ID");
				String user_name = sc.nextLine();
				System.out.println("Enter Book Code");
				book_code = sc.nextLine();
				System.out.println("Enter Date Issue");
				String date_issue1 = sc.nextLine();
				LocalDate date_issue = LocalDate.parse(date_issue1);
				System.out.println("Enter Date Return");
				String date_return1 = sc.nextLine();
				LocalDate date_return = LocalDate.parse(date_return1);
				System.out.println("Enter Date Returned");
				String date_returned1 = sc.nextLine();
				LocalDate date_returned = LocalDate.parse(date_returned1);
				System.out.println("Enter Fine Range");
				int fine_range = Integer.parseInt(sc.nextLine());
				BookIssue issue = new BookIssue(book_issue_no, user_name, book_code, date_issue, date_return,
						date_returned, fine_range);
				try {
					bookIssue.insert(issue);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LibraryAdmin();
				break;
			case 5:
				System.out.println("Enter Fine_range");
				fine_range = Integer.parseInt(sc.nextLine());
				System.out.println("Enter Fine_amount");
				int fine_amount = Integer.parseInt(sc.nextLine());
				System.out.println(fine_range);
				Fines fines = new Fines(fine_range, fine_amount);
				try {
					fine.insert(fines);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LibraryAdmin();
				break;

			case 6:
				UsersDao user = new UsersDao();
				flag = false;
				user_name = null;
				do {
					System.out.println("Enter User_Name");
					user_name = sc.nextLine();
					if (user_name.matches("[A-Za-z]{2,}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid user name");

					/* City */
				} while (flag == false);
				String city = null;
				flag = false;
				do {
					System.out.println("Enter city");
					city = sc.nextLine();
					if (city.matches("[A-Za-z]{2,}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid city");

					/* Password */
				} while (flag == false);
				String password = null;
				flag = false;
				do {
					System.out.println("Enter password");
					password = sc.nextLine();
					if (password.matches("(?=.*[0-9])(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid password");

					/* Phone number */
				} while (flag == false);
				Long mobile_no = null;
				flag = false;
				String phno = null;
				do {
					System.out.println("Enter Phone Number");
					phno = sc.nextLine();
					if (phno.matches("[6-9][0-9]{9}")) {
						flag = true;
					} else
						System.out.println("Please enter Valid Phone number");

				} while (flag == false);
				mobile_no = Long.parseLong(phno);

				/* Email Id */
				String email_id = null;
				flag = false;
				do {
					System.out.println("Enter email_id");
					email_id = sc.nextLine();
					if (email_id.matches("([a-zA-Z0-9]+[@][a-zA-Z]+[.][a-z]+{15,40})")) {
						flag = true;
					} else
						System.out.println("Please enter Valid email");

				} while (flag == false);
				/* user_role */
				String user_role = null;
				flag = false;
				do {
					System.out.println("Enter User role");
					user_role = sc.nextLine();
					if (user_role.matches("([a-z]*)")) {
						flag = true;
					} else
						System.out.println("Please enter Valid user_role");

				} while (flag == false);

				Users p2 = new Users(user_name, city, user_role, password, mobile_no, email_id);
				Suppliers p3 = new Suppliers(user_name, city, mobile_no);
				boolean a = false;
				try {
					a = user.adminInsert(p2);
					if (user_role.equals("supplier")) {
						supply.insert(p3);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (a) {
					System.out.println("Registration successful");
				} else {
					System.out.println("Not registered");
					break;
				}
				LibraryAdmin();

			case 7:
				System.out.println("Fine History");
				FineHistoryDao fineHist = new FineHistoryDao();
				List<FineHistory> FineList = new ArrayList<>();
				FineList = fineHist.view();
				for (int i = 0; i < FineList.size(); i++) {
					System.out.println(FineList.get(i));
				}

			case 8:
				try {
					LibraryApp.main(null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 9:
				System.exit(0);

			default:
				System.out.println("Enter valid choice");

			}

		} while (adminFlag);

	}

	public static void libUser(String user_name) throws ClassNotFoundException, SQLException {
		boolean userFlag = true;
		do {
			System.out
					.println("1.Search Book 2.View Book 3.Borrow Book 4.Return Book 5.Request New book 6.Home 7.exit");
			Scanner sc = new Scanner(System.in);
			UsersDao user = new UsersDao();
			BooksDao book = new BooksDao();
			SuppliersDao supply = new SuppliersDao();
			BookIssueDao bookIssue = new BookIssueDao();
			FinesDao fine = new FinesDao();
			OrderBookDao obDao = new OrderBookDao();

			int choice = Integer.parseInt(sc.nextLine());
			System.out.println(choice);
			switch (choice) {
			case 1:
				System.out.println("Search book by 1.Author 2.Category");
				int choice1 = Integer.parseInt(sc.nextLine());
				switch (choice1) {
				case 1:
					System.out.println("Enter Author Name");
					String author = sc.nextLine();
					ResultSet rs = book.authorFetch(author);
					while (rs.next()) {
						System.out.println(rs.getString(1));

					}
					libUser(user_name);
					break;
				case 2:
					System.out.println("Enter Category");
					String category = sc.nextLine();
					rs = book.categoryFetch(category);
					while (rs.next()) {
						System.out.println(rs.getString(1));

					}
					libUser(user_name);
					break;
				}
				break;

			case 2:
				System.out.println("View books");
				List Products = book.showBooks();
				for (int i = 0; i < Products.size(); i++) {
					System.out.println(Products.get(i));

				}
				libUser(user_name);
				break;

			case 3:
				System.out.println("Enter the book Name you want to Borrow");
				String book_title = sc.nextLine();
				Books b1 = new Books(book_title, user_name);
				String availability = book.bookBorrow(b1);
				if (availability.equals("available")) {
					System.out.println("Do you want to borrow the book yes/no");
					String opinion = sc.nextLine();
					if (opinion.equals("yes")) {

						System.out.println("Here After admin will takeover");
						System.out.println("Hi admin Enter your user_name");
						String uname = sc.nextLine();
						System.out.println("Enter PassWord");
						String password = sc.nextLine();
						Users u1 = new Users(uname, password);
						String adminCheck = user.fetch(u1);
						if (adminCheck.equals("admin")) {
							b1 = new Books(book_title, user_name);
							book.bookAvail(b1);
							b1 = new Books(book_title);
							int rackNumber = book.getRack(b1);
							System.out.println("The book is in Rack number " + rackNumber);
							System.out.println("Enter book issue no");
							int book_issue_no = Integer.parseInt(sc.nextLine());
							System.out.println("Enter Date Issue");
							String date_issue1 = sc.nextLine();
							LocalDate date_issue = LocalDate.parse(date_issue1);
							System.out.println("Enter Date Return");
							String date_return1 = sc.nextLine();
							LocalDate date_return = LocalDate.parse(date_return1);
							LocalDate date_returned = LocalDate.now();
							int fine_range_in_month = 0;
							BookIssue p1 = new BookIssue(book_issue_no, user_name, book_title, date_issue, date_return,
									date_returned, fine_range_in_month);
							Books b2 = new Books(book_title, book_issue_no);
							book.updateBookIssue(b2);
							bookIssue.insert(p1);

						}

					}

				} else {
					System.out.println("The book is unavailable");
					System.out.println("Do you want to Pre Request the book yes/no");
					String prechoice = sc.nextLine();
					if (prechoice.equals("yes")) {
						b1 = new Books(book_title, user_name);
						book.preRequest(b1);
					}
				}
				libUser(user_name);
				break;
			case 4:
				System.out.println("Enter the name of book you return");
				book_title = sc.nextLine();
				b1 = new Books(book_title, user_name);
				boolean returnCheck = book.checkReturn(b1);
				if (returnCheck) {
					b1 = new Books(book_title);
					book.returnBook(b1);
					System.out.println("Hi admin Enter your user_name");
					String uname = sc.nextLine();
					System.out.println("Enter PassWord");
					String password = sc.nextLine();
					Users u1 = new Users(uname, password);
					String adminCheck = user.fetch(u1);
					if (adminCheck.equals("admin")) {
						System.out.println("Enter Date Returned");
						String date_returned = sc.nextLine();
						int userFine = bookIssue.returnBookIssue(date_returned, book_title);
						System.out.println(userFine);
						Fines f1 = new Fines(userFine);
						int fineAmount = fine.fineCalculation(f1);
						System.out.println("FineAmount= " + fineAmount);
						Users u2 = new Users(fineAmount, user_name);
						user.update(u2);
						Users u3 = new Users(user_name);
						int fineOf = 0;
						FineHistoryDao fineHistory = new FineHistoryDao();
						try {
							fineOf = user.getFine(u3);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (fineOf > 0) {
							System.out.println(user_name + " you have fine of rs " + fineOf);
							System.out.println("You have to repay now to borrow book");
							System.out.println("Are you ready to pay yes/no");
							String borrowChoice = sc.nextLine();
							u3=new Users(fineOf,user_name);
							if (borrowChoice.equals("yes")) {
								try {
									user.setFine(u3);
									FineHistory fh1 = new FineHistory(user_name, fineOf);
									fineHistory.insert(fh1);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}
						}
					}
				} else {
					System.out.println("The Book Name you entered is invalid");
				}
				libUser(user_name);
				break;

			case 5:
				System.out.println("Enter the name of book you want to order");
				String book_name = sc.nextLine();
				System.out.println("Enter the author name");
				String author = sc.nextLine();
				String supplier_id = null;
				OrderBook p1 = new OrderBook(user_name, book_name, author, supplier_id);
				obDao.insert(p1);
				System.out.println("Here After admin will takeover");
				System.out.println("Hi admin Enter your user_name");
				String uname = sc.nextLine();
				System.out.println("Enter PassWord");
				String password = sc.nextLine();
				Users u1 = new Users(uname, password);
				String adminCheck = user.fetch(u1);
				if (adminCheck.equals("admin")) {
					System.out.println("Enter Supplier name");
					String supplier_name = sc.nextLine();
					obDao.update(supplier_name, book_name);

				}

			case 6:
				LibraryApp.main(null);

			case 7:
				System.exit(0);

			default:
				System.out.println("Please Enter Valid choice");

			}
		} while (userFlag);

	}
}
