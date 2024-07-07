import javax.swing.ImageIcon;
import java.awt.Image;

public class Info {
    private String name;
    private ImageIcon flag;
    private String region;
    private int population;
    private boolean isFor;

    public Info(String name, ImageIcon flag, String region, int population, boolean isFor) {
        this.name = name;
        this.flag = scaleImageIcon(flag, 50, 30); // Масштабируем изображение до нужного размера
        this.region = region;
        this.population = population;
        this.isFor = isFor;
    }

    // Геттеры и сеттеры для всех полей
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageIcon getFlag() {
        return flag;
    }

    public void setFlag(ImageIcon flag) {
        this.flag = scaleImageIcon(flag, 50, 30); // Масштабируем изображение до нужного размера
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isFor() {
        return isFor;
    }

    public void setFor(boolean isFor) {
        this.isFor = isFor;
    }

    private ImageIcon scaleImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
}
