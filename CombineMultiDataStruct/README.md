<h1>Background</h1>
Many discussions of data organization focus on individual data structures, such as data organized into linked lists or trees.
<ul>
  <li>This problem suggests one way in which multiple data structures might be combined in solving a multi-faceted problem.</li>
  <li>An alternative solution to problem might utilize a database, such as MySQL, for data storage and retrieval. 
      Although databases are widely used in contemporary applications, database technology is beyond the scope of CSC 207, 
      and the solution of this supplemental problem is designed to provide practice with both singly-linked lists and
      binary search trees.</li>
</ul>

<h1>Note</h1>
An abbreviated system containing student data will store both usernames and credits toward graduation.
<ul>
  <li>To allow efficient inserting, searching, and printing of student information, the 
  student data will be stored in a binary search tree, ordered by username.</li>
  <li>To allow printing of students in increasing order of credits toward graduation, the student
  data will also be stored in a singly-linked list, ordered by credits.</li>
  <li>For each student, the username and credits toward graduation will be stored exactly once. 
  (Storage of data in multiple places invites inconsistencies to arise, after data are updated in one location, 
  but not others.)</li>
  <li>Since each node will be contained in both a binary search tree and a linked list, two sets of points are needed.</li>
</ul>
Methods for this problem include:
<pre>
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
 public void insert (String username, double credits);
</pre>
<pre>
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
 public double findCredits (String username);
</pre>
<pre>
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
public boolean updateCredits (String username, double newCredits);
</pre>
<pre>
/**
 * print username and corresponding credits toward graduation,
 * ordered by username
 * @post
 *     each username/credits value printed on a separate line,
 *     ordered by username
 */
public void printByUsername ();
</pre>
<pre>
/**
 * print username and corresponding credits toward graduation,
 * ordered by credits toward graduation
 * @post
 *     each username/credits value printed on a separate line,
 *     ordered by credits toward graduation
 */
public void printByCredits ();
</pre>
