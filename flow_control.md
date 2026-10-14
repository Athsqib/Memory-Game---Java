## Flow Control

1. Branch, Digunakan untuk memilih perintah mana yang akan dijalankan berdasarkan ondisi tertentu
2. Loop

Tugas
Membuat percangan dan pengulangan

Diselesaikan denaan bahasa Java
Kasus: Bayar total parkir
Input Jam
Ada pilihan kendaraan Mobil dan Motor

- Untuk mobil 1 jam pertama Rp5.000
- Jam setelahnya akan ditambah Rp3.000/jam
- Setiap 12 jam mendapatkan charge tetap Rp.20.000

- Untuk motor 1 jam pertama Rp2.000
- Jam setelahnya akan ditambah Rp1.500/jam
- Setiap 12 jam mendapatkan charge tetap Rp.10.000

Hasil yang dikeluarkan berupa tiket parkir beserta total harga dan jam.

Case Test:
Jam = 2, Kendaraan = Mobil, Output = Rp8000
Jam = 10, Kendaraan = Motor, Output = Rp15500
Jam = 13, Kendaraan = Mobil, Output = Rp58000
Jam = 24, Kendaraan = Motor, Output = Rp53500
Jam = 0, Kendaraan = Motor, Output = Rp0

Dikasih ke kelompok 3

```mermaid
flowchart TD
    A([Start]) --> B[/Input Jam/]
    B --> C[/Input Kendaraan/]
    C --> D[Proses Motor]
    C --> E[Proses Mobil]
    D --> F[/Output Tiket/]
    E --> F
    F --> G([Finish])
```

Soal
Studi Kasus:
Buatlah program game memori yang dimana ada angka dan huruf acak yang akan menghilang dalam jangka waktu tertentu.
3 string huruf dan angka acak = [18QP.,06IO.,99JEE] nantinya variabel ini akan menghilang dan user diminta kembali untuk menulis apa yang sebelumnya dilihat setelah itu jawaban user dibandingkan dengan soal yang ditampilkan sebelumnya apakah benar atau tidak. Case Sensitive.


### Flowchart main
```mermaid
flowchart TD
    A([Mulai]) --> A1["clearScreen()"]
    A1 --> B[/"SELAMAT DATANG DI DALAM PERMAINAN MEMORI"/]
    B --> C[/"Pilih kesulitan:<br/>1. Easy<br/>2. Medium<br/>3. Hard"/]
    C --> D[/Input pilihan kesulitan/]
    D --> D1["input.nextLine() (buang sisa newline)"]
    D1 --> E{Kesulitan?}
    E -->|1 atau default| F["panjang = 4"]
    E -->|2| G["panjang = 5"]
    E -->|3| H["panjang = 10"]
    F --> I["clearScreen()"]
    G --> I
    H --> I
    I --> I1["kunci = randomizeString(panjang)"]
    I1 --> I2(("Flowchart randomizeString(panjang)"))
    I1 --> J[/"Tampilkan kunci (string acak)"/]
    J --> K["Tunggu 3 detik (sleep), lalu hapus layar"]
    K --> L["pengulangan = 3"]
    L --> M{"pengulangan > 0?"}
    M -->|Ya| N[/"Input: string yang kamu lihat"/]
    N --> O{"jawaban.equals(kunci)?"}
    O -->|Ya| P["Tampilkan 'Benar'<br/>Tunggu 1 detik (sleepPendek)"]
    P --> R{"pengulangan == 0?"}
    O -->|Tidak| S["Tampilkan 'Salah'<br/>Tunggu 1 detik (sleepPendek)"]
    S --> T["pengulangan = pengulangan - 1<br/>clearScreen()"]
    T --> M
    M -->|Tidak| R
    R -->|Ya| Q[/"GAME OVER"/]
    R -->|Tidak| Y[/"SELAMAT ANDA BENAR"/]
    Q --> Z([Selesai])
    Y --> Z
```

### Flowchart randomizeString

```mermaid
flowchart TD
    A((Flowchart main)) --> B["characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ' + 'abcdefghijklmnopqrstuvwxyz' + '0123456789'"]
    B --> C[Bikin objek random dari Class Random]
    C --> D[Membuat objek result dari Class StringBuilder]
    D --> E["i = 0"]
    E --> F{"i < length?"}
    F -->|Tidak| G["return result.toString()"]
    G --> H((Kembali ke main))
    F -->|Ya| I["index = random.nextInt(characters.length())"]
    I --> J["result.append(characters.charAt(index))"]
    J --> K["i = i + 1"]
    K --> F
```