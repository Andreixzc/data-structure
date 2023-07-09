public class Driver {
    public static void main(String[] args) {
        String nome = "R Catwoman: Hunted";
        String str;
        str = nome.replaceFirst("R", "");
        System.out.println(str.concat(".html").trim());
    

    }
}
