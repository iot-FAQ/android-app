package com.example.andriy.i_met;

public class Device {
    private TypeDevice typeDevice;
    private String address;
    private int data;
    private int serialNumber;

    public Device() {

    }

    public Device(String address, TypeDevice typeDevice) {
        this.address = address;
        this.typeDevice = typeDevice;
    }

    public Device(String address, TypeDevice typeDevice, int serialNumber) {
        this.address = address;
        this.serialNumber = serialNumber;
        this.typeDevice = typeDevice;
    }

    public Device(String address, TypeDevice typeDevice, int data, int serialNumber) {
        this.address = address;
        this.typeDevice = typeDevice;
        this.data = data;
        this.serialNumber = serialNumber;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSerialNumber(int serianNumber) {
        this.serialNumber = serianNumber;
    }

    public TypeDevice getTypeDevice() {
        return typeDevice;
    }

    public void setTypeDevice(TypeDevice typeDevice) {
        this.typeDevice = typeDevice;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

}
