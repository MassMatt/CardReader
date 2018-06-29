import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyApplication {


    List<String> charList = new ArrayList<String>();

    List<Card> cardList = new ArrayList<Card>();


    public MyApplication() {

        charList.add("1");
        charList.add("2");
        charList.add("3");
        charList.add("4");
        charList.add("5");
        charList.add("6");
        charList.add("7");
        charList.add("8");
        charList.add("9");
        charList.add("10");
        charList.add("A");
        charList.add("J");
        charList.add("Q");
        charList.add("K");

        for (String str : charList) {
            buildLists(str);
        }

        displayCardsInList(50);


        for (int i =0; i < 50; i ++) {
            System.out.println(rng(14));
        }

    }


    private void buildLists(String dirUrlStr) {

        try {
            int[][] tempArr = new int[140][140];

            for (int k = 0; k < 199; k++) {
                BufferedImage hugeImage = null;

                hugeImage = ImageIO.read(MyApplication.class.getResource("./" + dirUrlStr + "/" + k + ".jpg"));

                int[][] result = convertTo2DUsingGetRGB(hugeImage);

                for (int i = 0; i < 140; i++) {
                    for (int j = 0; j < 140; j++) {
                        if (result[i][j] != -1) {
                            tempArr[i][j]++;

                        }
                    }
                }


            }

            Card card = new Card(dirUrlStr);
            card.setResultArr(tempArr);
            cardList.add(card);
            System.out.println(dirUrlStr + " card added.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void displayCardsInList (int weight) {
        for (Card card : cardList) {
            for (int i = 0; i < card.getResultArr().length; i++) {
                for (int j = 0; j < card.getResultArr()[i].length; j++) {
                    if (card.getResultArr()[i][j] > weight) {
                        System.out.print("X");
                    } else {
                        System.out.print("0");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }



    private static int[][] convertTo2DUsingGetRGB(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] result = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                result[row][col] = image.getRGB(col, row);
            }
        }

        return result;
    }


    public int rng (int max) {

        Random random =new Random();

        return random.nextInt(max);
    }


}
