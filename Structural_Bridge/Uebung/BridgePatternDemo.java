package Structural_Bridge.Uebung;

public class BridgePatternDemo {
    public static void main(String[] args) {

            MedicalDevice heartSensor = new HeartRateSensor(new BluetoothTransmission());
            MedicalDevice sugarMeter = new BloodSugarMeter(new WifiTransmission());

            heartSensor.sendData();
            sugarMeter.sendData();

    }
}
