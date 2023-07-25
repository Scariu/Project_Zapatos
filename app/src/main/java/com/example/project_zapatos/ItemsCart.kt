package com.example.project_zapatos

interface AddItemsCart {
    fun addItemsCart(): MutableList<Zapatos>
}
interface DeleteItemsCart {
    fun deleteCart(item: Zapatos)
}

