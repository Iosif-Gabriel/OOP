import java.lang.String;

public class NameInvertor {

    public static String invert(String name) {

        if (name == null)
            return null;

        switch (name){
            case "":
                return "";
            case " ":
                return " ";
        }

        name = name.trim().replaceAll("\\s{2,}", " ");
        String[] names = name.split(" ");
        int size = names.length;

        switch (size) {
            case 1:
                return name;
            case 2:
                return names[1] + ", " + names[0];
            case 3:
                return names[2] + ", " + names[1] + " " + names[0];
            case 4:
                return names[3] + ", " + names[2] + " " + names[0] + " " + names[1];

            default:
                return null;

        }

    }
}
