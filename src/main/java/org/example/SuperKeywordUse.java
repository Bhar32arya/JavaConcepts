package org.example;
/*If the superclass has fields that are not accessible directly (e.g., private or protected),
the subclass constructor can use parameters to initialize these fields by calling the superclass constructor.*/
class GrandParent {
    protected int grandVariable;
    public GrandParent(int grandVariable) {
        this.grandVariable = grandVariable;
    }
    public int getGrandVariable() {
        return grandVariable;
    }
}
class Parent extends GrandParent {
    protected int parentVariable;
    public Parent(int parentVariable, int grandVariable) {
        super(grandVariable);
        this.parentVariable = parentVariable;

    }
    public int getParentVariable() {
        return parentVariable;
    }
}
class child extends Parent {
    protected int childVariable;
    public child(int parentVariable, int grandVariable, int childVariable) {
        super(parentVariable, grandVariable);
        this.childVariable = childVariable;
    }
    public int getChildVariable() {
        return childVariable;
    }
    public void accessVariables() {
        // Access variables from the grandparent, parent, and child classes
        //super.super is not allowed
        System.out.println("Grandparent Variable: " + getParentVariable());
        System.out.println("Parent Variable: " + super.parentVariable);
        System.out.println("Child Variable: " + this.childVariable);
    }
}
public class SuperKeywordUse {
    public static void main(String[] args) {

    }
}
