/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Alberto
 */
public enum Rating {
    G("G"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    NC_17("NC-17");
    
    private final String desc;
    
    private Rating(String name) {
        desc = name;
    }

    @Override
    public String toString() {
        return desc;
    }
}
