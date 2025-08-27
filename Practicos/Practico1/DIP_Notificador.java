interface Canal {
    void enviar(String mensaje);
}

class EmailServicio implements Canal {
    public void enviar(String mensaje) {
        System.out.println("Enviando Email: " + mensaje);
    }
}

class TelegramServicio implements Canal {
    public void enviar(String mensaje) {
        System.out.println("Enviando Telegram: " + mensaje);
    }
}

class Notificador {
    private Canal canal;

    public Notificador(Canal canal) { // inyección por constructor
        this.canal = canal;
    }

    // También se podría ofrecer un setter para cambiar el canal en runtime.
    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    public void notificar(String mensaje) {
        canal.enviar(mensaje);
    }
}

class MainDIP {
    public static void main(String[] args) {
        Notificador n1 = new Notificador(new EmailServicio());
        n1.notificar("Hola por Email");

        Notificador n2 = new Notificador(new TelegramServicio());
        n2.notificar("Hola por Telegram");

        // Cambio de dependencia por setter (opcional)
        n2.setCanal(new EmailServicio());
        n2.notificar("Ahora por Email otra vez");
    }
}

/*
PROBLEMA (violación DIP):
La clase de alto nivel Notificador dependía directamente de EmailServicio (detalle concreto).
Esto dificulta cambiar el medio de envío y probar con dobles/mocks.

SOLUCIÓN:
Crear la abstracción Canal y hacer que Notificador dependa de Canal (no de clases concretas).
Inyectar la implementación deseada (EmailServicio, TelegramServicio, etc.) por constructor o setter.
*/
