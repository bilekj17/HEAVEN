package Objects;

import Entity.Player;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.Heaven.Main;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public class GameObject {
    public Texture texture;
    public String name;
    public boolean collision;
    public float worldX, worldY;
    public Rectangle solidArea;

    public GameObject(String name, String texturePath, boolean collision, float x, float y) {
        this.name = name;
        this.texture = new Texture(texturePath);
        this.collision = collision;
        this.worldX = x;
        this.worldY = y;
        this.solidArea = new Rectangle(x, y, Main.TILE_SIZE, Main.TILE_SIZE);
    }

    public void draw(SpriteBatch batch, Player player) {
        float screenX = worldX - player.worldX + Main.SCREEN_WIDTH / 2f - Main.TILE_SIZE;
        float screenY = worldY - player.worldY + Main.SCREEN_HEIGHT / 2f - Main.TILE_SIZE;

        batch.draw(texture, screenX, screenY, Main.TILE_SIZE * 2, Main.TILE_SIZE * 2);
    }

    public void dispose() {
        texture.dispose();
    }
}
