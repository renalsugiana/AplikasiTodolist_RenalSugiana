/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class AplikasiTodolist {
    
    public static String[]model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testShowTodoList();
        //testAddTodoList();
        //testRemoveTodoList();
        //testInput();
        testViewShowTodoList();
    }
    // Menampilkan TodoList
    public static void showTodoList(){
        for (int i = 0; i<model.length;i++){
            String todo = model[i];
            int no = i+1;
        
            if(todo!= null){
                System.out.println(no+"."+todo);
            }
        }
    }
    
    public static void testShowTodoList(){
        showTodoList();
    }
    
    // Menambahkan TodoList
    public static void addTodoList(String todo){
        // Cek apakah model penuh?
        boolean isFull = true;
    for (int i = 0; i < model.length; i++){
        if (model[i] == null) {
            // Model masih ada yang kosong
            isFull = false;
            break;
        }
    }
    
    // Jika penuh, kita resize ukuran Array 2x lipat
    if (isFull){
            String[] temp = model;
        model = new String[model.length * 2];
        
        for (int i = 0; i < temp.length; i++) {
            model[i] = temp[i];
        }
    }
    
    // Tambahkan ke posisi yang data Array-nya NULL
    for (int i = 0; i < model.length; i++){
        if (model[i] == null) {
            model[i] = todo;
            break;
            }
        }
    }
    
    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh Todo Ke-" + i);
        }
        showTodoList();
    }
    
    // Menghapus Todolist
    public static boolean removeTodoList(Integer number){
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number -1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                 model[i] = null;
                } else {
                 model[i] = model[i + 1];
                }
            }
            return true;
        }
    }
    
    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        
        boolean result = removeTodoList(20);
        System.out.println(result);
        
        result = removeTodoList(7);
        System.out.println(result);
        
        result = removeTodoList(2);
        System.out.println(result);
        
        showTodoList();
    }
    
    public static String input(String info) {
        System.out.println(info + " : ");
        String data = scanner.nextLine();
        return data;    
    }
    
    public static void testInput() {
        String name = input("Nama");
        System.out.println("Hi " + name);
        
        String channel = input("Channel");
        System.out.println(channel);
    }
    
    // Menampilkan menu Todolist
    public static void viewShowTodoList(){
        while (true) {
            showTodoList();
            
            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");
            
        String input = input("Pilih");
        if (input.equals("1")) {
            viewAddTodoList();
        } else if (input.equals("2")) {
            viewRemoveTodoList();
        } else if (input.equals("x")) {
            break;
        } else {
            System.out.println("Pilihan tidak dimengerti");
            }
        }
    }
    
    public static void testViewShowTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }
    
    // Menampilkan view menambahkan Todolist
    
    // Menambahkan menu Todolist
    public static void viewAddTodoList(){
        System.out.println("Menambahkan TodoList");
        
        String todo = input("Todo (x Jika Batal)");
        
        if (todo.equals("x")) {
        // Batal    
        } else {
            addTodoList(todo);
        }
    } 
    
    public static void testViewAddTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        
        viewAddTodoList();
        
        showTodoList();
    }
    // Menghapus menu Todolist
    public static void viewRemoveTodoList(){
        System.out.println("Menghapus TodoList");
        
        String number = input("Nomor yang dihapus (x Jika Batal)");
        
        if (number.equals("x")) {
        // Batal
        } else {
        boolean success = removeTodoList(Integer.valueOf(number));
        if (!success) {
            System.out.println("Gagal menghapus TodoList : " + number);
            }
        }            
    }
    
   public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        
        viewRemoveTodoList();
        
        showTodoList();
   }
}
