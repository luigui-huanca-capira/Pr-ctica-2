/**
 * Práctica 2. Programación Orientada a Objetos Kotlin
 * Descripción: Implementación de una clase Producto que maneja un precio
 *              y un descuento, con métodos para calcular el precio final.
 * Autor:Luigui Alexander Huanca Capira
 * Fecha creación: 01/09/2024
 * Fecha última modificación: 01/09/2024
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