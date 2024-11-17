package org.prog.poly.homework.polyhomework;

public class MyPhone {

    public static void main(String[] args) {
        Phone phone = new Phone();
        AndroidPhone androidPhone = new AndroidPhone();
        ApplePhone applePhone = new ApplePhone();

        using(phone);
        using(androidPhone);
        using(applePhone);


        }
        public static void using(ICellPhone iCellPhone) {
            iCellPhone.call();
            iCellPhone.scanBiometrics();
            iCellPhone.makePhoto();
            iCellPhone.call();
        }
}