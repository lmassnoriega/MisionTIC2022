public class App {
    

    private int id;
    private String name;
    private final String DEVELOPER = "apple";
    private int matriz[][] = new int[2][2];


    public App(int id, String name, int matriz[][]) {
        this.id = id;
        this.name = name;
        this.matriz = matriz;
    }

    public String getDEVELOPER() {
        return this.DEVELOPER;
    }

    public void setMatriz(int matriz[][]) {
        this.matriz = matriz;
    }

    public int[][] getMatriz() {
        return this.matriz;
    }

    public App(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
