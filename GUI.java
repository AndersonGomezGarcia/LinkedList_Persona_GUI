import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame frame;
    private DefaultListModel<Persona> personaListModel;

    public GUI() {
        frame = new JFrame("CRUD Persona");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 300);

        personaListModel = new DefaultListModel<>();
        JList<Persona> personaList = new JList<>(personaListModel);
        JScrollPane scrollPane = new JScrollPane(personaList);

        JButton addButton = new JButton("Agregar Persona");
        JButton editButton = new JButton("Editar Persona");
        JButton deleteButton = new JButton("Eliminar Persona");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPersona();
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarPersona();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPersona();
            }
        });

        JPanel panel = new JPanel();
        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);

        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);

        frame.setVisible(true);
    }

    private void agregarPersona() {
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String apellidos = JOptionPane.showInputDialog("Apellidos:");
        String cedula = JOptionPane.showInputDialog("Cédula:");

        Persona nuevaPersona = new Persona(nombre, apellidos, cedula);
        personaListModel.addElement(nuevaPersona);
    }
    private void editarPersona() {
        int selectedIndex = personaListModel.getSize() > 0 ?
                JOptionPane.showOptionDialog(frame, "Seleccione una persona a editar:", "Editar Persona",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                        personaListModel.toArray(), personaListModel.toArray()[0]) : -1;

        if (selectedIndex != -1) {
            Persona personaSeleccionada = personaListModel.getElementAt(selectedIndex);

            String nuevoNombre = JOptionPane.showInputDialog("Nuevo Nombre:", personaSeleccionada.getNombre());
            String nuevosApellidos = JOptionPane.showInputDialog("Nuevos Apellidos:", personaSeleccionada.getApellidos());
            String nuevaCedula = JOptionPane.showInputDialog("Nueva Cédula:", personaSeleccionada.getCedula());

            Persona personaEditada = new Persona(nuevoNombre, nuevosApellidos, nuevaCedula);
            personaListModel.set(selectedIndex, personaEditada);
        }
    }

    private void eliminarPersona() {
        int selectedIndex = personaListModel.getSize() > 0 ?
                JOptionPane.showOptionDialog(frame, "Seleccione una persona a eliminar:", "Eliminar Persona",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                        personaListModel.toArray(), personaListModel.toArray()[0]) : -1;

        if (selectedIndex != -1) {
            personaListModel.remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }
}