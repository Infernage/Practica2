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
public enum SpecialFeatures {
    Trailers("Trailers"),
    Commentaries("Commentaries"),
    DeletedScenes("Deleted Scenes"),
    BehindTheScenes("Behind the Scenes");
    
    private final String desc;

    private SpecialFeatures(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
