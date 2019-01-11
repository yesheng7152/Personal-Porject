# Encryption With Polyalphabetic Ciphers
## Background
As you might expect from a puzzle that is used widely in the popular press, 
monoalphabetic ciphers are reasonably easy to break. Since each letter of the alphabet 
in the original message is always converted to the same letter in the enciphered message,
properties of English can be considered. For example, in a newspaper puzzle, if a coded word is shown to be 
one letter long (and if the language is English), then the coded letter likely stands for either 'A' or 'I', 
since those are the only two 1-letter words in common English. To discourage code breakers from utilizing 
common characteristics of English (or another language), one common encryption approach is to utilize several alphabets.
For example, sometimes 'A' will be encrypted by one letter, and another time 'A' will be encrypted by another letter. 
Thus, code breaker is likely to have a difficult time exploiting many statistical properties of language.
To implement this strategy we utilize a "keyword" to shift successive letters in our original message. 
Each letter in the message is shifted by an amount according to the row that shifts 'A' successively 
to the letters in our keyword.

<ul>
<li> Write A Program </li>
<ul>
  <li>  Encrypts a message according to a cipher alphabet and a keyword</li>
  <li>  The program should read the cipher alphabet and the keyword </li>
  <li>  The program should read a message on one line. (Messages extending 
  over two or more lines need not be considered for this problem.)</li>
  <li>  The program should encrypt and print the message, according to 
  the polyalphabetic cipher described in this narrative </li>
  <li>  The program should convert all letters to upper case </li>
  <li>  Non-letters should be left alone in the encoding </li>
  <li>  You may assume the message will not exceed 100 characters </li>
 </ul>
</ul>
 
 ## Example
 ### Input
 <pre>
 THIS LINE TESTS BOTH ENCRYPTION AND DECRYPTION
 COMPUTER
 </pre>
 ### Output
 <pre>
 NNER VZVK BSZZI TQBI LJSSZDAQRJ QDW LLKAXTBLAK
 </pre>
 
 
