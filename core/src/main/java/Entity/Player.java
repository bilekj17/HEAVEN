package Entity;

import Objects.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.Heaven.CollisionChecker;
import io.github.Heaven.KeyHandler;
import io.github.Heaven.Main;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public class Player {
    public float worldX, worldY;
    public float speed = 4;
    public String direction = "down";
    public boolean collisionOn = false;

    Texture up, down, left, right;
    KeyHandler keyH;
    CollisionChecker cChecker;
    public Rectangle solidArea;

    public Player(KeyHandler keyH, CollisionChecker cChecker) {
        this.keyH = keyH;
        this.cChecker = cChecker;

        worldX = 6 * Main.TILE_SIZE;
        worldY = 5 * Main.TILE_SIZE;

        solidArea = new Rectangle(8, 16, 32, 32);

        up = new Texture("player/up.png");
        down = new Texture("player/standing.png");
        left = new Texture("player/left1.png");
        right = new Texture("player/right1.png");
    }

    public void update() {
        if (keyH.up || keyH.down || keyH.left || keyH.right) {
            if (keyH.up) direction = "up";
            else if (keyH.down) direction = "down";
            else if (keyH.left) direction = "left";
            else if (keyH.right) direction = "right";

            collisionOn = cChecker.checkTile(this);
            if (!collisionOn) {
                switch (direction) {
                    case "up": worldY += speed; break;
                    case "down": worldY -= speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
                }
            }
        }
    }

    public void checkObjects(GameObject[] objects) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) continue;

            Rectangle playerRect = new Rectangle(worldX, worldY, Main.TILE_SIZE, Main.TILE_SIZE);
            if (playerRect.overlaps(objects[i].solidArea)) {
                switch (objects[i].name) {
                    case "Key":
                        System.out.println("Sebral jsi klíč!");
                        objects[i] = null;
                        break;
                    case "Door":
                        System.out.println("Narazil jsi na dveře!");
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void draw(SpriteBatch batch) {
        Texture image = switch (direction) {
            case "up" -> up;
            case "left" -> left;
            case "right" -> right;
            default -> down;
        };
        batch.draw(image, worldX, worldY, Main.TILE_SIZE * 2, Main.TILE_SIZE * 2);
    }
}
