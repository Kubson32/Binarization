package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Image extends JFrame{

    JButton Brighter = new JButton("Brighter");
    JButton Darker = new JButton("Darker");
    JButton Binary = new JButton("Binary");
    BufferedImage img = ImageIO.read(new File("C:\\Users\\Kuba\\Desktop\\Studia\\5 semestr\\Modelowanie dyskretne\\Mapa.bmp"));

    public Image() throws IOException {
        setTitle("Project 1");
        //binaryImage
        //Brightness

        JPanel ImPanel = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(binaryImage(img), 200, 0, null);
            }
        };

        JPanel Bpanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(Brightness(img, 2), 200, 0, null);
            }
        };

        JPanel Dpanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(Brightness(img, 2), 200, 0, null);
            }
        };

        /*JPanel BuPanel = new JPanel();

        BuPanel.add(Brighter);
        Brighter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Brighter){
                    ImPanel.setBackground(Color.WHITE);

                    //ImPanel.add(Bpanel);
                    add(Bpanel);
                    System.out.println("to");
                }
            }
        });*/
        //BuPanel.add(Darker);
        //BuPanel.add(Binary);

        //add(BuPanel, BorderLayout.NORTH);
        add(ImPanel);

        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public BufferedImage Brightness(BufferedImage source, double Degree){

        BufferedImage bi = new BufferedImage(source.getWidth(null), source.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        int [] pixel = new int[4];

        bi.getGraphics().drawImage(source, 0, 0, null);

        for (int i=0; i<bi.getWidth(); i++){
            for(int j=0; j<bi.getHeight(); j++){
                bi.getRaster().getPixel(i, j, pixel);

                pixel[0] = Val((int) (pixel[0]+Degree));
                pixel[1] = Val((int) (pixel[1]+Degree));
                pixel[2] = Val((int) (pixel[2]+Degree));

                bi.getRaster().setPixel(i, j, pixel);
            }
        }
        return bi;
    }

    public BufferedImage binaryImage (BufferedImage source){

        BufferedImage bi = new BufferedImage(source.getWidth(null), source.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        int [] pixel = new int[4];

        bi.getGraphics().drawImage(source, 0, 0, null);

        for (int i=0; i<bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                bi.getRaster().getPixel(i, j, pixel);

                pixel[0] = binar((pixel[0]));
                pixel[1] = binar((pixel[1]));
                pixel[2] = binar((pixel[2]));

                bi.getRaster().setPixel(i, j, pixel);
            }
        }
        return bi;
    }

    public int Val(int value)
    {

        if (value < 0) {
            value = 0;
        }
        else if (value > 255) {
            value = 255;
        }
        return value;
    }

    public int binar(int v){
        if(v<=217){
            v = 0;
        }
        else {
            v = 255;
        }
        return v;
    }

}