import java.io.File;

public class Card {


    private int[][] resultArr = new int[140][140];
    private String character;
    private int sampleSize;

    public Card(String character){
        this.character = character;
        sampleSize = 0;
        setSampleSize();
    }


    public int[][] getResultArr() {
        return resultArr;
    }

    public void setResultArr(int[][] resultArr) {
        this.resultArr = resultArr;
    }

    public String getCharacter() {
        return character;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize() {
        
    }
}
