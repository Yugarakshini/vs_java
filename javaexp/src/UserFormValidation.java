import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserFormValidation extends JFrame {
    private JTextField nameField, emailField, phoneField;
    private JLabel nameLabel, emailLabel, phoneLabel, resultLabel;

    public UserFormValidation() {
        setTitle("User Form Validation");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        nameField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);
        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        phoneLabel = new JLabel("Phone:");
        resultLabel = new JLabel();

        // Create a button and attach an ActionListener for validation
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateInputs();
            }
        });

        // Set layout using GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(emailLabel, gbc);

        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(phoneLabel, gbc);

        gbc.gridx = 1;
        add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(submitButton, gbc);

        gbc.gridy = 4;
        add(resultLabel, gbc);
    }

    private void validateInputs() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        // Regular expressions for basic validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String phoneRegex = "^[2-9]\\d{2}-\\d{3}-\\d{4}$";

        // Validate name (non-empty)
        if (name.isEmpty()) {
            showError("Name cannot be empty.");
            return;
        }

        // Validate email using regex
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);
        if (!emailMatcher.matches()) {
            showError("Invalid email address.");
            return;
        }

        // Validate phone number using regex
        Pattern phonePattern = Pattern.compile(phoneRegex);
        Matcher phoneMatcher = phonePattern.matcher(phone);
        if (!phoneMatcher.matches()) {
            showError("Invalid phone number. Use format XXX-XXX-XXXX.");
            return;
        }

        // If all inputs are valid, show success message
        showSuccess("Form submitted successfully!");
    }

    private void showError(String message) {
        resultLabel.setForeground(Color.RED);
        resultLabel.setText(message);
    }

    private void showSuccess(String message) {
        resultLabel.setForeground(Color.GREEN.darker());
        resultLabel.setText(message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserFormValidation form = new UserFormValidation();
                form.setVisible(true);
            }
        });
    }
}
