# Bloch's Effective Java

- **Publisher**: Addison-Wesley Professional
- **Author**: Joshua Bloch
- **Presenter**: Wen-Bin Luo
- **Link**: https://www.amazon.com/Effective-Java-Joshua-Bloch-ebook/dp/B078H61SCH

## Creating and Destroying Objects

### Consider static factory methods instead of constructors

- Static factory methods have names.
- Static factory methods are not required to create a new object each time they’re invoked.
- Static factory methods can return an object of any subtype of their return type.
- The class of the returned object can vary from call to call as a function of the input parameters.
- The class of the returned object need not exist when the class containing the method is written.
- Three essential components in a *service provider framework*:
    - *Service interface*: for providers to implement.
    - *Provider registration API*: providers use to register implementations.
    - *Service access API*: clients use to obtain instances of the service.
    - *Service provider interface* (optional): a factory object that produce instances of the service interface.
- Classes providing only static factory methods (without public or protected constructors) cannot be subclassed.
- Static factory methods are hard for programmers to find.

### Consider a builder when faced with many constructor parameters

- The **telescoping constructor pattern** does not scale well to large numbers of optional parameters.
- A **JavaBean pattern** may be in an inconsistent state partway through its construction.
- The JavaBeans pattern precludes the possibility of making a class immutable.
- The **builder pattern** combines the safety of the telescoping constructor pattern with the readability of the JavaBeans pattern.
- The Builder pattern simulates named optional parameters.
- To detect invalid parameters as soon as possible, check parameter validity in the builder’s constructor and methods.
- The Builder pattern is well suited to class hierarchies.
- **Covariant return typing**: a subclass method is declared to return a subtype of the return type declared in the superclass.
- The builder pattern is a good choice when designing classes whose constructors or static factories would have more than a handful of parameters.

### Enforce the singleton property with a private constructor or an enum type

- Making a class a singleton can make it difficult to test its clients.
- The singleton pattern keeps the constructor private and exports a public static member to provide access to the sole instance.
- To maintain the singleton guarantee, declare all instance fields transient and provide a `readResolve` method.
- Enum singleton provides an ironclad guarantee against multiple instantiation.
- A single-element enum type is often the best way to implement a singleton.

### Enforce noninstantiability with a private constructor

- A class can be made noninstantiable by including a private constructor.
- Such classes can be used to group static methods or methods on a final class.
- Attempting to enforce noninstantiability by making a class abstract does not work.
- The private constructor prevents the class from being subclassed.

### Prefer dependency injection to hardwiring resources

- Inappropriate use of singleton makes the class inflexible and untestable.
- Static utility classes and singletons are inappropriate for classes whose behavior is parameterized by an underlying resource.
- **Dependency injection**: pass the resource into the constructor when creating a new instance.
- Dependency injection provides flexibility and testability.
- Dependency injection is applicable to constructors, static factories, and builders.

### Avoid creating unnecessary objects

- Avoid creating unnecessary objects by using static factory methods.
- Lazy initialization would complicate the implementation with no measurable performance improvement.
- Autoboxing blurs but does not erase the distinction between primitive and boxed primitive types.
- Prefer primitives to boxed primitives, and watch out for unintentional autoboxing.

### Eliminate obsolete object references

- An obsolete reference is simply a reference that will never be dereferenced again.
- Memory leaks in garbage-collected languages (more properly known as **unintentional object retentions**) are insidious.
- Null out references once they become obsolete.
- Nulling out object references should be the exception rather than the norm.
- The best way to eliminate an obsolete reference is to let the variable that contained the reference fall out of scope.
- Whenever a class manages its own memory, the pro- grammer should be alert for memory leaks.
- A third common source of memory leaks is listeners and other callbacks.

### Avoid finalizers and cleaners

- Finalizers are unpredictable, often dangerous, and generally unnecessary.
- Cleaners are less dangerous than finalizers, but still unpredictable, slow, and generally unnecessary.
- There is no guarantee finalizers and cleaners will be executed promptly.
- Never do anything time-critical in a finalizer or cleaner.
- The promptness with which finalizers and cleaners are executed is primarily a function of the garbage collection algorithm.
- Never depend on a finalizer or cleaner to update persistent state.
- An uncaught exception thrown during finalization is ignored, and finalization of that object terminates.
- There is a severe performance penalty for using finalizers and cleaners.
- Finalizers open your class up to **finalizer attacks**.
- Unlike finalizers, cleaners do not pollute a class’s public API.
- Have your class implement `AutoCloseable`!
- The behavior of cleaners during `System.exit` is implementation specific.

### Prefer try-with-resources to try-finally

- Try-finally is no longer the best way to close resources!
- To be usable with the try-with-resources construct, a resource must implement the `AutoCloseable` interface.

## Methods Common to All Objects

### Obey the general contract when overriding equals

- Each instance of the class is inherently unique.
- There is no need for the class to provide a "logical equality" test.
- A superclass has already overridden equals, and the superclass behavior is appropriate for this class.
- The class is private or package-private,and you arec ertain that its equals method will never be invoked.
- The equals method implements an *equivalence relation*: *reflexive*, *symmetric* and *transitive*.
- Once the equals contract is violated, the behavior of other objects is undefined when confronted with your object.
- There is no way to extend an instantiable class and add a value component while preserving the equals contract.
- A recipe for a high-quality equals method:
    - Use the == operator to check if the argument is a reference to this object.
    - Use the instanceof operator to check if the argument has the correct type.
    - Cast the argument to the correct type.
    - For each "significant" field in the class, check if the fields of the two objects match.
- Always override hashCode when you override equals.
- Don’t substitute another type for Object in the equals declaration.

### Always override hashCode when you override equals

- You must override hashCode in every class that overrides equals.
- General contract for `hashCode`: equal objects must have equal hash codes.
- If every object has the same hash code, hash tables degenerate to linked lists.
- Any fields that are not used in equals comparisons should be excluded.
- Never exclude significant fields from the hash code com- putation to improve performance.

### Always override toString

- The benefits of providing a good `toString` implementation:
    - Make your class much more pleasant to use.
    - Make systems using the class easier to debug.
- When practical, the `toString` method should return all of the interesting information contained in the object.
- Whether or not you decide to specify the format, you should clearly document your intentions.

### Override clone judiciously

- Behaviors of the `clone` method:
    - If a class implements `Cloneable`, `Object`’s `clone` method returns a field-by-field copy of the object
    - Otherwise, it throws `CloneNotSupportedException`.
- `Object`’s `clone` method is protected. Therefore, `clone` cannot be invoked on an object merely because it implements `Cloneable`.
- A class implementing `Cloneable` is expected to provide a properly functioning public clone method.
- The general contract for the clone method is weak:
    - `x.clone() != x`
    - `x.clone().getClass() == x.getClass()`
    - `x.clone().equals(x)`
- By convention, the object returned by the `clone` method should be obtained by calling `super.clone`
- The `Cloneable` architecture is incompatible with normal use of final fields referring to mutable objects,
- Public `clone` methods should omit the `throws` clause,
- A better approach to object copying is to provide a *copy constructor* or *copy factory*.

### Consider implementing Comparable

- The general contract of the `compareTo` method:
    - Returns a negative integer, zero, or a positive integer.
    - Throws ClassCastException if the specified object’s type cannot be compared to this object.
- Classes that depend on comparison include:
    - The sorted collections `TreeSet` and `TreeMap`.
    - The utility classes `Collections` and `Arrays`, which contain searching and sorting algorithms.
- The ordering imposed by the `compareTo` method can be *consistent* or *inconsistent* with `equals`.

## Classes and Interfaces

### Minimize the accessibility of classes and members

- **Information hiding** or **encapsulation** decouples the components that comprise a system.
- The access control mechanism specifies the accessibility of classes, interfaces, and members.
- Rule of thumb: make each class or member as inaccessible as possible.
- For top-level (non-nested) classes and interfaces, there are only two possible access levels: *package-private* and *public*.
- For members (fields, methods, nested classes, and nested interfaces), there are four possible access levels: *private*, *package-private* (default), *protected*, and *public*.
- Both protected and public members are part of the class’s exported APIs.
- It is acceptable to make a *private* member *package-private* in order to test it.
- *Liskov substitution principle* implies that a subclass method overriding a superclass method cannot have a more restrictive access level.
- Instance fields of public classes should rarely be public.
- Classes with public mutable fields are not generally thread-safe.
- A field containing a reference to a mutable object has all the disadvantages of a nonfinal field.
- A **module** is a grouping of packages, like a package is a grouping of classes.
- A module may explicitly export some of its packages via *export declarations* in its *module declaration*.

### In public classes, use accessor methods, not public fields

- If a class is accessible outside its package, provide accessor methods.
- If a class is package-private or is a private nested class, there is nothing inherently wrong with exposing its data fields.
- Public classes should never expose mutable fields.

### Minimize mutability

- Five rules for immutable classes:
    - Don’t provide methods that modify the object’s state.
    - Ensure that the class can’t be extended.
    - Make all fields final.
    - Make all fields private.
    - Ensure exclusive access to any mutable components.
- Immutable objects are inherently thread-safe; they require no synchronization.
- A `clone` method or copy constructor need not and should not be provided on an immutable class.
- Performance issue: immutable classes require a separate object for each distinct value.
- Constructors should create fully initialized objects with all of their invariants established.

### Favor composition over inheritance

- Unlike method invocation, inheritance violates encapsulation.
- This "self-use" is an implementation detail, not guaranteed to hold.
- **Forwarding**: Each instance method in the new **forwarding class** invokes the corresponding method on the contained instance of the existing class and returns the results.

### Design and document for inheritance or else prohibit it

- The class must document its self-use of overridable methods.
- Designing a class for inheritance requires great effort and places substantial limitations on the class.
- The best practice is to prohibit subclassing in classes that are not designed and documented to be safely subclassed.

### Prefer interfaces to abstract classes

- Java permits only single inheritance.
- Existing classes can easily be retrofitted to implement a new interface.
- Interfaces are ideal for defining mixins.
- Interfaces allow for the construction of nonhierarchical type frameworks.
- Interfaces enable safe, powerful functionality enhancements via the *wrapper class* idiom.
- **Default method** is an obvious implementation of an interface method in terms of other interface methods.
- Interfaces are not permitted to contain instance fields or nonpublic static members (with the exception of private static methods).
- **Skeletal implementation class** combine the advantages of interfaces and abstract classes:
    - Can provide some default methods.
    - Implements the remaining non-primitive interface methods atop the primitive interface methods.
- Good documentation is absolutely essential in a skeletal implementation.

### Design interfaces for posterity

- In the presence of default methods, existing implementations of an interface may compile without error or warning but fail at runtime.

### Use interfaces only to define types

- The constant interface pattern is a poor use of interfaces. Instead, a constant utility class is a better alternative.
- Use static import to avoid qualifying constants.

### Prefer class hierarchies to tagged classes

- Tagged classes are verbose, error-prone, and inefficient.
- A tagged class is just a pallid imitation of a class hierarchy.

### Favor static member classes over nonstatic

- Four kinds of nested classes: static member classes, nonstatic member classes, anonymous classes, and local classes.
- Each instance of a nonstatic member class is implicitly associated with an enclosing instance of its containing class.
- When declaring a member class that does not require access to an enclosing instance, always put the `static` modifier in its declaration,

### Limit source files to a single top-level class

- Never put multiple top-level classes or interfaces in a single source file.

## Generics

### Don’t use raw types

- If you use raw types, you lose all the safety and expressiveness benefits of generics.
- Migration compatibility drove the decisions to support raw types and to implement generics using erasure.
- The safe alternative to raw collection types is to use unbounded wildcard types.
- You can’t put any element (other than null) into a `Collection<?>`.

### Eliminate unchecked warnings

- The *diamond operator* tells the compiler to infer the correct actual type parameter.
- Eliminate every unchecked warning that you can.
- If the code that provoked the warning is typesafe, then (and only then) suppress the warning with an `@SuppressWarnings("unchecked")` annotation.
- Always use the `SuppressWarnings` annotation on the smallest scope possible.

### Prefer lists to arrays

- Arrays are *covariant*.
- Generics are *invariant*.
- Arrays are *reified*. Arrays know and enforce their element type at runtime.
- Generics are implemented by *erasure*. They enforce their type constraints only at compile time and discard (or erase) their element type information at runtime.
- A non-reifiable type is one whose runtime representation contains less information than its compile-time representation.
- Because of erasure, the only parameterized types that are reifiable are unbounded wildcard types
- Arrays are covariant and reified; generics are invariant and erased.

### Favor generic methods

- *Generic singleton factory* is a generic meethod that creates singletons of a generic type.
- **Recursive type bound** allows for a type parameter to be bounded by some expression involving that type parameter itself.
- `E extends Comparable<E>` may be read as "any type E that can be compared to itself,"

### Use bounded wild cards to increase API flexibility

- For maximum flexibility, use wildcard types on input parameters that represent producers or consumers.
- **PECS**: producer-extends, consumer-super.
- Do not use bounded wildcard types as return types.
- There is a duality between type parameters and wildcards.

### Combine generics and varargs judiciously

- Varargs methods and generics do not interact gracefully.
- Varargs is a *leaky abstraction* the array that hold the varargs parameters is visible.
- *Heap pollution* occurs when a variable of a parameterized type refers to an object that is not of that type.
- It is unsafe to store a value in a generic varargs array parameter.
- The `SafeVarargs` annotation constitutes a promise by the author of a method that it is typesafe.
- It is unsafe to give another method access to a generic varargs parameter array.
- Use `@SafeVarargs` on every method with a varargs parameter of a generic or parameterized type.

### Consider typesafe heterogeneous containers

- The normal use of generics requires a fixed number of type parameters per container.
- The restriction can be got around by placing the type parameter on the key rather than the container.
- `Class` objects are used as keys for such typesafe heterogeneous containers.
- A `Class` object used in this fashion is called a **type token**.

## Enums and Annotations

### Use enums instead of int constants

- An *enumerated type* is a type whose legal values consist of a fixed set of constants.
- Enum types are effectively final, and are a generalization of singletons.
- Enums provide compile-time type safety.
- Enum types with identically named constants coexist peacefully because each type has its own namespace.
- Enum types allow adding arbitrary methods and fields and implementing arbitrary interfaces.
- To associate data with enum constants, declare instance fields and write a constructor that takes the data and stores it in the fields.
- Enums are by their nature immutable, so all fields should be final
- If an enum is generally useful, it should be a top-level class; if its use is tied to a specific top-level class, it should be a member class of that top-level class.
- Enum constants can have different behavior through *constant-specific method implementations*.
- Constant-specific method implementations can be combined with constant-specific data.
- However, constant-specific method implementations make it harder to share code among enum constants.
- Switches on enums are good for augmenting enum types with constant-specific behavior.
- Enums are a good practice when a set of constants whose members are known at compile time.

### Use instance fields instead of ordinals

- Enums are naturally associated with a single `int` value, which can be accessed with the `ordinal` method.
- While `ordinal` method works, it is a maintenance nightmare.
- Unless for `EnumSet` and `EnumMap`, it is best to avoid the ordinal method entirely.

### Use EnumSet instead of bit fields

- Bit fields have all the disadvantages of int enum constants and more.
- The `EnumSet` class efficiently represents sets of values drawn from a single enum type.
- Internally, each `EnumSet` is represented as a bit vector.
- Just because an enumerated type will be used in sets, there is no reason to represent it with bit fields.

### Use EnumMap instead of ordinal indexing

- `EnumMap` is comparable in speed to an ordinal-indexed array in that `EnumMap` uses such an array internally.
- It is rarely appropriate to use ordinals to index into arrays: use `EnumMap` instead.

### Emulate extensible enums with interfaces

- For the most part, extensibility of enums turns out to be a bad idea.
- A minor disadvantage of the use of interfaces to emulate extensible enums is that implementations cannot be inherited from one enum type to another.
- While you cannot write an extensible enum type, you can emulate it by writing an interface to accompany a basic enum type that implements the interface.

### Prefer annotations to naming patterns

- Annotations on annotation type declarations are known as **meta-annotations**.
- There is simply no reason to use naming patterns when you can use annotations instead.
- All programmers should use the predefined annotation types that Java provides.

### Consistently use the Override annotation

- `@Override` can be used only on method declarations.
- Use the `Override` annotation on every method declaration that you believe to override a superclass declaration.

### Use marker interfaces to define types

- A **marker interface** is an interface that contains no method declarations but merely designates (or “marks”) a class that implements the interface as having some property.
- Marker interfaces define a type that is implemented by instances of the marked class; marker annotations do not.
- Another advantage of marker interfaces over marker annotations is that they can be targeted more precisely.

## Lambdas and Streams

### Prefer lambdas to anonymous classes

- Historically, interfaces (or, rarely, abstract classes) with a single abstract method were used as **function types**.
- The instances of function types, known as **function objects**, represent functions or actions.
- The primary means of creating a function object was the **anonymous class**.
- In Java 8, the language formalized the notion that interfaces with a single abstract method and is now known as **functional interfaces**.
- An instance of functional interfaces can be created using **lambda expressions**, or **lambdas** for short.
- The compiler deduces the types of the lambda from context, using a process known as **type inference**.
- Omit the types of all lambda parameters unless their presence makes your program clearer.
- Lambdas share with anonymous classes the property that you can’t reliably serialize and deserialize them across implementations.
- Don’t use anonymous classes for function objects unless you have to create instances of types that aren’t functional interfaces.

### Prefer method references to lambdas

- Java provides a way to generate function objects even more succinct than lambdas: **method references**.
- Many method references refer to static methods, but there are four kinds that do not.
- Where method references are shorter and clearer, use them; where they aren’t, stick with lambdas.

### Favor the use of standard functional interfaces

- If one of the standard functional interfaces does the job, you should generally use it in preference to a purpose-built functional interface.
- Don’t be tempted to use basic functional interfaces with boxed primitives instead of primitive functional interfaces.
- When to use a purpose-built functional interface in preference to a standard one?
    - It will be commonly used and could benefit from a descriptive name.
    - It has a strong contract associated with it.
    - It would benefit from custom default methods.
- Always annotate functional interfaces with the `@FunctionalInterface` annotation.
- Do not provide a method with multiple overloadings that take different functional interfaces in the same argument position if it could create a possible ambiguity in the client.

### Use streams judiciously

- The streams API provides two key abstractions:
    - The stream: a finite or infinite sequence of data elements.
    - The stream pipeline: a multistage computation on these elements.
- A stream pipeline consists of a source stream followed by zero or more intermediate operations and one terminal operation.
- Stream pipelines are evaluated *lazily*: evaluation doesn't start until the terminal operation is invoked.
- The streams API is *fluent*.
- Overusing streams makes programs hard to read and maintain.
- In the absence of explicit types, careful naming of lambda parameters is essential to the readability of stream pipelines.
- Using helper methods is even more important for readability in stream pipelines than in iterative code.
- Refactor existing code to use streams and use them in new code only where it makes sense to do so.
- If you’re not sure whether a task is better served by streams or iteration, try both and see which works better.

### Prefer side-effect-free functions in streams

- The forEach operation should be used only to report the result of a stream computation, not to perform the computation.
- It is customary and wise to statically import all members of Collectors because it makes stream pipelines more readable.
- The essence of programming stream pipelines is side-effect-free function objects.

### Prefer Collection to Stream as a return type

- A method returning a sequence that will only be used for iteration should return an Iterable.
- The `Collection` interface is a subtype of `Iterable` and has a `stream` method, so it provides for both iteration and stream access.
- `Collection` or an appropriate subtype is generally the best return type for a public, sequence-returning method.

### Use caution when making streams parallel

- Parallelizing a pipeline is unlikely to increase its performance if:
    - The source is from `Stream.iterate`.
    - The intermediate operation `limit` is used.
- Performance gains from parallelism are best on streams over data structures:
    - That can be accurately and cheaply split into subranges of any desired sizes.
    - That provide good-to-excellent *locality of reference* when processed sequentially.
- Override the `spliterator` method of custom data collections to get decent parallel performance.
- Inappropriately parallelizing a stream can lead to:
    - Poor performance, including liveness failures.
    - Safety failures: Incorrect results and unpredictable behavior.
- Under the right circumstances, it is possible to achieve near-linear speedup in the number of processor cores simply by adding a `parallel` call to a stream pipeline.

## Methods

### Check parameters for validity

- Restrictions on what values may be passed into their parameters.
- Such restrictions should be checked at the beginning of the method body.
- Failure to validate parameters can result in a violation of *failure atomicity*.
- Use the Javadoc @throws tag to document the exception.
- `@Nullable` annotation indicates that a particular parameter may be null.
- `Objects.requireNonNull` method obliterates the need to perform null checks manually.
- In Java 9, a range-checking facility was added to `java.util.Objects`.
- Indiscriminate reliance on implicit validity checks can result in the loss of *failure atomicity*.
- Use the *exception translation* idiom to translate the natural exception into the correct one.

### Make defensive copies when needed

- It is essential to make a defensive copy of each mutable parameter to the constructor.
- Defensive copies should be made before checking the validity of the parameters.
- The validity check is performed on the copies rather than on the originals.
- Do not use the clone method to make a defensive copy of a parameter whose type is subclassable by untrusted parties.
- Return defensive copies of mutable internal fields.
- Use immutable objects as components of your objects wherever possible.
- There may be a performance penalty associated with defensive copying and it isn't always justified.

###  Design method signatures carefully

- Choose method names carefully and respect naming conventions.
- Don't go overboard in providing convenience methods.
- Avoid long parameter lists.
- Long sequences of identically typed parameters are especially
harmful.
- Three techniques for shortening overly long parameter lists:
    - Break the method up into multiple methods.
    - Create helper classes to hold groups of parameters.
    - Adapt the Builder pattern from object construction to method invocation.
- For parameter types, favor interfaces over classes.
- Prefer two-element enum types to boolean parameters.
