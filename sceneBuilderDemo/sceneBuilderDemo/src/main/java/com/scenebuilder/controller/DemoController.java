package com.scenebuilder.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shangml
 * @Date: 2024/01/03/15:21
 * @Description:
 */
@Controller
public class DemoController {

    @FXML
    void upload(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择Excel文件");
        Stage selectFile = new Stage();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Excel", "*.xlsx"),
                new FileChooser.ExtensionFilter("XLS", "*.xls"),
                new FileChooser.ExtensionFilter("XLSX", "*.xlsx")
        );
        List<File> files = fileChooser.showOpenMultipleDialog(selectFile);
//        if (files != null) {
//            String str = System.getProperty("user.home") + "\\Downloads\\附件下载";
//            Path destDir = Paths.get(str);
//            if (!Files.exists(destDir)) {
//                Files.createDirectories(destDir); // 创建目录
//            }
//
//            for (File file : files) {
//                Path source = file.toPath();
//                Path destination = destDir.resolve(source.getFileName());
//                Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING); // 复制文件到目标目录
//            }
//        }
        System.out.println(1);
    }
}
