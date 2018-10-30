    /***********************************************************************
     * Name(s)  Yesheng Chen                                               *
     * Box(s):   3278                                                      *
     * Assignment name (Sup. Problem Number 15)                            *
     *      (25% off if name/number does not match assignment)             *
     * Assignment for <due date>                                           *
     ***********************************************************************/

    /* *********************************************************************
     * Academic honesty certification:                                     *
     *   Written/online sources used:                                      *
     *    size of linked list in c++ function                              *
     *        https://stackoverflow.com/questions/3928935/size-of-linked   *
     *        -list-in-c-function                                          *
     *    Using a for loop to create a linked list [duplicate]             *
     *        https://stackoverflow.com/questions/21662332/using-a-for-    *
     *        loop-to-create-a-linked-list                                 *
     *    Dynamic Memory Allocation                                        *
     *        http://www.cs.grinnell.edu/~walker/courses/161.sp18/         *
     *        show-resource.php?resourceID=1010#string-malloc              *
     *    Function Pointers, Parameters, and Arrays                        *
     *        http://www.cs.grinnell.edu/~walker/courses/161.sp18/         *
     *        show-resource.php?resourceID=364                             *
     *    namelist.c file from Dynamic Memory, Pointers, and Linked Lists::*
     *    Linked-lists in C                                                *
     *        http://www.cs.grinnell.edu/~walker/courses/161.sp18/s        *
     *        how-single-session.php?sessionID=74                          *
     *   Help obtained                                                     *
     *     [indicate names of instructor, class mentors                    *
     *      or evening tutors, consulted according to class policy;        *
     *      write "none" if none of these sources used]                    *
     *     ["none" required for Supplemental Problems                      *
     *   My/our signature(s) below confirms that the above list of sources *
     *   is complete AND that I/we have not talked to anyone else          *
     *   (e.g., CSC 161 students) about the solution to this problem       *
     *                                                                     *
     *   Signature:                                                        *
     ***********************************************************************/
#include <stdio.h>
#include <stdlib.h>

struct node
   { int data;
     struct node * next;
   };

int countList (struct node * lst);
//find the length of the linked list

int functionAddOne (int);
//function that increase int by 1

int functionSquare (int a);
//return a sqaured

int functionTimes100 (int a);
//return a*100

void addNumber(struct node ** firstPtr);//modified from addNames
/* pre-condition:  firstPtr points to the pointer
                   designating the head of a list
  post-condition:  a number is read and
                   inserted into the list at a designated place
*/
void print(struct node * first);
/* pre-condition:  first designates the first node of a list
  post-condition:  The items on the list are printed from first to last
                   the list itself is unchanged
*/
struct node * map (int f (int), struct node * lst);
/* pre-condition:  first designates the first node of a list
                   f is a function that takes a integer as parameter
  post-condition:  A pointer to the head of the new linked-list will be retutned
                   The orginal list won't be changed
                   The length of the new list is the same as the old
                   The elements in the new list are the modified version of
                    elements in the original list based on the function
*/
int main (){
  /* program to coordinate the menu options and calls the requested function */

  struct node * first = NULL;   /* pointer to the first list item */
  char option[3];          /* user response to menu selection */
  printf ("Program to Maintain a List of Numbers\n");

  while (1) {
    /* print menu options */
    printf ("Options available\n");
    printf ("I - Insert a number into the list\n");
    printf ("P - Print the names on the list (iteratively)\n");
    printf ("M - Print the mapped list\n");
    printf ("Q - Quit\n");

    /* determine user selection */
    printf ("Enter desired option: ");
    scanf ("%s", option);

    switch (option[0])
      { case 'I':
        case 'i':
          addNumber(&first);
        case 'P':
        case 'p':
          print(first);
          break;
        case 'M':
        case 'm':
          //print(map (functionAddOne, first));
          //print(map (functionSquare, first));
          print(map (functionTimes100, first));
          break;
        case 'Q':
        case 'q':
          printf ("Program terminated\n");
          return 0;
          break;
      default: printf ("Invalid Option - Try Again!\n");
        continue;
    }
  }
}

struct node * map (int f(int), struct node * lst){
  /* pre-condition:  first designates the first node of a list
                     f is a function that takes a integer as parameter
    post-condition:  A pointer to the head of the new linked-list will be retutned
                     The orginal list won't be changed
                     The length of the new list is the same as the old
                     The elements in the new list are the modified version of
                      elements in the original list based on the function
  */
  //find the size of the original list
  int listSize = countList(lst);
  //allocate memory for the pointer of the head of the new list
  struct node * mapHead=malloc (sizeof (struct node));
  //if the original list is null
  if (listSize==0)
    // the mapped list is also null
    mapHead=NULL;
  else {
  //set a copy
  struct node * mapped = mapHead;
  //fill in the data filed of the first element in the list
  mapped->data =f(lst->data);
  //allocate sapce and fill in the data for the rest of the list base on the
  //element and the length of the original list
  for (int i=2; i<=listSize;i++){
    struct node * maptail=malloc (sizeof(struct node));
    //move to the next node  in the original list
    lst=lst->next;
    //fill in the data field for the newest node in the list
    maptail->data= f(lst->data);
    //connect the newest node at the end of the map list
    mapped->next=maptail;
    //set the newest node to be the new end node
    mapped=maptail;
  }
  //set the next field of the end of the list to be null
  mapped->next=NULL;}
  //return the pointer of the beginning of the map list
  return mapHead;
}

void addNumber(struct node ** firstPtr) {
/* pre-condition:  firstPtr points to the pointer designating the head of a list
  post-condition:  a number is read and
                   inserted into the list at a designated place
*/
  int Number;
  struct node * newNode = (struct node *)malloc(sizeof(struct node));
  struct node * listPtr;
  struct node * prevPtr;

   printf ("Enter number to be inserted into list: ");
   scanf ("%d", &Number);
   newNode->data = Number;
   if (*firstPtr == NULL) {
     /* insert number's node at start of list */
     newNode->next = *firstPtr;
     *firstPtr = newNode;
   }

   else {
     printf ("Enter  which new number should preceed \n");
     scanf ("%d", &Number);

     if (Number == (*firstPtr)->data) {
       /* insert number's node at start of list */
       newNode->next = *firstPtr;
       *firstPtr = newNode;
     }
     else {
       /* insert number's node after start of the list */

       /* start at beginning of list */
       listPtr = (*firstPtr)->next;  /* the current node to search */
       prevPtr = *firstPtr;          /* the node behind listPtr */

       while (listPtr && (Number != listPtr->data)) {
         prevPtr = listPtr;
         listPtr = prevPtr->next;
       }

       newNode->next = prevPtr->next;
       prevPtr->next = newNode;
     }
   }
   printf ("%d inserted into the list\n\n", newNode->data);
}


void print(struct node * first){
/* pre-condition:  first designates the first node of a list
  post-condition:  The items on the list are printed from first to last
                   the list itself is unchanged
  note:  processing proceeds iteratively
*/
  struct node * listElt = first;
  printf ("The numbers on the list are:\n\n");
//while listElt is not null print the elements and move down the list
  while (listElt) {
    printf ("%d\n", listElt->data);
    listElt = listElt->next;
  }

  printf ("\nEnd of List\n\n");
}

//find the length of the list
int countList (struct node * lst){
  //initial count to zero
  int count=0;
  //while the list is not null
  while (lst != NULL){
    //increase count by 1
    count ++;
    //move down the list
    lst=lst->next;
  }
  //return the total count
  return count;
}

//return a+1
int functionAddOne (int a ){
  int new = (a+1);
  //return the number after a been increased by 1
  return new;
}

//return a sqaured
int functionSquare (int a){
  int new = (a * a);
  return new;
}

//return a*100
int functionTimes100 (int a){
  int new = (a * 100);
  return new;
}
