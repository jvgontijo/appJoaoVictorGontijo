package br.com.infnet.appJoaoVictorGontijo.character;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Appearance {

    private String hairColor;

    private String eyesColor;

    private double height;

    private double weight;

    private boolean visible;

    public void updateAppearance(
            String hairColor,
            String eyeColor,
            double height,
            double weight,
            boolean isVisible
    ) {
        this.hairColor = hairColor;
        this.eyesColor = eyeColor;
        this.height = height;
        this.weight = weight;
        this.visible = isVisible;
    }

    @Override
    public String toString() {
        return "Appearance { " +
                "hairColor: " + hairColor +
                ", eyesColor:" + eyesColor +
                ", height: " + height +
                ", weight: " + weight +
                ", isVisible: " + visible +
                " }";
    }
}
