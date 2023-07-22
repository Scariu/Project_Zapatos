package com.example.project_zapatos

data class Zapatos (val nombre: String, val imagenUrl: String, val precio: Float)

class ListaZapatos {
    companion object {
        val zapatos = mutableListOf<Zapatos>().apply {

            add(Zapatos("Zapato 1", "https://falabella.scene7.com/is/image/Falabella/gsc_119829321_2496099_1?wid=800&hei=800&qlt=70", 99.99F))
            add(Zapatos("Zapato 2", "https://savillerow.cl/cdn/shop/products/1321000004416-1-SAVILLEROW-ZapatodeCueroSport.jpg?v=1642715326", 79.99F))
            add(Zapatos("Zapato 3", "https://gcdn.emol.cl/lujo/files/2021/06/sandalias-tacon.jpg", 149.99F))
            add(Zapatos("Zapato 4", "https://toolmania.cl/14461-full_default/zapatos-de-seguridad-con-punta-de-acero-talla-43-total-tools-tsp201sb43.jpg", 129.99F))
            add(Zapatos("Zapato 5", "https://samiacl02.akamaized.net/8425-large_default/chalas-de-paja-cafe.jpg", 109.99F))
            add(Zapatos("Zapato 6", "https://los40.cl/wp-content/uploads/2021/05/Picture-14.jpg", 89.99F))
            add(Zapatos("Zapato 7", "https://images-eu.ssl-images-amazon.com/images/I/41FhkR8YVqL.jpg", 199.99F))
            add(Zapatos("Zapato 8", "https://i.pinimg.com/736x/21/ac/31/21ac315c00ef7a0dd480730288edcca2.jpg", 199.99F))
            add(Zapatos("Zapato 9", "https://m.media-amazon.com/images/I/61tVF1wnFcL._AC_UY1000_.jpg", 119.99F))
            add(Zapatos("Zapato 10", "https://http2.mlstatic.com/D_NQ_NP_880135-MLC50174593968_062022-O.webp", 149.99F))
        }
    }
}