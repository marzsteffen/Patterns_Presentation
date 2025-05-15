package Structural_Bridge.Uebung;

public class BloodSugarMeter extends  MedicalDevice{
    public BloodSugarMeter(DataTransmission transmission) {
        super(transmission);
    }

    @Override
    public void sendData() {
        String data = "[BloodSugarMeter] Sending data: 120 mg/dL ";
        System.out.print(data);
        transmission.transmit("120 mg/dL");
    }
}
