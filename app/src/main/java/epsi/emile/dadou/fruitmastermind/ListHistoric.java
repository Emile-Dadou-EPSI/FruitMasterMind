package epsi.emile.dadou.fruitmastermind;


import android.graphics.drawable.Drawable;
import android.widget.ImageView;

class ListHistoric {
    private Drawable image1;
    private Drawable image2;
    private Drawable image3;
    private Drawable image4;

    private String indice1;
    private String indice2;
    private String indice3;
    private String indice4;

    public ListHistoric(Drawable image1, Drawable image2, Drawable image3, Drawable image4, String indice1, String indice2, String indice3, String indice4) {
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.indice1 = indice1;
        this.indice2 = indice2;
        this.indice3 = indice3;
        this.indice4 = indice4;
    }

    public Drawable getImage1() {
        return image1;
    }

    public Drawable getImage2() {
        return image2;
    }

    public Drawable getImage3() {
        return image3;
    }

    public Drawable getImage4() {
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

    public void setImage1(Drawable image1) {
        this.image1 = image1;
    }

    public void setImage2(Drawable image2) {
        this.image2 = image2;
    }

    public void setImage3(Drawable image3) {
        this.image3 = image3;
    }

    public void setImage4(Drawable image4) {
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
