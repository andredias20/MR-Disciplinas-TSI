package com.github.andredias20.observer.dry.app.view;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

public class AppView extends JFrame {

    private static final long serialVersionUID = 1L;

    public final JButton jbStart = new JButton("Start");
    public final JButton jbStop = new JButton("Stop");
    public final JButton jbSpeedUp = new JButton("Speed Up");
    public final JButton jbSlowDown = new JButton("Slow Down");

    public AppView(String carImage) {
        super();
        makeView(carImage);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void makeView(String carImage) {
        Container pane = super.getContentPane();

        pane .setLayout(new BorderLayout());
        var resource = Path.of("images/"+carImage).toString();
        ImageIcon icon = new ImageIcon(resource, "Some image file");
        pane.add(new JLabel(icon), BorderLayout.CENTER);

        JPanel gridPane = new JPanel(new GridLayout(1, 4));
        pane.add(gridPane, BorderLayout.SOUTH);

        gridPane.add(jbStart);
        gridPane.add(jbStop);
        gridPane.add(jbSpeedUp);
        gridPane.add(jbSlowDown);

    }
}
