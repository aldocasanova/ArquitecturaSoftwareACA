interface CanalMensaje {
    void enviar(String mensaje);
}

class Email implements CanalMensaje {
    public void enviar(String mensaje) { System.out.println("Email: " + mensaje); }
}

class SMS implements CanalMensaje {
    public void enviar(String mensaje) { System.out.println("SMS: " + mensaje); }
}

class WhatsApp implements CanalMensaje {
    public void enviar(String mensaje) { System.out.println("WhatsApp: " + mensaje); }
}

class Notificacion {
    private CanalMensaje canal;
    public Notificacion(CanalMensaje canal) { this.canal = canal; }
    public void enviar(String mensaje) { canal.enviar(mensaje); }
}

class MainNotificacion {
    public static void main(String[] args) {
        Notificacion n1 = new Notificacion(new Email());
        n1.enviar("Hola por Email");

        Notificacion n2 = new Notificacion(new SMS());
        n2.enviar("Hola por SMS");

        Notificacion n3 = new Notificacion(new WhatsApp());
        n3.enviar("Hola por WhatsApp");
    }
}

/*
PROBLEMA (en la versión original):
- Una clase Notificacion con métodos específicos (enviarEmail, enviarSMS, enviarWhatsApp)
  viola SRP (demasiadas responsabilidades) y OCP (para agregar un canal hay que MODIFICAR la clase).
  También complica DIP, pues depende de detalles concretos.

SOLUCIÓN (aplicando SOLID):
- Definir la abstracción CanalMensaje y delegar el envío a implementaciones (Email, SMS, WhatsApp).
- Notificacion depende de la ABSTRACCIÓN (DIP), y agregar nuevos canales no modifica Notificacion (OCP).
- Cada clase tiene su única responsabilidad (SRP).
*/
