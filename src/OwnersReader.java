import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

public class OwnersReader {

    public static Owner[] returnOwners() throws UnsupportedEncodingException {

        final String FILENAME = "owners.txt";
        final int FIRSTNAMEFIELDNUMBER = 0;
        final int LASTNAMEFIELDNUMBER = 1;
        final int AGEFIELDNUMBER = 2;
        final int ADDRESSFIELDNUMBER = 3;
        final int PHONEFIELDNUMBER = 4;

        byte[] fileInfo = readFromFile(FILENAME);
        if (fileInfo.length > 0) {
            String strInfo = new String(fileInfo, "UTF-8");

            String[] lines = strInfo.split(";");

            Owner[] owners = new Owner[lines.length];

            for (int i = 0; i < lines.length; i++) {

                String[] ownerLine = lines[i].split(",");

                owners[i] = new Owner(ownerLine[FIRSTNAMEFIELDNUMBER].replace("\n", ""),
                                        ownerLine[LASTNAMEFIELDNUMBER],
                                        ownerLine[AGEFIELDNUMBER],
                                        ownerLine[ADDRESSFIELDNUMBER],
                                        ownerLine[PHONEFIELDNUMBER]);
                System.out.println("Created owner with fields:");
                System.out.printf("%-1s, %-1s, %-1s, %-1s, %-1s \n",
                                owners[i].firstName,
                                owners[i].lastName,
                                owners[i].age,
                                owners[i].address,
                                owners[i].phone);
            }
            return owners;
        }
        return new Owner[0];
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
