package ui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import components.Assembler;

public class AssemblerPanel extends JFrame {

    private final JFileChooser fileChooser = new JFileChooser();

    private Assembler assembler;

    public JTextField inputField;

    public JTextField startingAddressField;

    public JButton selectFileButton;

    public JButton assembleButton;

    public AssemblerPanel(Assembler assembler) {
        super("Assembler");
        setSize(600, 200);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setup input file dialog
        fileChooser.setDialogTitle("Select source asm file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Minicomputer Assembly (.txt)", "txt", "asm"));

        // Setup input field
        JLabel inputLabel = new JLabel("Input file:");
        inputField = new JTextField();
        inputField.setMargin(new Insets(5, 5, 5, 5));

        // Setup file select button
        selectFileButton = new JButton("Select file");
        selectFileButton.addActionListener(e -> {
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                inputField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });

        // Setup assemble button
        assembleButton = new JButton("Assemble");
        assembleButton.addActionListener(e -> {
            try {
                assembler.run(new File(inputField.getText()), new File(inputField.getText() + ".txt"));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel footer = new JPanel();
        footer.setBackground(Color.WHITE);
        footer.add(assembleButton);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(inputLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(inputField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.weightx = 0.05;
        panel.add(selectFileButton, gbc);

        add(panel, BorderLayout.NORTH);
        add(footer, BorderLayout.SOUTH);
    }

}
