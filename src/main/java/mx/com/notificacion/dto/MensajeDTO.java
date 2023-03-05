package mx.com.notificacion.dto;


import java.io.Serializable;

public class MensajeDTO implements Serializable {

   private static final long serialVersionUID = 1L;

   private String mensaje;
   private String mensajeError;
   private Boolean correcto;

   public String getMensaje() {
      return mensaje;
   }

   public void setMensaje(String mensaje) {
      this.mensaje = mensaje;
   }

   public String getMensajeError() {
      return mensajeError;
   }

   public void setMensajeError(String mensajeError) {
      this.mensajeError = mensajeError;
   }

   public Boolean getCorrecto() {
      return correcto;
   }

   public void setCorrecto(Boolean correcto) {
      this.correcto = correcto;
   }

}

