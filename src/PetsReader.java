import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

public class PetsReader {

    public static Pet[] returnPets() throws UnsupportedEncodingException {

        final String FILENAME = "pets.txt";
        final int NAMEFIELDNUMBER = 0;
        final int AGEFIELDNUMBER = 1;

        byte[] fileInfo = readFromFile(FILENAME);
        if (fileInfo.length > 0) {
            String strInfo = new String(fileInfo, "UTF-8");

            String[] lines = strInfo.split(";");

            Pet[] pets = new Pet[lines.length];

            for (int i = 0; i < lines.length; i++) {
                String[] ownerLine = lines[i].split(",");

                pets[i] = new Pet(ownerLine[NAMEFIELDNUMBER].replace("\n", ""),
                                  ownerLine[AGEFIELDNUMBER]);
                System.out.println("Created pet with fields:");
                System.out.printf("%-1s, %-1s \n",
                        pets[i].name, pets[i].age);
            }
            return pets;
        }
        return new Pet[0];
    }

    public static byte[] readFromFile(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            int available = fileInputStream.available();
            byte[] buffer = new byte[available];
            fileInputStream.read(buffer);
            return buffer;
        } catch (Exception ignored) {
        }
        return new byte[0];

    }
}
