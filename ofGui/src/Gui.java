import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;
import java.util.List;

public class Gui extends JFrame implements ActionListener {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static int status_restart = 0;

    private static String cuv;
    private static Integer vieti = 0;
    private static String[] dash;
    private static String literaInput = "";
    private static String litereRele = "";
    private static List<Character> litereGhicite = new ArrayList<>();


    private final JLabel label;
    private final JButton buttonSubmit;
    private final JPanel resetare;
    private final JButton resetButton;
    private final JPanel panel;
    private final JTextField cuvAfis;
    private JTextField inputUser;


    public Gui() throws FileNotFoundException {
        super("Hang Man");

        setSize(WIDTH, HEIGHT);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cuv = textFile();

        cuvAfis = new JTextField(cuv);
        cuvAfis.setEditable(false);
        cuvAfis.setVisible(true);


        label = new JLabel();
        label.setIcon(new ImageIcon("hangthinghy+background.png"));

        panel = new JPanel();
        inputUser = new JTextField(12);
        buttonSubmit = new JButton("Incearca");
        buttonSubmit.addActionListener(this);

        //panel.add(cuvAfis);
        panel.add(inputUser);
        panel.add(buttonSubmit);

        resetare = new JPanel();
        resetButton = new JButton("Joaca din nou");
        resetButton.addActionListener(this);
        resetare.add(resetButton);
        resetButton.setVisible(true);


        this.getContentPane().add(BorderLayout.NORTH, resetare);
        this.getContentPane().add(BorderLayout.CENTER, label);
        this.getContentPane().add(BorderLayout.SOUTH, panel);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            resetGame(e);
            play(e);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        repaint();


    }

    @Override
    public void repaint(long time, int x, int y, int width, int height) {
        super.repaint(time, x, y, width, height);
        drawHangMan();

    }

    public void paint(Graphics g) {

        super.paint(g);

//        g.drawLine(120, 320, 120, 70);
//        g.drawLine(220, 70, 120, 70);
//        g.drawLine(220, 120, 220, 70);

        desenareCuvantDash(g);
        afisareIncercari(g);

    }

    private void desenareCuvantDash(Graphics g) {
        afisareCuvant();
        String res = "";
        for (int i = 0; i < dash.length; i++) {
            res += dash[i] + " ";
        }
        Font font = new Font("Serif", Font.BOLD | Font.ITALIC, 20);
        g.setColor(Color.orange);
        g.setFont(font);
        g.drawString(res, 380, 500);
    }


    public void play(ActionEvent e) throws FileNotFoundException {
        if (!getLitere(e) && literaInput != "") {
            JOptionPane.showMessageDialog(null, "Nu ai nimerit");
            vieti++;
        } else if (literaInput != "") {
            if (afisareCuvant()) {
                JOptionPane.showMessageDialog(null, "Ai Castigat");
            } else {
                JOptionPane.showMessageDialog(null, "Ai nimerit");
            }
        }
        repaint();
        if (vieti == 6) {
            JOptionPane.showMessageDialog(null, "Ai pierdut");
            JOptionPane.showMessageDialog(null, "Cuvantul era: " + cuv);
        }


    }

    public void afisareIncercari(Graphics g) {

        if (!cuv.contains(literaInput))
            litereRele = litereRele + literaInput + " ";

        Font font = new Font("Serif", Font.BOLD | Font.ITALIC, 20);
        g.setFont(font);
        g.setColor(Color.red);
        g.drawString("Litere folosite:", 10, 550);
        g.drawString(litereRele, 135, 550);

    }


    public static String textFile() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("words_alpha.txt"));
        List<String> cuvinte = new ArrayList<>();

        while (scan.hasNext()) {
            cuvinte.add(scan.nextLine());
        }
        Random rand = new Random();

        return cuvinte.get(rand.nextInt(cuvinte.size()));
    }

    public boolean afisareCuvant() {
        int corecte = 0;
        dash = new String[cuv.length()];
        for (int i = 0; i < cuv.length(); i++) {
            if (litereGhicite.contains(cuv.charAt(i))) {
                dash[i] = String.valueOf(cuv.charAt(i));
                corecte++;

            } else {
                dash[i] = "_";
            }
        }
        return cuv.length() == corecte;
    }

    public boolean getLitere(ActionEvent e) {
        if (e.getSource() == buttonSubmit) {
            literaInput = inputUser.getText().toLowerCase();
            litereGhicite.add(literaInput.charAt(0));
        }
        inputUser.setText("");
        return cuv.contains(literaInput);
    }


    public void resetGame(ActionEvent e) throws FileNotFoundException {

        if (e.getSource() == resetButton) {
            this.setVisible(false);
            Gui HangManGame = new Gui();
            HangManGame.setVisible(true);
            status_restart = 1;
            litereRele = "";
            vieti = 0;
            dash = new String[cuv.length()];
            litereGhicite = new ArrayList<>();
            literaInput = "";
            dash = new String[cuv.length()];
            inputUser = new JTextField(12);
            JOptionPane.showMessageDialog(null, "Good Luck");
        }


    }

    public void drawHangMan() {
        if (vieti >= 1) {
            label.setIcon(new ImageIcon("steve1.jpg"));
            //g.drawOval(185, 115, 51, 51);//cap
            if (vieti >= 2) {
                label.setIcon(new ImageIcon("steve2.jpg"));
                //g.drawLine(220, 220, 220, 165);//trup
            }

            if (vieti >= 3) {
                label.setIcon(new ImageIcon("steve3.jpg"));
                //g.drawLine(170, 170, 220, 195);//brat stang
            }

            if (vieti >= 4) {
                label.setIcon(new ImageIcon("steve4.jpg"));
                //g.drawLine(270, 170, 220, 195);//brat drept
            }

            if (vieti >= 5) {
                label.setIcon(new ImageIcon("steve5.jpg"));
                //g.drawLine(220, 220, 170, 270);//picior stang
            }
            if (vieti >= 6) {
                label.setIcon(new ImageIcon("steve6.jpg"));
                //g.drawLine(220, 220, 270, 270);//picior drept
            }
        }
    }
}