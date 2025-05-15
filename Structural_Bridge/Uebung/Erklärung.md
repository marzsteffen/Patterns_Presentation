## Erklärung des Java-Codes (Markdown)


# Erklärung des Java-Codes: Bridge Pattern im eHealth-Kontext

Der gezeigte Java-Code implementiert das Bridge Pattern, um die Kopplung zwischen medizinischen Geräten und ihren Datenübertragungsmethoden zu lösen. Hier ist eine Erklärung der Hauptbestandteile:

## 1. `DataTransmission` (Interface)
Dieses Interface definiert die Methode:
```java
void transmit(String data);
```
Es stellt die **Brücke** dar, über die die Datenübertragung abstrahiert wird.

## 2. Konkrete Implementierungen von `DataTransmission`

* **BluetoothTransmission**: Implementiert `transmit` mit einer Bluetooth-spezifischen Logik.
* **WiFiTransmission**: Implementiert `transmit` mit einer WLAN-spezifischen Logik.

Diese Klassen sind **austauschbar** und können unabhängig vom Gerät entwickelt werden.

## 3. `MedicalDevice` (Abstrakte Klasse)

Diese Klasse enthält eine Referenz auf ein `DataTransmission`-Objekt:

```java
protected DataTransmission transmission;
```

Die Methode `sendData()` ist abstrakt und wird in konkreten Subklassen definiert.
Ziel: Trennung der Gerätespezifikation von der Übertragungstechnologie.

## 4. Konkrete Geräteklassen

* **HeartRateSensor**: Simuliert das Senden eines Herzfrequenzwerts.
* **BloodSugarMeter**: Simuliert das Senden eines Blutzuckerwerts.

Beide verwenden die `transmission`-Referenz, um ihre Daten zu übertragen.

## 5. `main`-Methode

In der `main`-Methode wird gezeigt, wie Geräte mit verschiedenen Übertragungsarten kombiniert werden:

```java
MedicalDevice heartSensor = new HeartRateSensor(new BluetoothTransmission());
MedicalDevice sugarMeter = new BloodSugarMeter(new WiFiTransmission());
```

Ausgabe: 

```
[HeartRateSensor] Sending data: 75 bpm via Bluetooth
[BloodSugarMeter] Sending data: 120 mg/dL via WiFi
```






