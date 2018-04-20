/*
 *     Server-Side Composition model class
 *     Composition.java
 *     Created Mar 06, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Composition {

    public Composition() {
        title = null;
        year = null;
        compositionID = null;
        desc = null;
        accountId = null;
        isViewablePublicly = null;
    }

    private String title;
    private Integer year;
    private Integer compositionID;
    private String desc;
    private Integer accountId;
    private Integer isViewablePublicly;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {return year;}

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCompositionID()
    {
        return compositionID;
    }

    public void setCompositionID(Integer compositionID)
    {
        this.compositionID = compositionID;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAccountId() {
        return this.accountId;
    }

    /**
     *
     * @param isViewablePublicly 0 indicates composition is not viewable publicly, 1 indicates that composition
     *                           is viewable publicly
     */
    public void setIsViewablePublicly(Integer isViewablePublicly) {
        this.isViewablePublicly = isViewablePublicly;
    }

    /**
     *
     * @return 0 indicates composition is not viewable publicly, 1 indicates that composition
     * is viewable publicly
     */
    public Integer getIsViewablePublicly() {
        return this.isViewablePublicly;
    }
}