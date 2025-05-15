# Bridge Pattern: Formen und Farben Beispiel

## Konzept


* **Abstraktion**: Geometrische Formen (`Shape` wie `Circle`, `Square`).
* **Implementierung**: Farben, mit denen die Formen gefüllt werden (`Color` wie `RedColor`, `BlueColor`).

Anstatt Klassen wie `RedCircle`, `BlueSquare` usw. zu erstellen, ermöglicht das Bridge Pattern, Formen und Farben getrennt zu definieren und zur Laufzeit zu kombinieren.

## Beteiligte Klassen und Schnittstellen

* **`Color` (Implementor)**:
    * Ein Interface, das die Methode definiert, wie eine Farbe angewendet wird (z.B. `String fill()`).
    * *Code-Referenz:* `Color.java`

* **`RedColor`, `BlueColor` (ConcreteImplementor)**:
    * Konkrete Implementierungen des `Color`-Interfaces.
    * `RedColor`: Implementiert `fill()`, um "Color is Red" zurückzugeben.
    * `BlueColor`: Implementiert `fill()`, um "Color is Blue" zurückzugeben.
    * *Code-Referenz:* `RedColor.java`, `BlueColor.java`

* **`Shape` (Abstraction)**:
    * Eine abstrakte Klasse, die die allgemeine Definition einer Form darstellt.
    * Besitzt eine Referenz (`protected Color color;`) auf ein `Color`-Objekt (den Implementierer). Dies ist die "Brücke".
    * Der Konstruktor nimmt ein `Color`-Objekt entgegen.
    * Definiert eine abstrakte Methode, z.B. `String draw()`.
    * *Code-Referenz:* `Shape.java`

* **`Square`, `Circle` (RefinedAbstraction)**:
    * Konkrete Klassen, die von `Shape` erben.
    * Implementieren die `draw()`-Methode. In ihrer Implementierung rufen sie die `fill()`-Methode des `color`-Objekts auf, um die Form mit der spezifischen Farbe zu "zeichnen".
    * *Code-Referenz:* `Square.java`, `Circle.java`

