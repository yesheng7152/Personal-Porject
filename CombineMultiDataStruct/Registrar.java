package supProb2;
import java.util.NoSuchElementException;
/**
 * @author yeshengchen
 *
 */
public class Registrar {
	//fields 
	private StudentNode root;
	protected StudentNode first;

	//Constructor
	public Registrar () {
		root = null;
		first = null;
	}
	/**
	 * a single new node is created,
	 *   containing a student's username and credits toward graduation
	 * @pre
	 *    username is not NULL
	 * @post
	 *    the new node is inserted to the binary search tree
	 *    containing all student records, ordered by username
	 * @post
	 *    the node is also inserted into a singly-linked list,
	 *    ordered by credits toward graduate
	 */
	public void insert (String username, double credits) {
		//declaring a node 
		StudentNode newnode= new StudentNode (username, credits);
		insertBi(newnode);
		insertLink(newnode);
	}
	/**
	 * A helper procedure for insert. Insert the node into the Binary Search Tree
	 * @param newnode		a node that contains username and credits 
	 * 
	 */
	public void insertBi (StudentNode newnode) {
		if (root == null)
			root = newnode;
		else {
			StudentNode ptr = root;  // pointer to node in search for leaf
			while (ptr != null) {// search for leaf
				if (newnode.getUsername().compareTo(ptr.getUsername()) < 0) {
					// insert on left of given node
					if (ptr.getLeft() == null) {
						// when at end of tree, insert
						ptr.setLeft(newnode);
						return; 
					} else 
						// move left in tree and continue search
						ptr = ptr.getLeft();
				} else {
					// insert on right of given node
					if (ptr.getRight() == null) {
						// when at end of tree, insert
						ptr.setRight(newnode);
						return;
					} else
						// move right in tree and continue search
						ptr = ptr.getRight();
				}
			}
		}
	}
	/**
	 * A helper procedure for insert. Link the node with the rest of other nodes
	 * @param newnode 		a node that contains username and credits 
	 * 
	 */
	public void insertLink (StudentNode newnode) {
		//insert the node at the beginning if the list is null or the credits is lower than the first
		if (first == null|| first.getCredits() >= newnode.getCredits()) {
			newnode.setNext(first); 
			first = newnode; 
		}
		// insert the node at other positions 
		else {	
			StudentNode current = first; 
			//keep moving the pointer down the list until the end or when newnode's credit it smaller 
			//than it's current one
			while (current.getNext() != null && 
					(current.getNext()).getCredits() < newnode.getCredits()) 
				current = current.getNext(); 
			//insert the node
			newnode.setNext(current.getNext()); 
			current.setNext(newnode); 
		}
	} 
	
	
	/** search tree for username to obtain credits for graduation
	 * @pre
	 *    none
	 * @returns
	 *    if the username appears in a node,
	 *    the credits toward graduate are returned
	 * @throws
	 *    if the username does not appears in a node,
	 *    throws NoSuchElementException
	 */
	public double findCredits (String username) {
		return lookupKernel (root, username);
	}
	/**
	 * Helper for findCredits
	 * @param base				The root of the binary search tree we are looking at
	 * @param username			The username that we want to find
	 * @return					The credit of the username 
	 * 							NoSuchElementException() if such username doesn't exist 
	 */
	public double lookupKernel (StudentNode base, String username) {
		//search until the end
		if (base != null) {
			//if find the name then return it's credit
			if (base.getUsername().compareTo(username) == 0)
				return base.getCredits();
			//if the username is smaller, then search the left
			else if (base.getUsername().compareTo(username) < 0)
				return lookupKernel (base.getRight(), username);
			//otherwise search the right 
			else return lookupKernel (base.getLeft(), username);
		}
		//if doesn't exist throw error
		else {
			throw new NoSuchElementException();
		}
	}

	
	
	/**
	 * update credits toward graduation for
	 * @pre
	 *    username is not NULL
	 * @pre
	 *    newCredits gives the new number of credits for the username
	 * @post
	 *    credits toward graduation is updated with the new parameter
	 * @post
	 *    node is not moved on the binary search tree
	 * @post
	 *    node's position on the linked list is adjusted as needed,
	 *    to maintain the ordering of list nodes in ascending order
	 *    by credits toward graduation
	 * @returns
	 *    true if username found (with node updated and moved as needed)
	 *    false if username not found
	 */
	public boolean updateCredits (String username, double newCredits) {
		return updateKernel (root, username, newCredits);	
	}
	/**
	 * Helper forupdateCredits
	 * @param base			the root of the BST we are looking at 
	 * @param username		the username we are finding 
	 * @param newCredits	the new credit that will be updated to 
	 * @return				true if the name is found and updated, other wise false 
	 */
	public boolean updateKernel (StudentNode base, String username, double newCredits) {
		//find the position of element in the linked list
		StudentNode previous=first;
		StudentNode ptr=previous;
		while (ptr!= null && ptr.getUsername()!=username) {
			previous=ptr;
			ptr=ptr.getNext();
		}
		//search until the end
		if (base != null) {
			//if the username is found then update the credit and return true 
			if (base.getUsername().compareTo(username) == 0) {
				base.setCredits(newCredits);
				//remove the updated node from the linked list
				if (base.getUsername()==first.getUsername()) {
					first=ptr.getNext();
					//previous=ptr.getNext();
					ptr.setNext(null);
				}else {
					previous.setNext(ptr.getNext());
					ptr.setNext(null);}
				//insert the node back in
				insertLink(ptr);
				return true;
			}
			//if the username is smaller, then search the left
			else if (base.getUsername().compareTo(username) < 0)
				return updateKernel (base.getRight(), username, newCredits);
			//otherwise search the right 
			else 
				return updateKernel (base.getLeft(), username, newCredits);
		}
		//if username doesn't exist then return false
		return false;
	}


	/**
	 * print username and corresponding credits toward graduation,
	 * ordered by username
	 * @post
	 *     each username/credits value printed on a separate line,
	 *     ordered by username
	 */
	public void printByUsername () {
		System.out.println ("Student list with their username and credits ordered by username");
		printKernel (root);
		System.out.println ();
	}
	/**
	 * Helper for printByUsername 
	 * @param base		the root of the BST that needs to be printed 
	 */
	private void printKernel (StudentNode base) {
		// to print elements in a tree (using an in-order traversal),
		//     print the left subtree
		//     print the elements in a node
		//     print the right subtree
		if (base != null) {
			printKernel (base.getLeft());
			System.out.println(base.getUsername() + " " + base.getCredits());
			printKernel (base.getRight());
		}
	}


	/**
	 * print username and corresponding credits toward graduation,
	 * ordered by credits toward graduation
	 * @post
	 *     each username/credits value printed on a separate line,
	 *     ordered by credits toward graduation
	 */
	public void printByCredits () {
		System.out.println ("Student list with their username and credits ordered by credits");
		printKernelC (first);
	}
	/**
	 * Helper of printByCredits
	 * @param ptr		the node that points to the first element of the linked list
	 */
	private void printKernelC(StudentNode ptr) {
		//print the elements until the end of the linked-list 
		while (ptr !=null) {
			System.out.println(ptr.getUsername() + " " + ptr.getCredits());
			ptr=ptr.getNext();
		}
	}

	public static void main (String argv[]) {
		//Setting up for testing adding elements
		Registrar Grinnell = new Registrar ();
		Grinnell.insert("chenyesh", 65);
		System.out.println("chenyesh is added");
		Grinnell.insert("xichenji", 45);
		System.out.println("xichenji is added");
		Grinnell.insert("aaaa", 33);
		System.out.println("aaa is added");
		Grinnell.insert("wuzhaoqi", 30);
		System.out.println("wuzhaoqi is added");
		Grinnell.insert("jindavid", 100);
		System.out.println("jindavid is added");

//Testing printings
		Grinnell.printByUsername();
		Grinnell.printByCredits();
//Testing find credits 
		System.out.println("credits for chenyesh is "+Grinnell.findCredits("chenyesh"));
		System.out.println("credits for xichenji is "+Grinnell.findCredits("xichenji"));
	//Testing find credits with non exist username should return error
		//	System.out.println("credits for dongyila is "+Grinnell.findCredits("dongyila"));
//Testing updateCredits
		System.out.println("credits changed for jindavid");
		Grinnell.updateCredits("jindavid", 1);
		Grinnell.updateCredits("wuzhaoqi", 2000);
		System.out.print(Grinnell.updateCredits("bbbb", 6666));
		Grinnell.printByCredits();
		Grinnell.printByUsername();
	}
}
