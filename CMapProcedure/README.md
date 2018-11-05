# Background

In Scheme, recall that the map procedure takes a procedure and one or more list(s) as parameters and 
returns the list obtained by applying the procedure parameter to the list(s). This problem asks you to
write a basic version of map in C.
<p>In particular, write a C procedure map with the following signature:</p>
<pre>

node * map (int f (int), node * lst)
</pre>
where node is a list node defined as:

<pre>
   struct node
   { int data;
     struct node * next;
   };
   </pre>
and where f is a function that can be applied to an integer to obtain another integer.

## Notes
* The parameter lst points to the first node of a singly-linked list of integers.
* The list designated by lst is not changed by map.
* map returns a pointer to the first element of a new list.
* The resulting singly-linked list has the same length as the list lst and the elements on this new list should have values obtained by applying f to the integers stored in lst (and in the same order).
* Testing of this procedure is essential. It is suggested that you embed this procedure in a linked-list program.
