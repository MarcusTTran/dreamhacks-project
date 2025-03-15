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

    @Override
    public void create() {
        batch = new SpriteBatch();
        AnimationsLoader loader = new AnimationsLoader();

    }
    @Override
    public void render() {
        camera.update();
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        // batch.draw

        batch.end();

        Node player = maze.getPlayer();

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
                maze.goNorthTeleport();
            } else {
                maze.goNorth();
            }
            maze.makeEnemiesMove();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
                maze.goSouthTeleport();
            } else {
                maze.goSouth();
            }
            maze.makeEnemiesMove();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
                maze.goEastTeleport();
            } else {
                maze.goEast();
            }
            maze.makeEnemiesMove();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
                maze.goWestTeleport();
            } else {
                maze.goWest();
            }
            maze.makeEnemiesMove();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            System.exit(0);
        }
    }
    @Override
    public void dispose() {
        batch.dispose();
//        image.dispose();
    }
}
