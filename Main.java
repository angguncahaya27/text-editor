import java.util.Stack;
import java.util.Scanner;

public class TextEditor {

    private static String content = "";
    private static Stack<String> undoHistory = new Stack<>();
    private static Stack<String> redoHistory = new Stack<>();

    // Menambah teks
    public static void tambahTeks(String teks) {
        undoHistory.push(content);
        content += teks;
        redoHistory.clear();
    }

    // Undo
    public static void undo() {
        if (!undoHistory.isEmpty()) {
            redoHistory.push(content);
            content = undoHistory.pop();
        } else {
            System.out.println("Tidak ada aksi untuk di-undo!");
        }
    }

    // Redo
    public static void redo() {
        if (!redoHistory.isEmpty()) {
            undoHistory.push(content);
            content = redoHistory.pop();
        } else {
            System.out.println("Tidak ada aksi untuk di-redo!");
        }
    }

    // Show
    public static void tampilkan() {
        System.out.println("\nTeks saat ini: ");
        if (content.isEmpty()) {
            System.out.println("(kosong)");
        } else {
            System.out.println(content);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\n----- TEXT EDITOR -----");
            System.out.println("1. Write");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan teks: ");
                    String teks = sc.nextLine();
                    tambahTeks(teks);
                    break;

                case 2:
                    undo();
                    break;

                case 3:
                    redo();
                    break;

                case 4:
                    tampilkan();
                    break;

                case 5:
                    System.out.println("Terima kasih sudah menggunakan Text Editor!");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia!");
            }
        } while (pilih != 5);

        sc.close();
    }
}
