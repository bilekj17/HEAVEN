package io.github.Heaven;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class KeyHandler implements InputProcessor {
    public boolean up, down, left, right;

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.W) up = true;
        if (keycode == Input.Keys.S) down = true;
        if (keycode == Input.Keys.A) left = true;
        if (keycode == Input.Keys.D) right = true;
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.W) up = false;
        if (keycode == Input.Keys.S) down = false;
        if (keycode == Input.Keys.A) left = false;
        if (keycode == Input.Keys.D) right = false;
        return true;
    }

    // Ostatní metody můžou zůstat prázdné
    @Override public boolean keyTyped(char character) { return false; }
    @Override public boolean touchDown(int x, int y, int p, int b) { return false; }
    @Override public boolean touchUp(int x, int y, int p, int b) { return false; }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override public boolean touchDragged(int x, int y, int p) { return false; }
    @Override public boolean mouseMoved(int x, int y) { return false; }
    @Override public boolean scrolled(float a, float b) { return false; }
}
