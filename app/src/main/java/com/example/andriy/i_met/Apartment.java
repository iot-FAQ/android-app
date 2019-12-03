package com.example.andriy.i_met;

import java.util.ArrayList;

public class Apartment {
    ArrayList<Device> arrayDevice;
    String adress;
    public Apartment(String adress){
        this.adress=adress;
        arrayDevice=new ArrayList<>();
    }

    public ArrayList<Device> getArrayDevice() {
        return arrayDevice;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setArrayDevice(ArrayList<Device> arrayDevice) {
        this.arrayDevice = arrayDevice;
    }

    public void addDevice(Device newDevice){
        arrayDevice.add(newDevice);
    }
}
