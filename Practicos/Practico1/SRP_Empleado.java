class Empleado {
    private String nombre;
    private double salarioBase;
    private double horasExtras;

    public Empleado(String nombre, double salarioBase, double horasExtras) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.horasExtras = horasExtras;
    }

    public double calcularSalario() {
        return salarioBase + (horasExtras * 10);
    }

    public String getNombre() { return nombre; }
}

class ReporteEmpleado {
    public void imprimir(Empleado e) {
        System.out.println("=== Reporte de Empleado ===");
        System.out.println("Nombre: " + e.getNombre());
        System.out.println("Salario Total: " + e.calcularSalario());
    }
}

class MainSRP {
    public static void main(String[] args) {
        Empleado emp = new Empleado("Ana", 800, 5);
        new ReporteEmpleado().imprimir(emp);
    }
}

/*
PROBLEMA (violación SRP):
La clase Empleado calculaba el salario y también imprimía el reporte.
Esto mezcla dos responsabilidades: Cálculo de negocio + Presentación/Salida.

SOLUCIÓN:
Separar responsabilidades:
- Empleado: sólo conoce sus datos y cómo calcular su salario.
- ReporteEmpleado: se encarga de imprimir el reporte.
Beneficios: menor acoplamiento, más fácil probar y cambiar la presentación sin tocar el cálculo.
*/
