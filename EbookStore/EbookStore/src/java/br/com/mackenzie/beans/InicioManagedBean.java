/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.beans;

import br.com.mackenzie.service.AutorService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Graciela Miranda
 */
@ManagedBean
public class InicioManagedBean {

    @EJB
    AutorService autorService ;
    /**
     * Creates a new instance of InicioManagedBean
     */
    public InicioManagedBean() {
    }
    
    public void inserir(){
        autorService.inserir(null);
    }
    public void  listarTodos(){
        autorService.listarAutores();
    }
}
