package org.prog.poly.homework;

 public class AndroidPhone implements ICellPhone{
  @Override
  public void call(){
   System.out.println("AndroidPhone cans call.");
  }
  @Override
  public void scanBiometrics(){
   System.out.println("AndroidPhone scans your biometrics.");
  }
  @Override
  public void makePhoto(){
   System.out.println("ApplePhone makes photo for you.");}
}
