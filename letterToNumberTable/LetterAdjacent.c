 /* *********************************************************************
  * Academic honesty certification:                                     *
  *   Written/online sources used:                                      *
  *     Reading on Arrays                                               *
  *       http://www.cs.grinnell.edu/~walker/courses/161.sp18/          *
  *       show-resource.php?resourceID=360                              *
  *     Characters in C                                                 *
  *       http://www.cs.grinnell.edu/~walker/courses/161.sp18/          *
  *       show-resource.php?resourceID=521                              *
  *     Reading on Two-dimensional Arrays                               *
  *       http://www.cs.grinnell.edu/~walker/courses/161.sp18/          *
  *       show-resource.php?resourceID=634                              *
  *     Two dimensional (2D) arrays in C programming with example       *
  *       https://beginnersbook.com/2014/01/2d-arrays-in-c-example/     *
  *     Reading string from input with space character?                 *
  *       https://stackoverflow.com/questions/6282198/                  *
  *       reading-string-from-input-with-space-character                *
  *    Search Algorithms: What is the most efficient way to find the    *
  *    second largest element in a two-dimensional integer array?       *
  *       https://www.quora.com/Search-Algorithms-What-is-the           *
  *       -most-efficient-way-to-find-the-second-largest-element-       *
  *       in-a-two-dimensional-integer-array                            *
  *   Help obtained                                                     *
  *    Professor Henry Walker
  *   My/our signature(s) below confirms that the above list of sources *
  *   is complete AND that I/we have not talked to anyone else          *
  *   (e.g., CSC 161 students) about the solution to this problem       *
  *                                                                     *
  *   Signature:                                                        *
  ***********************************************************************/
#include <stdio.h>
#include <ctype.h>

/*This program reads size of a grid (m by n), and an m by n grid of
  characters, and then outputs the grid of characters, computes and
  prints the grid of counts, and prints two locations with the highest
  counts
  Preconditions: m and n must be positive real integers
                 m by n >= 2 (at least 2 elements in the grid)
 Postconditions: m by n grid of character, base on the inputs
                 m by n grid of integers (0<=integer<=8)
                 two location of the highest counts
                    -The value of the count could be the same
                     but the location will be different
                    -the location will be smaller than m and n, but >=0
*/
int main ()
{
  //declare variables and ask for inputs
  int m;
  printf ("Please enter the number of rows: \n");
  scanf("%d", &m);
  //get rid of any newline characters
  while (getchar() != '\n');
  int n;
  printf ("Please enter the number of column: \n");
  scanf("%d", &n);
  int row, col, a, b;
  //get rid of any newline characters
  while (getchar() != '\n');
  char CharTable [m][n];
  //input for the CharTable
  printf ("Please enter the table of characters: \n");
  for (row=0; row<m; row ++)
    {
      for (col=0; col<n; col ++)
      {
        scanf("%c", &CharTable[row][col]);
      }
    //get rid of any newline characters
    while (getchar() != '\n');
    }

  //print the table of Characters
  printf("Printing the table of Characters:\n");
  for (a=0; a<m; a++)
  {
    for (b=0; b<n; b++)
    {
      printf("%c", CharTable[a][b]);
    }
    printf("\n");
  }

    /*Converting the CharTable to IntTable by counting the
      number of surrounding characters around the index.
      -If the indicated positions contain a character that is
       not space character(' '), then the count will increase*/
  char IntTable [m][n];
  int count=0;
  for (row=0; row<m; row ++)
  {
    for (col=0; col<n; col++)
    {
      /*For all rows, except the first row, look at the position
        on the top*/
      if ((row!=0)&&(col>=0)){
        if (CharTable[row-1][col] != ' ')
            count++;
      }
      /*For all rows, except the last row, look at the position
        on the bottom*/
      if ((row!=m-1)&&(col>=0)){
        if (CharTable[row+1][col] != ' ')
            count++;
      }
      /*For all columns, except the first column, look at the
        position on the left*/
      if ((row>=0)&&(col!=0)){
        if (CharTable[row][col-1] != ' ')
          count++;
      }
      /*For all columns, except the last column, look at the
        position on the right*/
      if ((row>=0)&&(col!=n-1)){
        if (CharTable[row][col+1] != ' ')
          count++;
      }
      /*For all elements, except the ones in the first row or
        the first colmun, look at the position on the up left*/
      if ((row!=0)&&(col!=0)){
        if (CharTable[row-1][col-1] != ' ')
          count++;
      }
      /*For all elements, except the ones in the first or the
        last colmun, look at the position on the up right*/
      if ((row!=0)&&(col!=n-1)){
        if (CharTable[row-1][col+1] != ' ')
          count++;
      }
      /*For all elements, except the ones in the last row or the
        last column, look at the position on the down right*/
      if ((row!=m-1)&&(col!=n-1)){
        if (CharTable[row+1][col+1] != ' ')
          count++;
      }
      /*For all elements, except the ones in the last row or the
        first column, look at the position on the down left*/
      if ((row!=m-1)&&(col!=0)){
        if (CharTable[row+1][col-1] != ' ')
          count++;
      }
      //record the count into correct index
      IntTable[row][col]=count;
      //reset count back to 0
      count=0;
    }
  }

  //Printing the table of integers(counts)
    printf("Printing the table of integers:\n");
  for (row=0; row<m; row++)
  {
    for (col=0; col<n; col++)
    {
      printf("%d", IntTable[row][col]);
    }
    printf("\n");
  }

  //Find and print the location of the largest integer in IntTable
  /*Declare variables for the index of highest and second highest
    starting at two different locations can solve the problem with
    2 element 2D arrays. */
  int MaxRow=0;
  int MaxCol=(n-1);
  int MaxRow2=(m-1);
  int MaxCol2=0;

  for (row=0; row<m; row++)
  {
    for (col=0; col<n; col++)
    {
      /* If the current count is larger than 2nd highest and larger
         than or equal to the highest count, update the index of
        the second highest to the index of highest, then update
        the index of the highest count to the index of current */
      {
      if (IntTable[row][col]> IntTable[MaxRow2][MaxCol2]){
        if (IntTable[row][col]>= IntTable[MaxRow][MaxCol]){
          MaxRow2=MaxRow;
          MaxCol2=MaxCol;
          MaxRow=row;
          MaxCol=col;}
          /* If current count is larger than Second highest, but
             smaller than or equal to the Highest, only update
             the index of the Second highest to the current index*/
          else if (IntTable[row][col]<=IntTable[MaxRow][MaxCol]){
            MaxRow2=row;
            MaxCol2=col;}
            }
      }
    }
    }
    /* prints the final index of both highest and second highest, and the counts
       themselves */
  printf("Highest count is %d at row:%d, and column:%d\n", IntTable[MaxRow][MaxCol], MaxRow,MaxCol);
  printf("Second highest count is %d at row:%d, and column:%d\n", IntTable[MaxRow2][MaxCol2], MaxRow2, MaxCol2);

}
