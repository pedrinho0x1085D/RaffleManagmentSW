/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Pedro Cunha
 */
public class ExistingIDException extends Exception{
    public ExistingIDException(int id){
        super(id+"");
    }
}
