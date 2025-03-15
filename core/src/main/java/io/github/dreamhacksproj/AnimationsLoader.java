package io.github.dreamhacksproj;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

// - Always goes N, E, S. W from top row to bottom row in the sprite sheet
public class AnimationsLoader {

    public Animation<TextureRegion> loadAnimation(String fileName, int direction) {
        Texture texture = new Texture(fileName);
        int[] dimensions = getPhotoDimensions(texture.getWidth(), texture.getHeight());
        TextureRegion[][] tmp_frames = TextureRegion.split(texture, dimensions[0], dimensions[1]);

        // Place the regions into a 1D array in the correct order, starting from the top
        // left, going across first. The Animation constructor requires a 1D array.
        TextureRegion[] frames = new TextureRegion[ dimensions[1] ];
        int index = 0;
        for (int j = 0; j < dimensions[1]; j++) {
            frames[index++] = tmp_frames[direction][j];
        }

        // Initialize the Animation with the frame interval and array of frames
        return new Animation<TextureRegion>((float) 1 / (dimensions[1]), frames);
    }

    private int[] getPhotoDimensions(int rows, int cols) {
        int spriteWidth = 64;
        int spriteHeight = 64;
        rows = rows / spriteWidth;
        cols = cols / spriteHeight;
        return new int[]{rows, cols};
    }


}
