/**
 * @author <Do Xuan Gia Bao - s3932184>
 */

package myorg;

import myorg.service.ClaimProcessManagerImpl;
import myorg.model.*;
import myorg.util.FileManager;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    // Define file paths for data storage
    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/customer.txt";
    private static final String INSURANCE_CARDS_FILE_PATH = "src/main/resources/insuranceCard.txt";
    private static final String CLAIMS_FILE_PATH = "src/main/resources/claim.txt";

    // Create a simple date formatter for parsing and formatting dates
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // Create an instance of the claim manager for interacting with claims
    private static final ClaimProcessManagerImpl claimManager = new ClaimProcessManagerImpl();

    // Lists to store loaded customer and insurance card data
    private static List<Customer> customers;
    private static List<InsuranceCard> insuranceCards;

    // Scanner object for user input
    private static final Scanner scanner = new Scanner(System.in);

    // This method associates insurance cards with customers based on card ID
    private static void associateInsuranceCardsWithCustomers() {
        Map<String, InsuranceCard> cardMap = new HashMap<>();
        for (InsuranceCard card : insuranceCards) {
            cardMap.put(card.getCardNumber(), card);
        }
        for (Customer customer : customers) {
            InsuranceCard card = cardMap.get(customer.getInsuranceCardId());
            if (card != null) {
                customer.setInsuranceCard(card);
            }
        }
    }
    // Display the main menu to the user
    private static void showMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1 - View All Customers");
        System.out.println("2 - View All Claims");
        System.out.println("3 - Input Claims ID");
        System.out.println("4 - Add Claims");
        System.out.println("5 - Modify a Claim");
        System.out.println("6 - Delete a Claim");
        System.out.println("0 - Exit!");
        System.out.print("Enter a number to choose: ");
    }

    // Method to list all customers
    private static void listAllCustomers() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (customers.isEmpty()) {
            System.out.println("I'm sorry! No customer has been found.");
        } else {
            for (Customer customer : customers) {
                System.out.println("PolicyHolder: { ID: " + customer.getId() + ", Name: " + customer.getFullName() + " }");

                InsuranceCard card = customer.getInsuranceCard();
                if (card != null) {
                    System.out.println("\tInsurance Card: { Number: " + card.getCardNumber() + ", Expiration Date: " + sdf.format(card.getExpirationDate()) + " }");
                } else {
                    System.out.println("\tInsurance Card: Not Available");
                }
            }
        }
    }

    // Method to list all claims
    private static void listAllClaims() {
        List<Claim> allClaims = claimManager.getAll();
        if (allClaims.isEmpty()) {
            System.out.println("I'm sorry! No claim has been found.");
        } else {
            allClaims.forEach(claim ->
                    System.out.printf("Claim ID: %s, Claim Date: %s, Amount: %.2f, Status: %s%n",
                            claim.getId(), sdf.format(claim.getClaimDate()), claim.getClaimAmount(), claim.getStatus())
            );
        }
    }
    // Method to show details of a specific claim
    private static void showClaimDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Claim ID: ");
        String claimId = scanner.nextLine();
        Claim claim = claimManager.getOne(claimId);
        if (claim != null) {
            System.out.println("Claim Details: " + claim);
        } else {
            System.out.println("I'm sorry! The claim cannot be found.");
        }
    }

    // Method to add a new claim
    private static void addNewClaim() {
        try {
            System.out.println("Input the Claim ID: ");
            String id = scanner.nextLine();

            System.out.println("Input the Claim Date (yyyy-MM-dd): ");
            Date claimDate = sdf.parse(scanner.nextLine());

            System.out.println("Input the Insured Person ID: ");
            String insuredPersonId = scanner.nextLine();

            System.out.println("Input the Card Number: ");
            String cardNumber = scanner.nextLine();

            System.out.println("Input the Exam Date (yyyy-MM-dd): ");
            Date examDate = sdf.parse(scanner.nextLine());

            System.out.println("Input Document Names (separated by comma): ");
            String docs = scanner.nextLine();
            List<String> documents = List.of(docs.split(","));

            System.out.println("Input the Claim Amount: ");
            double claimAmount = Double.parseDouble(scanner.nextLine());

            System.out.println("What is the status? ");
            String status = scanner.nextLine();

            System.out.println("Input Receiver Banking Info: ");
            String receiverBankingInfo = scanner.nextLine();

            Claim claim = new Claim(id, claimDate, insuredPersonId, cardNumber, examDate, documents, claimAmount, status, receiverBankingInfo);
            claimManager.addClaim(claim);

            System.out.println("The claim has been added successfully.");
        } catch (ParseException e) {
            System.out.println("Error parsing the date. Please try again.");
        } catch (NumberFormatException e) {
            System.out.println("Error parsing the claim amount. Please enter a valid number.");
        }
    }

    // Method to update a claim
    private static void updateClaim() {
        try {
            System.out.print("Enter the ID of the claim to update: ");
            String claimId = scanner.nextLine();

            System.out.println("Enter new claim details: ");

            System.out.println("Enter Claim Date (yyyy-MM-dd): ");
            Date claimDate = sdf.parse(scanner.nextLine());

            System.out.println("Enter Insured Person ID: ");
            String insuredPersonId = scanner.nextLine();

            System.out.println("Enter Card Number: ");
            String cardNumber = scanner.nextLine();

            System.out.println("Enter Exam Date (yyyy-MM-dd): ");
            Date examDate = sdf.parse(scanner.nextLine());

            System.out.println("Enter Document Names (separated by comma): ");
            String docs = scanner.nextLine();
            List<String> documents = List.of(docs.split(","));

            System.out.println("Enter Claim Amount: ");
            double claimAmount = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter Status: ");
            String status = scanner.nextLine();

            System.out.println("Enter Receiver Banking Info: ");
            String receiverBankingInfo = scanner.nextLine();

            Claim updatedClaim = new Claim(claimId, claimDate, insuredPersonId, cardNumber, examDate, documents, claimAmount, status, receiverBankingInfo);
            claimManager.updateClaim(claimId, updatedClaim);

            System.out.println("Claim updated successfully.");
        } catch (ParseException e) {
            System.out.println("Error parsing the date. Please try again.");
        } catch (NumberFormatException e) {
            System.out.println("Error parsing the claim amount. Please enter a valid number.");
        }
    }

    // Method to delete a claim
    private static void deleteClaim() {
        System.out.print("Enter the ID of the claim to delete: ");
        String claimId = scanner.nextLine();

        boolean isDeleted = claimManager.deleteClaim(claimId);
        if (isDeleted) {
            System.out.println("Claim deleted successfully.");
        } else {
            System.out.println("Claim not found.");
        }
    }

    //Save and update data when users want to exit the system
    private static void saveDataAndExit() {
        try {
            System.out.println("Saving... Please wait.");
            FileManager.writeClaims(claimManager.getAll(), CLAIMS_FILE_PATH);
            System.out.println("Data is saved successfully. Good bye!");
            System.exit(0);
        } catch (IOException e) {
            System.err.println("Oops! Failed to save data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // The main entry point of the Insurance Claims Management System
    public static void main(String[] args) {
        try {
            customers = FileManager.readCustomers(CUSTOMERS_FILE_PATH);
            insuranceCards = FileManager.readInsuranceCards(INSURANCE_CARDS_FILE_PATH);
            List<Claim> claims = FileManager.readClaims(CLAIMS_FILE_PATH);
            claims.forEach(claimManager::addClaim);

            associateInsuranceCardsWithCustomers();

            System.out.println("Insurance Claims Management System Initialized.");
            while (true) {
                showMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> listAllCustomers();
                    case 2 -> listAllClaims();
                    case 3 -> showClaimDetails();
                    case 4 -> addNewClaim();
                    case 5 -> updateClaim();
                    case 6 -> deleteClaim();
                    case 0 -> {
                        saveDataAndExit();
                        return; // exit main program running
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error initializing system: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
