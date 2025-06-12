import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear una lista de productos con diferentes tipos de identificadores
        List<Producto<?>> productos = new ArrayList<>();

        // Producto con ID Integer
        productos.add(new Producto<>(1, "Laptop", 999.99));

        // Producto con ID String (SKU)
        productos.add(new Producto<>("jkasdi1984", "Teléfono", 499.99));

        // Producto con ID Long
        productos.add(new Producto<>(123456789L, "Tablet", 299.99));
        Producto<Integer> mouse = new Producto<>(2, "Mouse", 25.50);

        // Imprimir la lista de productos
        for (Producto<?> producto : productos) {
            System.out.println(producto);
        }

        // Crear un carrito de productos
        Carrito<Producto<?>> carrito = new Carrito<>();

        // Crear algunos productos con diferentes tipos de ID
        Producto<Integer> laptop = new Producto<>(1, "Laptop", 999.99);
        Producto<String> telefono = new Producto<>("SKU123", "Teléfono", 499.99);
        Producto<Long> tablet = new Producto<>(123456L, "Tablet", 299.99);

        // Agregar productos al carrito
        carrito.agregarProducto(laptop);
        carrito.agregarProducto(telefono);
        carrito.agregarProducto(tablet);

        // Mostrar contenido del carrito
        carrito.mostrarProductos();

        // Eliminar un producto
        carrito.eliminarProducto(telefono);
        System.out.println("\nDespués de eliminar el teléfono:");
        carrito.mostrarProductos();

        // Crear pedidos con diferentes fechas
        Pedido pedido1 = new Pedido(1, LocalDate.of(2023, 5, 15));
        pedido1.agregarProducto(laptop);
        pedido1.agregarProducto(mouse);

        Pedido pedido2 = new Pedido(2, LocalDate.of(2023, 3, 10));
        pedido2.agregarProducto(telefono);
        pedido2.agregarProducto(tablet);
        pedido2.agregarProducto(mouse);

        Pedido pedido3 = new Pedido(3, LocalDate.of(2023, 6, 1));
        pedido3.agregarProducto(tablet);

        // Lista de pedidos
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        // Ordenar por total (usando Comparable)
        System.out.println("Pedidos ordenados por total (ascendente):");
        Collections.sort(pedidos);
        pedidos.forEach(System.out::println);

        // Ordenar por fecha (usando Comparator)
        System.out.println("\nPedidos ordenados por fecha (ascendente):");
        Collections.sort(pedidos, new ComparadorPedidosPorFecha());
        pedidos.forEach(System.out::println);

        // También se puede usar con lambda
        System.out.println("\nPedidos ordenados por fecha (descendente):");
        Collections.sort(pedidos, (p1, p2) -> p2.getFecha().compareTo(p1.getFecha()));
        pedidos.forEach(System.out::println);
    }
}