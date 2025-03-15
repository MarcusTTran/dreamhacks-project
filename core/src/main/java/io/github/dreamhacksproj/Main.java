package io.github.dreamhacksproj;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.dreamhacksproj.Maze;
import io.github.dreamhacksproj.Node;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private static final int TILE_WIDTH = 16;
    private static final int TILE_HEIGHT = 16;
    private static final int MAP_WIDTH = 40;
    private static final int MAP_HEIGHT = 40;
    private SpriteBatch batch;
    private Texture image;
    public Texture backgroundTexture;
    public TextureRegion groundTile;
    public TextureRegion wallTile;
    public TextureRegion temp;
    public TextureRegion temp2;
    Maze maze = new Maze(40);
    private OrthographicCamera camera;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        backgroundTexture = new Texture("background.png");
        groundTile = new TextureRegion(backgroundTexture, 168, 168, TILE_WIDTH, TILE_HEIGHT);
        wallTile = new TextureRegion(backgroundTexture, 120, 200, TILE_WIDTH, TILE_HEIGHT);
        temp = new TextureRegion(backgroundTexture, 40, 200, TILE_WIDTH, TILE_HEIGHT);
        temp2 = new TextureRegion(backgroundTexture, 20, 160, TILE_WIDTH, TILE_HEIGHT);
        maze.generateMaze();
        maze.setRandomToTwo();
        maze.setRandomEnemy(3);
        maze.setRandomEnemy(3);
        maze.setRandomEnemy(3);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, MAP_WIDTH * TILE_WIDTH, MAP_HEIGHT * TILE_HEIGHT);
    }
    @Override
    public void render() {
        camera.update();
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (int x = 0; x < MAP_WIDTH; x++) {
            for (int y = 0; y < MAP_HEIGHT; y++) {
                if (maze.maze[y][x] == 1) {
                    batch.draw(wallTile, x * TILE_WIDTH, y * TILE_HEIGHT);
                } else if (maze.maze[y][x] == 2) {
                    batch.draw(temp, x * TILE_WIDTH, y * TILE_HEIGHT);
                } else if (maze.maze[y][x] == 3) {
                    batch.draw(temp2, x * TILE_WIDTH, y * TILE_HEIGHT);
                } else if (maze.maze[y][x] == 4) {
                    batch.draw(temp2, x * TILE_WIDTH, y * TILE_HEIGHT);
                }else if (maze.maze[y][x] == 5) {
                    batch.draw(temp2, x * TILE_WIDTH, y * TILE_HEIGHT);
                }else {
                    batch.draw(groundTile, x * TILE_WIDTH, y * TILE_HEIGHT);
                }
            }
        }
        batch.end();

        Node player = maze.getPlayer();

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
                maze.goNorthTeleport();
            } else {
                maze.goNorth();
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
                maze.goSouthTeleport();
            } else {
                maze.goSouth();
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
                maze.goEastTeleport();
            } else {
                maze.goEast();
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
                maze.goWestTeleport();
            } else {
                maze.goWest();
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            System.exit(0);
        }
    }
    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
