class DataPasien : Klinik() {
    override fun tambahPasien(pasien: Pasien) {
        super.tambahPasien(pasien)
        println("Data pasien ${pasien.nama} telah ditambahkan ke dalam database khusus.")
    }

    override fun lihatSemuaPasien() {
        println("Menampilkan semua pasien dari database khusus:")
        super.lihatSemuaPasien()
    }

    override fun hapusPasien(index: Int) {
        if (index >= 0 && index < getDaftarPasien().size) {
            val pasien = getDaftarPasien()[index]
            super.hapusPasien(index)
            println("Data pasien ${pasien.nama} telah dihapus dari database khusus.")
        } else {
            println("Indeks tidak valid untuk database khusus.")
        }
    }

    override fun cariPasien(nama: String): Pasien? {
        println("Mencari pasien di database khusus:")
        return super.cariPasien(nama)
    }

    override fun updateDataPasien(index: Int, pasienBaru: Pasien) {
        if (index >= 0 && index < getDaftarPasien().size) {
            val pasienLama = getDaftarPasien()[index]
            super.updateDataPasien(index, pasienBaru)
            println("Data pasien ${pasienLama.nama} telah diperbarui di database khusus.")
        } else {
            println("Indeks tidak valid untuk database khusus.")
        }
    }

    fun menu() {
        var pilihan: Int

        do {
            println("-------------------------------")
            println("Aplikasi Manajemen Data Pasien ")
            println("-------------------------------")
            println("Menu :")
            println("1. Tambah Pasien")
            println("2. Lihat Semua Pasien")
            println("3. Cari Pasien")
            println("4. Update Data Pasien")
            println("5. Hapus Pasien")
            println("6. Keluar")
            print("Pilih menu: ")
            pilihan = readLine()?.toIntOrNull() ?: 0

            when (pilihan) {
                1 -> {
                    print("Masukkan nama pasien: ")
                    val nama = readLine().toString()
                    print("Masukkan umur pasien: ")
                    val umur = readLine()?.toInt() ?: 0
                    print("Masukkan alamat pasien: ")
                    val alamat = readLine().toString()
                    tambahPasien(Pasien(nama, umur, alamat))
                }
                2 -> {
                    lihatSemuaPasien()
                }
                3 -> {
                    print("Masukkan nama pasien yang ingin dicari: ")
                    val nama = readLine().toString()
                    val pasienDitemukan = cariPasien(nama)
                    if (pasienDitemukan != null) {
                        println("Pasien ditemukan: ${pasienDitemukan.nama} - ${pasienDitemukan.umur} tahun - ${pasienDitemukan.alamat}")
                    } else {
                        println("Pasien dengan nama '$nama' tidak ditemukan.")
                    }
                }
                4 -> {
                    print("Masukkan nomor indeks pasien yang akan diperbarui: ")
                    val indeks = readLine()?.toIntOrNull() ?: -1
                    if (indeks >= 1 && indeks <= getDaftarPasien().size) {
                        print("Masukkan nama pasien baru: ")
                        val nama = readLine().toString()
                        print("Masukkan umur pasien baru: ")
                        val umur = readLine()?.toIntOrNull() ?: 0
                        print("Masukkan alamat pasien baru: ")
                        val alamat = readLine().toString()
                        updateDataPasien(indeks - 1, Pasien(nama, umur, alamat))
                    } else {
                        println("Indeks tidak valid.")
                    }
                }
                5 -> {
                    print("Masukkan nomor indeks pasien yang akan dihapus: ")
                    val indeks = readLine()?.toIntOrNull() ?: -1
                    hapusPasien(indeks - 1)
                }
                6 -> {
                    println("Terima kasih telah menggunakan layanan klinik.")
                }
                else -> {
                    println("Pilihan tidak valid.")
                }
            }
        } while (pilihan != 6)
    }
}
