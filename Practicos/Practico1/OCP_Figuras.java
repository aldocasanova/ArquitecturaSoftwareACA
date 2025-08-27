interface Figura {
    double calcularArea();
}

class Circulo implements Figura {
    double radio;
    public Circulo(double radio) { this.radio = radio; }
    public double calcularArea() { return Math.PI * radio * radio; }
}

class Rectangulo implements Figura {
    double ancho, alto;
    public Rectangulo(double ancho, double alto) { this.ancho = ancho; this.alto = alto; }
    public double calcularArea() { return ancho * alto; }
}

class Triangulo implements Figura {
    double base, altura;
    public Triangulo(double base, double altura) { this.base = base; this.altura = altura; }
    public double calcularArea() { return (base * altura) / 2.0; }
}

class MainOCP {
    public static void main(String[] args) {
        Figura f1 = new Circulo(5);
        Figura f2 = new Rectangulo(4,6);
        Figura f3 = new Triangulo(3,4);

        System.out.println("Área círculo: " + f1.calcularArea());
        System.out.println("Área rectángulo: " + f2.calcularArea());
        System.out.println("Área triángulo: " + f3.calcularArea());
    }
}

/*
PROBLEMA (violación OCP):
Una calculadora con if/instanceof obliga a MODIFICAR el método cada vez que agregamos una nueva figura.

SOLUCIÓN:
Definir una abstracción (Figura) con un método calcularArea() e implementar el polimorfismo en cada figura.
Ahora, para agregar una nueva figura sólo creamos una nueva clase que implemente Figura, SIN modificar el código existente.
*/
