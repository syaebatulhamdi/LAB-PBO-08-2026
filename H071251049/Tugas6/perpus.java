package TuPrak6;
import java.util.*;
public class perpus {
    // =========================
    // STRIBUT Library
    // =========================
    List<BarangPerpus> barang = new ArrayList<>();
    List<member> Member = new ArrayList<>();
    PerpusLogger logger = new PerpusLogger();

    // =========================
    // METHOD addItem
    // =========================
    String addItem(BarangPerpus item){
        if (item.judul.length() > 30){
            throw new IllegalArgumentException("Judul yang dipilih terlalu panjang.");
        } if (String.valueOf(item.ID).length() > 4){
            throw new IllegalArgumentException("Digit ID melebihi batas.");
        }
        barang.add(item);
        return "Item: [" + item.judul + "]\nberhasil di tambahkan.";
    }

    // ===========================================
    // METHOD TAMBAHAN Fungsi: Tambah Member 
    // ===========================================
    void addMember(member member){
        if (member.nama.length() > 30){
            throw new IllegalArgumentException("Input nama terlalu panjang.");
        } if (String.valueOf(member.memberID).length() > 4){
            throw new IllegalArgumentException("Digit ID melebihi batas.");
        }
        Member.add(member);
        System.out.println("member: [" + member.nama + "]\nberhasil ditambahkan.");
    }

    
    // METHOD TAMBAHAN Fungsi: Cari Nama Member 

    public member findMemberByName(String name) {
        for (member m : Member) {
            if (m.nama.equalsIgnoreCase(name)) {
                return m;
            }
        }
        throw new NoSuchElementException("Member tidak ditemukan.");
    }

    // =========================
    // METHOD findItemById
    // =========================
    public BarangPerpus findItemById(int id) {
        for (BarangPerpus item : barang) {
            if (item.ID == id) {
                return item;
            }
        }
        throw new NoSuchElementException("Item tidak ditemukan.");
    }

    // ============================================
    // METHOD TAMBAHAN Fungsi: Peminjaman Barang 
    // ============================================
    public void borrowItem(String memberName, int itemId, int days) {
        member member = findMemberByName(memberName);
        BarangPerpus item = findItemById(itemId);

        String result = member.meminjam(item, days);
        System.out.println(result);
        // catat ke log
        logger.logPinjamItem(item.judul, member.nama);
    }

    // ============================================
    // METHOD TAMBAHAN Fungsi: Pengembalian Barang 
    // ============================================
    public void returnItem(String memberName, int itemId, int daysLate) {
        member member = findMemberByName(memberName);
        BarangPerpus item = findItemById(itemId);

        String result = member.mengembalikan(item, daysLate);
        System.out.println(result);
        // catat ke log
        logger.logKembalikanItem(item.judul, member.nama);
    }

    // =========================
    // METHOD getLibraryStatus
    // =========================
    void getLibraryStatus(){
        System.out.println("╔══════╗════════════════════════════════╗══════════╗");
        System.out.println("║ ID   ║             JUDUL              ║ STATUS   ║");
        System.out.println("╠══════╣════════════════════════════════╣══════════╣");
        for (BarangPerpus item : barang){
            String status = "-";
            if (item.pinjaman){status = "dipinjam";} else {status = "tersedia";}
            System.out.printf("║ %-4d ║ %-30s ║ %-8s ║\n", item.ID, item.judul, status);
        }
        System.out.println("╚══════╝════════════════════════════════╝══════════╝");
    }

    // =========================
    // METHOD getAllLogs
    // =========================
    public void getAllLogs(){logger.getLogs();}
}
