import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Gerador extends JFrame {
    private JPanel Gerador;
    private JLabel lblAguardando;
    private JLabel lblConcluido;
    private JLabel lblNumero;
    private JButton btnGerar;

    public Gerador() {
        setTitle("Gerador");
        setContentPane(Gerador);
        //setSize(300, 200);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        btnGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GeradorUpdater().execute();
            }
        });
    }

    private class GeradorUpdater extends SwingWorker<Void, Float> {
        @Override
        protected Void doInBackground() throws Exception {
            lblAguardando.setForeground(Color.YELLOW);
            lblConcluido.setForeground(Color.DARK_GRAY);
            for (int i = 0; i < 5; i++) {
                float numero = new Random().nextFloat() * 99999;
                publish(numero);
                Thread.sleep(1000); // Aguarda 1 segundo
            }
            lblAguardando.setForeground(Color.DARK_GRAY);
            lblConcluido.setForeground(Color.GREEN);
            return null;
        }

        @Override
        protected void process(java.util.List<Float> numero) {
            if (!numero.isEmpty()) {
                //lblPeso.setText(String.format("%.2f", pesos.get(pesos.size() - 1)));
                lblNumero.setText(String.format("%.0f", numero.getLast()));
            }
        }
    }
}
