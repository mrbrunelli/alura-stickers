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
    private int width;
    private int height;

    public void generate(InputStream input, String text, String path) throws IOException {
        BufferedImage original = ImageIO.read(input);

        width = original.getWidth();
        height = original.getHeight();
        int extraHeight = getExtraHeight();

        BufferedImage image = new BufferedImage(width, height + extraHeight, BufferedImage.TRANSLUCENT);

        Graphics2D drawer = (Graphics2D) image.getGraphics();
        drawer.drawImage(original, 0, 0, null);

        Font font = new Font(Font.SERIF, Font.BOLD, getFontSize());

        FontMetrics metrics = drawer.getFontMetrics(font);
        int fontPositionX = (width - metrics.stringWidth(text)) / 2;
        int fontPositionY = height + (extraHeight / 2);

        drawer.setFont(font);
        drawer.setColor(Color.YELLOW);
        drawer.drawString(text, fontPositionX, fontPositionY);

        ImageIO.write(image, "png", new File(path + ".png"));
    }

    private int getExtraHeight() {
        return (int) (height * 0.20);
    }

    private int getFontSize() {
        return width / 10;
    }
}
