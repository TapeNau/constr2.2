package java_oracle;

public class Main {
    public static void main(String[] args) {

        try {
            Menu menu = new Menu();
            menu.run();
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
}
