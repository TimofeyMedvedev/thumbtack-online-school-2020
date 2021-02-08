package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.figures.v3.ColoredRectangle;
import net.thumbtack.school.figures.v3.Rectangle;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileService {
    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        return readByteArrayFromBinaryFile(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] array = new byte[fis.available()];
            fis.read(array);
            return array;
        }
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        byte[] byteArray = null;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            baos.write(array);
            byteArray = baos.toByteArray();
        }

        byte[] result = new byte[byteArray.length % 2 == 0 ? byteArray.length / 2 : byteArray.length / 2 + 1];
        try (ByteArrayInputStream bais = new ByteArrayInputStream(byteArray)) {
            for(int i = 0; i < result.length; i++) {
                result[i] = (byte) bais.read();
                bais.skip(1);
            }
        }
        return result;
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFileBuffered(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
            bos.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        return readByteArrayFromBinaryFileBuffered(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            byte[] array = new byte[bis.available()];
            bis.read(array);
            return array;
        }
    }

    public static void writeRectangleToBinaryFile(File file, Rectangle rect) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            writeRectangleToBinaryFile(rect, dos);
        }
    }

    public static Rectangle readRectangleFromBinaryFile(File file) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            return new Rectangle(dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt());
        }
    }

    public static void writeColoredRectangleToBinaryFile(File file, ColoredRectangle rect) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeInt(rect.getBottomRight().getY());
            dos.writeUTF(rect.getColor().toString());
        }
    }

    public static ColoredRectangle readColoredRectangleFromBinaryFile(File file) throws IOException, ColorException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            return new ColoredRectangle(dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt(), dis.readUTF());
        }
    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            for (Rectangle rect : rects) {
                writeRectangleToBinaryFile(rect, dos);
            }
        }
    }

    private static void writeRectangleToBinaryFile(Rectangle rect, DataOutputStream dos) throws IOException {
        dos.writeInt(rect.getTopLeft().getX());
        dos.writeInt(rect.getTopLeft().getY());
        dos.writeInt(rect.getBottomRight().getX());
        dos.writeInt(rect.getBottomRight().getY());
    }

    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            Rectangle[] rects = new Rectangle[(int) file.length() / 16];
            for (int i = 0; i < rects.length; i++) {
                raf.seek((rects.length - 1 - i) * 16);
                int leftX = raf.readInt();
                int leftY = raf.readInt();
                int rightX = raf.readInt();
                int rightY = raf.readInt();
                rects[i] = new Rectangle(leftX, leftY, rightX, rightY);
            }
            return rects;
        }
    }

    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) throws IOException {
        try (PrintStream ps = new PrintStream(file)) {
            ps.printf("%d %d %d %d", rect.getTopLeft().getX(), rect.getTopLeft().getY(),
                    rect.getBottomRight().getX(), rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] data = reader.readLine().split(" ");
            return new Rectangle(Integer.parseInt(data[0]), Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]), Integer.parseInt(data[3]));
        }
    }

    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) throws IOException {
        try (PrintStream ps = new PrintStream(file)) {
            ps.println(rect.getTopLeft().getX());
            ps.println(rect.getTopLeft().getY());
            ps.println(rect.getBottomRight().getX());
            ps.print(rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromTextFileFourLines(File file) throws IOException {
        int[] coordinates = new int[4];
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < coordinates.length; i++) {
                coordinates[i] = Integer.parseInt(reader.readLine());
            }
        }
        return new Rectangle(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            osw.write(trainee.getFirstName() + " " + trainee.getLastName() + " " + trainee.getRating());
        }
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException, TrainingException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            String[] data = reader.readLine().split(" ");
            return new Trainee(data[0], data[1], Integer.parseInt(data[2]));
        }
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            osw.write(trainee.getFirstName() +"\r\n");
            osw.write(trainee.getLastName() + "\r\n");
            osw.write(trainee.getRating() + "");
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            return new Trainee(reader.readLine(), reader.readLine(), Integer.parseInt(reader.readLine()));
        }
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(trainee);
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return  (Trainee) ois.readObject();
        }
    }

    public static String serializeTraineeToJsonString(Trainee trainee) {
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }

    public static Trainee deserializeTraineeFromJsonString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Trainee.class);
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            Gson gson = new Gson();
            gson.toJson(trainee, bw);
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            Gson gson = new Gson();
           return gson.fromJson(br, Trainee.class);
        }
    }
}
