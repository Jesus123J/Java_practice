/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.utlis;

import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.ContainerWrapper;

/**
 *
 * @author Jesus Gutierrez
 */
public abstract class AbstractComponentWrapper implements ComponentWrapper {

    @Override
    public Object getComponent() {
        return null;
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        // Método vacío
    }

    // Implementación vacía para los demás métodos
    @Override
    public int getX() { return 0; }

    @Override
    public int getY() { return 0; }

    @Override
    public int getWidth() { return 0; }

    @Override
    public int getHeight() { return 0; }

    @Override
    public int getScreenLocationX() { return 0; }

    @Override
    public int getScreenLocationY() { return 0; }

    @Override
    public int getMinimumWidth(int i) { return 0; }

    @Override
    public int getMinimumHeight(int i) { return 0; }

    @Override
    public int getPreferredWidth(int i) { return 0; }

    @Override
    public int getPreferredHeight(int i) { return 0; }

    @Override
    public int getMaximumWidth(int i) { return 0; }

    @Override
    public int getMaximumHeight(int i) { return 0; }

    @Override
    public boolean isVisible() { return true; }

    @Override
    public int getBaseline(int i, int i1) { return 0; }

    @Override
    public boolean hasBaseline() { return false; }

    @Override
    public ContainerWrapper getParent() { return null; }

    @Override
    public float getPixelUnitFactor(boolean bln) { return 1.0f; }

    @Override
    public int getHorizontalScreenDPI() { return 96; }

    @Override
    public int getVerticalScreenDPI() { return 96; }

    @Override
    public int getScreenWidth() { return 1920; }

    @Override
    public int getScreenHeight() { return 1080; }

    @Override
    public String getLinkId() { return null; }

    @Override
    public int getLayoutHashCode() { return 0; }

    @Override
    public int[] getVisualPadding() { return null; }

    @Override
    public void paintDebugOutline(boolean bln) {}

    @Override
    public int getComponentType(boolean bln) { return 0; }

    @Override
    public int getContentBias() { return 0; }
}
