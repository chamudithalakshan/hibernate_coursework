package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import lk.ijse.hibernate.bo.BoFactory;
import lk.ijse.hibernate.bo.custom.RoomBo;
import lk.ijse.hibernate.bo.custom.StudentBo;
import lk.ijse.hibernate.dto.RoomDto;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageRoomController implements Initializable {
    public Pane pane;
    public TableView tblRoom;
    public JFXTextField roomId;
    public JFXTextField type;
    public JFXTextField keyMoney;
    public JFXTextField qty;
    public TableColumn clmRoomId;
    public TableColumn clmType;
    public TableColumn clmKeyMoney;
    public TableColumn clmQty;
    RoomBo roomBo = (RoomBo) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.ROOMS);

    public void AddNewRoomOnAction(ActionEvent actionEvent) throws Exception {
        String id = roomId.getText();
        String rType = type.getText();
        String keyMoneyText = keyMoney.getText();
        String qtyText = qty.getText();
        RoomDto roomDto = new RoomDto(id, rType, keyMoneyText, Integer.parseInt(qtyText));
//        System.out.println(roomDto);
        roomBo.save(roomDto);
    }
    public void tableInit() throws Exception {
        clmRoomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        clmType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        clmKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        clmQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        tblRoom.setItems(roomBo.getAllRooms());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            tableInit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
