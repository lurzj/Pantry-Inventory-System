/* File Name: TableGUI.java
 * Created: 4-24-22
 * Purpose: To generate the table in a GUI that displays the inventory
 * 			in the pantry.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TableGUI {

public static void main(String[] args) {
generateJTable();
}

public static void generateJTable() {

// create JFrame and JTable
JFrame frame = new JFrame();
final JTable table = new JTable();

// create a table model
Object[] columns = { "Item Name", "Quantity Of Item", "Expiration Date" };
final DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columns);
table.setModel(model);

// JTable background Color,Font Size,Font Color,Row Height
table.setBackground(Color.GREEN.brighter());
table.setForeground(Color.black);
Font font = new Font("", 1, 18);
table.setFont(font);
table.setRowHeight(30);

// create JTextFields
final JTextField itemName = new JTextField();
final JTextField itemQuantity = new JTextField();
final JTextField expirationDate = new JTextField();

// create JButtons
JButton addButton = new JButton("Add");
JButton deleteButton = new JButton("Delete");
JButton editButton = new JButton("Edit");

// set bounds
itemName.setBounds(5, 220, 260, 25);
itemQuantity.setBounds(300, 220, 260, 25);
expirationDate.setBounds(600, 220, 260, 25);

addButton.setBounds(5, 300, 100, 25);
editButton.setBounds(105, 300, 100, 25);
deleteButton.setBounds(205, 300, 100, 25);

// create JScrollPane
JScrollPane pane = new JScrollPane(table);
pane.setBounds(0, 0, 880, 200);

frame.setLayout(null);

frame.add(pane);

// Add JTextFields to the JFrame
frame.add(itemName);
frame.add(itemQuantity);
frame.add(expirationDate);

// Adds JButtons to the JFrame
frame.add(addButton);
frame.add(deleteButton);
frame.add(editButton);

// create an array of objects
final Object[] row = new Object[3];

// Add button adds data into a row
addButton.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {

row[0] = itemName.getText();
row[1] = itemQuantity.getText();
row[2] = expirationDate.getText();

// Add row to the model
model.addRow(row);
}
});

// Delete Button removes selected row in table
deleteButton.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {

// i = selected row index
int i = table.getSelectedRow();
if (i >= 0) {
// Remove a row from JTable
model.removeRow(i);
} else {
System.out
.println("There were issue while Deleting the Row(s).");
}
}
});

table.addMouseListener(new MouseAdapter() {

@Override
public void mouseClicked(MouseEvent e) {

// i = selected row index
int i = table.getSelectedRow();

itemName.setText(model.getValueAt(i, 0).toString());
itemQuantity.setText(model.getValueAt(i, 1).toString());
expirationDate.setText(model.getValueAt(i, 2).toString());
}
});

// button update row - Clicked on Update Button
editButton.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {

// i = selected row index
int i = table.getSelectedRow();

if (i >= 0) {
model.setValueAt(itemName.getText(), i, 0);
model.setValueAt(itemQuantity.getText(), i, 1);
model.setValueAt(expirationDate.getText(), i, 2);
} else {
System.out.println("Error updating row");
}
}
});

frame.setSize(900, 400);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);

}
}