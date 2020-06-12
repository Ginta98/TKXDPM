/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OfficeSide.Controller;

/**
 *
 * @author Wind
 */
public class Sample {
    
    private Sample() {
    }
    
    public static Sample getInstance() {
        return SampleHolder.INSTANCE;
    }
    
    private static class SampleHolder {

        private static final Sample INSTANCE = new Sample();
    }
}
