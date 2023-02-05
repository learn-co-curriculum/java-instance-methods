# Instance Methods

## Learning Goals

- Implement an instance method to access object state
- Call an instance method using an object reference 

## Code Along

Fork and clone this lesson to run the code.


## Static Methods

Before we discuss instance methods, let's review how to define and call a
static method. We will implement a simple static method for the `Dog` class named `bark`.
Since the method is static, we can call it from the `main` method
without creating a `Dog` instance:

```java
public class Dog {

	public static void bark() {
		System.out.println("Woof!");
	}

	public static void main(String[] args) {
		bark();     
	}

}
```

The program prints:

```text
Woof!
```

We can define a parameter variable to pass a value into the method
when it is called. In the example below, the `bark` method has been updated with a
parameter named `greeting`. Each time we call `bark`, we need to provide a string value
that will be assigned to the `greeting` parameter.

```java
public class Dog {

	public static void bark(String greeting) {
		System.out.println(greeting + "!");
	}

	public static void main(String[] args) {
        bark("Woof");
        bark("Arf");
	}

}
```

The program prints:

```text
Woof!
Arf!
```

## Instance Methods

An instance method defines the implementation of an operation or task that
accesses and possibly updates the state of an object.
An instance method must be called using an object reference.
For example, we've seen how to call the `toUpperCase()` instance method
using a variable `greeting` that references a `String` object:

```java
String greeting = "hello";
System.out.println( greeting.toUpperCase() ); //HELLO
```

How do we define instance methods in our own classes?
In our `Dog` example, can we teach our `Dog` a new trick?
Can we teach our `Dog` to wag their tail when we give them a treat, for example?

We can. When we place a method definition within the body of a class
*without* the keyword `static`, that method becomes a specific
behavior of instances of that class. We call non-static methods
defined within the object's class **instance methods**
because they are methods that are invoked through
an instance of the class. An instance method can access the instance variables
defined in the class and modify the object state.

Let's add an instance variable `isWaggingTail` to the `Dog` class.
Each dog will store its own copy of the variable.

![dog state](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/dogstate2.png)

Let's assume dogs like treats but not baths.
We will add an instance method named `giveTreat` to
set `isWaggingTail` to true, and an instance method `giveBath`
to set `isWaggingTail` to false.  Notice we omit the keyword `static`
from both methods.  

We'll update the `main` to create two dogs and invoke the various methods:

```java
public class Dog {
    private boolean isWaggingTail;

    public void giveTreat() {
        isWaggingTail = true;
    }

    public void giveBath() {
        isWaggingTail = false;
    }

    public static void bark(String greeting) {
        System.out.println(greeting + "!");
    }

    public static void main(String[] args) {
        Dog fido = new Dog();
        Dog snoopy = new Dog();

        fido.giveTreat();    //sets fido.isWaggingTail to true
        snoopy.giveTreat();  //sets snoopy.isWaggingTail to true
        fido.giveBath();     //sets fido.isWaggingTail to false

        bark("Woof"); 
        bark("Arf");  
    }
}

```

The `main` method can call the `giveTreat` and `giveBath` methods
on a particular `Dog` class instance to change the value stored
in their `isWaggingTail` variable. 

Let's step through the `main` method using the IntelliJ debugger
and the `Java Visualizer` plugin so we can watch what happens when
the instance methods are called.

1. Set a breakpoint on the first line of executable code in the `main` method, i.e.
   the line that declares the variable `fido`:      
   `Dog fido = new Dog();`
2. Press the debug button, then select the "Java Visualizer" tab.
3. Press the "Step Over" icon to execute each line of code in the `main` method.

| Code                      | Java Visualizer                                                                                                                                     |
|---------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| `Dog fido = new Dog();`   | ![step 1](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/dogstate1.png)                                                         |
| `Dog snoopy = new Dog();` | ![step 2](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/dogstate2.png)                                                         |
| `fido.giveTreat();`       | ![step 3](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/dogstate3.png) <br> <br>fido is wagging their tail                     |
| `snoopy.giveTreat();`     | ![step 4](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/dogstate4.png) <br> <br>snoopy is wagging their tail                   |
| `fido.giveBath();`        | ![step 5](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/dogstate5.png) <br> <br>fido is not wagging their tail                 |
| `bark("Woof");`           | ![print Woof](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/dogstate2.png) <br><br>static method does not change object state. |
| `bark("Arf");`            | ![print Arf](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/dogstate2.png)  <br><br>static method does not change object state. |

You can also use the browser-based visualizer to step through the
program at [this link](https://pythontutor.com/visualize.html#code=public%20class%20Dog%20%7B%0A%20%20%20%20private%20boolean%20isWaggingTail%3B%0A%0A%20%20%20%20public%20void%20giveTreat%28%29%20%7B%0A%20%20%20%20%20%20%20%20isWaggingTail%20%3D%20true%3B%0A%20%20%20%20%7D%0A%0A%20%20%20%20public%20void%20giveBath%28%29%20%7B%0A%20%20%20%20%20%20%20%20isWaggingTail%20%3D%20false%3B%0A%20%20%20%20%7D%0A%0A%20%20%20%20public%20static%20void%20bark%28String%20greeting%29%20%7B%0A%20%20%20%20%20%20%20%20System.out.println%28greeting%20%2B%20%22!%22%29%3B%0A%20%20%20%20%7D%0A%0A%20%20%20%20public%20static%20void%20main%28String%5B%5D%20args%29%20%7B%0A%20%20%20%20%20%20%20%20Dog%20fido%20%3D%20new%20Dog%28%29%3B%0A%20%20%20%20%20%20%20%20Dog%20snoopy%20%3D%20new%20Dog%28%29%3B%0A%0A%20%20%20%20%20%20%20%20fido.giveTreat%28%29%3B%20%20%20%20//sets%20fido.isWaggingTail%20to%20true%0A%20%20%20%20%20%20%20%20snoopy.giveTreat%28%29%3B%20%20//sets%20snoopy.isWaggingTail%20to%20true%0A%20%20%20%20%20%20%20%20fido.giveBath%28%29%3B%20%20%20%20%20//sets%20fido.isWaggingTail%20to%20false%0A%0A%20%20%20%20%20%20%20%20bark%28%22Woof%22%29%3B%20//prints%20Woof!%0A%20%20%20%20%20%20%20%20bark%28%22Arf%22%29%3B%20%20//prints%20Arf!%0A%20%20%20%20%7D%0A%7D%0A&cumulative=false&curInstr=0&heapPrimitives=true&mode=display&origin=opt-frontend.js&py=java&rawInputLstJSON=%5B%5D&textReferences=false).
The visualization will show a variable named `this` appearing in the call stack frame
when you call the instance methods `giveTreat` and `giveBath`, but not when you call
the static method `bark()`.  In Java, `this` is a very important variable that makes it possible
to implement instance methods. We'll explore how the `this` variable
works in the next lesson!

###  Comprehension Check #1 

<details>
    <summary>Given the following <code>Cat</code> class, what is printed when the <code>main</code> method executes?</summary>

  <p>Before executing <code>fluffy.brush();</code>, both cats have
  the <code>isPurring</code> instance variable assigned the default
  value <code>false</code>.
  </p>

  <img src="https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/catstate1.png">

  <p>After executing <code>fluffy.brush();</code>:
  </p>

  <img src="https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/catstate2.png">


  <p>The program outputs: <br>fluffy purring = true<br>whiskers purring = false</p>

  <p>You can step through the code at <a href="https://pythontutor.com/visualize.html#code=public%20class%20Cat%20%7B%0A%20%20%20private%20boolean%20isPurring%3B%0A%0A%20%20%20public%20void%20brush%28%29%20%7B%0A%20%20%20%20%20%20isPurring%20%3D%20true%3B%0A%20%20%20%7D%0A%0A%20%20%20public%20static%20void%20main%28String%5B%5D%20args%29%20%7B%0A%20%20%20%20%20%20Cat%20fluffy%20%3D%20new%20Cat%28%29%3B%0A%20%20%20%20%20%20Cat%20whiskers%20%3D%20new%20Cat%28%29%3B%0A%20%20%20%20%20%20fluffy.brush%28%29%3B%0A%20%20%20%20%20%20System.out.println%28%22fluffy%20purring%20%3D%20%22%20%2B%20fluffy.isPurring%29%3B%0A%20%20%20%20%20%20System.out.println%28%22whiskers%20purring%20%3D%20%22%20%2B%20whiskers.isPurring%29%3B%0A%20%20%20%7D%0A%7D&cumulative=false&curInstr=0&heapPrimitives=true&mode=display&origin=opt-frontend.js&py=java&rawInputLstJSON=%5B%5D&textReferences=false">this link.</a></p>
</details>

```java
public class Cat {
   private boolean isPurring;

   public void brush() {
      isPurring = true;
   }

   public static void main(String[] args) {
      Cat fluffy = new Cat();
      Cat whiskers = new Cat();
      fluffy.brush();
      System.out.println("fluffy purring = " + fluffy.isPurring);
      System.out.println("whiskers purring = " + whiskers.isPurring);
   }
}
```

###  Comprehension Check #2


```java
public class BankAccount {
    private int balance;

    public void deposit(int amount) {
        balance += amount;
    }

    public static void main(String[] args) {
        BankAccount checkingAccount = new BankAccount();
        BankAccount savingsAccount = new BankAccount();
        //add code to deposit money in each account
        
    }
}
```

The `main` method creates two `BankAccount` instances:

![bankaccount initialized](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/bankaccount1.png)

<details>
    <summary>How would you call the <code>deposit</code> method to modify the account balances as shown below?</summary>

  <p><br><code>checkingAccount.deposit(100);</code><br><code>savingsAccount.deposit(50);</code>
  </p>

  <p>You can step through the code at <a href="https://pythontutor.com/visualize.html#code=public%20class%20BankAccount%20%7B%0A%20%20%20%20private%20int%20balance%3B%0A%0A%20%20%20%20public%20void%20deposit%28int%20amount%29%20%7B%0A%20%20%20%20%20%20%20%20balance%20%2B%3D%20amount%3B%0A%20%20%20%20%7D%0A%0A%20%20%20%20public%20static%20void%20main%28String%5B%5D%20args%29%20%7B%0A%20%20%20%20%20%20%20%20BankAccount%20checkingAccount%20%3D%20new%20BankAccount%28%29%3B%0A%20%20%20%20%20%20%20%20BankAccount%20savingsAccount%20%3D%20new%20BankAccount%28%29%3B%0A%20%20%20%20%20%20%20%20checkingAccount.deposit%28100%29%3B%0A%20%20%20%20%20%20%20%20savingsAccount.deposit%2850%29%3B%0A%20%20%20%20%7D%0A%7D%0A%0A&cumulative=false&curInstr=0&heapPrimitives=true&mode=display&origin=opt-frontend.js&py=java&rawInputLstJSON=%5B%5D&textReferences=false">this link.</a></p>
</details>

![bankaccount deposits](https://curriculum-content.s3.amazonaws.com/6676/java-mod2-strings/bankaccount2.png)

<br>




## Conclusion

In this lesson we went over the steps for defining and calling
an instance method:

1. Define an instance method in a class by *omitting* the keyword `static` in the method signature.
2. Declare and assign a variable to reference an instance of the class.
3. Call/Invoke the method using the reference variable.

## Resources

* [Java Tutorial: Defining Methods](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
