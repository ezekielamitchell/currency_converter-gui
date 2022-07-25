package io.ezekielamitchell;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


/******************************************************************************
 * @author Ezekiel A. Mitchell
 * @date 01 July 2022
 * This program produces a simple currency conversion tool
 ******************************************************************************/


public class Main implements ActionListener {

    String strDate = "06 July 2022";

    JFrame frame = new JFrame("Ezekiel's USD Currency Converter (" + strDate + ")");
    Font font1 = new Font("Currier", Font.BOLD, 13);
    JButton convertButton;
    JTextField fieldConversion, usdAmountField;
    JComboBox<String> converterBox;
    String[] currency = {"Select Currency", "Yen", "Baht", "AUD"};

    public static final DecimalFormat DF = new DecimalFormat("0.00");

    public Main() {

        // declare JPanels
        JPanel panelNorth = new JPanel();
        JPanel panelSouth = new JPanel();
        JPanel panelCenter = new JPanel();

        // declare JLabels
        JLabel usdLabel = new JLabel("Currency Conversion Amount: ");
        usdLabel.setFont(font1);
        JLabel usdAmountLabel = new JLabel("USD Amount: ");
        usdAmountLabel.setFont(font1);
        JLabel conversionLabel = new JLabel("Converting Currency: ");
        conversionLabel.setFont(font1);


        // frame start
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 210);
        frame.setLayout(new BorderLayout());

        // conversion field
        fieldConversion = new JTextField();
        fieldConversion.setPreferredSize(new Dimension(250, 20));
        fieldConversion.setEditable(false);


        // usdAmount field
        usdAmountField = new JTextField();
        usdAmountField.setPreferredSize(new Dimension(250, 20));


        // converter box
        converterBox = new JComboBox<>(currency);
        converterBox.addActionListener(this);
        converterBox.setPreferredSize(new Dimension(250, 50));


        // convert button
        convertButton = new JButton("Convert");
        convertButton.setPreferredSize(new Dimension(250, 25));
        convertButton.addActionListener(this);


        // panelNorth
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelNorth.add(usdLabel);
        panelNorth.add(fieldConversion);
        panelNorth.setPreferredSize(new Dimension(5000, 50));

        // panelCenter
        panelCenter.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelCenter.setPreferredSize(new Dimension(5000, 350));
        panelCenter.add(usdAmountLabel);
        panelCenter.add(usdAmountField);

        JPanel panelConversion = new JPanel();
        panelConversion.setPreferredSize(new Dimension(5000, 50));
        panelConversion.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelConversion.add(conversionLabel);
        panelConversion.add(converterBox);
        panelCenter.add(panelConversion, BorderLayout.NORTH);

        // panelSouth
        panelSouth.setPreferredSize(new Dimension(500, 50));
        panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSouth.add(convertButton);

        // frame final
        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelCenter, BorderLayout.CENTER);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    // test for empty usd amount field
    public boolean checkNull() {
        return usdAmountField.getText().isEmpty();
    }

    // test to see if user input char other than an int
    public boolean testString(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == convertButton) {

            if (checkNull()) {
                fieldConversion.setText("n/a enter usd amount to convert");

            } else if (!testString(usdAmountField.getText())) {
                fieldConversion.setText("error: enter only integers");

            } else {

                // no currency selected
                if (converterBox.getSelectedIndex() == 0) {
                    fieldConversion.setText("n/a select converting currency");
                }

                // Yen
                if (converterBox.getSelectedIndex() == 1) {
                    fieldConversion.setText("¥" + Double.parseDouble(DF.format(Double.parseDouble(usdAmountField.getText()) * 135.82)));
                }


                // Baht
                if (converterBox.getSelectedIndex() == 2) {
                    fieldConversion.setText("฿" + Double.parseDouble(DF.format(Double.parseDouble(usdAmountField.getText()) * 36.28)));
                }


                // selection == AUD
                if (converterBox.getSelectedIndex() == 3) {
                    fieldConversion.setText("A$" + Double.parseDouble(DF.format(Double.parseDouble(usdAmountField.getText()) * 1.47)));
                }

            }
        }
    }




    public static void main(String[] args) {
        Main main = new Main();
    }


}
