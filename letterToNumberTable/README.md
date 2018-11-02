# Letter To Number Table

## Background 

* Many word puzzles and games involve words placed in a 2-dimension grid. 
 With any arrangement of words, one can count the number of letters immediately adjacent to a position 
(up, down, left, right, or one square along a diagonal). For the above example, such a count would yield 
the following table, where each entry is the number of adjacent letters. 
(Again, row and column numbers are included for reference, but these identifiers can be ignored in the problem that follows.)

<ul>
<li>Write a program that</li>
<ul>
  <li> reads the size of a grid (the number of rows m and columns n)</li>
  <li> reads an m by n grid of characters </li>
  <li> once read, the program outputs the grid of characters (do not label row numbers or column numbers)</li>
  <li> computes and prints the grid of counts (do not label row numbers or column numbers)</li>
  <li> identifies the two locations with the highest counts</li>
  <li> assume that there are at least n characters entered for each row of the grid 
  (more than n characters may be entered on a row, but any extra characters should be ignored.)</li>
</ul>
</ul>

## Example 
### Input:
<pre>
            Column
               11111111112 
     012345678901234567890
Row   
 0       SYSTEM          
 1   COMPUTER            
 2      PROGRAM           
 3   MEMORY NETWORK    E  
 4      STRING   A     Q  
 5       A  L    L     U  
 6       R CO    G     A  
 7    TP R AG    E     TS 
 8    HH A LI    B     IC 
 9    EY Y CC    R     OH  
10    OS   U     A     NEW
11   GRINNELL           M 
12    YC   U            E 
13     S   S               </pre>

### Output:
<pre>
            Column
               11111111112 
     012345678901234567890
Row   
 0   233445543110000000000
 1   123578877420000000000
 2   467787766443321001110
 3   124687877533321002120
 4   234565555435441003230
 5   001446654103230003230
 6   122425443003230003341
 7   233526553003230003442
 8   355626553003230003553
 9   355515442003230003564
10   466646552002120002453
11   366424431001110001444
12   355535441000000000212
13   132202120000000000111
</pre>
