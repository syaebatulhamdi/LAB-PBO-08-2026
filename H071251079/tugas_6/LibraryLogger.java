package H071251079.tugas_6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    List<String[]> logs;
    Table table = new Table();

    LibraryLogger() {
        this.logs = new ArrayList<>();
    }
    
    String logActivity(String status, String memberName, String titleItem) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowFormat = now.format(dateFormat);

        if (status.equals("dikembalikan")) {
            for (String[] log : logs) {
                if (log[1].equals(titleItem) && log[2].equals(memberName) && log[3].equals("-")) {
                    log[3] = nowFormat;
                    break;
                }
            }
        } else {
            logs.add(new String[]{nowFormat, titleItem, memberName, "-"});
        }
        return nowFormat + " " + titleItem + " " + status + " oleh " + memberName;
    }

    void getLogs() {
        if (logs.isEmpty()) {
            System.out.println("Tidak ada log aktivitas");
            return;
        }
        
        List<String[]> data = new ArrayList<>();
        for (String[] log : logs) {
            data.add(new String[]{log[0], log[1], log[2], log[3]});
        }
        String[] headers = {"Dipinjam pada", "Judul", "Member", "Dikembalikan pada"};
        table.printTable(headers, data);
    }

    void clearLogs() {
        logs.clear();
        System.out.println("Log aktivitas berhasil dihapus");
    }
}
