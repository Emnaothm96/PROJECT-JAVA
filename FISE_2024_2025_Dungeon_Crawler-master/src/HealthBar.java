import java.awt.*;

public class HealthBar {
    private DynamicSprite sprite;

    public HealthBar(DynamicSprite sprite){
        this.sprite=sprite;
    }

    public void draw(Graphics g){
        int barWidth= (int) sprite.getWidth();
        int barHeight=5;
        int x = (int) sprite.getX();
        int y= (int) sprite.getY() - barHeight - 5;

        // Vérification : maxHealth ne doit pas être zéro
        if (sprite.getMaxHealth() <= 0) {
            // Si maxHealth est 0 ou négatif, on ne dessine rien ou une barre entièrement rouge
            g.setColor(Color.RED);
            g.fillRect(x, y, barWidth, barHeight);
            return; // Sortir pour éviter la division par zéro
        }

        int HealthWidth= (sprite.getCurrentHealth()) / (sprite.getMaxHealth()* barWidth);

        g.setColor(Color.RED);
        g.fillRect(x, y, barWidth, barHeight);

        g.setColor(Color.GREEN);
        g.fillRect(x, y, HealthWidth, barHeight);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, barWidth, barHeight);





    }
}
