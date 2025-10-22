package Tile;

import Entity.Player;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.Heaven.Main;

public class TileManager {
    public Tile[] tiles;
    public int[][] map;

    public TileManager() {
        tiles = new Tile[10];
        map = new int[Main.WORLD_COLS][Main.WORLD_ROWS];

        tiles[0] = new Tile(new Texture("tiles/drevena_podlaha_light.png"), false);
        tiles[1] = new Tile(new Texture("tiles/kamena_zed.png"), true);

        // jednoduchá testovací mapa
        for (int x = 0; x < Main.WORLD_COLS; x++) {
            for (int y = 0; y < Main.WORLD_ROWS; y++) {
                map[x][y] = (x == 0 || y == 0 || x == Main.WORLD_COLS - 1 || y == Main.WORLD_ROWS - 1) ? 1 : 0;
            }
        }
    }

    public void draw(SpriteBatch batch, Player player) {
        for (int x = 0; x < Main.WORLD_COLS; x++) {
            for (int y = 0; y < Main.WORLD_ROWS; y++) {
                Tile t = tiles[map[x][y]];
                batch.draw(t.texture, x * Main.TILE_SIZE, y * Main.TILE_SIZE,
                    Main.TILE_SIZE, Main.TILE_SIZE);
            }
        }
    }

    public void dispose() {
        for (Tile t : tiles) {
            if (t != null && t.texture != null)
                t.texture.dispose();
        }
    }
}
