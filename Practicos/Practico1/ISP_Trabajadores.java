interface Trabajador {
    void trabajar();
}

interface Comedor {
    void comer();
}

interface Dormilon {
    void dormir();
}

class Empleado implements Trabajador, Comedor, Dormilon {
    public void trabajar() { System.out.println("Empleado trabajando"); }
    public void comer() { System.out.println("Empleado comiendo"); }
    public void dormir() { System.out.println("Empleado durmiendo"); }
}

class Robot implements Trabajador {
    public void trabajar() { System.out.println("Robot trabajando"); }
}

class MainISP {
    public static void main(String[] args) {
        Empleado e = new Empleado();
        e.trabajar();
        e.comer();
        e.dormir();

        Robot r = new Robot();
        r.trabajar();
    }
}

/*
PROBLEMA (violación ISP):
Una única interfaz grande obligaba a Robot a implementar métodos que no necesita (comer, dormir),
lo que llevaba a implementar métodos “vacíos” o lanzar excepciones.

SOLUCIÓN:
Segregar en interfaces pequeñas y específicas (Trabajador, Comedor, Dormilon).
Cada clase implementa sólo lo que realmente usa.
*/
