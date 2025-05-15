package Structural_Bridge.Uebung;

public class WifiTransmission implements DataTransmission{
    @Override
    public void transmit(String data) {
        System.out.println("via WiFi: " + data);
    }
}
