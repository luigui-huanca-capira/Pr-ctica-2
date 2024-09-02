# Práctica 2: Programación Orientada a Objetos en Kotlin

Este repositorio contiene la solución a los ejercicios de la "Práctica 2: Programación Orientada a Objetos en Kotlin". En esta práctica, se implementan varias clases utilizando el lenguaje de programación Kotlin, aplicando principios de programación orientada a objetos como encapsulación, herencia y abstracción.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:
- Cada ejercicio se encuentra en un script separado con su respectivo nombre de clase.
- Los scripts están documentados con una breve descripción, autor, fecha de creación y fecha de última modificación.

## Ejercicios Incluidos

1. **CuentaBancaria**: Una clase que gestiona una cuenta bancaria con saldo y límite de retiro, incluyendo métodos para establecer y obtener el saldo, así como realizar retiros con validación.
   
2. **Producto**: Una clase que representa un producto con un precio y un descuento aplicable. Incluye métodos para calcular el precio final después de aplicar el descuento.
   
3. **Figuras**: Se crea una clase abstracta `Shape` y tres subclases (`Cuadrado`, `Círculo`, `Rectángulo`) que calculan el área y el perímetro de cada figura.
   
4. **Sistema de Gestión de Biblioteca**: Un sistema que incluye clases para gestionar materiales (libros, revistas), usuarios, y las operaciones de préstamo y devolución en una biblioteca.

## Cómo Ejecutar

Para ejecutar los scripts de Kotlin, asegúrate de tener Kotlin configurado en tu entorno. Luego, puedes compilar y ejecutar cada archivo `.kt` de la siguiente manera:

```bash
kotlinc NombreArchivo.kt -include-runtime -d NombreArchivo.jar
java -jar NombreArchivo.jar
