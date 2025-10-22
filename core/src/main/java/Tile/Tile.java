package Tile;

import com.badlogic.gdx.graphics.Texture;

public class Tile {
    /** Obrázek dlaždice (textura) */
    public Texture texture;

    /** Určuje, zda je dlaždice neprůchodná (např. zeď) */
    public boolean collision = false;

    /**
     * Konstruktor pro vytvoření nové dlaždice.
     * @param texturePath cesta k souboru textury (např. "tiles/wall.png")
     * @param collision zda má dlaždice kolizi (true = neprůchodná)
     */
    public Tile(Texture texturePath, boolean collision) {
        this.texture = new Texture(String.valueOf(texturePath));
        this.collision = collision;
    }

    /**
     * Uvolní texturu z paměti — je vhodné volat v dispose() fázi hry.
     */
    public void dispose() {
        if (texture != null) {
            texture.dispose();
        }
    }
}
