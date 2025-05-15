package Structural_Bridge.Uebung;

public class HeartRateSensor extends MedicalDevice{
    public HeartRateSensor(DataTransmission transmission) {
        super(transmission);
    }

    @Override
    public void sendData() {
        String data = "[HeartRateSensor] Sending data: 75 bpm ";
        System.out.print(data);
        transmission.transmit("75 bpm");
    }
}
