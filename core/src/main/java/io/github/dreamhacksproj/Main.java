package io.github.dreamhacksproj;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.dreamhacksproj.Maze;
import io.github.dreamhacksproj.Node;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private static final int TILE_WIDTH = 24;
    private static final int TILE_HEIGHT = 24;
    private static final int MAP_WIDTH = 32;
    private static final int MAP_HEIGHT = 32;
    private SpriteBatch batch;
    private Texture image;
    public Texture backgroundTexture;
    public TextureRegion groundTile;
    public TextureRegion wallTile;
    Maze maze = new Maze(32);


    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        backgroundTexture = new Texture("background.png");
        groundTile = new TextureRegion(backgroundTexture, 168, 168, TILE_WIDTH, TILE_HEIGHT);
        wallTile = new TextureRegion(backgroundTexture, 200, 200, TILE_WIDTH, TILE_HEIGHT);
        maze.generateMaze();
    }
    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        batch.begin();
        for (int x = 0; x < MAP_WIDTH; x++) {
            for (int y = 0; y < MAP_HEIGHT; y++) {
                if (maze.maze[y][x] == 1) {
                    batch.draw(groundTile, x * 24, y * 24);
                } else {
                    batch.draw(wallTile, x * 24, y * 24);
                }
            }
        }
        batch.end();
    }
    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
