import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    private static String text = "";
    private static Stack<String> undoStack = new Stack<>();
    private static Stack<String> redoStack = new Stack<>();

    public static void write(String newText) {
        undoStack.push(text);  // simpan kondisi sebelumnya
        text += newText;
        redoStack.clear(); // setiap write akan menghapus kemungkinan redo lama
    }

    public static void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(text);
            text = undoStack.pop();
        } else {
            System.out.println("Tidak ada yang bisa di-undo!");
        }
    }

    public static void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(text);
            text = redoStack.pop();
        } else {
            System.out.println("Tidak ada yang bisa di-redo!");
        }
    }

    public static void show() {
        System.out.println("Isi Text Editor:");
        System.out.println(text.isEmpty() ? "(kosong)" : text);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;
        String tulisan;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Write");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show");
            System.out.println("5. Exit");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan teks: ");
                    tulisan = input.nextLine();
                    write(tulisan);
                    break;
                case 2:
                    undo();
                    break;
                case 3:
                    redo();
                    break;
                case 4:
                    show();
                    break;
                case 5:
                    System.out.println("Program selesai!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);

        input.close();
    }
}
