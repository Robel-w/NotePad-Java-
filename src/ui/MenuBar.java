package ui;
import service.FileService;
import javax.swing.*;
import javax.swing.text.*;

public class MenuBar extends JMenuBar {
    public MenuBar(EditorPanel editorPanel){
        JMenu fileMenu = new JMenu("file");
        JMenu formatMenu = new JMenu("Format");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        JMenuItem boldItem = new JMenuItem("Bold");
        JMenuItem italicItem = new JMenuItem("Italic");
        JMenuItem underlineItem = new JMenuItem("Underline");


        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        formatMenu.add(boldItem);
        formatMenu.add(italicItem);
        formatMenu.add(underlineItem);

        add(fileMenu);
        add(formatMenu);
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

        boldItem.addActionListener(e->{
                JTextPane textPane = editorPanel.getTextPane();
                StyledDocument doc = textPane.getStyledDocument();

                int start = textPane.getSelectionStart();
                int end = textPane.getSelectionEnd();

                Style  style = textPane.addStyle("BoldStyle", null);
                StyleConstants.setBold(style, true);
                doc.setCharacterAttributes(start, end - start ,style, false);
    });

        italicItem.addActionListener(e -> {

            JTextPane textPane = editorPanel.getTextPane();

            StyledDocument doc = textPane.getStyledDocument();

            int start = textPane.getSelectionStart();
            int end = textPane.getSelectionEnd();

            Style style = textPane.addStyle("ItalicStyle", null);

            StyleConstants.setItalic(style, true);

            doc.setCharacterAttributes(start, end - start, style, false);
        });

        underlineItem.addActionListener(e -> {
            JTextPane textPane = editorPanel.getTextPane();
            StyledDocument doc = textPane.getStyledDocument();

            int start = textPane.getSelectionStart();
            int end = textPane.getSelectionEnd();

            Style style = textPane.addStyle("UnderlineStyle", null);
            StyleConstants.setUnderline(style, true);
            doc.setCharacterAttributes(start, end - start, style, false);
        });
    }

}
