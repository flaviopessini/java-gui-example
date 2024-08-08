import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private static JFrame frame;
    private JPanel Main;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private JLabel lblSenha;
    private JLabel lblUsuario;

    public Main() {
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String usuario = txtUsuario.getText().trim();
                final String senha = String.valueOf(txtSenha.getPassword()).trim();

                if (usuario.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o usuário e senha!", "Login", JOptionPane.WARNING_MESSAGE);
                } else {
                    Gerador newForm = new Gerador();
                    newForm.setVisible(true);

                    frame.dispose();
                }
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Main");
        frame.setContentPane(new Main().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
