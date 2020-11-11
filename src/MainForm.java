import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;

public class MainForm
{
    private JPanel panel1;
    private JRadioButton rb_f1;
    private JRadioButton rb_f2;
    private JRadioButton rb_f3;
    private JButton btnSelect;
    private JLabel lbResult;
    private JLabel lbMessage;
    private JTextField txtNumber;
    private JRadioButton rb_f4;
    private Instant startTime;
    private Instant endTime;
    private long iTestNumber = 11;
    private long iLoopIterations = 0;

    public MainForm()
    {
        btnSelect.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (rb_f1.isSelected())
                {
                    RunOverAllNumber();
                }
                if (rb_f2.isSelected())
                {
                    RunUntilSqrt();
                }
                if (rb_f3.isSelected())
                {
                    RunUntilSqrt_Odd();
                }
                if (rb_f4.isSelected())
                {
                    RunOverOddNumbers();
                }
            }
        });
    }

    private void RunOverAllNumber()
    {
        startTime = Instant.now();
        iLoopIterations = 0;
        iTestNumber = Long.parseLong(txtNumber.getText());
        boolean bIsPrime = true;
        for (long i=2; i < iTestNumber; i++)
        {
            iLoopIterations++;
            if ((iTestNumber%i) == 0)
            {
                bIsPrime = false;
                break;
            }
            try {
            //    Thread.sleep(5);
            }
            catch (Exception ex)
            {

            }
        }

        endTime = Instant.now();
        lbResult.setText("Number " + iTestNumber + " isPrime=" + bIsPrime +" Time to execute the function: " + Duration.between(startTime, endTime).toMillis() + " ms. num of iterations=" +iLoopIterations);
    }

    private void RunUntilSqrt()
    {
        startTime = Instant.now();
        iLoopIterations = 0;
        iTestNumber = Long.parseLong(txtNumber.getText());
        boolean bIsPrime = true;
        for (long i=2; i <= Math.sqrt(iTestNumber); i++)
        {
            iLoopIterations++;
            if ((iTestNumber % i) == 0) {
                bIsPrime = false;
                break;
            }
            try {
                //    Thread.sleep(5);
            } catch (Exception ex) {

            }
        }
        endTime = Instant.now();
        lbResult.setText("Number " + iTestNumber + " isPrime=" + bIsPrime +" Time to execute the function: " + Duration.between(startTime, endTime).toMillis() + " ms. num of iterations=" +iLoopIterations);
    }

    private void RunUntilSqrt_Odd()
    {
        startTime = Instant.now();
        iLoopIterations = 0;
        iTestNumber = Long.parseLong(txtNumber.getText());
        boolean bIsPrime = true;
        if ((iTestNumber % 2) == 0)
        {
            bIsPrime = false;
        }
        else {
            for (long i = 3; i <= Math.sqrt(iTestNumber); i = i + 2)
            {
                iLoopIterations++;
                if ((iTestNumber % i) == 0) {
                    bIsPrime = false;
                    break;
                }
                try {
                    //    Thread.sleep(5);
                } catch (Exception ex) {

                }
            }
        }
        endTime = Instant.now();
        lbResult.setText("Number " + iTestNumber + " isPrime=" + bIsPrime +" Time to execute the function: " + Duration.between(startTime, endTime).toMillis() + " ms. num of iterations=" +iLoopIterations);
    }

    private void RunOverOddNumbers()
    {
        startTime = Instant.now();
        iLoopIterations = 0;
        iTestNumber = Long.parseLong(txtNumber.getText());
        boolean bIsPrime = true;
        if ((iTestNumber % 2) == 0)
        {
            bIsPrime = false;
        }
        else {
            for (long i = 3; i<iTestNumber; i = i + 2)
            {
                iLoopIterations++;
                if ((iTestNumber % i) == 0) {
                    bIsPrime = false;
                    break;
                }
                try {
                    //    Thread.sleep(5);
                } catch (Exception ex) {

                }
            }
        }
        endTime = Instant.now();
        lbResult.setText("Number " + iTestNumber + " isPrime=" + bIsPrime +" Time to execute the function: " + Duration.between(startTime, endTime).toMillis() + " ms. num of iterations=" +iLoopIterations);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Hila's Application");
        frame.setContentPane(new MainForm().panel1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
