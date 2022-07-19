package com.example;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GenerateSticker {
    public void generate(InputStream input, String text, String path) throws IOException {
        BufferedImage original = ImageIO.read(input);

        int width = original.getWidth();
        int height = original.getHeight();

        BufferedImage image = new BufferedImage(width, height + 200, BufferedImage.TRANSLUCENT);

        Graphics2D drawer = (Graphics2D) image.getGraphics();
        drawer.drawImage(original, 0, 0, null);
        drawer.setColor(Color.YELLOW);
        drawer.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        drawer.drawString(text, 50, height + 100);

        ImageIO.write(image, "png", new File(path + ".png"));
    }
}
