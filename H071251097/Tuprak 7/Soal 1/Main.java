// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;
// import java.util.concurrent.TimeUnit;

// class Main {
//     public static void main(String[] args) {
//         Gudang gudang = new Gudang(20);
//         ExecutorService ex = Executors.newFixedThreadPool(6);

//         ex.execute(new Pemasok(gudang));
//         ex.execute(new Pemasok(gudang));

//         ex.execute(new Kurir(gudang));
//         ex.execute(new Kurir(gudang));
//         ex.execute(new Kurir(gudang));

//         ex.execute(new Monitor(gudang));

//         try {
//             Thread.sleep(15000);
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }

//         ex.shutdownNow();

//         try {
//             if (ex.awaitTermination(5, TimeUnit.SECONDS)) {
//                 System.out.println("Semua thread berhasil dihentikan.");
//             } else {
//                 System.out.println("Masih ada thread yang berjalan.");
//             }
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//     }
// }
