import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private List<String[]> logs; // [timestamp, title, memberName, returnedAt]
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LibraryLogger() {
        this.logs = new ArrayList<>();
       }

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String entry = timestamp + " " + activity;
        logs.add(new String[]{entry, null, null, null, null});
        return entry;
    }

    // Log borrow: stores structured data for table display
    public void logBorrow(LibraryItem item, Member member) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String type = (item instanceof Book) ? "Buku" : "DVD";
        String[] row = {
            timestamp,
            item.getTitle(),
            member.getName(),
            "-",
            type
        };
        logs.add(row);
    }

    // Log return: update log entry with return timestamp
    public void logReturn(LibraryItem item, Member member) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        for (String[] row : logs) {
            if (row[1] != null && row[1].equals(item.getTitle())
                    && row[2] != null && row[2].equals(member.getName())
                    && row[3].equals("-")) {
                row[3] = timestamp;
                return;
            }
        }
        // fallback if not found
        String type = (item instanceof Book) ? "Buku" : "DVD";
        logs.add(new String[]{timestamp, item.getTitle(), member.getName(), timestamp, type});
    }

    public String getLogs() {
        if (logs.isEmpty()) return "Tidak ada log aktivitas.";

        int titleLen = "Judul".length();
        int memberLen = "Member".length();
        for (String[] row : logs) {
            if (row[1] != null) {
                titleLen = Math.max(titleLen, row[1].length());
                memberLen = Math.max(memberLen, row[2].length());
            }
        }

        String border = "+" + "-".repeat(21) + "+" + "-".repeat(titleLen + 2) + "+"
                + "-".repeat(memberLen + 2) + "+" + "-".repeat(21) + "+";
        String fmt = "| %-19s | %-" + titleLen + "s | %-" + memberLen + "s | %-19s |%n";

        StringBuilder sb = new StringBuilder();
        sb.append(border).append("\n");
        sb.append(String.format(fmt, "Dipinjam pada", "Judul", "Member", "Dikembalikan pada"));
        sb.append(border).append("\n");
        for (String[] row : logs) {
            if (row[1] == null) continue; // skip raw activity logs
            sb.append(String.format(fmt, row[0], row[1], row[2], row[3]));
        }
        sb.append(border);
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
    }
}












