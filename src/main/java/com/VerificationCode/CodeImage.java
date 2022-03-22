package com.VerificationCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

public class CodeImage {
    /**
     * BufferedImage to base64
     * 
     * @param bufferedImage
     * @param imageFormatName
     * @return image in base64
     * @throws IOException
     */
    private static String getBufferedImageToBase64(BufferedImage bufferedImage) throws IOException {

        String imageFormatName = "png";
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        ImageIO.write(bufferedImage, imageFormatName, stream);
        String base64 = Base64.getEncoder().encodeToString(stream.toByteArray());
        return base64;
    }

    /**
     * Generate verification code
     * picture size: 120 * 40
     *
     * @return Map<String, Object>, picture in base64 and verification code answer in lower case.
     */
    public static Map<String, Object> generateCode() throws IOException {
        final int WIDTH = 120;
        final int HEIGHT = 40;
        final int FONT_SIZE = 30;
        int char_x = 10;
        final int CHAR_Y = 33;
        final int OFFSET = 25;
        final int CODE_LENGTH = 4;
        final int RAND_LINE_NUM = 5;
        final int RAND_LINE_START_X = 20;
        final int RAND_LINE_END_X = 80;

        String answer = "";

        final String[] CHARS = {
                "2", "3", "4", "5", "6", "7", "8", "9",
                "a", "b", "c", "d", "e", "f", "g", "h",
                "j", "k", "m", "n", "p", "q", "r", "s",
                "t", "u", "v", "w", "x", "y", "z", "A",
                "B", "C", "D", "E", "F", "G", "H", "J",
                "K", "M", "N", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z" };

        final Color[] COLORS = { Color.RED, Color.BLUE, Color.GREEN, Color.WHITE, Color.BLACK };

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        Map<String, Object> vcMap = new HashMap<>();

        // Pen
        Graphics pen = image.getGraphics();

        // Set background color
        pen.setColor(Color.GRAY);
        pen.fillRect(0, 0, WIDTH, HEIGHT);

        // Font: Times
        pen.setFont(new Font(null, Font.PLAIN, FONT_SIZE));

        Random randNum = new Random();

        // Generate the verification code
        for (int i = 0; i < CODE_LENGTH; i++) {
            int charIdx = randNum.nextInt(CHARS.length);
            int colorIdx = randNum.nextInt(COLORS.length);

            pen.setColor(COLORS[colorIdx]);
            pen.drawString(CHARS[charIdx], char_x, CHAR_Y);

            answer += CHARS[charIdx];
            char_x += OFFSET;
        }

        // Draw random lines
        pen.setColor(Color.BLACK);
        // Set coordinates of lines

        for (int i = 0; i < RAND_LINE_NUM; i++) {
            int x1 = randNum.nextInt(RAND_LINE_START_X);
            int y1 = randNum.nextInt(HEIGHT);
            int x2 = randNum.nextInt(RAND_LINE_START_X) + RAND_LINE_END_X;
            int y2 = randNum.nextInt(HEIGHT);

            pen.drawLine(x1, y1, x2, y2);
        }

        String base64 = getBufferedImageToBase64(image);

        vcMap.put("base64", base64);
        vcMap.put("ansewr", answer.toLowerCase());

        return vcMap;
    }

}
