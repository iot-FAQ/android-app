package com.example.andriy.i_met;

public class Device {
    private TypeDevice typeDevice;
    private String name;
    private int data;
    public Device(){

    }
    public Device(String name, TypeDevice typeDevice){
        this.name=name;
        this.typeDevice=typeDevice;
    }
    public Device(String name, TypeDevice typeDevice, int data){
        this.name=name;
        this.data=data;
        this.typeDevice=typeDevice;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
