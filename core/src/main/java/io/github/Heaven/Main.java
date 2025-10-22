package io.github.Heaven;

import Entity.Player;
import Objects.GameObject;
import Tile.TileManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    public static final int TILE_SIZE = 48;
    public static final int WORLD_COLS = 16;
    public static final int WORLD_ROWS = 13;
    public static final int SCREEN_WIDTH = TILE_SIZE * WORLD_COLS;
    public static final int SCREEN_HEIGHT = TILE_SIZE * WORLD_ROWS;


    private SpriteBatch batch;
    public Viewport viewport;
    public TiledMap map;
    public OrthographicCamera camera;
    private OrthogonalTiledMapRenderer renderer;
    TileManager tileManager;
    Player player;
    CollisionChecker cChecker;
    AssetSetter aSetter;
    GameObject[] objects;
    KeyHandler keyH;

    @Override
    public void create() {
        batch = new SpriteBatch();
        TmxMapLoader mapLoader = new TmxMapLoader();
        map = mapLoader.load("Maps/mapa1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        camera.position.set(400, 300, 0); // center in the middle of that area
        camera.zoom = 1f;
        camera.update();
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

        keyH = new KeyHandler();
        Gdx.input.setInputProcessor(keyH);

        tileManager = new TileManager();
        cChecker = new CollisionChecker(tileManager);
        player = new Player(keyH, cChecker);
        aSetter = new AssetSetter();
        objects = aSetter.setObjects();

        Gdx.graphics.setForegroundFPS(60);
    }

    @Override
    public void render() {
        update();
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        camera.position.set(400, 300, 0); // center in the middle of that area
        camera.zoom = 1f;
        camera.update();
        renderer.setView(camera);
        renderer.render();
        update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        tileManager.draw(batch, player);
        for (GameObject obj : objects) {
            if (obj != null) obj.draw(batch, player);
        }
        player.draw(batch);
        batch.end();
    }

    public void update() {
        player.update();
        camera.position.set(player.worldX, player.worldY, 0);
        camera.update();
    }


    @Override
    public void dispose() {
        batch.dispose();
        tileManager.dispose();
    }
}
