package Structural_Bridge.Uebung;

public class BluetoothTransmission implements DataTransmission {
    @Override
    public void transmit(String data) {
        System.out.println("via Bluetooth: " + data);
    }
}
