/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent;

import com.idevexpert.schoolnotes_fts3096_desktop.utlis.MyDrawerListener;
import java.awt.Component;
import java.util.Arrays;
import javax.swing.ImageIcon;
import kotlin.contracts.SimpleEffect;
import raven.drawer.DrawerOption;
import raven.drawer.component.DrawerBuilder;
import raven.drawer.component.DrawerPanel;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.drawer.component.menu.SimpleMenuStyle;
import raven.drawer.component.menu.data.Item;
import raven.drawer.component.menu.data.MenuItem;


/**
 *
 * @author Jesus Gutierrez
 */
public class MyDraweCoordinatorComponent extends SimpleDrawerBuilder{
    MyDrawerListener miDrawerListener;
    public MyDraweCoordinatorComponent(String name , String email , MyDrawerListener myDrawerListener){  
        super(name, email); 
        this.miDrawerListener = myDrawerListener;
    }
    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData().setIcon(new ImageIcon()).setTitle(super.name).setDescription(super.email);
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
             MenuItem educationalRole = 
                new Item("Roles Educativo")
                        .subMenu("Alumno")
                        .subMenu("Profesor")
                        .subMenu("Tutor")
                        .subMenu("Apoderado");
                                 
        MenuItem dashboardPerson = 
                new Item("Persona" );
        MenuItem[] menus = {
            dashboardPerson,
            educationalRole
        };
        return new SimpleMenuOption().setMenus(menus).addMenuEvent(new MenuEvent() {
            @Override
            public void selected(MenuAction action, int[] index) {
                miDrawerListener.index(index);
            }
        });
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData();
    }
 
}
