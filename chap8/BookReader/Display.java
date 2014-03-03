package BookReader;

public class Display{
	private Book activeBook;
	private User activeUser;
	private int pageNum = 0;

	public void displayUser(User u){
		activeUser = u;
		refreshUsername();
	}

	public void refreshUsername(){
	
	}

	public void displayBook(Book b){
		activeBook = b;
		pageNum = 0;

		refreshTitle();
		refreshDetails();
		refreshPage();
	}

	public void refreshTitle(){
	
	}

	public void refreshDetails(){
	
	}

	public void refreshPage(){
	
	}

	public void turnPageForward(){
		pageNum ++ ;
		refreshPage();
	}

	public void turnPageBackward(){
		pageNum -- ;
		refreshPage();
	}

	public int getPageNumber(){
		return pageNum;
	}
}

