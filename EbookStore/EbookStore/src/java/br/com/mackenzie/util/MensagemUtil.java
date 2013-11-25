/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author limagr
 */
public class MensagemUtil {
    
    public static void mensagemAviso(String msg){
         FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));          
    }
    
     public static void mensagemErro(String msg){
         FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));          
    }
}
