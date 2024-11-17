package org.prog.equalshashcode.homework;

/**
 * Write inheritance classes with depth of 4:
 * classA > classB > classC > classD
 *
 * Add a method to base class
 * Override that method in classB and classD slots
 *
 * Add method with overload to any class with at least 3 samples
 * method(a), method(a,b) method(a,b,c)
 */
public class OverrideOverloadHomework {
    public static void main (String[] args){
        var groupA = new GroupA();
        var groupB = new GroupB();
        var groupC = new GroupC();
        var groupD = new GroupD();

         groupA.doTheAction();
         groupB.doTheAction();
         groupC.doTheAction();
         groupD.doTheAction();
         GroupC.actionX("First parameter");
         GroupC.actionX( "First parameter","Second parameter");
         GroupC.actionX("First parameter","Second parameter","Third parameter");

    }


}

