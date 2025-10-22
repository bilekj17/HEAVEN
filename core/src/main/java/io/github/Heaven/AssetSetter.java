package io.github.Heaven;

import Objects.GameObject;
import Objects.OBJ_Door;
import Objects.OBJ_Key;
import Objects.OBJ_Table;

public class AssetSetter {
    public GameObject[] setObjects() {
        GameObject[] objects = new GameObject[10];

        objects[0] = new OBJ_Key(7 * Main.TILE_SIZE, 8 * Main.TILE_SIZE);
        objects[1] = new OBJ_Door(7 * Main.TILE_SIZE, 1 * Main.TILE_SIZE);
        objects[2] = new OBJ_Table(7 * Main.TILE_SIZE, 6 * Main.TILE_SIZE);
        objects[3] = new OBJ_Door(7 * Main.TILE_SIZE, 10 * Main.TILE_SIZE);

        return objects;
    }
}
