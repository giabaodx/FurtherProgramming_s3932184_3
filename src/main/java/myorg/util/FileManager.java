/**
 * @author <Do Xuan Gia Bao - s3932184>
 */

package myorg.util;

import myorg.model.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileManager {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static List<Customer> readCustomers(String filePath) throws IOException {
        List<Customer> customers = new ArrayList<>();
        List<String> lines = readLines(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length < 4) continue;
            if ("P".equals(parts[0])) {
                PolicyHolder policyHolder = new PolicyHolder(parts[1], parts[2], parts[3]);
                customers.add(policyHolder);
            } else if ("D".equals(parts[0])) {
                Dependent dependent = new Dependent(parts[1], parts[2], parts[3]);
                customers.add(dependent);
            }
        }
        return customers;
    }

    public static List<InsuranceCard> readInsuranceCards(String filePath) throws IOException, ParseException {
        List<InsuranceCard> insuranceCards = new ArrayList<>();
        List<String> lines = readLines(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length < 4) continue;
            Date expirationDate = dateFormat.parse(parts[3]);
            InsuranceCard card = new InsuranceCard(parts[0], parts[1], parts[2], expirationDate);
            insuranceCards.add(card);
        }
        return insuranceCards;
    }

    public static List<Claim> readClaims(String filePath) throws IOException, ParseException {
        List<Claim> claims = new ArrayList<>();
        List<String> lines = readLines(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length < 9) continue;
            Date claimDate = dateFormat.parse(parts[1]);
            Date examDate = dateFormat.parse(parts[4]);
            List<String> documents = Arrays.asList(parts[5].split(";"));
            double claimAmount = Double.parseDouble(parts[6]);
            String status = parts[7];
            String receiverBankingInfo = parts[8];
            Claim claim = new Claim(parts[0], claimDate, parts[2], parts[3], examDate, documents, claimAmount, status, receiverBankingInfo);
            claims.add(claim);
        }
        return claims;
    }

    private static List<String> readLines(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    public static void writeLines(List<String> lines, String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
    }

    public static void writeClaims(List<Claim> claims, String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Claim claim : claims) {
            String line = String.join(",",
                    claim.getId(),
                    dateFormat.format(claim.getClaimDate()),
                    claim.getInsuredPersonId(),
                    claim.getCardNumber(),
                    dateFormat.format(claim.getExamDate()),
                    String.join(";", claim.getDocuments()),
                    String.valueOf(claim.getClaimAmount()),
                    claim.getStatus(),
                    claim.getReceiverBankingInfo());
            lines.add(line);
        }
        writeLines(lines, filePath);
    }
}