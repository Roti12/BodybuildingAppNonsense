package no.uib.info216.assignment.GUI;

import no.uib.info216.assignment.excercises.Exercise;

import javax.swing.*;
import java.awt.*;

public class PopupExercises {

    private JPanel panel;


    public PopupExercises(String name, Exercise data) {

        JFrame frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));


        frame.setSize(500, 300);
        frame.setTitle(name);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        addData(data);
        frame.add(panel);
        frame.setVisible(true);

    }

    private void addData(Exercise data) {

        if(data.getMusclesString() != null) {
            panel.add(new JLabel("Muscles Worked :"));
            panel.add(new JTextField(data.getMusclesString()));
            panel.add(new JSeparator());
        }

        if(data.getCan_use() != null ) {
            panel.add(new JLabel("Can use :"));
            panel.add(new JTextField(data.getCan_UseString()));
            panel.add(new JSeparator());
        }

        if(data.getEquipment() != null) {
            panel.add(new JLabel("Requires :"));
            panel.add(new JTextField(data.getEquipment().getLocalName()));
            panel.add(new JSeparator());
        }
        if( data.getDescription() != null) {
            panel.add(new JLabel("Definition :"));
            panel.add(new JTextField(data.getDescription().getString()));
            panel.add(new JSeparator());
        }

    }
}


