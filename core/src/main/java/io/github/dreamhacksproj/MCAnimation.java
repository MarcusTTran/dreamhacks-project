package io.github.dreamhacksproj;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MCAnimation implements CharacterAnimation{

    AnimationsLoader loader;
    Animation<TextureRegion> [][] animations;

    // @Constructor
    public MCAnimation(AnimationsLoader loader) {
        this.loader = loader;
        animations = new Animation[2][4]; // Hit and Walk so far * 4 directions each
        String walkFileName = "lpc_main_char/standard/walk.png";
        String attackFileName = "lpc_main_char/standard/thrust.png";
        loadWalkingAnimations(walkFileName);
        loadAttackingAnimations(attackFileName);
    }

    private void loadWalkingAnimations(String walkFileName) {
        for (int i = 0; i < 4; i++) {
            animations[WALKING_INDEX][i] = loader.loadAnimation(walkFileName, i);
        }
    }

    private void loadAttackingAnimations(String attackFileName) {
        for (int i = 0; i < 4; i++) {
            animations[ATTACK_INDEX][i] = loader.loadAnimation(attackFileName, i);
        }
    }

    @Override
    public Animation<TextureRegion> getWalkingAnimation(int direction) {
        return animations[WALKING_INDEX][direction];
    }

    @Override
    public Animation<TextureRegion> getAttackingAnimation(int direction) {
        return animations[ATTACK_INDEX][direction];
    }

}



