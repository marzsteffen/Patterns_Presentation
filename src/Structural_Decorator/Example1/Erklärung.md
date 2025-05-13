# Decorator Pattern: Kaffee-Beispiel


## Beteiligte Klassen und Schnittstellen

Basierend auf dem Klassendiagramm des Decorator Patterns lassen sich folgende Elemente in unserem Kaffee-Beispiel identifizieren:

* **`Coffee` (Component)**:
    * Ein Interface, das die Methoden definiert, die sowohl von den Basis-Kaffeesorten als auch von den Dekoratoren implementiert werden müssen.
    * Typische Methoden: `double getCost()` und `String getDescription()`.

* **`SimpleCoffee` / `Espresso` (ConcreteComponent)**:
    * Konkrete Implementierungen des `Coffee`-Interfaces.
    * `SimpleCoffee`: Repräsentiert einen einfachen Kaffee mit einem Grundpreis.
    * `Espresso`: Repräsentiert einen Espresso mit einem Grundpreis.
    * Dies sind die Objekte, die dekoriert werden können.

* **`CoffeeDecorator` (Decorator)**:
    * Eine abstrakte Klasse, die das `Coffee`-Interface implementiert.
    * Besitzt eine Instanzvariable vom Typ `Coffee` (z.B. `protected Coffee decoratedCoffee;`). Diese Variable hält die Referenz auf das zu dekorierende Objekt.
    * Der Konstruktor nimmt ein `Coffee`-Objekt entgegen, das dekoriert werden soll.
    * Die Methoden `getCost()` und `getDescription()` rufen typischerweise die entsprechenden Methoden des `decoratedCoffee`-Objekts auf.

* **`MilkDecorator` / `SugarDecorator` (ConcreteDecorator)**:
    * Konkrete Klassen, die von `CoffeeDecorator` erben.
    * `MilkDecorator`: Fügt Milch hinzu. Überschreibt `getCost()`, um den Preis für Milch hinzuzufügen, und `getDescription()`, um "Milch" zur Beschreibung hinzuzufügen.
    * `SugarDecorator`: Fügt Zucker hinzu. Überschreibt `getCost()`, um den Preis für Zucker hinzuzufügen, und `getDescription()`, um "Zucker" zur Beschreibung hinzuzufügen.

## Beispielhafte Verwendung

```java
// Erstelle einen einfachen Kaffee
Coffee coffee = new SimpleCoffee();
System.out.println("Erstellter Kaffee: " + coffee.getDescription() + " || Preis: " + coffee.getCost() + " €");

// Dekoriere ihn mit Milch
coffee = new MilkDecorator(coffee);
System.out.println("Erstellter Kaffee: " + coffee.getDescription() + " || Preis: " + coffee.getCost()+ " €");

// Dekoriere ihn zusätzlich mit Zucker
coffee = new SugarDecorator(coffee);
System.out.println("Erstellter Kaffee: " + coffee.getDescription() + " || Preis: " + coffee.getCost()+ " €");