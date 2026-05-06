package H071251079.tugas_6;

import java.util.List;

public class Table {

    public void printTable(String[] headers, List<String[]> data) {
        int[] widths = getWidths(headers, data);
        String border = makeBorder(widths);
        String fmt    = makeFormat(widths);

        System.out.println(border);
        System.out.printf(fmt, (Object[]) headers);
        System.out.println(border);
        for (String[] row : data)
            System.out.printf(fmt, (Object[]) row);
        System.out.println(border);
    }

    private int[] getWidths(String[] headers, List<String[]> data) {
        int[] w = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            w[i] = headers[i].length();
        }
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                w[i] = Math.max(w[i], row[i].length());
            }
        }
        return w;
    }

    private String makeBorder(int[] widths) {
        StringBuilder sb = new StringBuilder();
        for (int w : widths)
            sb.append("+").append("-".repeat(w + 2));
        return sb.append("+").toString();
    }

    private String makeFormat(int[] widths) {
        StringBuilder sb = new StringBuilder();
        for (int w : widths)
            sb.append("| %-").append(w).append("s ");
        return sb.append("|%n").toString();
    }
}