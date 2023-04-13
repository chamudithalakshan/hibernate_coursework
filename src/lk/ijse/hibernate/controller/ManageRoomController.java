package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import lk.ijse.hibernate.bo.BoFactory;
import lk.ijse.hibernate.bo.custom.RoomBo;
import lk.ijse.hibernate.bo.custom.StudentBo;
import lk.ijse.hibernate.dto.RoomDto;

public class ManageRoomController {
    public Pane pane;
    public TableView tblRoom;
    public JFXTextField roomId;
    public JFXTextField type;
    public JFXTextField keyMoney;
    public JFXTextField qty;
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
}
