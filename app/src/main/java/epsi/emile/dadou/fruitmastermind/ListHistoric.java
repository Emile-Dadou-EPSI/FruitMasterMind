package epsi.emile.dadou.fruitmastermind;


import android.widget.ImageView;

class ListHistoric {
    private int image1;
    private int image2;
    private int image3;
    private int image4;

    private String indice1;
    private String indice2;
    private String indice3;
    private String indice4;

    public ListHistoric(int image1, int image2, int image3, int image4, String indice1, String indice2, String indice3, String indice4) {
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.indice1 = indice1;
        this.indice2 = indice2;
        this.indice3 = indice3;
        this.indice4 = indice4;
    }

    public ListHistoric(ImageView image1, ImageView image2, ImageView image3, ImageView image4, String indice1, String indice2, String indice3, String indice4) {
    }

    public int getImage1() {
        return image1;
    }

    public int getImage2() {
        return image2;
    }

    public int getImage3() {
        return image3;
    }

    public int getImage4() {
        return image4;
    }

    public String getIndice1() {
        return indice1;
    }

    public String getIndice2() {
        return indice2;
    }

    public String getIndice3() {
        return indice3;
    }

    public String getIndice4() {
        return indice4;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public void setImage3(int image3) {
        this.image3 = image3;
    }

    public void setImage4(int image4) {
        this.image4 = image4;
    }

    public void setIndice1(String indice1) {
        this.indice1 = indice1;
    }

    public void setIndice2(String indice2) {
        this.indice2 = indice2;
    }

    public void setIndice3(String indice3) {
        this.indice3 = indice3;
    }

    public void setIndice4(String indice4) {
        this.indice4 = indice4;
    }

}
