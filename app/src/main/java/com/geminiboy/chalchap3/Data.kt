package com.geminiboy.chalchap3

object Data {

    private val words = arrayOf(
        "Ayam", "Angsa", "Atapu",
        "Bintang", "Bebek", "Baju",
        "Cacing", "Celana", "Cuan",
        "Dede", "Danau", "Duduk",
        "English", "Empang", "Elang",
        "Facebook", "Friv", "Foto",
        "Gajah", "Google", "Gmail",
        "Haji", "Hitung", "Hapus",
        "Ikan", "Item", "Itali",
        "Jepang", "Jakarta", "Jambu"
    )

    val listData: ArrayList<String>
        get() {
            val list = arrayListOf<String>()
            for (position in words.indices) {
                list.add(words[position])
            }
            return list
        }
}