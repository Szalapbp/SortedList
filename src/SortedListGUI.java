import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortedListGUI extends JFrame
{
    private SortedList sortedList;
    private JTextArea displayArea;
    private JTextField inputField;
    private JButton addBtn, searchBtn;

    public SortedListGUI()
    {
        sortedList = new SortedList();

        JFrame frame = new JFrame("Sorted List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        inputField = new JTextField(15);
        addBtn = new JButton("Add");
        searchBtn = new JButton("Search");

        panel.add(new JLabel("Enter Text:"));
        panel.add(inputField);
        panel.add(addBtn);
        panel.add(searchBtn);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        addBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String text = inputField.getText().trim();
                if(!text.isEmpty()) {
                    sortedList.add(text);
                    updateDisplay("Added: " + text);
                    inputField.setText("");
                }
            }
        });
        searchBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String text = inputField.getText().trim();
                if(!text.isEmpty()) {
                    String result = sortedList.search(text);
                    updateDisplay("Search: " + text + " -> " + result);
                    inputField.setText("");
                }
            }
        });

        frame.setVisible(true);
    }

    private void updateDisplay(String message){
        displayArea.append(message + "\n");
        displayArea.append("Current List: " + sortedList + "\n");
    }

    public static void main(String[] args){
        new SortedListGUI();
    }

}
