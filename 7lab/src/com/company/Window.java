package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Window extends JFrame {
    private JPanel mainPanel;
    private Window window;

    private JTextField minValue;
    private JTextField maxValue;
    private int min;
    private int max;
    private JButton guessButton;
    private JPanel innerPanel;
    private JLabel guessedNumber;


    Window(){
        super("Игра Больше-Меньше");
        window = this;

        setBounds(400, 250, 400, 250);
        setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        innerPanel = new JPanel(new BorderLayout());
        innerPanel.setBounds(10, 100, 350, 75);
        innerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        createLookMenu();
        createMainPanel();
        createInnerPanel();
        innerPanel.setVisible(false);
    }

    private void createMainPanel(){
        JLabel labelMin = new JLabel("Мин.значение:");
        labelMin.setBounds(10, 20, 100, 25);
        minValue = new JTextField();
        minValue.setBounds(120, 20, 100, 25);

        JLabel labelMax = new JLabel("Макс.значение:");
        labelMax.setBounds(10, 50, 100, 25);
        maxValue = new JTextField();
        maxValue.setBounds(120, 50, 100, 25);

        guessButton = new JButton("Играть");
        guessButton.setBounds(250, 35, 100, 30);

        guessButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                guessNumber();
            }
        });
        mainPanel.add(labelMin);
        mainPanel.add(minValue);
        mainPanel.add(labelMax);
        mainPanel.add(maxValue);
        mainPanel.add(guessButton);
        add(mainPanel, null);
    }

    private void guessNumber(){
        if(minValue.getText().length() != 0 && maxValue.getText().length() != 0) {
            try {
                min = Integer.parseInt(minValue.getText());
                max = Integer.parseInt(maxValue.getText());
                if (max > min && min >= 0) {
                    innerPanel.setVisible(true);
                    minValue.setEnabled(false);
                    maxValue.setEnabled(false);
                    guessButton.setEnabled(false);
                    int number = generateNumber(min, max);
                    guessedNumber.setText(String.valueOf(number));
                } else {
                    JOptionPane.showMessageDialog(mainPanel, new String[]{"Числа должны быть положительным", "Максимальное значение должно быть больше минимального! "}, "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ignored) {
                JOptionPane.showMessageDialog(mainPanel, new String[]{"Проверьте целочисленность введенных данных!"}, "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private int generateNumber(int a, int b){
        Random random = new Random();
        return a + random.nextInt(b-a+1);
    }

    private void createInnerPanel(){
        JPanel labelPanel = new JPanel(new FlowLayout());
        JLabel jLabel = new JLabel("Я думаю, что это число ");
        guessedNumber = new JLabel("0");
        labelPanel.add(jLabel);
        labelPanel.add(guessedNumber);
        innerPanel.add(labelPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton isGreater = new JButton("Больше");
        isGreater.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int answer = Integer.parseInt(guessedNumber.getText());
                if(answer==max){
                    int result = JOptionPane.showConfirmDialog(mainPanel, new String[]{"Ты жулик! Сыграем еще раз?"}, "Сообщение", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                        dispose();
                        window = new Window();
                        window.setVisible(true);
                    }
                    else{
                        dispose();
                    }
                }
                else {
                    if(min == answer){
                        min++;
                    }
                    else {
                        min = answer + 1;
                    }
                    int number = generateNumber(min, max);
                    guessedNumber.setText(String.valueOf(number));
                }
            }
        });
        buttonPanel.add(isGreater);
        JButton isLess = new JButton("Меньше");
        isLess.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int answer = Integer.parseInt(guessedNumber.getText());
                if(min==answer){
                    int result = JOptionPane.showConfirmDialog(mainPanel, new String[]{"Ты жулик! Сыграем еще раз?"}, "Сообщение", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                        dispose();
                        window = new Window();
                        window.setVisible(true);
                    }
                    else{
                        dispose();
                    }
                }
                else {
                    if(max == answer){
                        max--;
                    }
                    else {
                        max = answer - 1;
                    }
                    int number = generateNumber(min, max);
                    guessedNumber.setText(String.valueOf(number));
                }
            }
        });
        buttonPanel.add(isLess);
        JButton isRight = new JButton("Угадал");
        isRight.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int result = JOptionPane.showConfirmDialog(mainPanel, new String[]{"Отлично, я угадал число! Сыграем еще раз?"}, "Сообщение", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    dispose();
                    window = new Window();
                    window.setVisible(true);
                }
                else{
                    dispose();
                }
            }
        });
        buttonPanel.add(isRight);
        innerPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(innerPanel);
    }

    private void createLookMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu lookAndFeel = new JMenu("Внешний вид");
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButtonMenuItem lookAndFeelWindows = createButtonLook("Windows", "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        JRadioButtonMenuItem lookAndFeelMetal = createButtonLook("Metal", "javax.swing.plaf.metal.MetalLookAndFeel");
        JRadioButtonMenuItem lookAndFeelMotif = createButtonLook("Motif", "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        JRadioButtonMenuItem lookAndFeelNimbus = createButtonLook("Nimbus", "javax.swing.plaf.nimbus.NimbusLookAndFeel");
        JRadioButtonMenuItem lookAndFeelClWindows = createButtonLook("Classical Windows", "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        lookAndFeelMetal.setSelected(true);
        buttonGroup.add(lookAndFeelWindows);
        buttonGroup.add(lookAndFeelMetal);
        buttonGroup.add(lookAndFeelMotif);
        buttonGroup.add(lookAndFeelNimbus);
        buttonGroup.add(lookAndFeelClWindows);
        lookAndFeel.add(lookAndFeelWindows);
        lookAndFeel.add(lookAndFeelNimbus);
        lookAndFeel.add(lookAndFeelMetal);
        lookAndFeel.add(lookAndFeelMotif);
        lookAndFeel.add(lookAndFeelClWindows);
        menuBar.add(lookAndFeel);
        JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.add(menuBar);
        add(menuPanel, BorderLayout.NORTH);
    }

    private JRadioButtonMenuItem createButtonLook(String text, String path){
        JRadioButtonMenuItem lookAndFeel = new JRadioButtonMenuItem(text);
        lookAndFeel.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel(path);
                SwingUtilities.updateComponentTreeUI(getContentPane());
            }
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex){
                ex.printStackTrace();
            }
        });
        return lookAndFeel;
    }
}
