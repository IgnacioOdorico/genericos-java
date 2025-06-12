import java.util.ArrayList;
import java.util.List;

class Carrito<T extends Producto<?>> {
    private List<T> productos;

    // Constructor
    public Carrito() {
        this.productos = new ArrayList<>();
    }

    // Agregar un producto al carrito
    public void agregarProducto(T producto) {
        productos.add(producto);
    }

    // Eliminar un producto del carrito
    public void eliminarProducto(T producto) {
        productos.remove(producto);
    }

    // Calcular el total sumando los precios de todos los productos
    public double obtenerTotal() {
        double total = 0.0;
        for (T producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    // Mostrar todos los productos del carrito
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }

        System.out.println("Productos en el carrito:");
        for (T producto : productos) {
            System.out.println(producto);
        }
        System.out.printf("Total del carrito: $%.2f%n", obtenerTotal());
    }
}