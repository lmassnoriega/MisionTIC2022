import java.io.BufferedReader;
import java.io.InputStreamReader;

public class reto1 {
    private int category_count[];

    @Override
    public String toString(){
        String message = "";
        for (int i = 0; i < category_count.length; i++) {
            message += category_name(i)+ ": "+category_count[i] + "\n";
        }
        return message;
    }
    
    public reto1() {
        category_count = new int[5];
        for (int i = 0; i < category_count.length; i++) {
            category_count[i] = 0;
        }
    }

    public void add_category_count(int category){
        category_count[category] += 1;
    }

    public static int category(float irca_measure){
        if (irca_measure <= 5) {
            return 0;
        } else {
            if (irca_measure <= 14) {
                return 1;
            } else {
                if (irca_measure <= 35) {
                    return 2;
                } else {
                    if (irca_measure <= 80) {
                        return 3;
                    } else {
                        return 4;
                    }
                }
            }
        }
    }

    public static String category_name(int irca_category){
        String category_risk = "";
        switch (irca_category) {
            case 0:
                category_risk = "SIN RIESGO";
                break;
            case 1:
                category_risk = "BAJO";
                break;
            case 2:
                category_risk = "MEDIO";
                break;
            case 3:
                category_risk = "ALTO";
                break;
            default:
                category_risk = "INVIABLE SANITARIAMENTE";
                break;
        }
        return category_risk;
    }

    public int favorite(){
        int fav = 0;
        int count = category_count[0];
        for (int i = 0; i < category_count.length; i++) {
            if (count<category_count[i]) {
                fav = i;
                count = category_count[i];
            }
        }
        return fav;
    }

    public static void main(String[] args) throws Exception {
        reto1 classifier = new reto1();
        float suma = 0;
        int measures = 1;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        try {
            measures = Integer.parseInt(lector.readLine());
            String data = lector.readLine();
            String readings[] = data.split(" ");
            for (int i = 0; i < readings.length; i++) {
                float measure = Float.parseFloat(readings[i]);
                suma+= measure;
                int irca_category = category(measure);
                classifier.add_category_count(irca_category);
            }
        } catch (Exception e) {
        }

        suma/=measures;
        System.out.println(category_name(category(suma)));
        System.out.printf("%3.2f \n",suma);
        System.out.println(category_name(classifier.favorite()));
    }
}
