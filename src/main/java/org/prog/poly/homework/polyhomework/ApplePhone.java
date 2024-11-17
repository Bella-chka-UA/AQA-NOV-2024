package org.prog.poly.homework.polyhomework;

public class ApplePhone implements ICellPhone{
    @Override
    public void call(){
        System.out.println("ApplePhone cans call.");
    }
    @Override
    public void scanBiometrics(){
        System.out.println("ApplePhone scans your biometrics.");
    }
    @Override
    public void makePhoto(){
    System.out.println("ApplePhone makes a photo for you.");}
}
