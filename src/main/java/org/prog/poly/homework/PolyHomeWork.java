package org.prog.poly.homework;

/** TODO: HOMEWORK
 * Write interface for a cell phone which can (ICellPhone):
 * - call
 * - scan biometrics
 * - make photo
 *
 * Add Adnroid and Apple phones which implement this interface
 * Write method that will accept ICellPhone as parameter
 * And it will scan,make photo, call;
 */
public class PolyHomeWork {
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
