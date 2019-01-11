package supProb2;

public class StudentNode {
	private String username;  //always stored in lowercase
	private double credits;   //credits toward graduation
	private StudentNode left;             //pointer to left subtree within a tree structure
	private StudentNode right;            //pointer to right subtree within a tree structure
	private StudentNode next;             //pointer to next node in singly-linked list

	public StudentNode (String initialName, double initialCredit) {
		username = initialName;
		credits = initialCredit;
		left = null;
		right = null;
		next = null;
	}

	public StudentNode (String startingName, double startingCredit,StudentNode leftNode, 
			StudentNode rightNode, StudentNode nextNode) {
		username = startingName;
		credits = startingCredit;
		left = leftNode;
		right = rightNode;
		next = nextNode;
	}

	// extractors
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the credits
	 */
	public double getCredits() {
		return credits;
	}

	/**
	 * @return the left
	 */
	public StudentNode getLeft() {
		return left;
	}

	/**
	 * @return the right
	 */
	public StudentNode getRight() {
		return right;
	}

	/**
	 * @return the next
	 */
	public StudentNode getNext() {
		return next;
	}

	// modifiers
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param credits the credits to set
	 */
	public void setCredits(double credits) {
		this.credits = credits;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(StudentNode left) {
		this.left = left;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(StudentNode right) {
		this.right = right;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(StudentNode next) {
		this.next = next;
	}
}
