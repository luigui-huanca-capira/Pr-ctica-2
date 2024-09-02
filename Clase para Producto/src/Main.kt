/**
 * Práctica 2. Programación Orientada a Objetos Kotlin
 * Descripción: Implementación de una clase Producto que maneja un precio
 *              y un descuento, con métodos para calcular el precio final.
 * Autor: [Tu nombre aquí]
 * Fecha creación: [Fecha actual]
 * Fecha última modificación: [Fecha actual]
 */

class Producto(precioInicial: Double, descuentoInicial: Double) {
    // Propiedad precio con getter y setter personalizado para validación
    var precio: Double = 0.0
        set(value) {
            if (value >= 0) {
                field = value
            } else {
                throw IllegalArgumentException("El precio no puede ser negativo")
            }
        }

    // Propiedad descuento con getter y setter personalizado para validación
    var descuento: Double = 0.0
        set(value) {
            if (value in 0.0..100.0) {
                field = value
            } else {
                throw IllegalArgumentException("El descuento debe estar entre 0 y 100")
            }
        }

    // Inicializador que establece el precio y descuento iniciales
    init {
        precio = precioInicial
        descuento = descuentoInicial
    }

    /**
     * Calcula el precio final después de aplicar el descuento.
     * @return El precio final con el descuento aplicado.
     */
    fun calcularPrecioFinal(): Double {
        val descuentoAplicado = precio * (descuento / 100)
        return precio - descuentoAplicado
    }

    /**
     * Obtiene el precio actual del producto.
     * @return El precio actual.
     */
    fun obtenerPrecio(): Double {
        return precio
    }

    /**
     * Obtiene el descuento actual del producto.
     * @return El descuento actual.
     */
    fun obtenerDescuento(): Double {
        return descuento
    }
}

/**
 * Función principal que demuestra el uso de la clase Producto.
 */
fun main() {
    // Crear un nuevo producto con precio inicial de 100 y descuento de 10%
    val miProducto = Producto(100.0, 10.0)

    println("Precio inicial: ${miProducto.obtenerPrecio()}")
    println("Descuento inicial: ${miProducto.obtenerDescuento()}%")
    println("Precio final: ${miProducto.calcularPrecioFinal()}")

    // Cambiar el precio y el descuento
    miProducto.precio = 120.0
    miProducto.descuento = 15.0

    println("\nNuevo precio: ${miProducto.obtenerPrecio()}")
    println("Nuevo descuento: ${miProducto.obtenerDescuento()}%")
    println("Nuevo precio final: ${miProducto.calcularPrecioFinal()}")

    // Intentar establecer un precio negativo (esto lanzará una excepción)
    try {
        miProducto.precio = -50.0
    } catch (e: IllegalArgumentException) {
        println("\nError: ${e.message}")
    }

    // Intentar establecer un descuento fuera del rango válido (esto lanzará una excepción)
    try {
        miProducto.descuento = 150.0
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}