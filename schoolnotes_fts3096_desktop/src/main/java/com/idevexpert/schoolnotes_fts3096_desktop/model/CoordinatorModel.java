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
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import org.apache.commons.lang3.StringUtils;
import raven.alerts.MessageAlerts;
import raven.drawer.Drawer;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.Option;
import raven.popup.component.GlassPaneChild;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.SimplePopupBorder;
import raven.popup.component.SimplePopupBorderOption;

/**
 *
 * @author Jesus Gutierrez
 */
public class CoordinatorModel extends CoordinatorDao {

    // private String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private String emailPattern = "^[a-zA-Z0-9._%+-]+@(gmail\\.com|uni\\.edu\\.pe)$";

    private Pattern pattern = Pattern.compile(emailPattern);
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
        insertCopyDataTablePerson(null, 0);

    }

    public void insertDataTablePerson() {

        /// MethodUtil.centerComponent(lodingJpanel, null, 0);
        Drawer.getInstance().closeDrawer();
        insertComponentCenter(lodingJpanel);
        new Thread(new Runnable() {
            @Override
            public void run() {
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
        new SwingWorker<CoordinatorAccountsByPersonListResponse, Void>() {
            @Override
            protected CoordinatorAccountsByPersonListResponse doInBackground() throws Exception {
               // jframeMain.jPanel4.add(lodingJpanel);
                jframeMain.jPanel4.setLayer(lodingJpanel, JLayeredPane.POPUP_LAYER);
                jframeMain.jPanel4.add(lodingJpanel, "pos 0 0 100% 100%");
    jframeMain.jPanel4.setComponentZOrder(lodingJpanel, 0);
                jframeMain.jPanel4.revalidate();
                jframeMain.jPanel4.repaint();
                try {
                    return listAccountByPerson(token, coordinatorPeopleListResponseTempChang.getListPerson().get(coordinatorPersonJpanel.jTableDataPerson.getSelectedRow()).getPersonId());
                } catch (Exception e) {
                    MessageAlerts.getInstance().showMessage("", "No tiene conexion vuelva a intentarlo otra ves", MessageAlerts.MessageType.WARNING);
                    return null;
                }
            }

            @Override
            protected void done() {
                try {
                    responseListAccountByPerson = get();
                } catch (InterruptedException ex) {
                    Logger.getLogger(CoordinatorModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    Logger.getLogger(CoordinatorModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                jframeMain.jPanel4.remove(lodingJpanel);
                jframeMain.jPanel4.revalidate();
                jframeMain.jPanel4.repaint();
                if (responseListAccountByPerson != null) {
                    if (responseListAccountByPerson.getAccountsList() == null) {
                        coordinatorPersonJpanel.jTabbedPane1.setSelectedIndex(0);
                        coordinatorPersonJpanel.jTabbedPane1.setEnabledAt(1, false);
                        MessageAlerts.getInstance().showMessage("No hay Cuenta", "No cuenta con cuenta esta persona");
                    } else {
                        coordinatorPersonJpanel.jTabbedPane1.setEnabledAt(1, true);
                    }
                    MethodUtil.insertDataTable(responseListAccountByPerson, coordinatorPersonJpanel.jTableDataAccount);
                } else {
                    coordinatorPersonJpanel.jTabbedPane1.setSelectedIndex(0);
                    coordinatorPersonJpanel.jTabbedPane1.setEnabledAt(1, false);
                    MessageAlerts.getInstance().showMessage("Conexion", "Error de conexion", MessageAlerts.MessageType.ERROR);
                }
            }

        }.execute();

    }

    public void insertCopyDataTablePerson(CoordinatorPeopleListResponse coordinatorPeopleListResponseTempChang, int nothingOrsomething) {
        SwingUtilities.invokeLater(() -> {
            int indice = coordinatorPersonJpanel.jTableDataPerson.getSelectedRow();
            coordinatorPersonJpanel.textFieldName.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getName()) : "");
            coordinatorPersonJpanel.textFieldLastName.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getLastname()) : "");
            coordinatorPersonJpanel.textFieldMotherLastName.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getMotherLastname()) : "");
            coordinatorPersonJpanel.textFieldDni.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getDni()) : "");
            coordinatorPersonJpanel.textFieldPhone.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getPhone()) : "");
            coordinatorPersonJpanel.textFieldEmail.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getMail()) : "");
            coordinatorPersonJpanel.textFieldAddress.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getAddress()) : "");
            coordinatorPersonJpanel.textFieldCellPhone.setText(nothingOrsomething == 1 ? StringUtils.trimToEmpty(coordinatorPeopleListResponseTempChang.getListPerson().get(indice).getCellphone()) : "");

            if (nothingOrsomething == 0 && coordinatorPeopleListResponseTempChang == null) {
                coordinatorPersonJpanel.jFormattedTextFieldDate.setText("");
                coordinatorPersonJpanel.jCheckBoxWomen.setSelected(false);
                coordinatorPersonJpanel.jCheckBoxMen.setSelected(false);
                coordinatorPersonJpanel.jTabbedPane1.setSelectedIndex(0);
                coordinatorPersonJpanel.jTabbedPane1.setEnabledAt(1, false);
                MethodUtil.clearRowTable(coordinatorPersonJpanel.jTableDataAccount);
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
        });

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

    protected void validateEmail() {
        String email = coordinatorPersonJpanel.textFieldEmail.getText();
        if (pattern.matcher(email).matches()) {
            coordinatorPersonJpanel.textFieldEmail.setForeground(Color.GREEN);
        } else {
            coordinatorPersonJpanel.textFieldEmail.setForeground(Color.RED);
        }
    }

    public void insertComponentCenter(JComponent component) {
        jframeMain.jPanel4.removeAll();
        jframeMain.jPanel4.setLayer(component, JLayeredPane.POPUP_LAYER);
        jframeMain.jPanel4.add(component, "pos 0 0 100% 100%");
//        jframeMain.jPanel4.removeAll();
//        jframeMain.jPanel4.add(component);
        jframeMain.jPanel4.revalidate();
        jframeMain.jPanel4.repaint();

    }
}
