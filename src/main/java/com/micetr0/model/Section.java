/*
 *     Server-Side Section model class
 *     Section.java
 *     Created Mar 06, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.model;

public class Section {

    private String owningComp = null;
    private String sectionID = null;



    //more fields needed

    public String getOwningComp(){return owningComp;}
    public void setOwningComp(String owningComp) {this.owningComp = owningComp;}
    public String getsectionID(){return sectionID;}
    public void setSectionID(String ID){this.sectionID = ID;}
}
