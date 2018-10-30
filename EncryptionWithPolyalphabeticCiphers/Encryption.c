#include <stdio.h>
#include <ctype.h>
#include <strings.h>

//Converting all letters to Upper case letter
char inputs (char *address,int length);
  int main ()
  {
    /* Declaring variables and Reading inputs and converting them to upper
       case keyword and message are both limited to 100 letters and Cipher-
       Alphabet to 26 */
    char keyword[101];
    printf("Please enter a keyword:  \n");
    inputs (keyword, 101);
    char message[101];
    printf("Please enter the message:  \n");
    inputs (message, 101);
    char CipherAlphabet[27];
    printf("Please enter the Cipher Alphabet:  \n");
    inputs(CipherAlphabet,27);
    int RowNumber;
    /*the inner loop looks at which alphabet will be used base on the keyword.
    the outer loop convert the message into the encrypted message after
    changing original message based on keyword and the Cipher Alphabet */
  for (int j=0;j<=(strlen(message)-1); j++)
  {
    /* If the message contains none-letter characters, that character will
       not be encrypted */
    if(isalpha(message[j])==0)
      message[j]=message[j];
    else
    {
      /* k is the position of characters in the keyword, and i is to make sure
         that the keyword would be repeated until the message has been fully
         encrypted.*/
    for (int k=0,i=0; i<=j; i++, k++)
    {
      if (k==(strlen(keyword)-1))
        k=0;
        /* RowNumber is to determine which shifted alphabet to use, if
           RowNumber is 2, then the alphabet would start with B and end with A;
           3, start with C and end with B etc. Subtracting 65 is because A
           is 65, and B is 66, and so on.*/
      RowNumber= (keyword[k]-65);
    }
    int MessageIndex= (message[j]-65);
    /* Using CipherAlphabet to encrypt the message, taking into the
       consideration of the RowNumber and the actual letter of the original
       message*/
    message[j]= CipherAlphabet[(MessageIndex + RowNumber)%26];
    }
  }
  printf("%s\n",message);
  }

char inputs (char *address,int length)
{
    //reads the input
    fgets(address, length, stdin);
    //converts the input to uppercases, letter by letter
    for (int n=0; n< length; n++)
      address[n]=toupper(address[n]);
  }
