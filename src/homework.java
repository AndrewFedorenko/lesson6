import java.io.UnsupportedEncodingException;

public class homework {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // assumption that we have the same quantity of pets and owners

        // creating of objects Owner array
        Owner[] owners = OwnersReader.returnOwners();

        // creating of objects Pets array
        Pet[] pets = PetsReader.returnPets();

        // setting the Owner to every pet in the same number of array
        for (int i = 0; i < 3; i++) {
            pets[i].Owner = owners[i];
        }

        System.out.println("Example of various pets equals: " + pets[0].equals(pets[1]));
        Pet samePet = pets[0];
        System.out.println("Example of the same pet equals: " + pets[0].equals(samePet));

    }
}
