interface Ave {
    void mostrar();
}

interface AveVoladora extends Ave {
    void volar();
}

class Gorrion implements AveVoladora {
    public void volar() { System.out.println("Gorrión volando!"); }
    public void mostrar() { System.out.println("Soy un gorrión"); }
}

class Pinguino implements Ave {
    public void mostrar() { System.out.println("Soy un pingüino, nado!"); }
}

class Aguila implements AveVoladora {
    public void volar() { System.out.println("Águila volando alto!"); }
    public void mostrar() { System.out.println("Soy un águila"); }
}

class Avestruz implements Ave {
    public void mostrar() { System.out.println("Soy un avestruz, corro!"); }
}

class MainLSP {
    public static void main(String[] args) {
        AveVoladora v1 = new Gorrion();
        AveVoladora v2 = new Aguila();
        Ave a1 = new Pinguino();
        Ave a2 = new Avestruz();

        v1.volar();
        v2.volar();
        a1.mostrar();
        a2.mostrar();

        // Sustitución sin excepciones: donde se espera Ave, sirve cualquier ave.
        Ave ave = a1; // pingüino como Ave
        ave.mostrar();
    }
}

/*
PROBLEMA (violación LSP):
Poner un Pinguino como subclase de Ave con método volar() hace que al usar "volar" lance excepciones,
rompiendo la sustitución (no puedo usar un Pinguino donde se espera un Ave que vuele).

SOLUCIÓN:
Separar comportamientos:
- Ave (no asume volar).
- AveVoladora (extiende Ave y agrega volar()).
Pingüino y Avestruz implementan Ave (no vuelan); Gorrión y Águila implementan AveVoladora.
Así, cualquier subclase puede sustituir a su supertipo sin romper contratos.
*/
