//mensajes que se muestran en pantalla de cliente

package com.backendportfolio.portfolio.Dto;


public class Mensaje {
    
    private String mensaje;

    //constructor
    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    //getters y setters

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
