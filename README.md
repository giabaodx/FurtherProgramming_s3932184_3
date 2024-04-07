# FurtherProgramming_s3932184

<!DOCTYPE html>
<html lang="en">

<body>
  <h1>Insurance Claims Management System</h1>

  <p>This is an insurance claims management system designed to allow users to manage, track, and process claims.</p>

  <h2>Features</h2>

  <ul>
    <li>Manage customers (policyholders and dependents)</li>
    <li>Manage insurance cards</li>
    <li>Manage claims (add, update, delete, view)</li>
    <li>Search for claims by ID</li>
    <li>Save and load claim data from files</li>
  </ul>

  <h2>Requirements</h2>

<ul>
    <li>Java development environment (JDK) - **Java 11 or later recommended**</li>
  </ul>

  <h2>Installing Java</h2>

  <p>This system requires a Java Development Kit (JDK) version 11 or later to run. While JDK 21 was used for development, newer versions may offer improvements and bug fixes. We recommend using the latest stable version available.</p>

  <p>To install Java, follow the steps provided by Oracle for your operating system:</p>

  <ul>
    <li>**Windows:** Visit the <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">Java SE Downloads page</a> on Oracle's website. Accept the license agreement and download the appropriate JDK installer for your Windows version (e.g., Windows x64). Run the installer and follow the on-screen instructions.</li>
    <li>**macOS:** Visit the <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">Java SE Downloads page</a> on Oracle's website. Accept the license agreement and download the JDK for macOS package. Follow the installation instructions provided by Oracle for macOS.</li>
    <li>**Linux:** Installation instructions for Linux distributions vary. You can typically install the JDK using your distribution's package manager (e.g., `apt-get`, `yum`). Refer to your distribution's documentation for specific instructions.</li>
  </ul>

  <h2>Running the System</h2>

  <ol>
    <li>Clone or download this repository.</li>
    <li>Open the project in your IDE.</li>
    <li>Run the `Main` class.</li>
  </ol>

  <h2>User Interface</h2>

  <p>The system provides a text-based user interface (TUI) for interacting with the system functionalities. Upon startup, the system will load data from text files and display the main menu.</p>

  <h2>Main Menu Options</h2>

  <ol>
    <li><strong>View All Customers:</strong> List all customers with their details (including insurance card information if available).</li>
    <li><strong>View All Claims:</strong> List all claims with their details (ID, date, amount, status, etc.).</li>
    <li><strong>Input Claims ID:</strong> Search for a specific claim by entering its ID.</li>
    <li><strong>Add Claims:</strong> Add a new claim by providing details such as date, insured person, card number, documents, amount, status, and receiver banking information.</li>
    <li><strong>Modify a Claim:</strong> Update an existing claim by entering its ID and providing new details.</li>
    <li><strong>Delete a Claim:</strong> Delete a claim by entering its ID.</li>
    <li><strong>Exit:</strong> Save data and exit the system.</li>
  </ol>

  <h2>Data Files</h2>

  <p>The system uses text files to store customer, insurance card, and claim data. These files are located in the `src/main/resources` directory. The system will automatically load data from these files on startup and save data back to them upon exiting.</p>

  <ul>
    <li><code>customer.txt</code>: Stores customer information (ID, full name, insurance card ID).</li>
    <li><code>insuranceCard.txt</code>: Stores insurance card information (card number, card holder ID, policy owner ID, expiration date).</li>
    <li><code>claim.txt</code>: Stores claim information (ID, date, insured person ID, card number, exam date, document list, amount, status, receiver banking info).</li>
  </ul>

  <p><strong>Note:</strong> The structure of these files is not intended to be modified by users. The system will handle data serialization and deserialization during load and save operations.</p>

  <h2>Sample Data Files</h2>

  <p>The repository includes sample data files containing at least 15 entries for each entity (customer, insurance card, claim). These files are for demonstration purposes only and can be replaced with your own data.</p>

  <p>This README provides a basic guide to using the insurance claims management system. If you encounter any issues or have questions, feel free to consult the code documentation or contact the developer.</p>
</body>
</html>
