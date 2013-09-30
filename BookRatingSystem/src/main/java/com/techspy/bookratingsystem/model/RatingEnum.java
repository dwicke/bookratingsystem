/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.model;

/**
 *
 * @author drew
 */
public enum RatingEnum {
    HELPFUL("Helpfulness"),
    CLARITY("Clarity"),
    EASINESS("Easiness"),
    OVERALL("Overall");
    
    private String text;
    
    RatingEnum(String text) {
        this.text = text;
    }
    
    public String getText() {
        return this.text;
    }
    public static RatingEnum fromString(String text) {
    if (text != null) {
      for (RatingEnum b : RatingEnum.values()) {
        if (text.equalsIgnoreCase(b.text)) {
          return b;
        }
      }
    }
    return null;
  }
    
}
