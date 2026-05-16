package ui;
import service.FileService;
import javax.swing.*;


public class MenuBar extends JMenuBar {
    public MenuBar(EditorPanel editorPanel){
        JMenu fileMenu = new JMenu("file");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        add(fileMenu);
        //open
        openItem.addActionListener(e ->{
            String content = FileService.openFile((JFrame) SwingUtilities.getWindowAncestor(this));
            editorPanel.getTextPane().setText(content);
        });
        //save
        saveItem.addActionListener(e->{
            FileService.saveFile((JFrame) SwingUtilities.getWindowAncestor(this),
                    editorPanel.getTextPane().getText());
        });
        //exit
        exitItem.addActionListener(e-> System.exit(0));
    }

}
