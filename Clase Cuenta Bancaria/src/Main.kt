/**
 * Práctica 2. Programación Orientada a Objetos Kotlin
 * Descripción: Implementación de una clase CuentaBancaria que maneja un saldo
 *              y un límite de retiro, con métodos para realizar operaciones.
 * Autor: Luigui Alexander Huanca Capira
 * Fecha creación: 01/09/2024
 * Fecha última modificación: 01/09/2024
 */

class CuentaBancaria(saldoInicial: Double, private val limiteRetiro: Double) {
    // Propiedad saldo con getter y setter personalizado para validación
    private var saldo: Double = 0.0
        set(value) {
            if (value >= 0) {
                field = value
            } else {
                throw IllegalArgumentException("El saldo no puede ser negativo")
            }
        }

    // Inicializador que establece el saldo inicial
    init {
        saldo = saldoInicial
    }

    /**
     * Realiza un retiro de la cuenta bancaria.
     * @param cantidad La cantidad a retirar.
     * @return true si el retiro fue exitoso, false en caso contrario.
     * @throws IllegalArgumentException si la cantidad es negativa o cero.
     */
    fun realizarRetiro(cantidad: Double): Boolean {
        if (cantidad <= 0) {
            throw IllegalArgumentException("La cantidad a retirar debe ser positiva")
        }
        if (cantidad > limiteRetiro) {
            println("Error: La cantidad excede el límite de retiro de $limiteRetiro")
            return false
        }
        if (cantidad > saldo) {
            println("Error: Saldo insuficiente")
            return false
        }
        saldo -= cantidad
        println("Retiro exitoso. Nuevo saldo: $saldo")
        return true
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     * @return El saldo actual.
     */
    fun obtenerSaldo(): Double {
        return saldo
    }

    /**
     * Obtiene el límite de retiro de la cuenta.
     * @return El límite de retiro.
     */
    fun obtenerLimiteRetiro(): Double {
        return limiteRetiro
    }
}

/**
 * Función principal que demuestra el uso de la clase CuentaBancaria.
 */
fun main() {
    // Crear una nueva cuenta con saldo inicial de 1000 y límite de retiro de 500
    val miCuenta = CuentaBancaria(1000.0, 500.0)

    println("Saldo inicial: ${miCuenta.obtenerSaldo()}")
    println("Límite de retiro: ${miCuenta.obtenerLimiteRetiro()}")

    // Intentar retirar 300
    miCuenta.realizarRetiro(300.0)

    // Intentar retirar 600 (excede el límite)
    miCuenta.realizarRetiro(600.0)

    // Intentar retirar 800 (excede el saldo)
    miCuenta.realizarRetiro(800.0)

    println("Saldo final: ${miCuenta.obtenerSaldo()}")
}