/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.model;

import com.idevexpert.schoolnotes_fts3096_desktop.data.dao.CoordinatorDao;
import com.idevexpert.schoolnotes_fts3096_desktop.data.dto.PersonDto;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorAccountsByPersonListResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorPeopleListResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.utlis.LodingJpanel;
import com.idevexpert.schoolnotes_fts3096_desktop.utlis.MethodUtil;
import com.idevexpert.schoolnotes_fts3096_desktop.view.JframeMain;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.CoordinatorAnnouncementJpanel;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.CoordinatorAttendanceJpanel;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.CoordinatorCasesJpanel;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.CoordinatorDashboardJpanel;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent.CoordinatorNotificationJpanel;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.CoordinatorPersonJpanel;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.CoordinatorProxyJpanel;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.CoordinatorTeacherJpanel;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.CoordinatorTutorJpanel;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent.NotificationProfile;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent.CreateAccountPerson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import org.apache.commons.lang3.StringUtils;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

/**
 *
 * @author Jesus Gutierrez
 */
public class CoordinatorModel extends CoordinatorDao {

    public CoordinatorAnnouncementJpanel coordinatorAnnouncementJpanel;
    public CoordinatorAttendanceJpanel coordinatorAttendanceJpanel;
    public CoordinatorCasesJpanel coordinatorCasesJpanel;
    public CoordinatorDashboardJpanel coordinatorDashboardJpanel;
    public CoordinatorPersonJpanel coordinatorPersonJpanel;
    public CoordinatorProxyJpanel coordinatorProxyJpanel;
    public CoordinatorTeacherJpanel coordinatorTeacherJpanel;
    public CoordinatorTutorJpanel coordinatorTutorJpanel;
    private String token;
    public LodingJpanel lodingJpanel = new LodingJpanel();
    public JframeMain jframeMain;
    public NotificationProfile noti;

    private SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");

    //Response Service
    public CoordinatorNotificationJpanel coordinatorNotificationJpanel;
    private CoordinatorAccountsByPersonListResponse responseListAccountByPerson;

    private CoordinatorPeopleListResponse personListTable;
    private CoordinatorPeopleListResponse personListTableTem;

    public CoordinatorModel(String token, JframeMain jframeMain) {
        this.noti = new NotificationProfile();
        this.coordinatorAnnouncementJpanel = new CoordinatorAnnouncementJpanel();
        this.coordinatorAttendanceJpanel = new CoordinatorAttendanceJpanel();
        this.coordinatorCasesJpanel = new CoordinatorCasesJpanel();
        this.coordinatorDashboardJpanel = new CoordinatorDashboardJpanel();
        this.coordinatorProxyJpanel = new CoordinatorProxyJpanel();
        this.coordinatorTeacherJpanel = new CoordinatorTeacherJpanel();
        this.coordinatorTutorJpanel = new CoordinatorTutorJpanel();
        this.coordinatorNotificationJpanel = new CoordinatorNotificationJpanel();
        this.token = token;
        this.jframeMain = jframeMain;
        init();
    }

    private void init() {
        insertComponentCenter(coordinatorDashboardJpanel);
    }

    //Dashboard Person
    public void searchDataTablePerson() {
        String searchData = coordinatorPersonJpanel.textFieldPersonSearch.getText().toUpperCase();
        personListTableTem = new CoordinatorPeopleListResponse();
        List<PersonDto> personDtos = new ArrayList<>();
        for (PersonDto personDto : personListTable.getListPerson()) {
            if (StringUtils.trimToEmpty(personDto.getName()).contains(searchData)
                    || StringUtils.trimToEmpty(personDto.getLastname()).contains(searchData)
                    || StringUtils.trimToEmpty(personDto.getMotherLastname()).contains(searchData)
                    || StringUtils.trimToEmpty(personDto.getDni()).contains(searchData)) {
                personDtos.add(personDto);
            }
        }
        personListTableTem.setListPerson(personDtos);
        MethodUtil.insertDataTable(personListTableTem, coordinatorPersonJpanel.jTableDataPerson);
        insertCopyDataTablePerson(personListTable, 0);
        MethodUtil.clearRowTable(coordinatorPersonJpanel.jTableDataAccount);

    }

    public void insertDataTablePerson() {

        /// MethodUtil.centerComponent(lodingJpanel, null, 0);
        Drawer.getInstance().closeDrawer();
                insertComponentCenter(lodingJpanel);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CoordinatorModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                personListTable = personList(token);
                if (personListTable == null) {
                    personListTable = new CoordinatorPeopleListResponse();
                }
                MethodUtil.insertDataTable(personListTable, coordinatorPersonJpanel.jTableDataPerson);
                insertComponentCenter(coordinatorPersonJpanel);
            }
        }).start();
    }

    public void insertDataTablePersonAccount(CoordinatorPeopleListResponse coordinatorPeopleListResponseTempChang) {
        responseListAccountByPerson = listAccountByPerson(token, coordinatorPeopleListResponseTempChang.getListPerson().get(coordinatorPersonJpanel.jTableDataPerson.getSelectedRow()).getPersonId());
        if (responseListAccountByPerson == null) {
            responseListAccountByPerson = new CoordinatorAccountsByPersonListResponse();
        }
        MethodUtil.insertDataTable(responseListAccountByPerson, coordinatorPersonJpanel.jTableDataAccount);
    }

    public void insertCopyDataTablePerson(CoordinatorPeopleListResponse coordinatorPeopleListResponseTempChang, int nothingOrsomething) {

        int indice = coordinatorPersonJpanel.jTableDataPerson.getSelectedRow();
        coordinatorPersonJpanel.textFieldName.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getName()) : "");
        coordinatorPersonJpanel.textFieldLastName.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getLastname()) : "");
        coordinatorPersonJpanel.textFieldMotherLastName.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getMotherLastname()) : "");
        coordinatorPersonJpanel.textFieldDni.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getDni()) : "");
        coordinatorPersonJpanel.textFieldPhone.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getPhone()) : "");
        coordinatorPersonJpanel.textFieldEmail.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getMail()) : "");
        coordinatorPersonJpanel.textFieldAddress.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getAddress()) : "");
        coordinatorPersonJpanel.textFieldCellPhone.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getCellphone()) : "");

        if (nothingOrsomething == 0) {
            coordinatorPersonJpanel.jFormattedTextFieldDate.setText("");
            coordinatorPersonJpanel.jCheckBoxWomen.setSelected(false);
            coordinatorPersonJpanel.jCheckBoxMen.setSelected(false);
            return;
        }
        String sexPeson = coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getSex();
        String dateEnter = coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getBirthdate();
        try {
            if (dateEnter != null) {
                Date date = formatoEntrada.parse(dateEnter);
                coordinatorPersonJpanel.jFormattedTextFieldDate.setText(formatoSalida.format(date));
            } else {
                coordinatorPersonJpanel.jFormattedTextFieldDate.setText("");
            }
        } catch (ParseException ex) {
        }

        if (StringUtils.trimToEmpty(sexPeson).equalsIgnoreCase("M")) {
            coordinatorPersonJpanel.jCheckBoxWomen.setSelected(false);
            coordinatorPersonJpanel.jCheckBoxMen.setSelected(true);
        } else if (StringUtils.trimToEmpty(sexPeson).equalsIgnoreCase("F")) {
            coordinatorPersonJpanel.jCheckBoxWomen.setSelected(true);
            coordinatorPersonJpanel.jCheckBoxMen.setSelected(false);
        } else {
            coordinatorPersonJpanel.jCheckBoxWomen.setSelected(false);
            coordinatorPersonJpanel.jCheckBoxMen.setSelected(false);
        }
    }

    public void listTypeTempOrLinearForTablePerson() {
        if (coordinatorPersonJpanel.jTableDataPerson.getRowCount() != personListTable.getListPerson().size()) {
            insertCopyDataTablePerson(personListTableTem, 1);
            insertDataTablePersonAccount(personListTableTem);
        } else {
            insertCopyDataTablePerson(personListTable, 1);
            insertDataTablePersonAccount(personListTable);
        }
    }

    public void accountGlassPaneCreate() {
        //  GlassPanePopup.showPopup(new CreateAccountPerson());
    }

    public void insertComponentCenter(JComponent component) {
        jframeMain.jPanel4.removeAll();
        SwingUtilities.updateComponentTreeUI(component);
        component.revalidate();
        component.repaint();
        jframeMain.jPanel4.add(component);
        jframeMain.revalidate();
        jframeMain.repaint();
    }
}
