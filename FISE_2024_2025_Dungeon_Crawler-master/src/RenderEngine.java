import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class RenderEngine extends JPanel implements Engine{
    private ArrayList<Displayable> renderList;

    public RenderEngine(JFrame jFrame) {
        renderList = new ArrayList<>();
    }

    public void addToRenderList(Displayable displayable){
        if (!renderList.contains(displayable)){
            renderList.add(displayable);
        }
    }

    public void addToRenderList(ArrayList<Displayable> displayable){
        if (!renderList.contains(displayable)){
            renderList.addAll(displayable);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Displayable displayable : renderList) {
            displayable.draw(g);
            if (displayable instanceof DynamicSprite) {
                new HealthBar((DynamicSprite) displayable).draw(g);
            }
        }
    }

    @Override
    public void update(){
        this.repaint();
    }
}
