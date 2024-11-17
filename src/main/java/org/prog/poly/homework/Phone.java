package org.prog.poly.homework;

public class Phone implements ICellPhone {
    @Override
    public void call() {
        System.out.println("Phone cans call.");
    }

    @Override
    public void scanBiometrics() {
        System.out.println("Phone not scans your biometrics.");
    }

    @Override
    public void makePhoto() {
        System.out.println("Phone can`t take photo for you.");
    }
}