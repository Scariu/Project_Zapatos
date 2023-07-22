package com.example.project_zapatos

data class Zapatos (val nombre: String, val imagenUrl: String, val precio: Float)

class ListaZapatos {
    companion object {
        val zapatos = mutableListOf<Zapatos>().apply {

            add(Zapatos("Zapato 1", "https://example.com/zapato1.jpg", 99.99F))
            add(Zapatos("Zapato 2", "https://example.com/zapato2.jpg", 79.99F))
            add(Zapatos("Zapato 3", "https://example.com/zapato3.jpg", 149.99F))
            add(Zapatos("Zapato 4", "https://example.com/zapato4.jpg", 129.99F))
            add(Zapatos("Zapato 5", "https://example.com/zapato5.jpg", 109.99F))
            add(Zapatos("Zapato 6", "https://example.com/zapato6.jpg", 89.99F))
            add(Zapatos("Zapato 7", "https://example.com/zapato7.jpg", 199.99F))
            add(Zapatos("Zapato 8", "https://example.com/zapato8.jpg", 169.99F))
            add(Zapatos("Zapato 9", "https://example.com/zapato9.jpg", 119.99F))
            add(Zapatos("Zapato 10", "https://example.com/zapato10.jpg", 149.99F))
        }
    }
}