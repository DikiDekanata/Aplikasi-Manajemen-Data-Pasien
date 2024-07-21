open class Klinik {
    private val daftarPasien = mutableListOf<Pasien>()

    open fun tambahPasien(pasien: Pasien) {
        daftarPasien.add(pasien)
        println("Pasien berhasil ditambahkan.")
    }

    open fun lihatSemuaPasien() {
        if (daftarPasien.isEmpty()) {
            println("Belum ada pasien yang terdaftar.")
        } else {
            println("Daftar Pasien:")
            for ((index, pasien) in daftarPasien.withIndex()) {
                println("${index + 1}. ${pasien.nama} - ${pasien.umur} tahun - ${pasien.alamat}")
            }
        }
    }

    open fun hapusPasien(index: Int) {
        if (index >= 0 && index < daftarPasien.size) {
            val pasienDihapus = daftarPasien.removeAt(index)
            println("Pasien ${pasienDihapus.nama} telah dihapus dari daftar.")
        } else {
            println("Indeks tidak valid.")
        }
    }

    open fun cariPasien(nama: String): Pasien? {
        for (pasien in daftarPasien) {
            if (pasien.nama.equals(nama, ignoreCase = true)) {
                return pasien
            }
        }
        return null
    }

    open fun updateDataPasien(index: Int, pasienBaru: Pasien) {
        if (index >= 0 && index < daftarPasien.size) {
            daftarPasien[index] = pasienBaru
            println("Data pasien berhasil diperbarui.")
        } else {
            println("Indeks tidak valid.")
        }
    }

    protected fun getDaftarPasien(): List<Pasien> {
        return daftarPasien
    }
}