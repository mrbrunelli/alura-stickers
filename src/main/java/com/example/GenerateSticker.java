package com.example;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
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
        int heightFactor = height / 100 * 20;

        BufferedImage image = new BufferedImage(width, height + heightFactor, BufferedImage.TRANSLUCENT);

        Graphics2D drawer = (Graphics2D) image.getGraphics();
        drawer.drawImage(original, 0, 0, null);

        Font font = new Font(Font.SERIF, Font.BOLD, width / 10);

        FontMetrics metrics = drawer.getFontMetrics(font);
        int fontPositionX = (width - metrics.stringWidth(text)) / 2;
        int fontPositionY = height + (heightFactor / 2);

        drawer.setFont(font);
        drawer.setColor(Color.YELLOW);
        drawer.drawString(text, fontPositionX, fontPositionY);

        ImageIO.write(image, "png", new File(path + ".png"));
    }
}
