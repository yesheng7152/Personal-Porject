<h1>Background</h1>
This problem introduces some simplified elements related to a program to track shopping in a grocery store. <br>
Items available in a grocery store might be categorized as produce (e.g., vegetables, fruit, cheese, meat, etc.), 
beverages (bottled water, milk, soft drinks, energy drinks, etc.), and packages (boxes of crackers, noodles, tea, etc.).

<h1>Note</h1>
<ol>
For this problem, you should implement the following:
  <li>Class definitions for Item and its subclasses Produce, Beverage, and Package</li>
  <li>A ShoppingCart class, modeled upon the SchoolDirectory class from the CSC 207 lab Generalization, 
  Polymorphism, and Exceptions. The ShoppingCart class should have these features:</li>
    <ul>
      <li>A private array Cart of Item objects:</li>
        <ul>
          <li>The size of Cart is given by private field maxSize.</li>
          <li>Field currentSize gives the actual number of objects stored in Cart, in positions Cart[0] to Cart[currentSize-1].</li>
        </ul>
      <li>A method addItem places a new item object into the array, expanding the array as needed, and incrementing currentSize</li>
      <li>A method printCart should provide a listing of all items in the cart.</li>
      <li>A method totalCost should compute the total cost of all items in the cart.</li>
      <li>A method numberInCart should take a parameter String groceryName and return how many items in the current shopping cart have that name.</li>
    </ul>
</ol>
