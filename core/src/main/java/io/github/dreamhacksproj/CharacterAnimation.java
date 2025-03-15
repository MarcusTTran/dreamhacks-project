package io.github.dreamhacksproj;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Vector;

public interface CharacterAnimation {
    int NORTH_INDEX = 0;
    int EAST_INDEX = 1;
    int SOUTH_INDEX = 2;
    int WEST_INDEX = 3;

    int WALKING_INDEX = 0;
    int ATTACK_INDEX = 1;


    Animation<TextureRegion> getWalkingAnimation(int direction);
    Animation<TextureRegion> getAttackingAnimation(int direction);

}
