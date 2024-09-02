/**
 * Práctica 2. Programación Orientada a Objetos Kotlin
 * Descripción: Implementación de una jerarquía de clases para figuras geométricas,
 *              incluyendo una clase abstracta Shape y subclases para Cuadrado,
 *              Círculo y Rectángulo.
 * Autor: Luigui Alexander Huanca Capira
 * Fecha creación: 01/29/2024
 * Fecha última modificación: 01/29/2024
 */

import kotlin.math.PI

// Clase abstracta Shape
abstract class Shape {
    abstract val area: Double
    abstract val perimetro: Double

    /**
     * Calcula el área de la figura.
     */
    abstract fun calcularArea()

    /**
     * Calcula el perímetro de la figura.
     */
    abstract fun calcularPerimetro()

    /**
     * Imprime los resultados de área y perímetro.
     */
    fun imprimirResultados() {
        println("Área: $area")
        println("Perímetro: $perimetro")
    }
}

// Subclase Cuadrado
class Cuadrado : Shape {
    private var lado: Double = 0.0
    override var area: Double = 0.0
    override var perimetro: Double = 0.0

    // Constructor secundario
    constructor(lado: Double) {
        this.lado = lado
        calcularArea()
        calcularPerimetro()
    }

    override fun calcularArea() {
        area = lado * lado
    }

    override fun calcularPerimetro() {
        perimetro = 4 * lado
    }
}

// Subclase Circulo
class Circulo : Shape {
    private var radio: Double = 0.0
    override var area: Double = 0.0
    override var perimetro: Double = 0.0

    // Constructor secundario
    constructor(radio: Double) {
        this.radio = radio
        calcularArea()
        calcularPerimetro()
    }

    override fun calcularArea() {
        area = PI * radio * radio
    }

    override fun calcularPerimetro() {
        perimetro = 2 * PI * radio
    }
}

// Subclase Rectangulo
class Rectangulo : Shape {
    private var base: Double = 0.0
    private var altura: Double = 0.0
    override var area: Double = 0.0
    override var perimetro: Double = 0.0

    // Constructor secundario
    constructor(base: Double, altura: Double) {
        this.base = base
        this.altura = altura
        calcularArea()
        calcularPerimetro()
    }

    override fun calcularArea() {
        area = base * altura
    }

    override fun calcularPerimetro() {
        perimetro = 2 * (base + altura)
    }
}

/**
 * Función principal que demuestra el uso de las clases de figuras.
 */
fun main() {
    val cuadrado = Cuadrado(5.0)
    val circulo = Circulo(3.0)
    val rectangulo = Rectangulo(4.0, 6.0)

    println("Resultados para el Cuadrado:")
    cuadrado.imprimirResultados()

    println("\nResultados para el Círculo:")
    circulo.imprimirResultados()

    println("\nResultados para el Rectángulo:")
    rectangulo.imprimirResultados()
}