/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent;

import com.idevexpert.schoolnotes_fts3096_desktop.utlis.ColorUtil;
import com.idevexpert.schoolnotes_fts3096_desktop.view.login.LoginJPanel;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import raven.popup.component.GlassPaneChild;
import raven.popup.component.SimplePopupBorderOption;

/**
 *
 * @author Jesus Gutierrez
 */
public class GlassPaneLogin extends GlassPaneChild {

    private JComponent component;

    public GlassPaneLogin(JComponent component) {
        this.component = component;
        init();
    }

    private void init() {
        setBackground(ColorUtil.kPrimaryTransparent);
        setLayout(new MigLayout("wrap,fillx,insets 15 0 15 0", "[fill, ]"));
        add(component);
    }
}
