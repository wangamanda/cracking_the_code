package BookReader;

public class OnlineReaderSystem{
	private Library library;
	private UserManager userManager;
	private Display display;
	private Book activeBook;
	private User activeUser;

	public OnlineReaderSystem(){
		library = new Library();
		userManager = new UserManager();
		display = new Display();
	}

	public Library getLibrary(){
		return library;
	}

	public UserManager getUserManager(){
		return userManager;
	}

	public Display getDisplay(){
		return display;
	}

	public Book getActiveBook(){
		return activeBook;
	}

	public User getActiveUser(){
		return activeUser;
	}

	public void setActiveBook(Book b){
		activeBook = b;
		display.displayBook(b);
	}

	public void setActiveUser(User u){
		activeUser = u;
		display.displayUser(u);
	}
}
