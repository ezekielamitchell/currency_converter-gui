package io.ezekielamitchell;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


/******************************************************************************
 * @author Ezekiel A. Mitchell
 * @date 01 July 2022
 * This program produces a simple currency conversion tool
 ******************************************************************************/
public class Main implements ActionListener {

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    String strDate= formatter.format(date);

    JFrame frame = new JFrame("Ezekiel's USD Currency Converter (" + strDate + ")");
    Font font1 = new Font("Currier", Font.BOLD, 13);

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
        frame.setSize(500,210);
        frame.setLayout(new BorderLayout());

        // conversion field
        JTextField fieldConversion = new JTextField();
        fieldConversion.setPreferredSize(new Dimension(250,20));
        fieldConversion.setEditable(false);


        // usdAmount field
        JTextField usdAmountField = new JTextField();
        usdAmountField.setPreferredSize(new Dimension(250,20));


        // converter box
        String[] currency = {"Select Currency", "Yen"};
        JComboBox<String> converterBox = new JComboBox<>(currency);
        converterBox.setPreferredSize(new Dimension(250, 50));

        // convert button
        JButton convertButton = new JButton("Convert");
        convertButton.setPreferredSize(new Dimension(250, 25));


        // panelNorth
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelNorth.add(usdLabel);
        panelNorth.add(fieldConversion);
//        panelNorth.setBackground(Color.GREEN);
        panelNorth.setPreferredSize(new Dimension(5000,50));

        // panelCenter
        panelCenter.setLayout(new FlowLayout(FlowLayout.RIGHT));
//        panelCenter.setBackground(Color.BLUE);
        panelCenter.setPreferredSize(new Dimension(5000, 350));
        panelCenter.add(usdAmountLabel);
        panelCenter.add(usdAmountField);

        JPanel panelConversion = new JPanel();
//        panelConversion.setBackground(Color.YELLOW);
        panelConversion.setPreferredSize(new Dimension(5000,50));
        panelConversion.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelConversion.add(conversionLabel);
        panelConversion.add(converterBox);
        panelCenter.add(panelConversion, BorderLayout.NORTH);

        // panelSouth
//        panelSouth.setBackground(Color.red);
        panelSouth.setPreferredSize(new Dimension(500,50));
        panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSouth.add(convertButton);

        // frame final
        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelCenter, BorderLayout.CENTER);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Main main = new Main();
    }


}
