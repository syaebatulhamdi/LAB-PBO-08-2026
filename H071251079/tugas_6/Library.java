package H071251079.tugas_6;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    List<LibraryItem> items;
    List<Member> members;
    LibraryLogger logger;
    Table table = new Table();

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.logger = new LibraryLogger();
    }

    String addMember(Member member) {
        members.add(member);
        return member.name + " berhasil ditambahkan";
    }

    String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    Member findMemberById(int memberId) {
        for (Member member: members) {
            if (member.memberId == memberId) {
                return member;
            }
        }
        throw new NoSuchElementException("Id anggota dengan " + memberId + " tidak ditemukan");
    }

    LibraryItem findItemById(int itemId) {
        for (LibraryItem item: items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        throw new NoSuchElementException("Id item dengan " + itemId + " tidak ditemukan");
    }

    void getLibraryStatus() {
        if (items.isEmpty()) {
            System.out.println("Tidak ada item di status perpustakaan");
            return;
        }
        
        List<String[]> data = new ArrayList<>();
        for (LibraryItem item : items) {
            data.add(new String[]{String.valueOf(item.getItemId()), item.getTitle(), item.isBorrowed() ? "Dipinjam" : "Tersedia"});
        }
        String[] headers = {"ID", "Judul", "Status"};
        table.printTable(headers, data);
    }

    void getAllLogs() {
        logger.getLogs();
    }
}
