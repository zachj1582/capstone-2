Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

********************
1. Encapsulation

Encapsulation is one of the fundamental concepts in OOP. It describes the idea of bundling data and methods 
that work on that data within one unit or class. Often used to hide data or state of an object from the outside.
Keeping the data private and only accessible with getters and setters allows you to control the access to that data.
You can keep data read only or write only. It also gives you control over the data sent in to the setters,
you can validate the information coming in via the setter to ensure that your object always has valid state.

The same goes for methods, controlling which methods can be called outside of the class 
and which are private for internal use only. With the different modifiers in Java you can keep 
certain methods private and only allow outside classes to call them through an abstraction.
Again allowing for validation prior to returning a private method. 

Ex.

public Coffee brewCoffee(CoffeeSelection selection) throws CoffeeException {
        switch (selection) {
            case FILTER_COFFEE:
                return brewFilterCoffee();
            case ESPRESSO:
                return brewEspresso();
            default:
                throw new CoffeeException("CoffeeSelection [" + selection + "] not supported!");
        }
    }
    
private Coffee brewEsspresso(){.....}

private Coffee brewFilterCoffee(){.....}

********************
2. Inheritance

Inheritance is a mechanism where you can derive a class from another class for a hierarchy 
of classes that share a set of attributes and methods. Essentially taking the blue print from the parent class 
and giving it to the child class. The child class can then use the state and methods accessible to it.
As with encapsulation the access modifiers used determine whether the child will inherit certain methods and state.
Sub classes inherit all public and protected methods and attributes as well as the types of the
superclass. You can then use the inherited attributes, use or override the inherited methods, 
and cast the subclass to any type of its superclass.

public class Lion extends Animals {
public Lion (int legs, boolean carnivore){

super(legs, carnivore);

....
}
}

********************
3. Abstraction

Abstraction is hiding the implementation details and showing only functionality to the user.
Creating a blue print that must be followed in subclasses. Or the example in encapsulation where
you're hiding the internal private methods of a class so only the functionality is returned to the user. 
"When developing with a higher level of abstraction, you communicate the behaviour and less the implementation."


********************
4. Polymorphism
   
Polymorphism is changing the behaviour of a super class in the subclass. Method overriding is one example.
Honestly, as much as I read about it that's about all I can grasp of the concept, anything that
is polymorphic being changed is an example of polymorphism.





Please write 1-3 paragraphs explaining these 4 concepts further.  Please provide a sufficient enough explanation about these pillars, as well as some examples to illustrate the practical use cases of these principles.  



