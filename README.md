**Program Investasi Sederhana**

Kode program ini merupakan bagian dari sistem trading yang menangani proses login dan main interface pengguna. Kelas MainInterface menyajikan pilihan login sebagai Admin atau Customer, dan akan mengarahkan ke interface login masing-masing sesuai pilihan. Kelas StockAdminInterface dan NationalGovermentSecuritiesAdminInterface menyediakan menu bagi admin untuk mengelola data saham dan surat berharga negara (SBN) menggunakan berbagai service lainnya. Berikut merupakan skenario Ketika program dijalankan.

**Skenario Tampilan Awal**

Saat program dijalankan, pengguna akan disambut dengan tampilan menu utama yang meminta mereka memilih salah satu dari dua opsi: masuk sebagai Admin (opsi 1) atau sebagai Customer (opsi 2). Pemilihan opsi ini menentukan jalur interaksi selanjutnya sesuai dengan peran yang dipilih.

![Screenshot 2025-04-29 081451](https://github.com/user-attachments/assets/2d88bdf1-b8df-423f-84df-370201e98a94)

**Skenario Login as Admin**

Jika pengguna memilih opsi 1 (Admin), maka sistem akan meminta input username dan password. Apabila informasi yang dimasukkan tidak sesuai, pengguna akan diberi pesan invalid dan diminta untuk mengisi ulang. Namun, jika login berhasil, pengguna akan langsung diarahkan ke Home Admin Interface dan disambut dengan pesan selamat datang.

![Screenshot 2025-04-29 081928](https://github.com/user-attachments/assets/ad2d1afc-c380-454d-a61a-c5f7a39174d4)

**Skenario Manage Stock dan View All Stock**

Setelah berhasil login sebagai Admin dan masuk ke Admin Interface, jika pengguna memilih opsi 1 (Manage Stock), maka akan diarahkan ke menu manajemen saham. Di dalam menu ini, ketika pengguna memilih sub-opsi 1 (View All Stocks), sistem akan menampilkan daftar seluruh saham yang tersedia lengkap dengan informasi kode saham, nama perusahaan, dan harga saham saat ini.

![Screenshot 2025-04-29 082014](https://github.com/user-attachments/assets/1f1315da-277e-4bbd-a5fd-0a0b121a1350)

**Skenario Add Stock**

Jika Admin memilih opsi 2 (Add Stock) pada menu manajemen saham, maka sistem akan meminta input berupa kode saham, nama perusahaan, dan harga saham. Setelah data diisi dan dikonfirmasi, sistem akan mencoba menambahkan saham tersebut ke dalam GlobalDataSource. Jika berhasil, akan ditampilkan pesan bahwa saham berhasil ditambahkan, namun jika gagal (misalnya karena kode sudah ada), maka akan muncul pesan kegagalan.

![Screenshot 2025-04-29 090007](https://github.com/user-attachments/assets/42d6d11c-611c-483a-98e2-ad76f9ff0452)

**Skenario Update Stock**

Jika Admin memilih opsi 3 (Update Stock Price), maka sistem akan meminta kode saham yang ingin diubah dan harga baru. Setelah input diterima, sistem akan memproses pembaruan data. Jika pembaruan berhasil, maka harga saham akan diperbarui di dalam GlobalDataSource, dan pesan sukses akan ditampilkan. Jika gagal (misalnya karena kode tidak ditemukan), sistem akan menampilkan pesan kegagalan.

![Screenshot 2025-04-29 090118](https://github.com/user-attachments/assets/32d5f558-0bc3-40cf-828e-c4c25040e682)

**Tampilan Setelah Data Terupdate**

Setelah Admin berhasil memperbarui harga saham, Admin dapat memilih kembali opsi 1 (View All Stocks) untuk memastikan perubahan sudah diterapkan. Sistem akan menampilkan daftar semua saham yang tersedia, termasuk saham dengan kode BMRI (Bank Mandiri) yang kini menampilkan harga terbaru sesuai dengan pembaruan yang dilakukan sebelumnya. Ini memastikan bahwa data telah tersimpan dan tercerminkan secara real-time di tampilan.

![Screenshot 2025-04-29 090153](https://github.com/user-attachments/assets/d518fa1c-2864-4110-8a66-fcf16d895f85)

**Skenario Delete Stock**

Admin dapat memilih opsi 4 (Delete Stock) untuk menghapus saham yang tidak diinginkan. Sistem akan menampilkan pesan berhasil sebagai konfirmasi bahwa saham tersebut telah dihapus dengan sukses. Saham yang dihapus juga akan langsung hilang dari GlobalDataSource. Maka tidak akan muncul lagi ketika Admin memilih opsi 1 (View All Stocks).

![Screenshot 2025-04-29 090219](https://github.com/user-attachments/assets/6c35cf03-2caa-4d53-b061-3c039733dcec)

**Skenario Kembali ke Home Admin Interface**

Admin dapat kembali ke Home Admin Interface dengan memilih opsi 5 (Back), maka akan muncul kembali menu opsi Manage Stock atau Manage NationalGovermentSecurities (SBN).

![Screenshot 2025-04-29 090241](https://github.com/user-attachments/assets/2c018279-f401-455b-8f1f-9d4bdab551d5)

**Skenario Admin Memilih Opsi Manage NationalGovermentSecurities**

Disini Admin memasuki NationalGovermentSecurities Admin Interface, dimana ada dua opsi yang dapat dipilih oleh Admin. Opsi 1 (View All NGS) yang akan menampilkan seluruh NationalGovermentSecurities dari DataSource. Dan opsi 2 (Create New NGS) untuk menambahkan Surat Berharga Negara yang baru.

![Screenshot 2025-04-29 090448](https://github.com/user-attachments/assets/20c6fb54-f7c7-49c7-a7b6-cd86d4d911ff)

**Skenario View All NGS**

Jika Admin memilih opsi 1 (View All NGS), maka program akan mengambil semua data Surat Berharga Negara dari GlobalDataSource, yang kemudian ditampilkan kepada Admin.

![Screenshot 2025-04-29 090459](https://github.com/user-attachments/assets/a902ab9b-3c36-49d0-b8da-d8b781acb067)

**Skenario Create New NGS** 

Jika Admin ingin menambah Surat Berharga Negara yang baru, maka Admin dapat memiih opsi 2 (Create New NGS). Dimana Admin akan diminta untuk menginputkan beberapa informasi terkait Surat Berharga Negara, seperti code, name, interestRate, nationalQuota, dan lainnya. Jika Admin berhasil menambahkan Surat Berharga Negara baru, maka akan muncul pesan berhasil.

![Screenshot 2025-04-29 091320](https://github.com/user-attachments/assets/4e5d2dd1-9941-45fe-8804-5e53b2a3faef)

**Tampilan List NGS setelah Admin Menambahkan NGS Baru**

Disini terlihat bahwa Surat Berharga Negara yang tadi berhasil di-inputkan oleh Admin telah muncul saat Admin memilih opsi View All NGS. Hal ini menujukkan bahwa data Surat Berharga Negara telah berada di dalam GlobalDataSource.

![Screenshot 2025-04-29 091401](https://github.com/user-attachments/assets/518e81ac-a81b-4690-967c-1981aa683a5b)

**Skenario Admin Logout**

User dapat memilih opsi 3 (Back) untuk kembali ke Home Admin Interface setelah selesai mengelola Surat Berharga Negara. Jika pengguna ingin mengakhiri sesi sebagai admin, mereka dapat memilih opsi 3 (Logout) dari menu utama admin, yang akan membawa mereka kembali ke Main Interface, tempat mereka dapat memilih untuk login ulang sebagai Admin atau Customer.

![Screenshot 2025-04-29 091443](https://github.com/user-attachments/assets/71a9d777-3b88-418a-93b6-30c17d399b98)

**Skenario Login as Customer**

Jika pengguna memilih opsi 2 (Customer), maka sistem akan meminta input username dan password. Apabila informasi yang dimasukkan tidak sesuai, pengguna akan diberi pesan invalid dan diminta untuk mengisi ulang. Namun, jika login berhasil, pengguna akan langsung diarahkan ke Home Customer Interface dan disambut dengan pesan selamat datang.

![Screenshot 2025-04-29 092806](https://github.com/user-attachments/assets/6df85db1-ee39-480c-ad6e-18408ec6363d)

**Skenario View Portfolio** 

Jika Customer memilih opsi 5 (View Portfolio), maka program akan menampilkan seluruh data saham maupun Surat Berharga Negara (SBN) yang telah dimiliki oleh customer tersebut. Informasi ini mencakup detail kepemilikan masing-masing instrumen keuangan yang telah dibeli. Data portfolio customer tersebut disimpan dan dikelola melalui PortfolioDataSource serta terintegrasi dengan GlobalDataSource, yang menjadi pusat data utama program.

![Screenshot 2025-04-29 092848](https://github.com/user-attachments/assets/cca874ca-e892-4400-a965-b7e3bb14e934)

**View All Stocks**

Sama dengan opsi View All Stocks yang terdapat pada Admin, ketika Customer memilih opsi 6 (View All Stock) sistem akan menampilkan daftar seluruh saham yang tersedia lengkap dengan informasi kode saham, nama perusahaan, dan harga saham saat ini.

![Screenshot 2025-04-29 092900](https://github.com/user-attachments/assets/be628143-acb3-4ab0-8245-7ab4a1da2fdb)

**View All National Goverment Securities**

Sama dengan opsi View All NGS yang terdapat pada Admin, ketika Customer memilih opsi 7 (View All National Goverment Securities) sistem akan menampilkan daftar seluruh Surat Berharga Negara yang tersedia lengkap dengan informasi kode Surat Berharga Negara, nama Surat Berharga Negara, suku bunga, dan tanggal jatuh tempo.

![Screenshot 2025-04-29 093740](https://github.com/user-attachments/assets/77c230dc-315e-4a08-aeed-fdfb18f27d79)

**Skenario Buy Stock**

Jika Customer memilih opsi 1 (Buy Stock), maka program akan menampilkan seluruh data saham yang tersedia. Selanjutnya, Customer akan diminta untuk memasukan kode saham (stock code) serta jumlah saham yang ingin dibeli.

![Screenshot 2025-04-29 094014](https://github.com/user-attachments/assets/5e52e48d-e496-4308-b8f3-aa52b72b8d81)

**Skenario Sell Stock**

Pada opsi 2, Customer dapat menjual aset saham yang mereka miliki. Pertama, program akan menampilkan seluruh saham yang dimiliki Customer dengan beberapa detail informasi seperti kode saham, jumlah saham yang dimiliki saat ini dan harga pasar terkini. Selanjutnya Customer dapat memasukan kode dan jumlah saham yang ingin dijual. 

Jika Customer berhasil menjual saham yang dimilikinya, maka data pada portfolio customer akan mengalami perubahan secara otomatis. Jumlah saham yang terjual akan berkurang sesuai dengan jumlah yang dijual. Proses pengurangan ini ditangani oleh MinusStockService, yang bertugas memperbarui data di dalam GlobalDataSource.

![Screenshot 2025-04-29 094105](https://github.com/user-attachments/assets/d29adc6e-ebbd-4d74-906a-7b42d3d2a2e3)

**Skenario Buy National Goverment Securities (NGS)**

Jika Customer ingin membeli Surat Berharga Negara (National Goverment Securities), maka Customer dapat memiih opsi 3 (Buy National Goverment Securities (NGS)). Dimana program akan menampilkan seluruh Surat Berharga Negara yang tersedia dengan beberapa informasi terkait SBN, seperti kode, nama, suku bunga, dan jatuh tempo dari SBN. Selanjutnya, Customer dapat membeli Surat Berharga Negaradengan memasukan kode dan jumlah investasi. 

![Screenshot 2025-04-29 094454](https://github.com/user-attachments/assets/c8d400d5-09da-4f1a-9126-899afd20ca82)

**Skenario Simulate NGS coupun**

Jika Customer memilih opsi 4 (Simulate NGS coupun) maka Customer dapat melihat estimasi keuntungan per bulan dari SBN yang dimiliki Customer. Dimana, Customer akan diminta untuk memasukan kode SBN yang kemudian sistem akan menghitung estimasi sesuai dengan rumus yang ditetapkan pada kelas NationalGovermentSecuritiesSimulation.

![Screenshot 2025-04-29 094541](https://github.com/user-attachments/assets/5dce58c3-0f95-4869-a1af-b7b47fa0e90e)

**Skenario Customer Logout**

User dapat memilih opsi 8 (Customer Logout) untuk kembali ke Main Interface.

![Screenshot 2025-04-29 215828](https://github.com/user-attachments/assets/87c887ae-0d65-49e0-9d7d-1c238df3d795)



