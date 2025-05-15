package Structural_Bridge.Uebung;

//Abstraction
public abstract class MedicalDevice {
    protected DataTransmission transmission;

    public MedicalDevice(DataTransmission transmission) {
        this.transmission = transmission;
    }

    public abstract void sendData();
}
