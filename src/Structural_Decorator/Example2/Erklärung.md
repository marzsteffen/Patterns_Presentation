# Decorator Pattern: Pizza-Beispiel

Das Decorator Pattern ist ein Strukturmuster, das es erlaubt, Objekten dynamisch zusätzliches Verhalten hinzuzufügen, ohne deren Klassen zu verändern. Dies geschieht durch das "Einpacken" des ursprünglichen Objekts in ein oder mehrere Dekorierer-Objekte. Dieses Beispiel zeigt dies anhand einer Pizza, die mit verschiedenen Belägen versehen wird.

## Beteiligte Klassen und Schnittstellen

Angelehnt an das allgemeine Klassendiagramm des Decorator Patterns lassen sich folgende Elemente in unserem Pizza-Beispiel identifizieren:

* **`Pizza` (Component)**:
    * Ein Interface, das die grundlegenden Operationen für eine Pizza definiert.
    * Beinhaltet Methoden wie `double getPrice()`, `boolean isVegetarian()`, `boolean isHot()`, und `String getDescription()`.
    * *Code-Referenz:* `Structural_Decorator/Example2/Pizza.java`

* **`Base` (ConcreteComponent - Abstrakte Basis)**:
    * Eine abstrakte Klasse, die das `Pizza`-Interface implementiert.
    * Stellt eine Grundimplementierung für verschiedene Pizzaböden dar (definiert Preis, Schärfe, vegetarischen Status und Basisbeschreibung).
    * *Code-Referenz:* `Structural_Decorator/Example2/Base.java`
    * **Konkrete Implementierungen (ConcreteComponent):**
        * `Crunchy`: Erbt von `Base` und definiert einen knusprigen Pizzaboden mit spezifischem Preis.
            * *Code-Referenz:* `Structural_Decorator/Example2/Crunchy.java`
        * `Puffy`: Erbt von `Base` und definiert einen luftigen Pizzaboden mit spezifischem Preis.
            * *Code-Referenz:* `Structural_Decorator/Example2/Puffy.java`
        * `Sicilian`: Erbt von `Base` und definiert einen sizilianischen Pizzaboden mit spezifischem Preis.
            * *Code-Referenz:* `Structural_Decorator/Example2/Sicilian.java`
        * Dies sind die Basisobjekte, die dekoriert werden können.

* **`Topping` (Decorator)**:
    * Eine abstrakte Klasse, die ebenfalls das `Pizza`-Interface implementiert.
    * Enthält eine Referenz (`private final Pizza below;`) auf das `Pizza`-Objekt, das dekoriert wird. Dies kann entweder ein `Base`-Objekt (ein Pizzaboden) oder ein anderes, bereits dekoriertes `Topping`-Objekt sein.
    * Der Konstruktor nimmt das zu dekorierende `Pizza`-Objekt (`below`) entgegen.
    * Die meisten Methoden (`isVegetarian()`, `isHot()`, `getPrice()`) leiten die Aufrufe standardmäßig an das `below`-Objekt weiter.
    * Die Methode `getDescription()` wird typischerweise erweitert, um den Namen des aktuellen Belags zur Beschreibung des darunterliegenden Objekts hinzuzufügen (z.B. `below.getDescription() + ", " + this.getClass().getSimpleName()`).
    * *Code-Referenz:* `Structural_Decorator/Example2/Topping.java`

* **`Cheese` / `Salami` / `Chili` (ConcreteDecorator)**:
    * Konkrete Klassen, die von `Topping` erben und spezifische Beläge repräsentieren.
    * **`Cheese`**:
        * Dekoriert die Pizza mit Käse.
        * Überschreibt `getPrice()`, um den Preis für Käse zum Preis der darunterliegenden Pizza zu addieren (`1.00 + super.getPrice()`).
        * *Code-Referenz:* `Structural_Decorator/Example2/Cheese.java`
    * **`Salami`**:
        * Dekoriert die Pizza mit Salami.
        * Überschreibt `getPrice()`, um den Preis für Salami zu addieren (`1.50 + super.getPrice()`).
        * Überschreibt `isVegetarian()`, um `false` zurückzugeben.
        * *Code-Referenz:* `Structural_Decorator/Example2/Salami.java`
    * **`Chili`**:
        * Dekoriert die Pizza mit Chili.
        * Überschreibt `isHot()`, um `true` zurückzugeben. Der Preis wird in diesem spezifischen Dekorierer nicht direkt modifiziert, sondern die Implementierung von `getPrice()` aus der `Topping`-Oberklasse wird genutzt.
        * *Code-Referenz:* `Structural_Decorator/Example2/Chili.java`

## Beispielhafte Verwendung

Der Client-Code (`PizzaDecoratorDemo`) demonstriert, wie eine Pizza schrittweise aufgebaut wird:

```java
// Erstelle einen knusprigen Pizzaboden (ConcreteComponent)
Pizza pizza = new Crunchy();

// Belege die Pizza mit Käse (ConcreteDecorator)
pizza = new Cheese(pizza);
// Belege die Pizza mit einem weiteren Käse-Topping
pizza = new Cheese(pizza);

// Belege die Pizza mit Salami (ConcreteDecorator)
pizza = new Salami(pizza);

// Mache die Pizza scharf mit Chili (ConcreteDecorator)
pizza = new Chili(pizza);

// Gib die Details der fertigen, dekorierten Pizza aus
System.out.println("Pizza: " + pizza.getDescription()); // Ruft getDescription() des äußersten Dekorators auf
System.out.println("Preis: " + pizza.getPrice() + "  €");     // Ruft getPrice() des äußersten Dekorators auf
System.out.println("Vegetarisch: " + pizza.isVegetarian()); // Ruft isVegetarian() des äußersten Dekorators auf
System.out.println("Scharf: " + pizza.isHot());         // Ruft isHot() des äußersten Dekorators auf