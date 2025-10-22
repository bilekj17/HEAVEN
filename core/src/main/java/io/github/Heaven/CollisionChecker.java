package io.github.Heaven;

import Entity.Player;
import Tile.TileManager;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public class CollisionChecker {
    TileManager tileM;

    public CollisionChecker(TileManager tileM) {
        this.tileM = tileM;
    }

    public boolean checkTile(Player entity) {
        Rectangle rect = new Rectangle(
            entity.worldX + entity.solidArea.x,
            entity.worldY + entity.solidArea.y,
            entity.solidArea.width,
            entity.solidArea.height
        );

        int leftCol = (int)(rect.x / Main.TILE_SIZE);
        int rightCol = (int)((rect.x + rect.width) / Main.TILE_SIZE);
        int topRow = (int)((rect.y + rect.height) / Main.TILE_SIZE);
        int bottomRow = (int)(rect.y / Main.TILE_SIZE);

        int tile1, tile2;
        switch (entity.direction) {
            case "up" -> {
                tile1 = tileM.map[leftCol][topRow];
                tile2 = tileM.map[rightCol][topRow];
            }
            case "down" -> {
                tile1 = tileM.map[leftCol][bottomRow];
                tile2 = tileM.map[rightCol][bottomRow];
            }
            case "left" -> {
                tile1 = tileM.map[leftCol][topRow];
                tile2 = tileM.map[leftCol][bottomRow];
            }
            case "right" -> {
                tile1 = tileM.map[rightCol][topRow];
                tile2 = tileM.map[rightCol][bottomRow];
            }
            default -> { return false; }
        }
        return tileM.tiles[tile1].collision || tileM.tiles[tile2].collision;
    }
}
