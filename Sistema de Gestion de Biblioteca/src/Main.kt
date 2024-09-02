/**
 * Práctica 2. Programación Orientada a Objetos Kotlin
 * Descripción: Implementación de un sistema de gestión de biblioteca
 *              que incluye clases para materiales, usuarios y operaciones de biblioteca.
 * Autor: Luigui Alexander Huanca Capira
 * Fecha creación: 01/09/2024
 * Fecha última modificación: 01/09/2024
 */

// Clase base abstracta Material
abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles(): String
}

// Subclase Libro
class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles(): String {
        return "Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numeroPaginas"
    }
}

// Subclase Revista
class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles(): String {
        return "Revista: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial"
    }
}

// Data class Usuario
data class Usuario(val nombre: String, val apellido: String, val edad: Int)

// Interfaz IBiblioteca
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestamoMaterial(usuario: Usuario, material: Material)
    fun devolucionMaterial(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}

// Clase Biblioteca que implementa IBiblioteca
class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuariosConPrestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("Material registrado: ${material.mostrarDetalles()}")
    }

    override fun registrarUsuario(usuario: Usuario) {
        if (!usuariosConPrestamos.containsKey(usuario)) {
            usuariosConPrestamos[usuario] = mutableListOf()
            println("Usuario registrado: $usuario")
        } else {
            println("El usuario ya está registrado.")
        }
    }

    override fun prestamoMaterial(usuario: Usuario, material: Material) {
        if (material in materialesDisponibles && usuario in usuariosConPrestamos.keys) {
            materialesDisponibles.remove(material)
            usuariosConPrestamos[usuario]?.add(material)
            println("Préstamo realizado: ${material.titulo} a ${usuario.nombre} ${usuario.apellido}")
        } else {
            println("No se pudo realizar el préstamo. Verifique disponibilidad del material y registro del usuario.")
        }
    }

    override fun devolucionMaterial(usuario: Usuario, material: Material) {
        if (usuario in usuariosConPrestamos.keys && material in usuariosConPrestamos[usuario]!!) {
            usuariosConPrestamos[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("Devolución realizada: ${material.titulo} por ${usuario.nombre} ${usuario.apellido}")
        } else {
            println("No se pudo realizar la devolución. Verifique los datos del préstamo.")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { println(it.mostrarDetalles()) }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("Materiales reservados por ${usuario.nombre} ${usuario.apellido}:")
        usuariosConPrestamos[usuario]?.forEach { println(it.mostrarDetalles()) }
    }
}

fun main() {
    val biblioteca = Biblioteca()

    // Crear materiales
    val libro1 = Libro("1984", "George Orwell", 1949, "Ficción distópica", 328)
    val libro2 = Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico", 432)
    val revista1 = Revista("National Geographic", "Various", 2023, "0027-9358", 243, 6, "National Geographic Society")

    // Registrar materiales
    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(libro2)
    biblioteca.registrarMaterial(revista1)

    // Crear usuarios
    val usuario1 = Usuario("Juan", "Pérez", 30)
    val usuario2 = Usuario("María", "González", 25)

    // Registrar usuarios
    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)

    // Realizar préstamos
    biblioteca.prestamoMaterial(usuario1, libro1)
    biblioteca.prestamoMaterial(usuario2, revista1)

    // Mostrar materiales disponibles
    biblioteca.mostrarMaterialesDisponibles()

    // Mostrar materiales reservados por usuario
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario2)

    // Realizar devolución
    biblioteca.devolucionMaterial(usuario1, libro1)

    // Mostrar materiales disponibles después de la devolución
    biblioteca.mostrarMaterialesDisponibles()
}