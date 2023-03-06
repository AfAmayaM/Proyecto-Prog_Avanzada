package co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence;

public class Producto {

    private Categoria categoria;

    public static void main(String[] args) {

        Producto producto = new Producto();
        producto.categoria = Categoria.TECNOLOGIA;

        System.out.println(producto.categoria.name());
    }
}



