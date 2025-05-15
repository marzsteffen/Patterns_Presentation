## Aufgabe:
In einem System sollen verschiedene medizinische Geräte (z. B. Herzfrequenzsensor, Blutzuckermessgerät) Daten über unterschiedliche Übertragungsmethoden (z. B. Bluetooth, WLAN) an ein zentrales System senden.

Diese Geräte und ihre Übertragungsmethoden sollen unabhängig voneinander erweitert werden können – z. B. neue Gerätetypen oder neue Übertragungstechnologien.

**Ziel:** Implementiere das Bridge Pattern, um die Kopplung zwischen Gerät und Übertragungsmethode zu lösen.

## Anforderungen:
1. Es soll eine abstrakte Klasse oder ein Interface für `MedicalDevice` geben.
2. Die Übertragungsmethode (`DataTransmission`) soll eine eigene Hierarchie sein.
3. `MedicalDevice` verwendet eine Referenz auf `DataTransmission`, um Daten zu senden.
4. Implementiere zwei konkrete Geräte:
    - `HeartRateSensor`
    - `BloodSugarMeter`
5. Implementiere zwei Übertragungsmethoden:
    - `BluetoothTransmission`
    - `WiFiTransmission`
6. Zeige im `main`, wie ein Gerät mit unterschiedlichen Übertragungsmethoden arbeitet.

## Beispielausgabe:
[HeartRateSensor] Sending data: 75 bpm via Bluetooth.

[BloodSugarMeter] Sending data: 120 mg/dL via WiFi.




# Tipps:

## Klassenstruktur:

- **Abstraktion (Bridge):**
    - `MedicalDevice` (abstract)
        - `HeartRateSensor`
        - `BloodSugarMeter`

- **Implementierung (Implementor):**
    - `DataTransmission` (interface)
        - `BluetoothTransmission`
        - `WiFiTransmission`





